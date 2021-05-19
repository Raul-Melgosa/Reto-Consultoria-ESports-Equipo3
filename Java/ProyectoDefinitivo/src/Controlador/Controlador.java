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
import java.util.ArrayList;
import javax.swing.JComboBox;

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
//Array
    private static String [] d;
    
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
        bd.desconectar();
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
     public static void VentanaAltaEquipo(javax.swing.JFrame anterior){
        anterior.dispose();
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
            bd.desconectar();
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
            bd.desconectar();
        }
        catch(Exception e){
            System.out.println(e.getClass()+e.getMessage());
        }
        return id_Jefe;
    }
    public static void VentanaBajaEquipo(javax.swing.JFrame anterior){
        anterior.dispose();
        Views.Equipos.BajaEquipo bajaEquipo=new Views.Equipos.BajaEquipo();
        bajaEquipo.setVisible(true);
    }
    public static boolean BajaEquipo(String nombre){
        Equipo eq = new Equipo();
        eq.setNombre(nombre);
        boolean baja=false;
        try{
            baja=tEquipo.Delete(bd.conectar(), eq);
            bd.desconectar();
        }
        catch(Exception e){
            System.out.println(e.getClass()+e.getMessage());
        }
        return baja;
    }
    
    public static void VentanaModificacionEquipo(javax.swing.JFrame anterior){
        anterior.dispose();
        String [] d= new String [3];
        //d=DatosEquipo(id);
        Views.Equipos.ModifEquipo modificarEquipo=new Views.Equipos.ModifEquipo(d);
        modificarEquipo.setVisible(true);
    }
    
    public static String [] DatosEquipo(int id_equipo){
        Equipo equipo=new Equipo();
        Equipo datosEquipo=new Equipo();
        try{
            datosEquipo=tEquipo.SelectTodosLosDatosDeUnEquipo(bd.conectar(), equipo);
            bd.desconectar();
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
                {
                    modificar=tEquipo.UpdateIdJefe(bd.conectar(), idJefe, idEquipo);
                    bd.desconectar();
                }
                else
                {
                    modificar=tEquipo.UpdateNombre(bd.conectar(), nombreE, idEquipo);
                    bd.desconectar();
                }
            }
          catch(Exception e){
            System.out.println(e.getClass()+e.getMessage());
        }
            return modificar;
    }
    
     public static void VentanaAltaJugador(javax.swing.JFrame anterior){
         anterior.dispose();
        Views.Jugadores.AltaJugador altaJugador=new Views.Jugadores.AltaJugador();
        altaJugador.setVisible(true);
    }
    public static boolean ValidarNombreEquipo(String nombre){
         boolean encontrado=false;
         int id=0;
         try{
            id=tEquipo.SelectID(bd.conectar(),nombre);
         }
         catch(Exception e){
            System.out.println(e.getClass()+e.getMessage());
        }
         if(id==0)
             encontrado=false;
         else
             encontrado=true;
         return encontrado;
     }
     public static boolean AltaJugador(String dni,String nombre,String apellido,String nickname,String rol,int dorsal,int sueldo,String nombreEquipo){
        Equipo equipo=new Equipo();
        equipo.setNombre(nombreEquipo);
        Jugador jugador=new Jugador(dni,nombre,apellido,nickname,dorsal,sueldo,equipo);
         
         switch(rol){
             case "Jungla": jugador.setRol(TipoRol.JUNGLA);
             case "Top": jugador.setRol(TipoRol.TOP);
             case "Mid": jugador.setRol(TipoRol.MID);
             case "Adc": jugador.setRol(TipoRol.ADC);
             case "Support": jugador.setRol(TipoRol.SUPPORT);
             case "Suplente": jugador.setRol(TipoRol.SUPLENTE);            
         }
         
         boolean insert=false;
         try{
             insert=tj.Insert(bd.conectar(), jugador);
             
         }
         catch(Exception e){
            System.out.println(e.getClass()+e.getMessage());
        }
         return insert;
     }
     
     public static void VentanaBajaJugador(javax.swing.JFrame anterior){
         anterior.dispose();
        Views.Jugadores.VbajaJugadores bajaJugador=new Views.Jugadores.VbajaJugadores();
        bajaJugador.setVisible(true);
    }
     public static boolean BorrarJugador(String nombre,String apellido){
         boolean delete=false;
         try{
             delete=tj.Delete(bd.conectar(), nombre, apellido);
         }
         catch(Exception e){
            System.out.println(e.getClass()+e.getMessage());
        }
         return delete;
     }
     public static void LLenarComboBoxEquipo(JComboBox combo){
         ArrayList <Equipo> nombreEquipos=new ArrayList();
         try{
             nombreEquipos=tEquipo.SelectGeneral(bd.conectar());
             for(int x=0;x<nombreEquipos.size();x++){
             combo.addItem(nombreEquipos.get(x).getNombre());
            }
         }
        catch(Exception e){
            System.out.println(e.getClass()+e.getMessage());
        } 
     }
     public static void LlenarComboBoxJugador(JComboBox CBjugador){
         ArrayList <Jugador> nombreJugador=new ArrayList();
         try{
             nombreJugador=tj.SelectGeneral(bd.conectar());
             for(int x=0;x<nombreJugador.size();x++){
             CBjugador.addItem(nombreJugador.get(x).getNombre());
            }
         }
        catch(Exception e){
            System.out.println(e.getClass()+e.getMessage());
        }
     }
     public static void VentanaModificarJugador(javax.swing.JFrame anterior){
         anterior.dispose();
         Views.Jugadores.ModifJugador modificarJugador = new Views.Jugadores.ModifJugador();
         modificarJugador.setVisible(true);
     }
     public static String [] DatosJugador(String nombre){
         Jugador j=new Jugador();
         j.setNombre(nombre);
         Jugador [] datos=new Jugador[1];
         String n="";
         try{
             datos=tj.SelectJugador(bd.conectar(), j);
             n=tEquipo.SelectNombre(bd.conectar(), datos[0].getEquipo().getId());
         }
         catch(Exception e){
            System.out.println(e.getClass()+e.getMessage());
        }
         d=new String [6];
         
         d[0]=datos[0].getDni();
         d[1]=datos[0].getNombre();
         d[2]=datos[0].getRol().toString();
         d[3]=Integer.toString(datos[0].getDorsal());
         d[4]=Integer.toString(datos[0].getSueldo());
         d[5]=n;
         
         return d;   

     }
    public static boolean ModificarJugador(String dni,String rol,int dorsal,int sueldo,String nEquipo){
        
        boolean update=false;
        int IdEquipo=0;
         try{
            IdEquipo=tEquipo.SelectID(bd.conectar(), nEquipo);
            
            Jugador j=new Jugador();
            j.setDni(dni);
            switch(rol){
             case "Jungla": j.setRol(TipoRol.JUNGLA);
             case "Top": j.setRol(TipoRol.TOP);
             case "Mid": j.setRol(TipoRol.MID);
             case "Adc": j.setRol(TipoRol.ADC);
             case "Support": j.setRol(TipoRol.SUPPORT);
             case "Suplente": j.setRol(TipoRol.SUPLENTE);            
         }
            j.setDorsal(dorsal);
            j.setSueldo(sueldo);
            Equipo e=new Equipo();
            e.setId(IdEquipo);
            j.setEquipo(e);
            
            update=tj.Update(bd.conectar(), j);
         }
         catch(Exception e){
            System.out.println(e.getClass()+e.getMessage());
        }
       return update;
    }
     
    public static void salir()
    {
        System.exit(0);
    }
}
