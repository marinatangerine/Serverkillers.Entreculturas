package main;

import javax.xml.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@XmlRootElement
public class Proyecto {
	//Atributos
	private int codProyecto;
	private String nombre;
	private String lineaAccion;
	private String subLinea;
	private String pais;
	private String localizacion;
	private Date fechaInicio;
	private Date fechaFin;
	private String acciones;
	
	//Cardinalidad
	private Sede sede;	
	private int idSede = sede.getIdSede();
		
	//Metodo constructor
	public Proyecto () {
		
	}
	
	public Proyecto (int pCodProyecto, String pNombre, String pLineaAccion, String pSubLinea, String pPais, 
			String pLocalizacion, Date pFechaInicio,Date pFechaFin, String pAcciones) {
		this.codProyecto = pCodProyecto;
		this.nombre = pNombre;
		this.lineaAccion = pLineaAccion;
		this.subLinea = pSubLinea;
		this.pais = pPais;
		this.localizacion = pLocalizacion;
		this.fechaInicio = pFechaInicio;
		this.fechaFin = pFechaFin;
		this.acciones = pAcciones;
	}
	
	//Metodos get
	public int getCodProyecto() {
		return codProyecto;
	}
	public String getNombre() {
		return nombre;
	}
	public String getLineaAccion() {
		return lineaAccion;
	}
	public String getSubLinea() {
		return subLinea;
	}
	public String getPais() {
		return pais;
	}
	public String getLocalizacion() {
		return localizacion;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public String getAcciones() {
		return acciones;
	}
	public int getIdSede() {
		return idSede;
	}
	
	//Metodos set
	public void setCodProyecto (int codProyecto) {
		this.codProyecto = codProyecto;
	}
	public void setNombre (String nombre) {
		this.nombre = nombre;
	}
	public void setLineaAccion (String lineaAccion) {
		this.lineaAccion = lineaAccion;
	}
	public void setSubLinea (String subLinea) {
		this.subLinea = subLinea;
	}
	public void setPais (String pais) {
		this.pais = pais;
	}
	public void setLocalizacion (String localizacion) {
		this.localizacion = localizacion;
	}
	public void setFechaInicio (Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public void setFechaFin (Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public void setAcciones (String acciones) {
		this.acciones = acciones;
	}
	public void setIdSede(int idSede) {
		this.idSede = idSede;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return String.format(
				"Código de Proyecto: " + codProyecto + 
				". Nombre: " + nombre +
				". Linea de acción: " + lineaAccion +
				". Sublinea de acción: " + subLinea +
				". País: " + pais +
				". Localización: " + localizacion +
				". Fecha de inicio: " + formatter.format(fechaInicio) +
				". Fecha de fin: " + formatter.format(fechaFin) + 
				". Acciones: " + acciones +
				". Identificador de Sede: " + idSede);
	}	
}