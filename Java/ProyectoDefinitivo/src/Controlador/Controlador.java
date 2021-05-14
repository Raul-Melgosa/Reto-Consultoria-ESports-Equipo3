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
    
    public static void salir()
    {
        System.exit(0);
    }
}
