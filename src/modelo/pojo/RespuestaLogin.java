/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.pojo;

/**
 *
 * @author lecap
 */
public class RespuestaLogin {
    
    private boolean error;
    private String mensaje;
    private Usuario usuario;

    public RespuestaLogin(boolean error, String mensaje, Usuario usuario) {
        this.error = error;
        this.mensaje = mensaje;
        this.usuario = usuario;
    }

    public RespuestaLogin() {
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
