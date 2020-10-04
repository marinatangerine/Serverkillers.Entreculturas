package main.java.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.java.dao.DAO;
import main.java.dao.DAOFactory;
import main.java.dao.MySqlPersonasDAO;
import main.java.dao.MySqlSedesDAO;
import main.java.model.Persona;
import main.java.model.Sede;

public class MostrarPersonaController implements Initializable{
	
	private static DAOFactory MySqlDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	private static DAO<Persona> mysqlpersonasDAO = (MySqlPersonasDAO) MySqlDAOFactory.getPersonasDAO();
	private static DAO<Sede> mysqlsedesDAO = (MySqlSedesDAO) MySqlDAOFactory.getSedesDAO();
	
	@FXML
	private TableView<Persona> tablaPersona;
	
	@FXML
	private TableColumn<Persona, Integer> columnId;
	
	@FXML
	private TableColumn<Persona, String> columnUserName;
	
	@FXML
	private TableColumn<Persona, String> columnPass;
	
	@FXML
	private TableColumn<Persona, String> columnNamePersona;
	
	@FXML
	private TableColumn<Persona, String> columnSurname;
	
	@FXML
	private TableColumn<Persona, String> columnAddress;
	
	@FXML
	private TableColumn<Persona, String> columnPhone;
	
	@FXML
	private TableColumn<Persona, String> columnEmail;
	
	@FXML
	private TableColumn<Persona, Boolean> columnRol;
	
	@FXML
	private TableColumn<Persona, Integer> columnSede;
	
	
	@FXML
	private Button inicio;
	
	@FXML
	ObservableList<Persona> personaList; 
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mysqlpersonasDAO.loadData();

		columnId.setCellValueFactory(new PropertyValueFactory<Persona, Integer>("personId"));
		columnUserName.setCellValueFactory(new PropertyValueFactory<Persona, String>("userName"));
		columnPass.setCellValueFactory(new PropertyValueFactory<Persona, String>("pass"));
		columnNamePersona.setCellValueFactory(new PropertyValueFactory<Persona, String>("name"));
		columnSurname.setCellValueFactory(new PropertyValueFactory<Persona, String>("surname"));
		columnAddress.setCellValueFactory(new PropertyValueFactory<Persona, String>("address"));
		columnPhone.setCellValueFactory(new PropertyValueFactory<Persona, String>("phone"));
		columnEmail.setCellValueFactory(new PropertyValueFactory<Persona, String>("email"));
		columnRol.setCellValueFactory(new PropertyValueFactory<Persona, Boolean>("admin"));
		columnSede.setCellValueFactory(new PropertyValueFactory<Persona, Integer>("idSede"));
		
		personaList = FXCollections.observableArrayList(mysqlpersonasDAO.list());
		
		tablaPersona.setItems(personaList);
		
	}
	
	public void salir(ActionEvent event) {
		Node source = (Node) event.getSource();
		Stage stage = (Stage)source.getScene().getWindow();
		stage.close();
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

	public void terminate() {
		// TODO Auto-generated method stub
		
	}

	public Object closeWindow() {
		// TODO Auto-generated method stub
		return null;
	}
}
