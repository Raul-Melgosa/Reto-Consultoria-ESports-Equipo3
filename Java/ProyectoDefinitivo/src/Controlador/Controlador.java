/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloBD.*;
import ModeloUML.*;
import Views.*;
import Views.Jugadores.AltaJugador;
import java.sql.Array;

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
            insertadoCorrectamente=tEquipo.Insert(bd.conectar(),equipo);
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
    public static void VentanaBajaEquipo(){
        Views.Equipos.BajaEquipo bajaEquipo=new Views.Equipos.BajaEquipo();
        bajaEquipo.setVisible(true);
    }
    public static boolean BajaEquipo(String nombre){
        Equipo eq = new Equipo();
        eq.setNombre(nombre);
        boolean baja=false;
        try{
            baja=tEquipo.Delete(bd.conectar(), eq);
        }
        catch(Exception e){
            System.out.println(e.getClass()+e.getMessage());
        }
        return baja;
    }
    public static void VentanaModificacionEquipo(int id){
        String [] d= new String [3];
        d=DatosEquipo(id);
        Views.Equipos.ModifEquipo modificarEquipo=new Views.Equipos.ModifEquipo(d);
        modificarEquipo.setVisible(true);
    }
    public static String [] DatosEquipo(int id_equipo){
        Equipo equipo=new Equipo();
        Equipo datosEquipo=new Equipo();
        try{
            datosEquipo=tEquipo.SelectTodosLosDatosDeUnEquipo(bd.conectar(), equipo);
        }
        catch(Exception e){
            System.out.println(e.getClass()+e.getMessage());
        }
        String [] datos= new String [3];
        datos[0]=Integer.toString(datosEquipo.getId());
        datos[1]=datosEquipo.getNombre();
        datos[2]=Integer.toString(datosEquipo.getJefe().getId());
        return datos;
    }
    public static boolean ModificarEquipo(String nombreE,int idJefe,int idEquipo){
        boolean modificar=false;
            try{
                if(nombreE.equals(null))
                    modificar=tEquipo.UpdateIdJefe(bd.conectar(), idJefe, idEquipo);
                else
                    modificar=tEquipo.UpdateNombre(bd.conectar(), nombreE, idEquipo);
            }
          catch(Exception e){
            System.out.println(e.getClass()+e.getMessage());
        }
            return modificar;
    }
     public static void VentanaAltaJugador(){
        Views.Jugadores.AltaJugador altaJugador=new Views.Jugadores.AltaJugador();
        altaJugador.setVisible(true);
    }
     public static void VentanaBajaJugador(){
        Views.Jugadores.VbajaJugadores bajaJugador=new Views.Jugadores.VbajaJugadores();
        bajaJugador.setVisible(true);
    }
     public static void Volver(javax.swing.JFrame jframe){
         jframe.dispose();
     }
    public static void salir()
    {
        System.exit(0);
    }
}
