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
import java.util.ArrayList;

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
       public ArrayList SelectNombre(Connection c) throws Exception{
        con=c;
        String plantilla="SELECT NOMBRE FROM jefes";
        PreparedStatement ps=con.prepareStatement(plantilla);
        ResultSet resultado=ps.executeQuery();
         
        ArrayList <Jefe> nombreEquipo=new ArrayList();
         
        while(resultado.next()){
           Jefe jefe =new Jefe();
           jefe.setNombre(resultado.getString("NOMBRE"));
           nombreEquipo.add(jefe);
        }
        return nombreEquipo;
    }
    public ArrayList <Jefe> SelectJefe(Connection c,Jefe j) throws Exception{
        con=c;
        String plantilla="Select * FROM jefes WHERE upper(nombre)=upper(?)";
        PreparedStatement ps=con.prepareStatement(plantilla);
        ps.setString(1,j.getNombre());
        
        ArrayList <Jefe> datos=new ArrayList();
        ResultSet resultado=ps.executeQuery();
        if(resultado.next()){
            j.setDni(resultado.getString("DNI"));
            j.setApellido(resultado.getString("APELLIDOS"));
            j.setNickname(resultado.getString("NICKNAME"));
            j.setEmail(resultado.getString("EMAIL"));
            
            datos.add(j);
        }
         return datos;
    }
    public boolean Update(Connection c,Jefe j) throws Exception{
        con=c;
        String plantilla="UPDATE jefes SET nombre=?,apellidos=?,nickname=?,email=? WHERE upper(dni)=upper(?)";
        PreparedStatement ps=con.prepareStatement(plantilla);
        ps.setString(1,j.getNombre());
        ps.setString(2,j.getApellido());
        ps.setString(3,j.getNickname());
        ps.setString(4,j.getEmail());
        ps.setString(5,j.getDni());
         
        int m=ps.executeUpdate();
        boolean modificar=false;
        if(m==1){
            modificar=true;
        }
        ps.close();
        return modificar;
    }
    public ArrayList <Integer> Sueldos(Connection c) throws Exception {
        con=c;
        String plantilla="SELECT SUELDO FROM JEFES";
        PreparedStatement ps=con.prepareStatement(plantilla);
        
        ResultSet rs= ps.executeQuery();
       ArrayList <Integer> sueldosJefe=new ArrayList();
        if(rs.next()){
             int sueldo=0;
            sueldo=rs.getInt("SUELDO");
            sueldosJefe.add(sueldo);
        }
        return sueldosJefe;
    }
     public ArrayList <Jefe> SelectGeneral(Connection c) throws Exception {
         con=c;
         String plantilla="SELECT * FROM jefes";
         PreparedStatement ps=con.prepareStatement(plantilla);
         
         ResultSet resultado=ps.executeQuery();
         
         ArrayList <Jefe> datos=new ArrayList();
         if(resultado.next()){
             Jefe j=new Jefe();
             j.setNombre(resultado.getString("NOMBRE"));
             j.setApellido(resultado.getString("APELLIDO"));
             j.setDni(resultado.getString("DNI"));
             j.setId(resultado.getInt("ID_JEFE"));
             j.setEmail(resultado.getString("EMAIL"));
             j.setNickname(resultado.getString("NICKNAME"));
             datos.add(j);
         }
         return datos;
     }

}
