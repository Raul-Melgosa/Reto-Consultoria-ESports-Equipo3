/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloUML;

import java.time.LocalTime;

/**
 *
 * @author Equipo 3(Raúl Melgosa, Oier Velar, Alaitz Candela)
 */
public class Partido {
    private int id;
    private LocalTime hora;
    private int partidasGanadasLocal;
    private int partidasGanadasVisitante;
    private int idLocal;
    private int idVisitante;
    private int idGanador;
    

    public Partido(int id, LocalTime hora, int idLocal, int idVisitante) {
        this.id = id;
        this.hora = hora;
        this.idLocal = idLocal;
        this.idVisitante = idVisitante;
    }
    
    public Partido(int idLocal, int idVisitante) {
        this.idLocal = idLocal;
        this.idVisitante = idVisitante;
    }

    public Partido(int id, LocalTime hora, int partidasGanadasLocal, int partidasGanadasVisitante, int idLocal, int idVisitante, int idGanador) {
        this.id = id;
        this.hora = hora;
        this.partidasGanadasLocal = partidasGanadasLocal;
        this.partidasGanadasVisitante = partidasGanadasVisitante;
        this.idLocal = idLocal;
        this.idVisitante = idVisitante;
        this.idGanador = idGanador;
    }

    public Partido() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getPartidasGanadasLocal() {
        return partidasGanadasLocal;
    }

    public void setPartidasGanadasLocal(int partidasGanadasLocal) {
        this.partidasGanadasLocal = partidasGanadasLocal;
    }

    public int getPartidasGanadasVisitante() {
        return partidasGanadasVisitante;
    }

    public void setPartidasGanadasVisitante(int partidasGanadasVisitante) {
        this.partidasGanadasVisitante = partidasGanadasVisitante;
    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public int getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(int idVisitante) {
        this.idVisitante = idVisitante;
    }

    public int getIdGanador() {
        return idGanador;
    }

    public void setIdGanador(int idGanador) {
        this.idGanador = idGanador;
    }
    
    
}
