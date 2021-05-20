/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloBD;

import ModeloUML.Equipo;
import ModeloUML.Jefe;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author 1GDAW07
 */
public class TablaEquipos {
    Connection con;
    
     public boolean Insert(Connection c,Equipo e) throws Exception {
         con=c;
        String plantilla="INSERT INTO EQUIPOS(NOMBRE,ID_JEFE) VALUES(?,?)";
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
     public boolean Delete (Connection c,Equipo e) throws Exception{
         con=c;
         String plantilla="DELETE FROM EQUIPO WHERE upper(nombre)=upper(?) ";
         PreparedStatement ps= con.prepareStatement(plantilla);
         ps.setString(1, e.getNombre());
         
         int n=ps.executeUpdate();
         boolean borrar=false;
         ps.close();
         if(n==1){
             borrar=true;
         }
         
        return borrar;  
     }
     public Equipo SelectTodosLosDatosDeUnEquipo (Connection c, Equipo e) throws Exception {
         con=c;
         String plantilla="SELECT * FROM equipos WHERE id_equipo=?";
         PreparedStatement ps=con.prepareStatement(plantilla);
         ps.setInt(1, e.getId());
         
         ResultSet resultado=ps.executeQuery();
         Jefe j=new Jefe();
         if(resultado.next()){
             e.setNombre(resultado.getString("NOMBRE"));
             j.setId(resultado.getInt(" ID_JEFE"));
             e.setJefe(j);
         }
         return e;
     }
     public boolean UpdateNombre (Connection c,String n,int idEquipo) throws Exception{
         con=c;
         String plantilla="UPDATE equipo SET upper(NOMBRE)=upper(?) WHERE id_equipo=? ";
         PreparedStatement ps=con.prepareStatement(plantilla);
         ps.setString(1, n);
         ps.setInt(2, idEquipo);
         
         int m=ps.executeUpdate();
         ps.close();
         boolean modificar=false;
         if(m==1){
               modificar=true;
         }
         
        return modificar;  
     }
     public boolean UpdateIdJefe (Connection c, int id,int idEquipo) throws Exception{
          con=c;
         String plantilla="UPDATE equipo SET upper(ID_JEFE)=upper(?) WHERE id_equipo=? ";
         PreparedStatement ps=con.prepareStatement(plantilla);
         ps.setInt(1, id);
         ps.setInt(2, idEquipo);
         
         int m=ps.executeUpdate();
         ps.close();
         boolean modificar=false;
         if(m==1){
               modificar=true;
         }
         
        return modificar;  
     }
    public int SelectID(Connection c, String n) throws Exception{
        con=c;
        String plantilla="Select ID_EQUIPO FROM EQUIPOS WHERE upper(nombre)=upper(?)";
        PreparedStatement ps=con.prepareStatement(plantilla);
        ps.setString(1, n);
        int id=0;
        ResultSet resultado=ps.executeQuery();
         if(resultado.next()){
             id=resultado.getInt("ID_EQUIPO");
         }
         return id;
    }
    public ArrayList SelectGeneral(Connection c) throws Exception{
        con=c;
        String plantilla="SELECT NOMBRE,ID_EQUIPO FROM equipos ";
         PreparedStatement ps=con.prepareStatement(plantilla);
         ResultSet resultado=ps.executeQuery();
         
         ArrayList <Equipo> nombreEquipo=new ArrayList();
         
         while(resultado.next()){
            Equipo e =new Equipo();
            e.setNombre(resultado.getString("NOMBRE"));
            e.setId(resultado.getInt("ID_EQUIPO"));
            nombreEquipo.add(e);
         }
        return nombreEquipo;
    }
    public String SelectNombre(Connection c, int ID) throws Exception{
        con=c;
        String plantilla="Select NOMBRE FROM EQUIPOS WHERE ID_EQUIPO=?";
        PreparedStatement ps=con.prepareStatement(plantilla);
        ps.setInt(1,ID );
       String nom="";
        ResultSet resultado=ps.executeQuery();
         if(resultado.next()){
            nom=resultado.getString("NOMBRE");
         }
         return nom;
    }
}
