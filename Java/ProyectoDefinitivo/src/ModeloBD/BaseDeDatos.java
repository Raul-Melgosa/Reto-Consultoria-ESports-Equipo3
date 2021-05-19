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
public class BaseDeDatos {
    private Connection con;
    
    public Connection conectar()
    {
        try
        {
            // Registramos el driver
            Class.forName("oracle.jdbc.OracleDriver");            
            
            String login="eqdaw03"; // usuario
            String password= "eqdaw03"; // contrasena˜
            String url = "jdbc:oracle:thin:@SrvOracle:1521:orcl";
            con = DriverManager . getConnection (url ,login ,password);
        }
        catch( ClassNotFoundException e)
        {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
        catch(SQLException e)
        {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
        return con;
    }
}
