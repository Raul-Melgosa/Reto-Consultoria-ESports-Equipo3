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
public class Jugador {
    private int id;
    private String dni;
    private String nombre;
    private String apellido;
    private String nickname;
    private TipoRol rol;
    private int sueldo;
    private int dorsal;

    public Jugador(int id, String dni, String nombre, String apellido, String nickname, TipoRol rol, int sueldo, int dorsal) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname = nickname;
        this.rol = rol;
        this.sueldo = sueldo;
        this.dorsal = dorsal;
    }

    public Jugador() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public TipoRol getRol() {
        return rol;
    }

    public void setRol(TipoRol rol) {
        this.rol = rol;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }
    
    
}
