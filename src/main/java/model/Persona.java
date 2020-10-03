package main.java.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@Entity
@Table(name = "persona")
@Inheritance(strategy=InheritanceType.JOINED)
public class Persona {
	//Atributos
	@Id
	@Column(name = "personId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int personId;
	
	@Column(name = "userName")
	private String userName; 
	
	@Column(name = "pass")
	private String pass; 
	
	@Column(name = "administrator")
	private boolean admin; 
	
	@Column(name = "namePersona")
	private String name; 
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "address")
	private String address;
	
	@Column (name = "phone")
	private String phone;
	
	@Column (name = "email")
	private String email;
	
	//Cardinalidad
	@Column (name = "fk_sedePersona")
	private int idSede;
	
	//Metodo constructor
	public Persona() {
	}
	
	public Persona (int pPersonId, String pUserName, String pPass, boolean admin, String pName, 
			String pSurname, String pAddress,String pPhone, String pEmail, int pIdSede) {
		this.personId = pPersonId;
		this.userName = pUserName;
		this.pass = pPass;
		this.admin = admin;
		this.name = pName;
		this.surname = pSurname;
		this.address = pAddress;
		this.phone = pPhone;
		this.email = pEmail;
		this.idSede = pIdSede;
	}
	
	public Persona (String pUserName, String pPass, boolean admin, String pName, 
			String pSurname, String pAddress,String pPhone, String pEmail, int pIdSede) {
		this.userName = pUserName;
		this.pass = pPass;
		this.admin = admin;
		this.name = pName;
		this.surname = pSurname;
		this.address = pAddress;
		this.phone = pPhone;
		this.email = pEmail;
		this.idSede = pIdSede;
	}
	
	//Metodos get
	public int getPersonId() {
		return personId;
	}
	public String getUserName() {
		return userName;
	}
	public String getPass() {
		return pass;
	}
	public boolean getAdmin() {
		return admin;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getAddress() {
		return address;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public int getIdSede() {
		return idSede;
	}
	
	//Metodos set
	public void setPersonId (int personId) {
		this.personId = personId;
	}
	public void setUserName (String userName) {
		this.userName = userName;
	}
	public void setPass (String pass) {
		this.pass = pass;
	}
	public void setAdmin (boolean admin) {
		this.admin = admin;
	}
	public void setName (String name) {
		this.name = name;
	}
	public void setSurname (String surname) {
		this.surname = surname;
	}
	public void setAddress (String address) {
		this.address = address;
	}
	public void setPhone (String phone) {
		this.phone = phone;
	}
	public void setEmail (String email) {
		this.email = email;
	}
	public void setIdSede(int idSede) {
		this.idSede = idSede;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Identificador de persona: " + personId + 
				". Nombre de usuario: " + userName +
				". Contraseña: " + pass +
				". Nombre: " + name +
				". Apellidos: " + surname +
				". Dirección: " + address +
				". Teléfono: " + phone +
				". Email: " + email + 
				". Role: " + (admin ? "Administrador" : "Usuario") +
				". Identificador de Sede: " + idSede + " ");
	}	
}