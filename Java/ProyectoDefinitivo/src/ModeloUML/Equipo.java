/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloUML;

import java.util.ArrayList;

/**
 *
 * @author Equipo 3(Raúl Melgosa, Oier Velar, Alaitz Candela)
 */
public class Equipo {
    private int id;
    private String nombre;
    private ArrayList<Jugador> jugadoresEquipo;
    private Tecnico principal;
    private Tecnico asistente;

    public Equipo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Equipo(int id, String nombre, ArrayList<Jugador> jugadoresEquipo, Tecnico principal) {
        this.id = id;
        this.nombre = nombre;
        this.jugadoresEquipo = jugadoresEquipo;
        this.principal = principal;
    }

    public Equipo(int id, String nombre, ArrayList<Jugador> jugadoresEquipo, Tecnico principal, Tecnico asistente) {
        this.id = id;
        this.nombre = nombre;
        this.jugadoresEquipo = jugadoresEquipo;
        this.principal = principal;
        this.asistente = asistente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Jugador> getJugadoresEquipo() {
        return jugadoresEquipo;
    }

    public void setJugadoresEquipo(ArrayList<Jugador> jugadoresEquipo) {
        this.jugadoresEquipo = jugadoresEquipo;
    }

    public Tecnico getPrincipal() {
        return principal;
    }

    public void setPrincipal(Tecnico principal) {
        this.principal = principal;
    }

    public Tecnico getAsistente() {
        return asistente;
    }

    public void setAsistente(Tecnico asistente) {
        this.asistente = asistente;
    }
    
    
}
