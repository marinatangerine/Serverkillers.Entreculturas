package jaxb;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

public class Persona {
	//Atributos
	private int personId;
	private String userName;
	private String pass;
	private boolean role;
	private String name;
	private String surname;
	private String address;
	private String phone;
	private String email;
	
	//Cardinalidad
	private ArrayList <Sede> sede;
	
	//Metodo constructor
	public Persona (int pPersonId, String pUserName, String pPass, boolean pRole, String pName, 
			String pSurname, String pAddress,String pPhone, String pEmail) {
		this.personId = pPersonId;
		this.userName = pUserName;
		this.pass = pPass;
		this.role = pRole;
		this.name = pName;
		this.surname = pSurname;
		this.address = pAddress;
		this.phone = pPhone;
		this.email = pEmail;
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
	public boolean getRole() {
		return role;
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
	
	//Metodos get listas
	public List<Sede> getSede_Persona() {
		return sede;
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
	public void setRole (boolean role) {
		this.role = role;
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
	
	//Metodos add listas
	public void addSede_Persona(Sede pSede) {
		sede.add(pSede);
	}
}
