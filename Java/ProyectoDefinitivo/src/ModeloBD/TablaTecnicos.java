/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloBD;

import ModeloUML.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Equipo 3(Raúl Melgosa, Oier Velar, Alaitz Candela)
 */
public class TablaTecnicos {
    Connection con;
    
    public String ValidarTecnico(Connection c,Tecnico t) throws Exception{
        con=c;
        String plantilla="SELECT TIPO FROM TECNICOS WHERE ID_EQUIPO=?";
        PreparedStatement ps=con.prepareStatement(plantilla);
        ps.setInt(1,t.getEquipo().getId());
        
        ResultSet rs= ps.executeQuery();
         String tipo="";
        if(rs.next()){
            tipo=rs.getString("TIPO");
        }
        return tipo;
    }
    public ArrayList <Integer> Sueldos(Connection c) throws Exception {
        con=c;
        String plantilla="SELECT SUELDO FROM TECNICOS";
        PreparedStatement ps=con.prepareStatement(plantilla);
        
        ResultSet rs= ps.executeQuery();
       ArrayList <Integer> sueldosT=new ArrayList();
        if(rs.next()){
             int sueldo=0;
            sueldo=rs.getInt("SUELDO");
            sueldosT.add(sueldo);
        }
        return sueldosT;
    }
    public boolean Insert (Connection c,Tecnico t) throws Exception {
        con=c;
        String plantilla="INSERT INTO TECNICOS(DNI,NOMBRE,APELLIDOS,NICKNAME,SUELDO,ID_EQUIPO,TIPO) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(plantilla);
        ps.setString(1, t.getDni());
        ps.setString(2, t.getNombre());
        ps.setString(3, t.getApellido());
        ps.setString(4, t.getNickname());
        ps.setInt(5, t.getSueldo());
        ps.setInt(6, t.getEquipo().getId());
        ps.setString(7, t.getTipo().toString());
        
        boolean insert=false;
        int n=ps.executeUpdate();
        if(n!=1)
            System.out.println("Objeto no modificado");
            
       else
            insert=true;
        
        return insert;
  
    }
    public boolean Delete(Connection c,Tecnico t) throws Exception{
        con=c;
        String plantilla="DELETE FROM TECNICOS WHERE UPPER(NOMBRE)=UPPER(?) AND UPPER(APELLIDOS)=UPPER(?)";
        PreparedStatement ps=con.prepareStatement(plantilla);
        ps.setString(1, t.getNombre());
        ps.setString(1, t.getApellido());
        
        boolean borrar=false;
        int n=ps.executeUpdate();
        if(n==1)
            borrar=true;
        
        return borrar;    
    }
    public boolean Update (Connection c,Tecnico t) throws Exception{
         con=c;
         String plantilla="UPDATE equipo SET upper(NOMBRE)=upper(?),UPPER(APELLIDO)=UPPER(?),SUELDO=?,ID_EQUIPO=?,UPPER(NICKNAME)=UPPER(?),UPPER(TIPO)=UPPER(?) WHERE upper(DNI)=upper(?)";
         PreparedStatement ps=con.prepareStatement(plantilla);
         ps.setString(1, t.getNombre());
         ps.setString(2, t.getApellido());
         ps.setInt(3, t.getSueldo());
         ps.setInt(4, t.getEquipo().getId());
         ps.setString(5, t.getNickname());
         ps.setString(6, t.getTipo().toString());
         ps.setString(7, t.getDni());
         int m=ps.executeUpdate();
         ps.close();
         boolean modificar=false;
         if(m==1){
               modificar=true;
         }
         
        return modificar;  
     }
    public ArrayList SelectNombre(Connection c) throws Exception{
        con=c;
        String plantilla="SELECT NOMBRE FROM TECNICOS ORDER BY ID_EQUIPO";
         PreparedStatement ps=con.prepareStatement(plantilla);
         ResultSet resultado=ps.executeQuery();
         
         ArrayList <Tecnico> nombreTecnico=new ArrayList();
         
         while(resultado.next()){
            Tecnico t =new Tecnico();
            t.setNombre(resultado.getString("NOMBRE"));
            nombreTecnico.add(t);
         }
        return nombreTecnico;
    }
    public Tecnico [] SelectTecnico(Connection c,Tecnico t) throws Exception{
         con=c;
         String plantilla="SELECT * FROM TECNICOS WHERE UPPER(NOMBRE)=UPPER(?)";
         PreparedStatement ps=con.prepareStatement(plantilla);
         ps.setString(1,t.getNombre());
         ResultSet resultado=ps.executeQuery();
         
          Tecnico [] datosTecnico=new Tecnico[2];
         Equipo e=new Equipo();
         while(resultado.next()){
            t.setNombre(resultado.getString("NOMBRE"));
            t.setSueldo(resultado.getInt("SUELDO"));
            e.setId(resultado.getInt("ID_EQUIPO"));
            t.setEquipo(e);
            t.setApellido(resultado.getString("APELLIDOS"));
            t.setNickname(resultado.getString("NICKNAME"));
            t.setTipo(TipoTecnico.valueOf("TIPO"));
            t.setTipo(TipoTecnico.valueOf("DNI"));
            
            datosTecnico[0]=t;
         }
        return datosTecnico;
     }
     public ArrayList <Tecnico> SelectGeneral(Connection c) throws Exception {
         con=c;
         String plantilla="SELECT * FROM tecnicos";
         PreparedStatement ps=con.prepareStatement(plantilla);
         
         ResultSet resultado=ps.executeQuery();
         
         ArrayList <Tecnico> datos=new ArrayList();
         TablaEquipos te = new TablaEquipos();
         while(resultado.next()){
             Tecnico t=new Tecnico();
             Equipo e=new Equipo();
             e.setNombre(te.SelectNombre(con, resultado.getInt("ID_EQUIPO")));
             t.setId(resultado.getInt("ID_TECNICO"));
             t.setDni(resultado.getString("DNI"));
             t.setNombre(resultado.getString("NOMBRE"));
             t.setApellido(resultado.getString("APELLIDOS"));
             t.setNickname(resultado.getString("NICKNAME"));
             t.setSueldo(resultado.getInt("SUELDO"));
             t.setTipo(TipoTecnico.valueOf(resultado.getString("TIPO")));
             t.setEquipo(e);
             datos.add(t);
         }
         return datos;
     }
}
