package main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.*;

@XmlRootElement
@Entity
@Table(name = "voluntario")
public class Voluntario extends Persona {
	//Atributos
	
	@Column(name = "areaActividades")
	private String areaActividades;

	//Metodo constructor
	public Voluntario() {
	}
	
	public Voluntario(Persona p) {
		super(p.getPersonId(), p.getUserName(), p.getPass(), p.getAdmin(), p.getName(), p.getSurname(), p.getAddress(), p.getPhone(), p.getEmail(), p.getIdSede());
	}
	
	public Voluntario (int pPersonId, String pUserName, String pPass, boolean admin, String pName, 
			String pSurname, String pAddress,String pPhone, String pEmail, int pIdSede, String areaActividades) {
		super (pPersonId, pUserName, pPass, admin, pName, pSurname, pAddress, pPhone, pEmail, pIdSede);
		this.areaActividades = areaActividades;
	}
	
	//Metodos get

	public String getAreaActividades () {
		return this.areaActividades;
	}
	
	//Metodos set

	public void setAreaActividades (String areaActividades) {
		this.areaActividades = areaActividades;
	}
	
	@Override
	public String toString() {
		return super.toString()+ String.format(
				"Núnero de persona: " + super.getPersonId() + 
				". Área de actividades: " + areaActividades
				);
	}
}
