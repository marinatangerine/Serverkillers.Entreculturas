package clasesP5_AA2;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Voluntario extends Persona {
	//Atributos
	@XmlAttribute
	private int idVoluntario;
	@XmlElement
	private String sede;
	@XmlElement
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
