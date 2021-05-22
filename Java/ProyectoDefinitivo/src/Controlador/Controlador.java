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
import java.sql.Connection;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author Equipo 3(Raúl Melgosa, Oier Velar, Alaitz Candela)
 */
public class Controlador {
//tablas
    private static TablaJugadores tj;
    private static TablaLiga tl;
    private static TablaPerfiles tp;
    private static TablaJefes tJefe;
    private static TablaEquipos tEquipo;
    private static TablaTecnicos tTecnico;
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
            tl=new TablaLiga();
            tp=new TablaPerfiles();
            tJefe=new TablaJefes();
            tEquipo=new TablaEquipos();
            tTecnico=new TablaTecnicos();
            //Views.VLogin login=new Views.VLogin();
            //login.setVisible(true);
            Views.Vconsulta vc=new Views.Vconsulta();
            vc.setVisible(true);
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
            bd.desconectar();
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
            bd.desconectar();
             
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
            bd.desconectar();
        }
        catch(Exception e){
            System.out.println(e.getClass()+e.getMessage());
        }
        return delete;
    }
     
     public static void LLenarComboBoxEquipo(JComboBox combo){
        ArrayList <Equipo> nombreEquipos=new ArrayList();
        try{
            nombreEquipos=tEquipo.SelectNombreId(bd.conectar());
            bd.desconectar();
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
            nombreJugador=tj.SelectNombre(bd.conectar());
            bd.desconectar();
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
            bd.desconectar();
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
            bd.desconectar();
            
            Jugador j=new Jugador();
            j.setDni(dni);
            switch(rol){
                case "Jungla": j.setRol(TipoRol.JUNGLA);
                    break;
                case "Top": j.setRol(TipoRol.TOP);
                    break;
                case "Mid": j.setRol(TipoRol.MID);
                    break;
                case "Adc": j.setRol(TipoRol.ADC);
                    break;
                case "Support": j.setRol(TipoRol.SUPPORT);
                    break;
                case "Suplente": j.setRol(TipoRol.SUPLENTE);  
                    break;
            }
            j.setDorsal(dorsal);
            j.setSueldo(sueldo);
            Equipo e=new Equipo();
            e.setId(IdEquipo);
            j.setEquipo(e);
            
            update=tj.Update(bd.conectar(), j);
            bd.desconectar();
        }
        catch(Exception e){
            System.out.println(e.getClass()+e.getMessage());
        }
       return update;
    }
     
    public static void VentanaAltaJefe(javax.swing.JFrame anterior) {
        anterior.dispose();
        Views.Jefes.AltaJefe altaJefe=new Views.Jefes.AltaJefe();
        altaJefe.setVisible(true);
    }
    
    public static boolean AltaJefe(String dni,String nombre,String apellido,String nickname,String email){
        Jefe jefe=new Jefe();
        jefe.setDni(dni);
        jefe.setNombre(nombre);
        jefe.setApellido(apellido);
        jefe.setEmail(email);
        
        boolean insertar=false;
        try{
            insertar=tJefe.Insert(bd.conectar(), jefe);
            bd.desconectar();
        }
        catch(Exception e){
            System.out.println(e.getClass()+e.getMessage());
        }
        return insertar;
    }
    
    public static void VentanaBajaJefe(javax.swing.JFrame anterior) {
        anterior.dispose();
        Views.Jefes.BajaJefe bajaJefe=new Views.Jefes.BajaJefe();
        bajaJefe.setVisible(true);
    }
    
    public static void VentanaLogin(javax.swing.JFrame anterior) {
        anterior.dispose();
        VLogin vLog=new VLogin();
        vLog.setVisible(true);
    }
    
    public static boolean BajaJefe(String nombre,String apellido){
        boolean delete=false;
        try{
            delete=tJefe.Delete(bd.conectar(), nombre, apellido);
            bd.desconectar();
        }
        catch(Exception e){
            System.out.println(e.getClass()+e.getMessage());
        }
        return delete;
    }
    
    public static void VentanaModificarJefes(javax.swing.JFrame anterior){
        anterior.dispose();
        Views.Jefes.ModifJefe mj = new Views.Jefes.ModifJefe();
        mj.setVisible(true);  
    }
    public static void LlenarComboBoxJefe(JComboBox CBjefe){
        ArrayList <Jefe> nombreJefe=new ArrayList();
        try{
            nombreJefe=tJefe.SelectNombre(bd.conectar());
            bd.desconectar();
            for(int x=0;x<nombreJefe.size();x++){
            CBjefe.addItem(nombreJefe.get(x).getNombre());
            }
        }
        catch(Exception e){
            System.out.println(e.getClass()+e.getMessage());
        }
    }
    public static String [] DatosJefe(String nombreJefe){
        Jefe j=new Jefe();
        j.setNombre(nombreJefe);
        ArrayList <Jefe> datos=new ArrayList();
        try{
            datos=tJefe.SelectJefe(bd.conectar(), j);
            bd.desconectar();
        }
        catch(Exception e){
            System.out.println(e.getClass()+e.getMessage());
        }
        d=new String [5];
        
        d[0]=datos.get(0).getDni();
        d[1]=datos.get(0).getApellido();
        d[2]=datos.get(0).getNickname();
        d[3]=datos.get(0).getEmail();
        
        return d;  
    }
    public static boolean ModificarJefe(String dni,String nombre,String apellido,String nickname,String email){
        Jefe j=new Jefe();
        j.setDni(dni);
        j.setNombre(nombre);
        j.setApellido(apellido);
        j.setNickname(nickname);
        j.setEmail(email);
        
        boolean modificar=false;
        try{
            modificar=tJefe.Update(bd.conectar(), j);
            bd.desconectar();
        }
        catch(Exception e){
            System.out.println(e.getClass()+e.getMessage());
        }
        return modificar;
    }
    public static void VentanaAltaPerfil(javax.swing.JFrame anterior){
        anterior.dispose();
        Views.Perfiles.AltaPerfil altaP=new Views.Perfiles.AltaPerfil();
        altaP.setVisible(true);
    }
    public static boolean InsertarPerfil(String NombreUsuario,String contrasena,String email, String tipo ){
        Perfil p=new Perfil();
        p.setNombreUsuario(NombreUsuario);
        p.setPassword(contrasena);
        p.setEmail(email);
       
        switch(tipo){
            case "Admin": p.setTipo(TipoPerfil.ADMIN);
                break;
            case "Usu":p.setTipo(TipoPerfil.USU);
                break;
        }
        
        boolean insertado=false;
        try{
            insertado=tp.Insert(bd.conectar(), p);
        }
        catch(Exception e){
            System.out.println(e.getClass()+e.getMessage());
        }
        return insertado;
    }
    public static void VentanaBajaPerfil(javax.swing.JFrame anterior){
        anterior.dispose();
        Views.Perfiles.BajaPerfil bp= new Views.Perfiles.BajaPerfil();
        bp.setVisible(true);
    }
    public static boolean BajaPerfil(String nombreUsu,String contrasena){
        Perfil p=new Perfil();
        p.setNombreUsuario(nombreUsu);
        p.setPassword(nombreUsu);
        
        boolean baja=false;
        try{
            baja=tp.Delete(bd.conectar(), p);
            bd.desconectar();
        }
        catch(Exception e){
            System.out.println(e.getClass()+e.getMessage());
        }
        return baja;
    }
    public static void VentanaModificarPerfil(javax.swing.JFrame anterior){
         anterior.dispose();
        Views.Perfiles.ModifPerfil mp= new Views.Perfiles.ModifPerfil();
        mp.setVisible(true);
    }
     public static void LLenarComboBoxPerfil(JComboBox combo){
        ArrayList <Perfil> nombrePerfiles=new ArrayList();
        try{
            nombrePerfiles=tp.SelectNombreUsuario(bd.conectar());
            bd.desconectar();
            for(int x=0;x<nombrePerfiles.size();x++){
            combo.addItem(nombrePerfiles.get(x).getNombreUsuario());
            }
        }
        catch(Exception e){
            System.out.println(e.getClass()+e.getMessage());
        } 
    }
     public static String [] DatosPerfil(String nombrePerfil){
        Perfil p=new Perfil();
        p.setNombreUsuario(nombrePerfil);
        ArrayList <Perfil> datos=new ArrayList();
        try{
            datos=tp.SelectJefe(bd.conectar(), p);
            bd.desconectar();
        }
        catch(Exception e){
            System.out.println(e.getClass()+e.getMessage());
        }
        d=new String [5];
        
        d[0]=datos.get(0).getNombreUsuario();
        d[1]=datos.get(0).getPassword();
        d[2]=datos.get(0).getEmail();
        
        return d;  
    }
      public static boolean ModificarPerfil(String nombreUsu,String contrasenna,String email,String tipo){
        Perfil p=new Perfil();
        p.setEmail(email);
        p.setNombreUsuario(nombreUsu);
        p.setPassword(contrasenna);
        
        switch(tipo){
            case "Admin": p.setTipo(TipoPerfil.ADMIN);
                break;
            case "Usu": p.setTipo(TipoPerfil.USU);
                break;
        }
        
       boolean modificar=false;
        int id=0;
        try{
            id=tp.SelectID(bd.conectar(), nombreUsu, contrasenna);
            modificar=tp.Update(bd.conectar(), p, id);
            bd.desconectar();
        }
        catch(Exception e){
            System.out.println(e.getClass()+e.getMessage());
        }
        return modificar;
    }
      
    public static void generarLiga()
    {
        try
        {
            Connection c=bd.conectar();
            if(tl.generarLiga(c))
            {
                ArrayList<Equipo> listaEquipos=tEquipo.SelectNombreId(c);
                int maximoPartidos=(listaEquipos.size()/2);
                ArrayList<Jornada> listaJornadas=tl.SelectJornadas(c);
                for(int x=0;x<listaEquipos.size();x++)
                {
                    ArrayList<Equipo> emparejador = (ArrayList<Equipo>)listaEquipos.clone();
                    for(int y=0;y<=x;y++)
                    {
                        emparejador.remove(0);
                    }
                    int limite=emparejador.size();
                    for(int z=0;z<limite;z++)
                    {
                        int a=(int) (Math.random()*(emparejador.size()));
                        boolean partidoInsertado=false;
                        for(int f=0;f<listaJornadas.size()&&!partidoInsertado;f++)
                        {
                            if(listaJornadas.get(f).getListaPartidos().isEmpty())
                            {
                                tl.InsertarPartido(c,emparejador.get(a).getId(),listaEquipos.get(x).getId(),listaJornadas.get(f).getId(),horaAleatoria());
                                listaJornadas.get(f).getListaPartidos().add(new Partido(emparejador.get(a).getId(),listaEquipos.get(x).getId()));
                                tl.InsertarPartido(c,listaEquipos.get(x).getId(),emparejador.get(a).getId(),(listaJornadas.get(f).getId()+listaJornadas.size()/2),horaAleatoria());
                                listaJornadas.get((f+(listaJornadas.size()/2))).getListaPartidos().add(new Partido(listaEquipos.get(x).getId(),emparejador.get(a).getId()));
                                partidoInsertado=true;
                            }
                            else if(listaJornadas.get(f).getListaPartidos().size()==maximoPartidos)
                            {
                                
                            }
                            else
                            {
                                boolean apto=true;
                                for(int h=0;h<listaJornadas.get(f).getListaPartidos().size()&&!partidoInsertado;h++)
                                {
                                    if(listaJornadas.get(f).getListaPartidos().get(h).getIdLocal()==listaEquipos.get(x).getId() ||
                                       listaJornadas.get(f).getListaPartidos().get(h).getIdVisitante()==listaEquipos.get(x).getId() ||
                                       listaJornadas.get(f).getListaPartidos().get(h).getIdLocal()==emparejador.get(a).getId() ||
                                       listaJornadas.get(f).getListaPartidos().get(h).getIdVisitante()==emparejador.get(a).getId())
                                    {
                                        apto=false;
                                    }
                                }
                                if(apto)
                                {
                                    tl.InsertarPartido(c,emparejador.get(a).getId(),listaEquipos.get(x).getId(),listaJornadas.get(f).getId(),horaAleatoria());
                                    listaJornadas.get(f).getListaPartidos().add(new Partido(emparejador.get(a).getId(),listaEquipos.get(x).getId()));
                                    tl.InsertarPartido(c,listaEquipos.get(x).getId(),emparejador.get(a).getId(),(listaJornadas.get(f).getId()+listaJornadas.size()/2),horaAleatoria());
                                    listaJornadas.get((f+(listaJornadas.size()/2))).getListaPartidos().add(new Partido(listaEquipos.get(x).getId(),emparejador.get(a).getId()));
                                    partidoInsertado=true;
                                }
                                
                            }
                        }
                        emparejador.remove(a);
                    }
                }
            }
            bd.desconectar();
        }
        catch(Exception e)
        {
            System.out.println(e.getClass());
        }
    }
    
    public static void rellenarClasificacion(javax.swing.JTable tabla)
    {
        try
        {
           Connection c=bd.conectar();
            ArrayList<String[]> datos=tl.SelectClasificacion(c);
            
            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tabla.getModel();
            for(int x=0;x<datos.size();x++)
            {
                String nombre=tEquipo.SelectNombre(c, Integer.parseInt(datos.get(x)[0]));
                model.addRow(new Object[]{x+1,nombre , datos.get(x)[1]});
            }
            bd.desconectar();
        }
        catch(Exception e)
        {
            System.out.println(e.getClass());
        }
    }
    
    public static String horaAleatoria()
    {
        String devolver="";
        switch((int)(Math.random()*7))
        {
            case 0:
                devolver="16:15:00";
                break;
            case 1:
                devolver="17:00:00";
                break;
            case 2:
                devolver="18:00:00";
                break;
            case 3:
                devolver="19:00:00";
                break;
            case 4:
                devolver="21:00:00";
                break;
            case 5:
                devolver="22:00:00";
                break;
            case 6:
                devolver="17:30:00";
                break;
            default:
                devolver="18:30:00";
                break;
        }
        return devolver;
    }
    public static void VentanaAltaTecnico(javax.swing.JFrame anterior){
        anterior.dispose();
        Views.Tecnicos.AltaTecnico altaT=new Views.Tecnicos.AltaTecnico();
        altaT.setVisible(true);
    }
    public static boolean ValidarTecnicos(String tipo,String nombreEquipo){
       boolean tieneTecnico=false;
        try{
            int id=0;
            id=tEquipo.SelectID(bd.conectar(), nombreEquipo);
            bd.desconectar();
            
            Tecnico t=new Tecnico();
            Equipo e=new Equipo();
            e.setId(id);
            t.setEquipo(e);
           
           String tipoTecnico="";
           tipoTecnico=tTecnico.ValidarTecnico(bd.conectar(), t);
           bd.desconectar();
           
           
           if(tipoTecnico.equals(tipo)){
               tieneTecnico=true;
           } 

        }
         catch(Exception ex)
        {
            System.out.println(ex.getClass());
        }
        
        return tieneTecnico;
        
    }
    public static boolean ValidarSueldo(int sueldo){
        boolean mediaSueldo=false;
        try{
            //media tecnicos
            int mediaT=0;
            ArrayList <Integer> sueldosT=new ArrayList();
            sueldosT=tTecnico.Sueldos(bd.conectar());
            bd.desconectar();
            for(int x=0;x<sueldosT.get(x);x++){
                mediaT=sueldosT.get(x);
            }
            mediaT=mediaT+sueldo;
            mediaT=mediaT/(sueldosT.size()+1);
            
            //media Jugadores
            int mediaJ=0;
            ArrayList <Integer> sueldosJ=new ArrayList();
            sueldosJ=tj.Sueldos(bd.conectar());
            bd.desconectar();
            for(int x=0;x<sueldosJ.get(x);x++){
                mediaJ=sueldosJ.get(x);
            }
            mediaJ=mediaJ/(sueldosJ.size());
            
            //media Jefes
            int mediaJefe=0;
            ArrayList <Integer> sueldosJefe=new ArrayList();
            sueldosJefe=tJefe.Sueldos(bd.conectar());
            bd.desconectar();
            for(int x=0;x<sueldosJefe.get(x);x++){
                mediaJefe=sueldosJefe.get(x);
            }
            mediaJefe=mediaJefe/(sueldosJefe.size());
            
            int mediaTotal=(mediaT+mediaJ+mediaJefe)/3;
            
            if(mediaTotal>=2000000)
                mediaSueldo=true;
        }
         catch(Exception ex)
        {
            System.out.println(ex.getClass());
        }
        return mediaSueldo;
    }
    public static boolean AltaTecnico(String dni,String nombre,String apellido,String nickname,int sueldo,String tipo,String nombreEquipo){
        boolean alta=false;
        try{
             Tecnico t=new Tecnico();
             t.setDni(dni);
             t.setNombre(nombre);
             t.setApellido(apellido);
             t.setNickname(nickname);
             t.setSueldo(sueldo);
           
             switch(tipo){
                 case "Principal": t.setTipo(TipoTecnico.PRINCIPAL);
                    break;
                 case "Asistente": t.setTipo(TipoTecnico.ASISTENTE);
                    break;
             }
             
            int id=0;
            id=tEquipo.SelectID(bd.conectar(), nombreEquipo);
            bd.desconectar();
            
           
            Equipo e=new Equipo();
            e.setId(id);
            t.setEquipo(e);
           
            alta=tTecnico.Insert(bd.conectar(), t);
            bd.desconectar();
        }
          catch(Exception ex)
        {
            System.out.println(ex.getClass());
        }
        
        
        
        return alta;
    }
     public static void VentanaBajaTecnico(javax.swing.JFrame anterior){
        anterior.dispose();
        Views.Tecnicos.BajaTecnico bajaT=new Views.Tecnicos.BajaTecnico();
        bajaT.setVisible(true);
    }
    public static boolean BajaTecnico(String nombre,String apellido){
        boolean baja=false;
        Tecnico t=new Tecnico ();
        t.setNombre(nombre);
        t.setApellido(apellido);
        try{
            baja=tTecnico.Delete(bd.conectar(), t);
            bd.desconectar();
        }
          catch(Exception ex)
        {
            System.out.println(ex.getClass());
        }
        return baja;
    }
     public static void VentanaModificarTecnico(javax.swing.JFrame anterior){
        anterior.dispose();
        Views.Tecnicos.ModifTecnico modificarT=new Views.Tecnicos.ModifTecnico();
        modificarT.setVisible(true);
    }
    public static void LlenarComboBoxTecnico(JComboBox CBtecnico){
        ArrayList <Jugador> nombreTecnico=new ArrayList();
        try{
            nombreTecnico=tTecnico.SelectNombre(bd.conectar());
            bd.desconectar();
            for(int x=0;x<nombreTecnico.size();x++){
            CBtecnico.addItem(nombreTecnico.get(x).getNombre());
            }
        }
        catch(Exception e){
            System.out.println(e.getClass()+e.getMessage());
        }
    }
    public static String [] DatosTecnico(String nombre){
       String nombreEquipo="";
        Tecnico t=new Tecnico();
       t.setNombre(nombre);
       Tecnico [] datosTecnico=new Tecnico[2];
        try{
            datosTecnico=tTecnico.SelectTecnico(bd.conectar(), t);
            bd.desconectar();
            nombreEquipo=tEquipo.SelectNombre(bd.conectar(), datosTecnico[0].getEquipo().getId());
        }
        catch(Exception e){
            System.out.println(e.getClass()+e.getMessage());
        }
        String [] datos= new String [8];
        datos[0]=datosTecnico[0].getDni();
        datos[1]=datosTecnico[0].getNombre();
        datos[2]=datosTecnico[0].getApellido();
        datos[3]=datosTecnico[0].getNickname();
        datos[4]=nombreEquipo;
        datos[5]=Integer.toString(datosTecnico[0].getSueldo());
        datos[6]=datosTecnico[0].getTipo().toString();
        
        return datos;
    }
    public static boolean ModificarTecnico(String dni,String nombre,String apellido,String nickname,int sueldo,String tipo,String nombreEquipo){
        boolean modificar=false,mediaSueldo=false;
        
        mediaSueldo=ValidarSueldo(sueldo);
        if(mediaSueldo==true)
            modificar=false;
        else
            try{
                Tecnico t=new Tecnico();
                
                int id=0;
                id=tEquipo.SelectID(bd.conectar(), nombreEquipo);
                bd.desconectar();
                
                 switch(tipo){
                 case "Principal": t.setTipo(TipoTecnico.PRINCIPAL);
                    break;
                 case "Asistente": t.setTipo(TipoTecnico.ASISTENTE);
                    break;
                }
                 
                 t.setDni(dni);
                 t.setNombre(nombre);
                 t.setApellido(apellido);
                 t.setNickname(nickname);
                 t.setSueldo(sueldo);
                 
                 modificar=tTecnico.Update(bd.conectar(), t);
                
            }
            catch(Exception e){
                System.out.println(e.getClass()+e.getMessage());
            }  
        
        return modificar;
    }

    public static void VentanaConsulta(javax.swing.JFrame anterior){
        anterior.dispose();
        Views.Vconsulta vc=new Views.Vconsulta();
        vc.setVisible(true);
    }
    public static ArrayList <String> Datos(String t){
       ArrayList <Equipo> eq=new ArrayList();
       ArrayList <Jugador> ju=new ArrayList();
       ArrayList <Jefe> je=new ArrayList();
       ArrayList <Tecnico> te=new ArrayList();
       ArrayList <Perfil> pe=new ArrayList();
       ArrayList <String> datos=new ArrayList();
       
       try{
           switch(t){
            case "Equipos": eq=tEquipo.SelectGeneral(bd.conectar());
                            bd.desconectar();
                            for(int x=0;x<eq.size();x++){
                                datos.add(eq.get(x).toString());
                            }                   
                break;
            case "Jugadores":  ju=tj.SelectGeneral(bd.conectar());
                            bd.desconectar();
                            for(int x=0;x<ju.size();x++){
                                datos.add(ju.get(x).toString());
                            }
                break;
            case "Jefes":  je=tJefe.SelectGeneral(bd.conectar());
                            bd.desconectar();
                            for(int x=0;x<je.size();x++){
                                datos.add(je.get(x).toString());
                            }
                break;
            case "Tecnicos": te=tTecnico.SelectGeneral(bd.conectar());
                            bd.desconectar();
                            for(int x=0;x<te.size();x++){
                                datos.add(te.get(x).toString());
                            }
                break;
            case "Perfiles": pe=tp.SelectGeneral(bd.conectar());
                            bd.desconectar();
                            for(int x=0;x<pe.size();x++){
                                datos.add(pe.get(x).toString());
                            }
                break;
           }
       }
        catch(Exception e){
                System.out.println(e.getClass()+e.getMessage());
            }  
        return datos;
    }
    public static void salir()
    {
        System.exit(0);
    }
}


