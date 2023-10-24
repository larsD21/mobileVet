package de.vet.jwt;

import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;

import java.util.logging.Logger;
import java.io.Serializable;

@SessionScoped
public class LoggerProducer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3986797632252209396L;

	@Produces
	@LogbackLogger
	public Logger produceLogger(InjectionPoint injectionPoint) {
		return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}
}
