/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.davidmorente.system;

import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.davidmorente.controllers.MenuClienteControllers;
import org.davidmorente.controllers.MenuPrincipalControllers;
import org.davidmorente.controllers.ProgramadorControllers;
import org.davidmorente.controllers.MenuProveedorController;

/**
 *
 * @author informatica
 */
public class Main extends Application {
    private Stage escenarioPrincipal;
    private Stage ventanaProgramador;
    private Scene escena;
    private final String URLVIEW = "/org/davidmorente/views/";

    @Override
    public void start(Stage escenarioPrincipal) throws IOException {
        this.escenarioPrincipal = escenarioPrincipal;
        this.escenarioPrincipal.setTitle("Super Kinal");
        menuPrincipalView();
       //  Parent root = FXMLLoader.load(getClass().getResource("/org/cristianluna/view/MenuPrincipalView.fxml"));
        //Scene escena = new Scene(root);
        //escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();
        
    }
    public Initializable cambiarEscena(String fxmlName, int width, int heigth)throws Exception{
        Initializable resultado = null;
        FXMLLoader louder = new FXMLLoader();
        InputStream file =Principal.class.getResourceAsStream(URLVIEW + fxmlName);
        louder.setBuilderFactory(new JavaFXBuilderFactory());
        louder.setLocation(Principal.class.getResource(URLVIEW + fxmlName));
        escena = new Scene((AnchorPane)louder.load(file), width, heigth);
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.sizeToScene();
        resultado = (Initializable)louder.getController();
        return resultado;
    }
    public void menuPrincipalView(){
        try{
          MenuPrincipalControllers menuPrincipalView = (MenuPrincipalControllers)cambiarEscena("MenuPrincipalView.fxml",635,622);
            menuPrincipalView.setEscenarioPrincipal( this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void menuClientesView(){
        try{
          MenuClienteControllers menuClientesView = (MenuClienteControllers)cambiarEscena("MenuClientesView.fxml",904,510);
            menuClientesView.setEscenarioPrincipal(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void verVentanaProveedor(){
        try{
          MenuProveedorController verVentanaProveedor = (MenuProveedorController)cambiarEscena("MenuProveedor.fxml",910,512);
            verVentanaProveedor.setEscenarioProveedor(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void verVentanaProgramador(){
        try{
          ProgramadorControllers verVentanaProgramador = (ProgramadorControllers)cambiarEscena("Programador.fxml",449,457);
            verVentanaProgramador.setEscenarioProgramador(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
