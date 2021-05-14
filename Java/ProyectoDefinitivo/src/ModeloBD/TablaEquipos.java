/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloBD;

import ModeloUML.Equipo;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author 1GDAW07
 */
public class TablaEquipos {
    Connection con;
    
     public boolean Insert(Equipo e) throws Exception {
        String plantilla="INSERT INTO EQUIPOS(NOMBRE,ID_JEFE) VALUES(?,?)); ";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setString(1,e.getNombre());
        ps.setInt(2,e.getJefe().getId());
        
        boolean insertado=false;
        
        int n=ps.executeUpdate();
        ps.close();
        if(n==1){
            insertado=true;
        }
        return insertado;
    }
}
