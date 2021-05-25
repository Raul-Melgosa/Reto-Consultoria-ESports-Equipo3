/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloBD;

import ModeloUML.*;
import java.sql.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Equipo 3(Raúl Melgosa, Oier Velar, Alaitz Candela)
 */
public class TablaPartido {
    Connection con;
    
    public ArrayList<Partido> ListaPartidos(Connection c,int idJornada) throws Exception{
        con=c;
        String plantilla="SELECT ID_PARTIDO,ID_LOCAL,ID_VISITANTE,TO_CHAR(HORA,'HH24:mi:ss') HORA,PARTIDAS_GANADAS_LOCAL,PARTIDAS_GANADAS_VISITANTE FROM partidos WHERE ID_JORNADA=?";
        PreparedStatement ps=con.prepareStatement(plantilla);
        ps.setInt(1, idJornada);
        
        ArrayList <Partido> listaPartidos= new ArrayList();
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            Partido p=new Partido(); 
            p.setId(rs.getInt("ID_PARTIDO"));
            p.setIdLocal(rs.getInt("ID_LOCAL"));
            p.setIdVisitante(rs.getInt("ID_VISITANTE"));
            p.setHora(LocalTime.parse(rs.getString("HORA"), DateTimeFormatter.ofPattern("HH:mm:ss")));
            p.setPartidasGanadasLocal(rs.getInt("PARTIDAS_GANADAS_LOCAL"));
            p.setPartidasGanadasVisitante(rs.getInt("PARTIDAS_GANADAS_VISITANTE"));   
            listaPartidos.add(p);
        }
        return listaPartidos;
    }
    public String SelectPartidasLocal(Connection c,int idPartido) throws Exception{
        con=c;
        String plantilla="SELECT NVL(TO_CHAR(PARTIDAS_GANADAS_LOCAL) ,'Partidas ganadas') PARTIDAS_GANADAS_LOCAL FROM partidos WHERE ID_PARTIDO=?";
        PreparedStatement ps=con.prepareStatement(plantilla);
        ps.setInt(1, idPartido);
        
        String devolver="";
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            devolver=rs.getString("PARTIDAS_GANADAS_LOCAL");
        }
        return devolver;
    }
    
    public String SelectPartidasVisitante(Connection c,int idPartido) throws Exception{
        con=c;
        String plantilla="SELECT NVL(TO_CHAR(PARTIDAS_GANADAS_VISITANTE) ,'Partidas ganadas') PARTIDAS_GANADAS_VISITANTE FROM partidos WHERE ID_PARTIDO=?";
        PreparedStatement ps=con.prepareStatement(plantilla);
        ps.setInt(1, idPartido);
        
        String devolver="";
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            devolver=rs.getString("PARTIDAS_GANADAS_VISITANTE");
        }
        return devolver;
    }
}
