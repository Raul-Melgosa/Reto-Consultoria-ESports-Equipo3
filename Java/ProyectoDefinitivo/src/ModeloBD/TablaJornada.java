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
    
    public String selectFecha(Connection c,int idJornada) throws Exception{
        con=c;
        String plantilla="SELECT TO_CHAR(FECHA,'dd/MM/yyyy') fecha FROM jornadas WHERE id_jornada=?";
        PreparedStatement ps=con.prepareStatement(plantilla);
        ps.setInt(1, idJornada);
        
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
            return rs.getString("fecha");
        }
        return null;
    }
    
    public Jornada UltimaJornada(Connection c) throws Exception{
        con=c;
        String plantilla="SELECT * FROM jornadas WHERE FECHA=TO_DATE(TO_CHAR((SYSDATE)),'dd/MM/yy') \n" +
                                                    "OR FECHA=TO_DATE(TO_CHAR((SYSDATE-1)),'dd/MM/yy')\n" +
                                                    "OR FECHA=TO_DATE(TO_CHAR((SYSDATE-2)),'dd/MM/yy')\n" +
                                                    "OR FECHA=TO_DATE(TO_CHAR((SYSDATE-3)),'dd/MM/yy')\n" +
                                                    "OR FECHA=TO_DATE(TO_CHAR((SYSDATE-4)),'dd/MM/yy')\n" +
                                                    "OR FECHA=TO_DATE(TO_CHAR((SYSDATE-5)),'dd/MM/yy')\n" +
                                                    "OR FECHA=TO_DATE(TO_CHAR((SYSDATE-6)),'dd/MM/yy')";
        PreparedStatement ps=con.prepareStatement(plantilla);
        
        TablaPartido tp = new TablaPartido();
        ResultSet rs=ps.executeQuery();
        Jornada jornada=new Jornada();
        if(rs.next()){
            
            jornada.setId(rs.getInt("ID_JORNADA"));
            Date d = rs.getDate("FECHA");
            jornada.setFecha(d.toLocalDate());
            ArrayList <Partido> partidos=new ArrayList();
            partidos=tp.ListaPartidos(con,jornada.getId());
            jornada.setListaPartidos(partidos);
       }
        return jornada;
    }
}
