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
    public boolean Insert(Connection c,Jefe j) throws Exception{
        con=c;
        String plantilla="INSERT INTO JEFES(DNI,NOMBRE,APELLIDOS,NICKNAME,EMAIL) VALUES(?,?,?,?,?)";
        PreparedStatement ps= con.prepareStatement(plantilla);
        ps.setString(1,j.getDni());
        ps.setString(2,j.getNombre());
        ps.setString(3,j.getApellido());
        ps.setString(4,j.getNickname());
        ps.setString(5,j.getEmail());
        
        int n=ps.executeUpdate();
        boolean insert=false;
        if(n==1){
            insert=true;
        }
        return insert;
    }
      public boolean Delete(Connection c, String nombre,String apellido) throws Exception{
        con=c;
        String plantilla="DELETE FROM JEFES WHERE UPPER(NOMBRE)=UPPER(?) AND UPPER(APELLIDO)=UPPER(?)";
        PreparedStatement ps=con.prepareStatement(plantilla);
        ps.setString(1,nombre);
        ps.setString(2,apellido);
        
        boolean delete=false;
        int n=ps.executeUpdate();
        if(n==1){
            delete=true;
        }
        return delete;
    }
}
