package main.java.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement   
@Entity
@Table(name = "sede")
public class Sede {
	
	// Atributos
	
	@Id
	@Column(name = "idSede")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSede;
	
	@Column(name = "ciudad")
	private String ciudad;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column (name = "telefono")
	private String telefono;
	
	@Column (name = "email")
	private String email;
	
	@Column (name = "central")
	private Boolean central;
	
	//Cardinalidad
	@Transient
	private ArrayList <Persona> persona;
	@Transient
	private ArrayList <Proyecto> proyecto;
	
	//Metodo constructor
	public Sede() {
		
	}
	
	public Sede (int pIdSede, String pCiudad, String pDireccion, String pTelefono, String pEmail, boolean pCentral) {
		this.idSede = pIdSede;
		this.ciudad = pCiudad;
		this.direccion = pDireccion;
		this.telefono = pTelefono;
		this.email = pEmail;
		this.central = pCentral;
	}
	
	public Sede (String pCiudad, String pDireccion, String pTelefono, String pEmail, boolean pCentral) {
		this.ciudad = pCiudad;
		this.direccion = pDireccion;
		this.telefono = pTelefono;
		this.email = pEmail;
		this.central = pCentral;
	}
	
	//Metodos get
	public int getIdSede() {
		return idSede;
	}
	public String getCiudad() {
		return ciudad;
	}
	public String getDireccion() {
		return direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public String getEmail() {
		return email;
	}
	public boolean getCentral() {
		return central;
	}
	
	//Metodos get listas
	public List<Persona> getPersona_Sede() {
		return persona;
	}
	public List<Proyecto> getProyecto_Sede() {
		return proyecto;
	}
	
	//Metodos set
	public void setIdSede(int idSede) {
		this.idSede = idSede;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public void setDireccion (String direccion) {
		this.direccion = direccion;
	}
	public void setTelefono (String telefono) {
		this.telefono = telefono;
	}
	public void setEmail (String email) {
		this.email = email;
	}
	public void setCentral (boolean central) {
		this.central = central;
	}
	
	//Metodos add listas
	public void addPersona_Sede(Persona pPersona) {
		persona.add(pPersona);
	}
	public void addProyecto_Sede(Proyecto pProyecto) {
		proyecto.add(pProyecto);
	}
	
	@Override
	public String toString() {
		return String.format(
				"Identificador: " + idSede + 
				". Ciudad: " + ciudad +
				". Dirección: " + direccion +
				". Teléfono: " + telefono +
				". Email: " + email + 
				". Central: " + ((central != null && central) ? "Central" : "Delegación"));
	}
}