/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloBD;

import ModeloUML.Jefe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author 1GDAW07
 */
public class TablaJefes {
    Connection con;
    
    public int Select(Connection c,Jefe j) throws Exception {
        con=c;
        String plantilla="Select id_jefe FROM jefes WHERE upper(nombre)=upper(?) AND upper(apellidos)=upper(?)";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setString(1,j.getNombre());
        ps.setString(2,j.getApellido());
        
        ResultSet resultado=ps.executeQuery();
        int id=0;
        if(resultado.next()){
            id=resultado.getInt("ID_JEFE");
            System.out.println("a");
        }
        return id;
    }
}
