/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import modelo.dao.UsuarioDAO;
import modelo.pojo.RespuestaLogin;
import utils.Utilidades;

/**
 *
 * @author lecap
 */
public class FXMLLoginController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private TextField tfEmail;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnIniciarSesion(ActionEvent event) {
        String email = tfEmail.getText();
        String password = tfPassword.getText();
        if (tfEmail.getText().isEmpty() || tfPassword.getText().isEmpty()) {
            Utilidades.mostrarAlertaSimple("Atenticacion", "Campos faltantes", 
                    Alert.AlertType.INFORMATION);
        }else{
            verificarAcceso(email, password);
        }
    }
    
    private void verificarAcceso(String email, String password){
        try {
            RespuestaLogin autenticacion = UsuarioDAO.iniciarSesion(email, password);
            if (!autenticacion.isError()) {
                Utilidades.mostrarAlertaSimple("Autenticacion", autenticacion.getMensaje(), 
                        Alert.AlertType.INFORMATION);
            }else{
                Utilidades.mostrarAlertaSimple("Autenticacion", autenticacion.getMensaje(),
                        Alert.AlertType.WARNING);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
