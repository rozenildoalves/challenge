package br.gov.pe.sefaz.model;

public enum PhoneType {
	
	CELULAR("celular"),
	FIXO("fixo");
	
	private String type; 

	PhoneType(final String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return getType();
	}

}
