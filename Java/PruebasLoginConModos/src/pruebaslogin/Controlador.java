/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaslogin;

import ModeloBD.*;
import ModeloUML.*;
import Vista.Login;

/**
 *
 * @author Equipo 3(Raúl Melgosa, Oier Velar, Alaitz Candela)
 */
public class Controlador {
    private static TablaJugadores tj;
    private static TablaPerfiles tp;
    private static BaseDeDatos bd;
    private Perfil usuario;
    
    public static void main(String[] args) {
        try
        {
            bd=new BaseDeDatos();
            tj=new TablaJugadores();
            tp=new TablaPerfiles();
            Login login = new Login();
            login.setLocationRelativeTo(null);
            login.setVisible(true);
        }
        catch(Exception e)
        {
            System.out.println("EXCEPCION GENERICA");
            System.out.println(e.getClass());
            System.out.println(e.getCause());
        }
        
    }
    
    public static void comprobarUsuario(String username,String password) throws Exception
    {
        tp.buscarUsuario(bd.conectar(),username,password);
    }
    
    public static void salir()
    {
        System.exit(0);
    }
}
