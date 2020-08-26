package br.gov.pe.sefaz.dao;

public class DAOException extends Exception {

	public DAOException(Exception exception) {
		super("Ocorreu um erro durante o acesso à Base de Dados!", exception);
	}
	
}