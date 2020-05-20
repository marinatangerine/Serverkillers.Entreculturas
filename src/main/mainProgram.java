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


/**
 * @author suare
 *
 */
public class mainProgram {
	private static DAOFactory xmlDAOFactory = DAOFactory.getDAOFactory(DAOFactory.XML);
	private static DAO<Persona> personasDAO = (XmlPersonasDAO) xmlDAOFactory.getXmlPersonasDAO();
	
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
		System.out.println("3. Salir");
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
}
