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

public class MostrarSedeController implements Initializable{
	
	private static DAOFactory MySqlDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	private static DAO<Persona> mysqlpersonasDAO = (MySqlPersonasDAO) MySqlDAOFactory.getPersonasDAO();
	private static DAO<Sede> mysqlsedesDAO = (MySqlSedesDAO) MySqlDAOFactory.getSedesDAO();
	
	@FXML
	private TableView<Sede> tablaSede;
	
	@FXML
	private TableColumn<Sede, Integer> columnId;
	
	@FXML
	private TableColumn<Sede, String> columnCiudad;
	
	@FXML
	private TableColumn<Sede, String> columnDireccion;
	
	@FXML
	private TableColumn<Sede, String> columnTelefono;
	
	@FXML
	private TableColumn<Sede, String> columnEmail;
	
	@FXML
	private TableColumn<Sede, Boolean> columnTipoSede;
	
	
	
	
	@FXML
	private Button inicio;
	
	@FXML
	ObservableList<Sede> sedeList; 
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mysqlsedesDAO.loadData();

		columnId.setCellValueFactory(new PropertyValueFactory<Sede, Integer>("idSede"));
		columnCiudad.setCellValueFactory(new PropertyValueFactory<Sede, String>("ciudad"));
		columnDireccion.setCellValueFactory(new PropertyValueFactory<Sede, String>("direccion"));
		columnTelefono.setCellValueFactory(new PropertyValueFactory<Sede, String>("telefono"));
		columnEmail.setCellValueFactory(new PropertyValueFactory<Sede, String>("email"));
		columnTipoSede.setCellValueFactory(new PropertyValueFactory<Sede, Boolean>("central"));
		
		
		sedeList = FXCollections.observableArrayList(mysqlsedesDAO.list());
		
		tablaSede.setItems(sedeList);
		
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
