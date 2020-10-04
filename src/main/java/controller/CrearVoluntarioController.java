package main.java.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.java.main.DuplicateEntityException;
import main.java.model.Persona;
import main.java.model.Sede;
import main.java.model.Voluntario;
import main.java.dao.DAO;
import main.java.dao.DAOFactory;
import main.java.dao.MySqlPersonasDAO;
import main.java.dao.MySqlSedesDAO;
import main.java.dao.MySqlVoluntariosDAO;

public class CrearVoluntarioController implements Initializable {
	
	private static DAOFactory MySqlDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	private static DAO<Persona> mysqlpersonasDAO = (MySqlPersonasDAO) MySqlDAOFactory.getPersonasDAO();
	private static DAO<Sede> mysqlsedesDAO = (MySqlSedesDAO) MySqlDAOFactory.getSedesDAO();
	private static DAO<Voluntario> mysqlvoluntariosDAO = (MySqlVoluntariosDAO) MySqlDAOFactory.getVoluntariosDAO();
	
	ObservableList<String> rolList = FXCollections.observableArrayList("Administrador", "Usuario");
	@FXML
	ObservableList<Integer> sedeList;
	
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
	private Button inicio;
	
	@FXML 
	private Button guardar;
	
	@FXML
	private ChoiceBox rol;
	
	@FXML 
	private ChoiceBox sede;
	
	@FXML
	private TextField areaActividades;
	
	
	

	
	

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		rol.setItems(rolList);
		mysqlsedesDAO.loadData();
		List<Integer> idSedes = mysqlsedesDAO.list().stream().map(Sede::getIdSede).collect(Collectors.toList());
		sedeList = FXCollections.observableArrayList(idSedes);
		sede.setItems(sedeList);
		
		
		
		
	}
	
	
	@FXML
	private void guardar(ActionEvent event) throws DuplicateEntityException, IOException {
		String username = this.userName.getText();
		String pass = this.pass.getText();
		String namePersona = this.namePersona.getText();
		String surname = this.surname.getText();
		String address = this.address.getText();
		String phone = this.phone.getText();
		String email = this.email.getText();
		Boolean admin = this.rol.getSelectionModel().getSelectedItem() == "Administrador";
		Integer idSede = Integer.parseInt(this.sede.getSelectionModel().getSelectedItem().toString());
		String areaActividades = this.areaActividades.getText();
		
		Voluntario voluntario = new Voluntario(username, pass, admin, namePersona, surname, address, phone, email, idSede, areaActividades);
		mysqlvoluntariosDAO.add(voluntario);
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MenuVista.fxml"));
		Parent root = loader.load();
		MenuController controller = loader.getController();
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		
		stage.setScene(scene);
		stage.show();
		
		stage.setOnCloseRequest(e -> controller.closeWindow());
		
		Stage myStage = (Stage) this.guardar.getScene().getWindow();
		myStage.close();
		
	}
	

	
	
	@FXML
	public void closeWindow() {
		
		
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
		
		stage.setOnCloseRequest(e -> controller.closeWindow());
		
		Stage myStage = (Stage) this.inicio.getScene().getWindow();
		myStage.close();
		
		
	}
	

	
	
	@FXML
	public void terminate() {
		// TODO Auto-generated method stub
		
	}


}