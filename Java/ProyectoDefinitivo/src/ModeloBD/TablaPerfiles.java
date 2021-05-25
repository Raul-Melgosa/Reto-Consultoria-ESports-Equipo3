/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloBD;

import ModeloUML.Perfil;
import ModeloUML.TipoPerfil;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Equipo 3(Raúl Melgosa, Oier Velar, Alaitz Candela)
 */
public class TablaPerfiles {
    Connection con;
    
    public Perfil buscarUsuario(Connection c, String nombre, String pass)
    {
        try
        {
            con=c;
            String plantilla="SELECT * FROM perfiles WHERE NOMBRE_USUARIO=? AND CONTRASENNA=?";
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
    public boolean Insert(Connection c,Perfil p) throws Exception {
       con=c;
       String plantilla="INSERT INTO PERFILES(NOMBRE_USUARIO,EMAIL,CONTRASENNA,TIPO) VALUES(?,?,?,?)";
       PreparedStatement ps=con.prepareStatement(plantilla);
       ps.setString(1, p.getNombreUsuario());
       ps.setString(2,p.getEmail());
       ps.setString(3, p.getPassword());
       ps.setString(4, p.getTipo().toString());
       
       int n=ps.executeUpdate();
       boolean insert=false;
       if(n==1){
           insert=true;
       }
       return insert;
    }
     public boolean Delete(Connection c,Perfil p) throws Exception {
       con=c;
       String plantilla="DELETE FROM perfiles WHERE UPPER(NOMBRE_USUARIO)=?";
       PreparedStatement ps=con.prepareStatement(plantilla);
       ps.setString(1, p.getNombreUsuario());
      
       
       int n=ps.executeUpdate();
       boolean insert=false;
       if(n==1){
           insert=true;
       }
       return insert;
    }
     public ArrayList SelectNombreUsuario(Connection c) throws Exception{
        con=c;
        String plantilla="SELECT NOMBRE_USUARIO FROM perfiles ";
         PreparedStatement ps=con.prepareStatement(plantilla);
         ResultSet resultado=ps.executeQuery();
         
         ArrayList <Perfil> nombreEquipo=new ArrayList();
         
         while(resultado.next()){
            Perfil p =new Perfil();
            p.setNombreUsuario(resultado.getString("NOMBRE_USUARIO"));
            nombreEquipo.add(p);
         }
        return nombreEquipo;
    }
       public ArrayList <Perfil> SelectPerfil(Connection c,Perfil p) throws Exception{
        con=c;
        String plantilla="Select * FROM PERFILES WHERE upper(NOMBRE_USUARIO)=upper(?)";
        PreparedStatement ps=con.prepareStatement(plantilla);
        ps.setString(1,p.getNombreUsuario());
        
        ArrayList <Perfil> datos=new ArrayList();
        ResultSet resultado=ps.executeQuery();
        while(resultado.next()){
            p.setNombreUsuario(resultado.getString("NOMBRE_USUARIO"));
            p.setPassword(resultado.getString("CONTRASENNA"));
            p.setEmail(resultado.getString("EMAIL"));
            p.setTipo(TipoPerfil.valueOf(resultado.getString("TIPO")));
            
            datos.add(p);
        }
         return datos;
    }
     public int SelectID(Connection c, String u,String p) throws Exception{
        con=c;
        String plantilla="Select ID_PERFIL FROM PERFILES WHERE upper(NOMBRE_USUARIO)=upper(?) AND UPPER(CONTRASENNA)=UPPER(?)";
        PreparedStatement ps=con.prepareStatement(plantilla);
        ps.setString(1, u);
        ps.setString(2, p);
        int id=0;
        ResultSet resultado=ps.executeQuery();
         if(resultado.next()){
             id=resultado.getInt("ID_PERFIL");
         }
         return id;
    }
        public boolean Update(Connection c,Perfil p,int id) throws Exception{
        con=c;
        String plantilla="UPDATE PERFILES SET NOMBRE_USUARIO=?,EMAIL=?,CONTRASENNA=?,TIPO=? WHERE ID_PERFIL=?";
        PreparedStatement ps=con.prepareStatement(plantilla);
        ps.setString(1,p.getNombreUsuario());
        ps.setString(2,p.getEmail());
        ps.setString(3,p.getPassword());
        ps.setString(4,p.getTipo().toString());
        ps.setInt(5,id);
         
        int m=ps.executeUpdate();
        boolean modificar=false;
        if(m==1){
            modificar=true;
        }
        ps.close();
        return modificar;
    }
     public ArrayList <Perfil> SelectGeneral(Connection c) throws Exception {
         con=c;
         String plantilla="SELECT * FROM perfiles";
         PreparedStatement ps=con.prepareStatement(plantilla);
         
         ResultSet resultado=ps.executeQuery();
         
         ArrayList <Perfil> datos=new ArrayList();
         while(resultado.next()){
             Perfil p=new Perfil();
             p.setId(resultado.getInt("ID_PERFIL"));
             p.setNombreUsuario(resultado.getString("NOMBRE_USUARIO"));
             p.setEmail(resultado.getString("EMAIL"));
             p.setTipo(TipoPerfil.valueOf(resultado.getString("TIPO")));
             datos.add(p);
         }
         return datos;
     }

}
