package br.gov.pe.sefaz.model;

public class Phone {
	
	private Integer ddd;
	private String number;
	private PhoneType type;
	
	public Phone() {
		this.ddd = 0;
		this.number = "";
		this.type = PhoneType.CELULAR;
	}
	
	public Phone(Integer ddd, String number, PhoneType type) {
		this.ddd = ddd;
		this.number = number;
		this.type = type;
	}
	
	
	public Integer getDdd() {
		return ddd;
	}
	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public PhoneType getType() {
		return type;
	}
	public void setType(PhoneType type) {
		this.type = type;
	}
	
	
}
