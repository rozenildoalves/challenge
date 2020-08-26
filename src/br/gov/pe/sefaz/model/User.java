package br.gov.pe.sefaz.model;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, unique = true)	
	private String name;	
	
	@Column(nullable = false, unique = true)	
	private String email;
	
	@javax.persistence.Transient
	private String password;
	
	@OneToMany
	@Enumerated(EnumType.STRING)
	private List<Phone> phone;
	
	@Enumerated(EnumType.STRING)
	private Logger logger;
	
	public User() {		
		this.id = 0;
		this.name = "";	
		this.email = "";
		this.password = "";
		this.phone = new ArrayList<>();
		this.logger = Logger.NO;
	}
	

	
	User(Integer id, String name, String email, String password, List<Phone> phone, Logger logger) {
		this.id = id;
		this.name = name;	
		this.email = email; 
		this.password = password;
		this.phone = phone;
		this.logger = logger;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<Phone> getPhone() {
		return phone;
	}


	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}


	public Logger getLogger() {
		return logger;
	}
	
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	
	@Override
	public boolean equals(Object object) {
		
		if (object == null) {
			return false;
		}
		
		final User other = (User) object;
		
		if ((this.id != 0) && (this.id == other.id)) {
			return true;
		}
		
		if ((this.id != 0) && ((this.id == other.id) || (this.email.equals(other.email)))) {
			return true;
		}
		
		return this.name.equals(other.name);
	}


	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}




	

	

}
