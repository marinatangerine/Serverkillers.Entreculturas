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
	private void crearNuevoVoluntario(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CrearVoluntarioVista.fxml"));
		Parent root = loader.load();
		CrearVoluntarioController controller = loader.getController();
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		
		stage.setScene(scene);
		stage.show();
		
		stage.setOnCloseRequest(e -> controller.closeWindow());
		
		Stage myStage = (Stage) this.crearVoluntario.getScene().getWindow();
		myStage.close();	
	}
	
	@FXML
	private Button crearSede;
	
	@FXML 
	private void crearSede(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CrearSedeVista.fxml"));
		Parent root = loader.load();
		CrearSedeController controller = loader.getController();
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		
		stage.setScene(scene);
		stage.show();
		
		stage.setOnCloseRequest(e -> controller.closeWindow());
		
		Stage myStage = (Stage) this.crearSede.getScene().getWindow();
		myStage.close();	
	}
	
	@FXML
	private Button crearProyecto;
	
	@FXML 
	private void crearProyecto(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CrearProyectoVista.fxml"));
		Parent root = loader.load();
		CrearProyectoController controller = loader.getController();
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		
		stage.setScene(scene);
		stage.show();
		
		stage.setOnCloseRequest(e -> controller.closeWindow());
		
		Stage myStage = (Stage) this.crearProyecto.getScene().getWindow();
		myStage.close();	
	}
	
	@FXML
	private Button mostrarPersonas;
	
	@FXML
	private void mostrarPersonas(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MostrarPersonaVista.fxml"));
		Parent root = loader.load();
		MostrarPersonaController controller = loader.getController();
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		
		stage.setScene(scene);
		stage.show();
		
		stage.setOnCloseRequest(e -> controller.closeWindow());
		
		Stage myStage = (Stage) this.mostrarPersonas.getScene().getWindow();
		myStage.close();
	}
	
	@FXML
	private Button mostrarVoluntarios;
	
	@FXML
	private void mostrarVoluntarios(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MostrarVoluntarioVista.fxml"));
		Parent root = loader.load();
		MostrarVoluntarioController controller = loader.getController();
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		
		stage.setScene(scene);
		stage.show();
		
		stage.setOnCloseRequest(e -> controller.closeWindow());
		
		Stage myStage = (Stage) this.mostrarVoluntarios.getScene().getWindow();
		myStage.close();
	}
	
	@FXML
	private Button mostrarSedes;
	
	@FXML
	private void mostrarSedes(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MostrarSedeVista.fxml"));
		Parent root = loader.load();
		MostrarSedeController controller = loader.getController();
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		
		stage.setScene(scene);
		stage.show();
		
		stage.setOnCloseRequest(e -> controller.closeWindow());
		
		Stage myStage = (Stage) this.mostrarSedes.getScene().getWindow();
		myStage.close();
	}
	
	@FXML
	private Button mostrarProyectos;
	
	@FXML
	private void mostrarProyectos(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MostrarProyectoVista.fxml"));
		Parent root = loader.load();
		MostrarProyectoController controller = loader.getController();
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		
		stage.setScene(scene);
		stage.show();
		
		stage.setOnCloseRequest(e -> controller.closeWindow());
		
		Stage myStage = (Stage) this.mostrarProyectos.getScene().getWindow();
		myStage.close();
	}
	
	@FXML 
	private Button inicio;
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
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
