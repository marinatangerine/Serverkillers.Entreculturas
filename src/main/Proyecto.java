package main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@XmlRootElement
@Entity
@Table(name = "proyecto")
public class Proyecto {
	
	//Atributos
	
	@Id
	@Column (name = "codProyecto")
	private int codProyecto;
	
	@Column (name = "nombre")
	private String nombre;
	
	@Column (name = "lineaAccion")
	private String lineaAccion;
	
	@Column (name = "subLinea")
	private String subLinea;
	
	@Column (name = "pais")
	private String pais;
	
	@Column (name = "localizacion")
	private String localizacion;
	
	@Column (name = "fechaInicio")
	private LocalDate fechaInicio;
	
	@Column (name = "fechaFin")
	private LocalDate fechaFin;
	
	@Column (name = "acciones")
	private String acciones;
	
	//Cardinalidad
	@Column (name = "fk_sedeProyecto")
	private int idSede;
		
	//Metodo constructor
	public Proyecto () {
		
	}
	
	public Proyecto (int pCodProyecto, String pNombre, String pLineaAccion, String pSubLinea, String pPais, 
			String pLocalizacion, LocalDate pFechaInicio,LocalDate pFechaFin, String pAcciones) {
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
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public LocalDate getFechaFin() {
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
	public void setFechaInicio (LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public void setFechaFin (LocalDate fechaFin) {
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
		
		return String.format(
				"Código de Proyecto: " + codProyecto + 
				". Nombre: " + nombre +
				". Linea de acción: " + lineaAccion +
				". Sublinea de acción: " + subLinea +
				". País: " + pais +
				". Localización: " + localizacion +
				". Fecha de inicio: " + fechaInicio.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
				". Fecha de fin: " + fechaFin.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + 
				". Acciones: " + acciones +
				". Identificador de Sede: " + idSede);
	}	
}