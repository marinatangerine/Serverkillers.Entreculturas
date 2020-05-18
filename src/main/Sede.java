package main;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Sede {
	// Atributos
	@XmlAttribute
	private int idSede;
	@XmlElement
	private String ciudad;
	@XmlElement
	private String direccion;
	@XmlElement
	private String telefono;
	@XmlElement
	private String email;
	@XmlElement
	private boolean central;
	
	//Cardinalidad
	
	private ArrayList <Persona> persona;
	private ArrayList <Proyecto> proyecto;
	
	//Metodo constructor
	public Sede (int pIdSede, String pCiudad, String pDireccion, String pTelefono, String pEmail, boolean pCentral) {
		this.idSede = pIdSede;
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
	public boolean central() {
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
	
}