package br.gov.pe.sefaz.dao;

public class DAOException extends Exception {

	public DAOException(Exception exception) {
		super("Ocorreu um erro durante o acesso � Base de Dados!", exception);
	}
	
}