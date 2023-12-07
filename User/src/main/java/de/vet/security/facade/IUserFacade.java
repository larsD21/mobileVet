package de.vet.security.facade;


import de.vet.security.entity.User;
import jakarta.ejb.Local;


@Local
public interface IUserFacade {
	public User findUserByName(String username);
}