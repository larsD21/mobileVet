package de.vet.security.facade;


import de.vet.security.dao.UserDAO;
import de.vet.security.entity.User;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class UserFacadeImp implements IUserFacade {

	@Inject
	private UserDAO userDAO;
	
	public User findUserByName(String name) {
		return userDAO.findUserByName(name);
	}
}