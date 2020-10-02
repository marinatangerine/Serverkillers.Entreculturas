package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.DuplicateEntityException;
import main.Sede;
import model.Persona;
import dao.DAO;
import dao.DAOFactory;
import dao.MySqlPersonasDAO;
import dao.MySqlSedesDAO;

public class CrearPersonaController implements Initializable {
	
	private static DAOFactory MySqlDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	private static DAO<Persona> mysqlpersonasDAO = (MySqlPersonasDAO) MySqlDAOFactory.getPersonasDAO();
	
	ObservableList<String> rolList = FXCollections.observableArrayList("Administrador", "Usuario");
	
	@FXML
	private TextField userName;
	
	@FXML
	private PasswordField pass;
	
	@FXML
	private TextField namePersona;
	
	@FXML
	private TextField surname;
	
	@FXML
	private TextField address;
	
	@FXML
	private TextField phone;
	
	@FXML
	private TextField email;
	
	@FXML 
	private Button salir;
	
	@FXML 
	private Button guardar;
	
	@FXML
	private ChoiceBox rol;
	
	@FXML 
	private ChoiceBox sede;
	
	
	

	
	

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		rol.setItems(rolList);
		
		
	}
	
	
	@FXML
	private void guardar(ActionEvent event) throws DuplicateEntityException {
		String username = this.userName.getText();
		String pass = this.pass.getText();
		String namePersona = this.namePersona.getText();
		String surname = this.surname.getText();
		String address = this.address.getText();
		String phone = this.phone.getText();
		String email = this.email.getText();
		
//		Persona persona = new Persona(-1, username, pass, true, namePersona, surname, address, phone, email, 1);
//		mysqlpersonasDAO.add(persona);
		
		
	}
	
	
	
	@FXML
	public void closeWindow() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MenuVista.fxml"));
			Parent root = loader.load();
			MenuController controller = loader.getController();
			Scene scene= new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@FXML 
	private void inicio(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MenuVista.fxml"));
		Parent root = loader.load();
		MenuController controller = loader.getController();
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		
		stage.setScene(scene);
		stage.show();
		
		
	}
	

	
	
	@FXML
	public void terminate() {
		// TODO Auto-generated method stub
		
	}


}
