/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloBD.*;
import ModeloUML.*;
import Views.*;

/**
 *
 * @author Equipo 3(Raúl Melgosa, Oier Velar, Alaitz Candela)
 */
public class Controlador {
//tablas
    private static TablaJugadores tj;
    private static TablaPerfiles tp;
    private static TablaJefes tJefe;
    private static TablaEquipos tEquipo;
//Base de datos
    private static BaseDeDatos bd;
//Perfil
    private static Perfil usuario;
    
    public static void main(String[] args) {
        try
        {
            bd=new BaseDeDatos();
            tj=new TablaJugadores();
            tp=new TablaPerfiles();
            tJefe=new TablaJefes();
            tEquipo=new TablaEquipos();
            VLogin login = new VLogin();
            login.setLocationRelativeTo(null);
            login.setVisible(true);
        }
        catch(Exception e)
        {
            System.out.println("EXCEPCION GENERICA");
            System.out.println(e.getClass()+"\n"+e.getCause());
        }
        
    }
    
    public static boolean comprobarUsuario(String username,String password) throws Exception
    {
        usuario=tp.buscarUsuario(bd.conectar(),username,password);
        if(usuario==null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public static void irVPrincipal(javax.swing.JFrame anterior) throws Exception
    {
        anterior.dispose();
        if(usuario.getTipo().equals(TipoPerfil.ADMIN))
        {
            VprincipalAdmin admin = new VprincipalAdmin();
            admin.setVisible(true);
        }
        else
        {
            VprincipalUsu usu= new VprincipalUsu();
            usu.setVisible(true);
        }
    }
     public static void VentanaAltaEquipo(){
        Views.Equipos.AltaEquipo altaE=new Views.Equipos.AltaEquipo();
        altaE.setVisible(true);
    }
    public static boolean AltaEquipo(String nombreEquipo,String nombreJefe,String apellidoJefe){
        int idJefe;
        idJefe=ComprobarJefe(nombreJefe,apellidoJefe);
        Jefe jefe=new Jefe();
        jefe.setId(idJefe);
        Equipo equipo=new Equipo();
        equipo.setNombre(nombreJefe);
        equipo.setJefe(jefe);
        
        boolean insertadoCorrectamente=false;
        try{
            insertadoCorrectamente=tEquipo.Insert(equipo);
        }
        catch(Exception e){
            System.out.println(e.getClass()+e.getMessage());
        }
        return insertadoCorrectamente;
    }
    public static int ComprobarJefe(String nombreJ,String apellidoJ){
        int id_Jefe=0;
        Jefe jefe=new Jefe();
        jefe.setNombre(nombreJ);
        jefe.setApellido(apellidoJ);
        try{
            id_Jefe=tJefe.Select(bd.conectar(),jefe);
        }
        catch(Exception e){
            System.out.println(e.getClass()+e.getMessage());
        }
        return id_Jefe;
    }
    
    public static void salir()
    {
        System.exit(0);
    }
}
