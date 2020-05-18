package Clases;

public class Sede {
	// Atributos
	
	private int idSede;
	private String ciudad;
	private String direccion;
	private String telefono;
	private String email;
	private Bool central;
	
	//Metodo constructor
	private Sede (int pIdSede, String pCiudad, String pDireccion, String pTelefono, String pEmail, Bool pCentral) {
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
	public Bool central() {
		return central;
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
	public void setCentral (Bool central) {
		this.central = central;
	}
}
