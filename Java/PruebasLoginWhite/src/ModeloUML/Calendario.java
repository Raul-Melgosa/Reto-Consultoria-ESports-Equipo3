/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloUML;

import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author Equipo 3(Raúl Melgosa, Oier Velar, Alaitz Candela)
 */
public class Calendario {
    private int id;
    private LocalDate fechaCierre;
    private LocalDate fechaExpiracion;
    private String descripcion;
    private ArrayList<Jornada> listaJornadas;

    public Calendario(int id, LocalDate fechaCierre, LocalDate fechaExpiracion, String descripcion) {
        this.id = id;
        this.fechaCierre = fechaCierre;
        this.fechaExpiracion = fechaExpiracion;
        this.descripcion = descripcion;
    }

    public Calendario(int id, LocalDate fechaCierre, LocalDate fechaExpiracion, String descripcion, ArrayList<Jornada> listaJornadas) {
        this.id = id;
        this.fechaCierre = fechaCierre;
        this.fechaExpiracion = fechaExpiracion;
        this.descripcion = descripcion;
        this.listaJornadas = listaJornadas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(LocalDate fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public LocalDate getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDate fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Jornada> getListaJornadas() {
        return listaJornadas;
    }

    public void setListaJornadas(ArrayList<Jornada> listaJornadas) {
        this.listaJornadas = listaJornadas;
    }
    
    
}
