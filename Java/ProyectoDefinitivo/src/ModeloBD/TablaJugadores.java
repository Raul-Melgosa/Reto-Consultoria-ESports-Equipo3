/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloBD;

import java.sql.*;

/**
 *
 * @author Equipo 3(Raúl Melgosa, Oier Velar, Alaitz Candela)
 */
public class TablaJugadores {
    Connection con;
    
    public void prueba(Connection c) throws Exception
    {
        con=c;
        String plantilla = "Select * FROM Jugadores";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            System.out.println(rs.getString("nombre"));
        }
    }
}
