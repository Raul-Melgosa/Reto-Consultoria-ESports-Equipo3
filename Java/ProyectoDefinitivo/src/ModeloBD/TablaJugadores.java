/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloBD;

import ModeloUML.Jugador;
import java.sql.*;

/**
 *
 * @author Equipo 3(Raúl Melgosa, Oier Velar, Alaitz Candela)
 */
public class TablaJugadores {
    Connection con;
    
    public boolean Insert(Connection c,Jugador j) throws Exception
    {
        con=c;
        String plantilla = "INSERT INTO JUGADORES(DNI,NOMBRE,APELLIDOS,NICKNAME,ROL,DORSAL,SUELDO,ID_EQUIPO) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement ps= con.prepareStatement(plantilla);
        ps.setString(1, j.getDni());
        ps.setString(2, j.getNombre());
        ps.setString(3, j.getApellido());
        ps.setString(4, j.getNickname());
        ps.setString(5, j.getRol().toString());
        ps.setInt(6, j.getDorsal());
        ps.setInt(7, j.getSueldo());
        ps.setString(8,j.getEquipo().getNombre());
        
        boolean insert=false;
        ps.close();
        int n=ps.executeUpdate();
        if(n==1){
            insert=true;
        }
        return insert;    
    }
}
