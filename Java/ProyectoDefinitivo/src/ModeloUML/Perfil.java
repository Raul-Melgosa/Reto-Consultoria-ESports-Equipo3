/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloUML;

/**
 *
 * @author Equipo 3(Raúl Melgosa, Oier Velar, Alaitz Candela)
 */
public class Perfil {
    private String nombreUsuario;
    private String password;
    private String email;
    private TipoPerfil tipo;
    private int id;

    public Perfil(String nombreUsuario, String password, String email, TipoPerfil tipo) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.email = email;
        this.tipo = tipo;
    }

    public Perfil() {
    }
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoPerfil getTipo() {
        return tipo;
    }

    public void setTipo(TipoPerfil tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id=" + id + "nombreUsuario=" + nombreUsuario + ", password=" + password + ", email=" + email + ", tipo=" + tipo ;
    }
    
    
    
}
