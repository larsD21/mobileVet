package de.vet.rest;


import java.util.HashSet;
import java.util.Set;


import de.vet.jwt.CorsResponseFilter;
import de.vet.security.JWTTokenNeededFilter;
import de.vet.security.PlainSHA512PasswordHash;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import jakarta.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@BasicAuthenticationMechanismDefinition()
@DatabaseIdentityStoreDefinition(

		dataSourceLookup = "PROD/MYSQL",
		//dataSourceLookup = "app/PostgresDS",
        callerQuery = "select PASSWORD from t_user where USERNAME=?",
        groupsQuery = "select ROLENAME as GROUPNAME from t_user_roles where USERNAME=?",
        hashAlgorithm = PlainSHA512PasswordHash.class
)


@ApplicationScoped
@Named
@ApplicationPath("api")
public class ApplicationConfig extends Application {
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(CorsResponseFilter.class);
        classes.add(JWTTokenNeededFilter.class);
        classes.add(PatientResource.class);
        classes.add(OwnerResource.class);
        classes.add(AppointmentResource.class);
        classes.add(DrugResource.class);
        classes.add(GOTResource.class);
        classes.add(VetResource.class);
        classes.add(BillingResource.class);
        return classes;
    }
}