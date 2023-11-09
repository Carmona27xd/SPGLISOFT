/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import utils.Constantes;

/**
 *
 * @author lecap
 */
public class ConexionBD {
    public static final String URL_CONEXION = "jdbc:mysql://" + Constantes.HOSTNAME + ":"
            + Constantes.PUERTO + "/" + Constantes.NOMBRE_BD + "?allowPublicKeyRetrieval=true&useSSL=false";
    
    public static Connection obtenerConexion (){
        Connection conexionBD = null;
        try {
            Class.forName(Constantes.DRIVER);
            conexionBD = DriverManager.getConnection(URL_CONEXION, Constantes.USUARIO, Constantes.PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            
        }
        return conexionBD;
    }
}
