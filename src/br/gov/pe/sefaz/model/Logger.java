package br.gov.pe.sefaz.model;

public enum Logger {
	
	YES("Yes"),
	NO("No");
	
	private String log; 

	Logger(final String log) {
		this.log = log;
	}
	
	public String getLog() {
		return log;
	}
	
	@Override
	public String toString() {
		return getLog();
	}
}