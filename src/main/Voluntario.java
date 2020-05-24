package main;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Voluntario extends Persona {
	//Atributos
	private int numVoluntario;
	private int idSede;
	private String areaActividades;

	//Metodo constructor
	public Voluntario() {
	}
	
	public Voluntario(Persona p) {
		super(p.getPersonId(), p.getUserName(), p.getPass(), p.getAdmin(), p.getName(), p.getSurname(), p.getAddress(), p.getPhone(), p.getEmail());
	}
	
	public Voluntario (int pPersonId, String pUserName, String pPass, boolean admin, String pName, 
			String pSurname, String pAddress,String pPhone, String pEmail, 
			int idVoluntario, int idSede, String areaActividades) {
		super (pPersonId, pUserName, pPass, admin, pName, pSurname, pAddress, pPhone, pEmail);
		this.numVoluntario = idVoluntario;
		this.idSede = idSede;
		this.areaActividades = areaActividades;
	}
	
	//Metodos get
	public int getNumVoluntario () {
		return this.numVoluntario;
	}
	public int getIdSede () {
		return this.idSede;
	}
	public String getAreaActividades () {
		return this.areaActividades;
	}
	
	//Metodos set
	public void setNumVoluntario (int numVoluntario) {
		this.numVoluntario = numVoluntario;
	}
	public void setIdSede (int idSede) {
		this.idSede = idSede;
	}
	public void setAreaActividades (String areaActividades) {
		this.areaActividades = areaActividades;
	}
	
	@Override
	public String toString() {
		return super.toString()+ String.format(
				"Identificador: " + numVoluntario + 
				". Sede: " + idSede +
				". Área de actividades: " + areaActividades
				);
	}
}
