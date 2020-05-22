/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import dao.DAOFactory;
import dao.DAO;
import dao.XmlPersonasDAO;
import dao.XmlVoluntariosDAO;


/**
 * @author suare
 *
 */
public class mainProgram {
	private static DAOFactory xmlDAOFactory = DAOFactory.getDAOFactory(DAOFactory.XML);
	private static DAO<Persona> personasDAO = (XmlPersonasDAO) xmlDAOFactory.getXmlPersonasDAO();
	private static DAO<Voluntario> voluntariosDAO = (XmlVoluntariosDAO) xmlDAOFactory.getXmlVoluntariosDAO();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		personasDAO.loadData();
		boolean exitMenu = false;
		while(!exitMenu) {
			printMenu();
			Scanner scanner = new Scanner(System.in);
			int option = scanner.nextInt();
			switch(option) {
			case 1: 
				Persona persona = createPersonaFromInput();
				System.out.println(persona);
				personasDAO.add(persona);
				personasDAO.saveAll();
				break;
			case 2:
				ArrayList<Persona> personas = (ArrayList<Persona>) personasDAO.list();
				for(int i = 0; i < personas.size(); i++) {
					System.out.println(personas.get(i));
				}
				break;
			case 3: 
				Voluntario voluntario = createVoluntarioFromInput();
				System.out.println(voluntario);
				voluntariosDAO.add(voluntario);
				voluntariosDAO.saveAll();
				break;
			case 4:
				ArrayList<Voluntario> voluntarios = (ArrayList<Voluntario>) voluntariosDAO.list();
				for(int i = 0; i < voluntarios.size(); i++) {
					System.out.println(voluntarios.get(i));
				}
				break;
			case 7:
				exitMenu = true;
				System.out.println("Hasta otra");
				break;
			default: 
				System.out.println("Introduce una opción válida");
			}
		}

	}
	
	public static void printMenu() {
		System.out.println("-----------------------------");
		System.out.println("Bienvenido/a a Entreculturas");
		System.out.println("-----------------------------");
		System.out.println("Seleccione una opción:");
		System.out.println("1. Crear una persona");
		System.out.println("2. Mostrar personas");
		System.out.println("3. Crear un voluntario");
		System.out.println("4. Mostrar voluntarios");
		System.out.println("7. Salir");
	}
	
	public static Persona createPersonaFromInput() {
		Scanner scanner = new Scanner(System.in);
		Persona persona = new Persona();
		
		System.out.println("Identificador: ");
		persona.setPersonId(scanner.nextInt());
		
		System.out.println("Nombre de usuario: ");
		persona.setUserName(scanner.next());
		
		System.out.println("Contraseña: ");
		persona.setPass(scanner.next());
		
		System.out.println("Nombre: ");
		persona.setName(scanner.next());
		
		System.out.println("Apellidos: ");
		persona.setSurname(scanner.next());
		
		System.out.println("Dirección: ");
		persona.setAddress(scanner.next());
		
		System.out.println("Teléfono: ");
		persona.setPhone(scanner.next());
		
		System.out.println("Email: ");
		persona.setEmail(scanner.next());
		
		System.out.println("¿Crear como administrador? S/N ");
		String input = "";
		while((!input.equals("S")) && (!input.equals("N"))) {
			input = scanner.next();
			switch(input) {
			case "S":
				persona.setAdmin(true);
				break;
			case "N":
				persona.setAdmin(false);
				break;
			default: 
				System.out.println("Escriba S/N");
			}
		}
		return persona;
	}
	
	public static Voluntario createVoluntarioFromInput() {
		Scanner scanner = new Scanner(System.in);
		Voluntario voluntario = new Voluntario(createPersonaFromInput());
		
		System.out.println("Número de voluntario: ");
		voluntario.setNumVoluntario(scanner.nextInt());
		
		System.out.println("Sede: ");
		voluntario.setIdSede(scanner.nextInt());
		
		System.out.println("Área de actividad: ");
		voluntario.setAreaActividades(scanner.next());
		
		return voluntario;
	}
}
