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
    
    /**
     * Metodo para conectarse con la base de datos
     * @return devuelve la conexion
     */
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

//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            String user = "hr";
//            String pass = "hr";
//            
//            con=java.sql.DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xepdb1",user,pass);
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
    
    /**
     * Metodo para desconectarse de la base de datos
     */
    public void desconectar(){
        try{
           con.close();
        }
        catch(Exception e){
            System.out.println("Error al cerrar la conexión");
        }

        
    }
}
