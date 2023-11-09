/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.conexion.ConexionBD;
import modelo.pojo.RespuestaLogin;
import modelo.pojo.Usuario;

/**
 *
 * @author lecap
 */
public class UsuarioDAO {
    
    public static RespuestaLogin iniciarSesion(String email, String password) throws SQLException{
        RespuestaLogin respuesta = new RespuestaLogin();
        Connection conexionBD = ConexionBD.obtenerConexion();
        if (conexionBD != null) {
            try {
                String consulta = "SELECT id_usuario, nombre, apellido_paterno, apellido_materno, email, matricula, tipo_usuario "
                        + "FROM usuarios WHERE email = ? AND contrasena = (SHA2(?, 256))";
                PreparedStatement prepararConsulta = conexionBD.prepareStatement(consulta);
                prepararConsulta.setString(1, email);
                prepararConsulta.setString(2, password);
                ResultSet resultadoSentencia = prepararConsulta.executeQuery();
                if (resultadoSentencia.next()) {
                    respuesta.setError(false);
                    respuesta.setMensaje("Credenciales correctas");
                    Usuario usuario = new Usuario();
                    usuario.setUserId(resultadoSentencia.getInt("id_usuario"));
                    usuario.setNombre(resultadoSentencia.getString("nombre"));
                    usuario.setApellidoPaterno(resultadoSentencia.getString("apellido_paterno"));
                    usuario.setApellidoMaterno(resultadoSentencia.getString("apellido_materno"));
                    usuario.setEmail(resultadoSentencia.getString("email"));
                    usuario.setMatricula(resultadoSentencia.getString("matricula"));
                    usuario.setTipoUsuario(resultadoSentencia.getString("tipo_usuario"));
                    respuesta.setUsuario(usuario);
                }else{
                    respuesta.setError(true);
                    respuesta.setMensaje("Credenciales incorrectas");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                respuesta.setMensaje("Error de conexion con la base de datos");
            }finally{
                conexionBD.close();
            }
        }else{
            respuesta.setMensaje("Error en la conexion");
        }
        return respuesta;
    }
}
