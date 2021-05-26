/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloBD;

import ModeloUML.Equipo;
import ModeloUML.Jugador;
import ModeloUML.TipoRol;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Equipo 3(Raúl Melgosa, Oier Velar, Alaitz Candela)
 */
public class TablaJugadores {
    Connection con;
    
    public boolean Insert(Connection c,Jugador j) throws Exception
    {
        con=c;
        String plantilla = "INSERT INTO JUGADORES(DNI,NOMBRE,APELLIDOS,NICKNAME,ROL,DORSAL,SUELDO,ID_EQUIPO) VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement ps= con.prepareStatement(plantilla);
        ps.setString(1, j.getDni());
        ps.setString(2, j.getNombre());
        ps.setString(3, j.getApellido());
        ps.setString(4, j.getNickname());
        ps.setString(5, j.getRol().toString());
        ps.setInt(6, j.getDorsal());
        ps.setInt(7, j.getSueldo());
        ps.setString(8, j.getEquipo().getNombre());
        
        boolean insert=false;
        int n=ps.executeUpdate();
        if(n==1){
            insert=true;
        }
        ps.close();
        return insert;    
    }
    public boolean Delete(Connection c, String nombre,String apellido) throws Exception{
        con=c;
        String plantilla="DELETE FROM JUGADORES WHERE UPPER(NOMBRE)=UPPER(?) AND UPPER(APELLIDO)=UPPER(?)";
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
        String plantilla="SELECT NOMBRE FROM JUGADORES ORDER BY ID_EQUIPO";
         PreparedStatement ps=con.prepareStatement(plantilla);
         ResultSet resultado=ps.executeQuery();
         
         ArrayList <Jugador> nombreJugador=new ArrayList();
         
         while(resultado.next()){
            Jugador j =new Jugador();
            j.setNombre(resultado.getString("NOMBRE"));
            nombreJugador.add(j);
         }
        return nombreJugador;
    }
     public Jugador [] SelectJugador(Connection c,Jugador j) throws Exception{
         con=c;
         String plantilla="SELECT * FROM JUGADORES WHERE UPPER(NOMBRE)=UPPER(?)";
         PreparedStatement ps=con.prepareStatement(plantilla);
         ps.setString(1,j.getNombre());
         ResultSet resultado=ps.executeQuery();
         
          Jugador [] datosJugador=new Jugador[7];
         Equipo e=new Equipo();
         while(resultado.next()){
            j.setNombre(resultado.getString("NOMBRE"));
            j.setDni(resultado.getString("DNI"));
            j.setRol(TipoRol.valueOf(resultado.getString("ROL")));
            j.setDorsal(resultado.getInt("DORSAL"));
            j.setSueldo(resultado.getInt("SUELDO"));
            e.setId(resultado.getInt("ID_EQUIPO"));
            j.setEquipo(e);
            
            
            datosJugador[0]=j;
         }
        return datosJugador;
     }
     public boolean Update (Connection c,Jugador j) throws Exception{
         con=c;
         String plantilla="UPDATE equipo SET upper(ROL)=upper(?),DORSAL=?,SUELDO=?,ID_EQUIPO=? WHERE upper(DNI)=upper(?)";
         PreparedStatement ps=con.prepareStatement(plantilla);
         ps.setString(1, j.getRol().toString());
         ps.setInt(2, j.getDorsal());
         ps.setInt(3,j.getSueldo());
         ps.setInt(4, j.getEquipo().getId());
         ps.setString(5,j.getDni());
         
         int m=ps.executeUpdate();
         ps.close();
         boolean modificar=false;
         if(m==1){
               modificar=true;
         }
         
        return modificar;  
     }
     public ArrayList <Integer> Sueldos(Connection c) throws Exception {
        con=c;
        String plantilla="SELECT SUELDO FROM JUGADORES";
        PreparedStatement ps=con.prepareStatement(plantilla);
        
        ResultSet rs= ps.executeQuery();
       ArrayList <Integer> sueldosJ=new ArrayList();
        if(rs.next()){
             int sueldo=0;
            sueldo=rs.getInt("SUELDO");
            sueldosJ.add(sueldo);
        }
        return sueldosJ;
    }
      public ArrayList <Jugador> SelectGeneral(Connection c) throws Exception {
         con=c;
         String plantilla="SELECT * FROM jugadores";
         PreparedStatement ps=con.prepareStatement(plantilla);
         
         ResultSet resultado=ps.executeQuery();
         TablaEquipos te = new TablaEquipos();
         ArrayList <Jugador> datos=new ArrayList();
         while(resultado.next()){
             Equipo e=new Equipo();
             e.setNombre(te.SelectNombre(con, resultado.getInt("ID_EQUIPO")));
             Jugador j=new Jugador();
             j.setEquipo(e);
             j.setId(resultado.getInt("ID_JUGADORES"));
             j.setDni(resultado.getString("DNI"));
             j.setNombre(resultado.getString("NOMBRE"));
             j.setApellido(resultado.getString("APELLIDOS"));
             j.setNickname(resultado.getString("NICKNAME"));
             j.setRol(TipoRol.valueOf(resultado.getString("ROL")));
             j.setSueldo(resultado.getInt("SUELDO"));
             j.setDorsal(resultado.getInt("Dorsal"));
             
             datos.add(j);
         }
         return datos;
     }
}
