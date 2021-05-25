/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloBD;

import ModeloUML.Jornada;
import ModeloUML.Partido;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Equipo 3(Raúl Melgosa, Oier Velar, Alaitz Candela)
 */
public class TablaJornada {
    Connection con;
    
    public ArrayList <Jornada> ListaJornada(Connection c) throws Exception{
        con=c;
        String plantilla="SELECT * FROM jornadas";
        PreparedStatement ps=con.prepareStatement(plantilla);
        
         ArrayList <Jornada> listaJornada=new ArrayList();
        TablaPartido tp=new TablaPartido();
       ResultSet rs=ps.executeQuery();
       while(rs.next()){
           Jornada jornada=new Jornada();
           jornada.setId(rs.getInt("ID_JORNADA"));
           Date d = rs.getDate("FECHA");
           jornada.setFecha(d.toLocalDate());
           ArrayList <Partido> partidos=new ArrayList();
           partidos=tp.ListaPartidos(con,jornada.getId());
           jornada.setListaPartidos(partidos);
           listaJornada.add(jornada);
       }
       return listaJornada;
    }
}
