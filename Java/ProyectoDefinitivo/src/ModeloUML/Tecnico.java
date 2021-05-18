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
public class Tecnico {
    private int id;
    private String dni;
    private String nombre;
    private String apellido;
    private int sueldo;
    private String nickname;
    private TipoTecnico tipo;

    public Tecnico(int id, String dni, String nombre, String apellido, int sueldo, String nickname, TipoTecnico tipo) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sueldo = sueldo;
        this.nickname = nickname;
        this.tipo = tipo;
    }

    public Tecnico(int id, String dni, String nombre, String apellido, int sueldo, TipoTecnico tipo) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sueldo = sueldo;
        this.tipo = tipo;
    }

    public Tecnico() {
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

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public TipoTecnico getTipo() {
        return tipo;
    }

    public void setTipo(TipoTecnico tipo) {
        this.tipo = tipo;
    }

    
}
