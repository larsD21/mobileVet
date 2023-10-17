package de.vet.security;


import de.vet.jwt.KeyGenerator;
import de.vet.jwt.LogbackLogger;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;



import static jakarta.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static jakarta.ws.rs.core.Response.Status.UNAUTHORIZED;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Logger;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import de.vet.security.facade.IUserFacade;
import de.vet.security.entity.User;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class UserService {

	@Inject
	private IUserFacade userFacade;
	
	@Inject
	private KeyGenerator keyGenerator;
	
    @Context
    private UriInfo uriInfo;
    

    @Inject
	@LogbackLogger
    private Logger logger;
	
	
	/*
	curl -X POST http://localhost:8080/bankREST_v2-1.0/api/users/login \
		-H 'Accept: application/json' \
		-H 'Content-Type: application/json' \
		-H 'username: chef' \
		-H 'password: chef'
	*/
	
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response authenticateUser(
			@HeaderParam("username") String username, 
			@HeaderParam("password") String password) {
		System.out.println("login called with login: "+username+" password: "+password);
		User user = null;
		try {
			user = authenticate(username, password);
		
		} catch (Exception e) {
			return Response.status(UNAUTHORIZED).build();
		}
		String token = issueToken(user);
		logger.info("### token ="+token);
		if(user.getRoles().contains("VET")){
			return Response.ok().header(AUTHORIZATION, "Bearer " +token)
					.header("vetID", user.getVet().getVetID())
					.build();
		}
		return Response.ok().header(AUTHORIZATION, "Bearer " +token).build();
		
	}	
	
	private User authenticate(String username, String password) throws Exception {
		
		User aUser = userFacade.findUserByName(username);
		System.out.println("authenticate called with username: "+username+" password: "+password);
		System.out.println("Loggd in User="+aUser.getUsername());

	    
		PlainSHA512PasswordHash hashAlgo = new PlainSHA512PasswordHash();
		if (aUser.getPassword().equals(hashAlgo.generate(password.toCharArray()))) {
			logger.info("### korrekte Authentifizierung ### ");
			logger.info(aUser.toString());
			return aUser;
		} else {
			System.out.println("Falsches Kennwort: " + aUser.getPassword() + " uebergebener Wert:"
					+ hashAlgo.generate(password.toCharArray()));
			throw new SecurityException("Falscher Benutzername/Kennwort");
		}
		
	}
	
	
    @SuppressWarnings("deprecation")
	private String issueToken(User user) {
        byte[] secret  = keyGenerator.generateKey();
        logger.info("key= "+secret.toString());

        String jws = Jwts.builder()
        		  .setIssuer(uriInfo.getAbsolutePath().toString())
        		  .setSubject(user.getUsername())
        		  .claim("Roles", user.getRoles().toString())
                  .setIssuedAt(new Date())
                  .setExpiration(toDate(LocalDateTime.now().plusMinutes(15L)))
        		  .signWith(SignatureAlgorithm.HS256, secret)
        		  .compact();
		return jws;

    }
    
    private Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
