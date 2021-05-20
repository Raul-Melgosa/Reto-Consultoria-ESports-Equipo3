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
 * @author 1GDAW09
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
            while(rs.next())
            {
                devolver.add(new Jornada(rs.getInt("ID_JORNADA")));
            }
            return devolver;
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getClass());
            return null;
        }
    }
    
    public void insertarPartido(Connection c,int idLocal, int idVisitante,int idJornada)
    {
        con=c;
        try
        {
            String plantilla = "INESRT INTO PARTIDOS(ID_LOCAL,ID_VISITANTE,ID_JORNADA) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ps.setInt(1, idLocal);
            ps.setInt(2, idVisitante);
            ps.setInt(3, idJornada);
            ps.executeUpdate();
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getClass());
        }
    }
}
