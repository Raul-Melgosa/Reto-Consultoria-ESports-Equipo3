/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloBD;

import ModeloUML.Perfil;
import ModeloUML.TipoPerfil;
import java.sql.*;

/**
 *
 * @author 1GDAW09
 */
public class TablaPerfiles {
    Connection con;
    
    public Perfil buscarUsuario(Connection c, String nombre, String pass)
    {
        try
        {
            con=c;
            String plantilla="SELECT * FROM perfiles WHERE UPPER(NOMBRE_USUARIO)=UPPER(?) AND UPPER(CONTRASENNA)=UPPER(?)";
            PreparedStatement ps = con.prepareStatement(plantilla);
            ps.setString(1, nombre);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                String username=rs.getString("NOMBRE_USUARIO");
                String password=rs.getString("CONTRASENNA");
                String email=rs.getString("EMAIL");
                if(rs.getString("tipo").equals("ADMIN"))
                {
                    return new Perfil(username,password,email,TipoPerfil.ADMIN);
                }
                else
                {
                    return new Perfil(username,password,email,TipoPerfil.USU);
                }
            }
            else
            {
                return null;
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getClass());
            return null;
        }
    }
}
