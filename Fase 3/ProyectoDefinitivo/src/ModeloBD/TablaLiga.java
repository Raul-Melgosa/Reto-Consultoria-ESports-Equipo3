/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloBD;

import ModeloUML.Jornada;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Equipo 3(Raúl Melgosa, Oier Velar, Alaitz Candela)
 */
public class TablaLiga {
    private static Connection con;
    
    public boolean generarLiga(Connection c)
    {
        con=c;
        try
        {
            CallableStatement cs = con.prepareCall("{call GENERAR_CALENDARIO_JORNADAS}");
            cs.execute();
            return true;
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getClass());
            return false;
        }
    }
    
    public ArrayList<Jornada> SelectJornadas(Connection c)
    {
        con=c;
        try
        {
            String plantilla = "SELECT ID_JORNADA FROM JORNADAS";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ResultSet rs=ps.executeQuery();
            ArrayList<Jornada> devolver=new ArrayList();
            int x=0;
            while(rs.next())
            {
                devolver.add(new Jornada(rs.getInt("ID_JORNADA")));
                devolver.get(x).setListaPartidos(new ArrayList());
                x++;
            }
            return devolver;
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getClass());
            return null;
        }
    }
    
    public void InsertarPartido(Connection c,int idLocal, int idVisitante,int idJornada,String hora)
    {
        con=c;
        try
        {
            String plantilla1 = "SELECT TO_CHAR(FECHA) FROM JORNADAS WHERE ID_JORNADA=?";
            PreparedStatement ps1 = con.prepareStatement(plantilla1);
            ps1.setInt(1, idJornada);
            ResultSet rs = ps1.executeQuery();
            if(rs.next())
            {
                hora+=" "+rs.getString("TO_CHAR(FECHA)");
            }
            String plantilla = "INSERT INTO PARTIDOS(ID_LOCAL,ID_VISITANTE,ID_JORNADA,HORA) VALUES(?,?,?,TO_TIMESTAMP(?,'HH24:MI:SS dd/MM/yy'))";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ps.setInt(1, idLocal);
            ps.setInt(2, idVisitante);
            ps.setInt(3, idJornada);
            ps.setString(4, hora);
            ps.executeUpdate();
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getClass());
        }
    }
    
    public ArrayList<String[]> SelectClasificacion(Connection c)
    {
        con=c;
        ArrayList<String[]> devolver=new ArrayList();
        try
        {
            String plantilla="SELECT E.ID_EQUIPO,NVL(COUNT(P.ID_EQUIPO_GANADOR)*3,0) PUNTOS FROM EQUIPOS E, PARTIDOS P WHERE ID_EQUIPO=ID_EQUIPO_GANADOR(+) GROUP BY ID_EQUIPO ORDER BY PUNTOS DESC";
            PreparedStatement ps=con.prepareStatement(plantilla);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                String[] datos = new String[2];
                datos[0]=rs.getString("ID_EQUIPO");
                datos[1]=rs.getString("PUNTOS");
                devolver.add(datos);
            }
            if(devolver.isEmpty())
            {
                return null;
            }
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getClass());
        }
        return devolver;
    }
}
