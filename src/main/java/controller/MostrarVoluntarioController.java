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
import main.java.dao.MySqlVoluntariosDAO;
import main.java.model.Persona;
import main.java.model.Sede;
import main.java.model.Voluntario;

public class MostrarVoluntarioController implements Initializable{
	
	private static DAOFactory MySqlDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	private static DAO<Persona> mysqlpersonasDAO = (MySqlPersonasDAO) MySqlDAOFactory.getPersonasDAO();
	private static DAO<Voluntario> mysqlvoluntariosDAO = (MySqlVoluntariosDAO) MySqlDAOFactory.getVoluntariosDAO();
	private static DAO<Sede> mysqlsedesDAO = (MySqlSedesDAO) MySqlDAOFactory.getSedesDAO();
	
	@FXML
	private TableView<Voluntario> tablaVoluntario;
	
	@FXML
	private TableColumn<Voluntario, Integer> columnId;
	
	@FXML
	private TableColumn<Voluntario, String> columnUserName;
	
	@FXML
	private TableColumn<Voluntario, String> columnPass;
	
	@FXML
	private TableColumn<Voluntario, String> columnNamePersona;
	
	@FXML
	private TableColumn<Voluntario, String> columnSurname;
	
	@FXML
	private TableColumn<Voluntario, String> columnAddress;
	
	@FXML
	private TableColumn<Voluntario, String> columnPhone;
	
	@FXML
	private TableColumn<Voluntario, String> columnEmail;
	
	@FXML
	private TableColumn<Voluntario, Boolean> columnRol;
	
	@FXML
	private TableColumn<Voluntario, Integer> columnSede;
	
	@FXML
	private TableColumn<Voluntario, String> columnArea;
	
	
	@FXML
	private Button inicio;
	
	@FXML
	ObservableList<Voluntario> voluntarioList; 
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mysqlvoluntariosDAO.loadData();

		columnId.setCellValueFactory(new PropertyValueFactory<Voluntario, Integer>("personId"));
		columnUserName.setCellValueFactory(new PropertyValueFactory<Voluntario, String>("userName"));
		columnPass.setCellValueFactory(new PropertyValueFactory<Voluntario, String>("pass"));
		columnNamePersona.setCellValueFactory(new PropertyValueFactory<Voluntario, String>("name"));
		columnSurname.setCellValueFactory(new PropertyValueFactory<Voluntario, String>("surname"));
		columnAddress.setCellValueFactory(new PropertyValueFactory<Voluntario, String>("address"));
		columnPhone.setCellValueFactory(new PropertyValueFactory<Voluntario, String>("phone"));
		columnEmail.setCellValueFactory(new PropertyValueFactory<Voluntario, String>("email"));
		columnRol.setCellValueFactory(new PropertyValueFactory<Voluntario, Boolean>("admin"));
		columnSede.setCellValueFactory(new PropertyValueFactory<Voluntario, Integer>("idSede"));
		columnArea.setCellValueFactory(new PropertyValueFactory<Voluntario, String>("areaActividades"));
		
		voluntarioList = FXCollections.observableArrayList(mysqlvoluntariosDAO.list());
		
		tablaVoluntario.setItems(voluntarioList);
		
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
