package jaxb;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

public class Voluntario extends Persona {
	//Atributos
	private int idVoluntario;
	private String sede;
	private String areaActividades;

	//Metodo constructor
	public Voluntario (int pPersonId, String pUserName, String pPass, boolean pRole, String pName, 
			String pSurname, String pAddress,String pPhone, String pEmail, int pIdVoluntario, 
			String pSede, String pAreaActividades) {
		super (pPersonId, pUserName, pPass, pRole, pName, pSurname, pAddress, pPhone, pEmail);
		this.idVoluntario = idVoluntario;
		this.sede = sede;
		this.areaActividades = areaActividades;
	}
	
	//Metodos get
	public int idVoluntario () {
		return this.idVoluntario;
	}
	public String sede () {
		return this.sede;
	}
	public String areaActividades () {
		return this.areaActividades;
	}
	
	//Metodos set
	public void setSede (String sede) {
		this.sede = sede;
	}
	public void setAreaActividades (String areaActividades) {
		this.areaActividades = areaActividades;
	}
}
