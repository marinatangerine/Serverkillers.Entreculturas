package main.java.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.java.model.Persona;

public class MenuController implements Initializable {
	

	
	@FXML
	private Button crearPersona;
	
	@FXML 
	private void crearNuevaPersona(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CrearPersonaVista.fxml"));
		Parent root = loader.load();
		CrearPersonaController controller = loader.getController();
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		
		stage.setScene(scene);
		stage.show();
		
		stage.setOnCloseRequest(e -> controller.closeWindow());
		
		Stage myStage = (Stage) this.crearPersona.getScene().getWindow();
		myStage.close();
		
	
		
	}
	
		
		
	
	
	@FXML
	private Button crearVoluntario;
	
	@FXML
	private Button crearSede;
	
	@FXML
	private Button crearProyecto;
	
	@FXML
	private Button mostrarPersonas;
	
	@FXML
	private Button mostrarVoluntarios;
	
	@FXML
	private Button mostrarSedes;
	
	@FXML
	private Button mostrarProyectos;
	
	@FXML 
	private Button salir;
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void salir(ActionEvent event) {
		Node source = (Node) event.getSource();
		Stage stage = (Stage)source.getScene().getWindow();
		stage.close();
	}



	public void terminate() {
		// TODO Auto-generated method stub
		
	}


		
	

	


}
