package br.gov.pe.sefaz.service;

public class ServiceException extends Exception {

	ServiceException(String message, Exception exception) {
		super(message, exception);
	}

	public ServiceException(String message) {
		super(message);
	}
	
}