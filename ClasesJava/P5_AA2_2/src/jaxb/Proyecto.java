package jaxb;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

public class Proyecto {
	//Atributos
	private int codProyecto;
	private String nombre;
	private String lineaAccion;
	private String subLinea;
	private String pais;
	private String localizacion;
	private String fechaInicio;
	private String fechaFin;
	private String acciones;
	
	//Cardinalidad
	private ArrayList <Sede> sede;
		
	//Metodo constructor
	public Proyecto (int pCodProyecto, String pNombre, String pLineaAccion, String pSubLinea, String pPais, 
			String pLocalizacion, String pFechaInicio,String pFechaFin, String pAcciones) {
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
	public String getFechaInicio() {
		return fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public String getAcciones() {
		return acciones;
	}
	
	//Metodos get listas
	public List<Sede> getSede_Proyecto() {
		return sede;
	}
	//Metodos set
	public void setFechaInicio (String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public void setFechaFin (String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public void setAcciones (String acciones) {
		this.acciones = acciones;
	}
	
	//Metodos add listas
	public void addSede_Proyecto(Sede pSede) {
		sede.add(pSede);
	}
}

