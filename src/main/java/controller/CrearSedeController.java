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
import main.java.dao.DAO;
import main.java.dao.DAOFactory;
import main.java.dao.MySqlPersonasDAO;
import main.java.dao.MySqlSedesDAO;

public class CrearSedeController implements Initializable {
	
	private static DAOFactory MySqlDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	private static DAO<Sede> mysqlsedesDAO = (MySqlSedesDAO) MySqlDAOFactory.getSedesDAO();
	
	
	
	ObservableList<String> tipoList = FXCollections.observableArrayList("Central", "Delegación");
	
	
	@FXML
	private TextField ciudadede;
	
	@FXML
	private TextField direccionSede;
	
	@FXML
	private TextField phoneSede;
	
	@FXML
	private TextField emailSede;
	
	@FXML 
	private Button inicio;
	
	@FXML 
	private Button guardar;
	
	@FXML
	private ChoiceBox tipoSede;
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		tipoSede.setItems(tipoList);
	}
	
	
	@FXML
	private void guardar(ActionEvent event) throws DuplicateEntityException, IOException {
		String ciudad = this.ciudadede.getText();
		String direccion = this.direccionSede.getText();
		String phone = this.phoneSede.getText();
		String email = this.emailSede.getText();
		Boolean central = this.tipoSede.getSelectionModel().getSelectedItem() == "Central";
		
		Sede sede = new Sede(ciudad, direccion, phone, email, central);
		mysqlsedesDAO.add(sede);
		
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
