package main;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Voluntario extends Persona {
	//Atributos
	private int numVoluntario;
	private String areaActividades;

	//Metodo constructor
	public Voluntario() {
	}
	
	public Voluntario(Persona p) {
		super(p.getPersonId(), p.getUserName(), p.getPass(), p.getAdmin(), p.getName(), p.getSurname(), p.getAddress(), p.getPhone(), p.getEmail(), p.getIdSede());
	}
	
	public Voluntario (int pPersonId, String pUserName, String pPass, boolean admin, String pName, 
			String pSurname, String pAddress,String pPhone, String pEmail, int pIdSede,
			int idVoluntario, String areaActividades) {
		super (pPersonId, pUserName, pPass, admin, pName, pSurname, pAddress, pPhone, pEmail, pIdSede);
		this.numVoluntario = idVoluntario;
		this.areaActividades = areaActividades;
	}
	
	//Metodos get
	public int getNumVoluntario () {
		return this.numVoluntario;
	}

	public String getAreaActividades () {
		return this.areaActividades;
	}
	
	//Metodos set
	public void setNumVoluntario (int numVoluntario) {
		this.numVoluntario = numVoluntario;
	}

	public void setAreaActividades (String areaActividades) {
		this.areaActividades = areaActividades;
	}
	
	@Override
	public String toString() {
		return super.toString()+ String.format(
				"Núnero de voluntario: " + numVoluntario + 
				". Área de actividades: " + areaActividades
				);
	}
}
