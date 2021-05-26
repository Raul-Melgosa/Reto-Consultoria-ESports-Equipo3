/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Views.*;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 1GDAW09
 */
public class ControladorIT {
    
    public ControladorIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Controlador.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Controlador.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of comprobarUsuario method, of class Controlador. Con un usuario Administrador
     */
    @Test
    public void testComprobarUsuarioAdmin() throws Exception {
        System.out.println("comprobarUsuario");
        String[] args = null;
        Controlador.main(args);
        String username = "RaulMelgosa";
        String password = "12345Abcd";
        boolean expResult = true;
        boolean result = Controlador.comprobarUsuario(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of comprobarUsuario method, of class Controlador. Con un usuario normal
     */
    @Test
    public void testComprobarUsuarioUsu() throws Exception {
        System.out.println("comprobarUsuario");
        String[] args = null;
        Controlador.main(args);
        String username = "Usuario";
        String password = "usuario";
        boolean expResult = true;
        boolean result = Controlador.comprobarUsuario(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of irVPrincipal method, of class Controlador.
     */
    @Test
    public void testIrVPrincipal() throws Exception {
        System.out.println("irVPrincipal");
        String[] args = null;
        Controlador.main(args);
        JFrame anterior = new VLogin();
        Controlador.irVPrincipal(anterior);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of VentanaAltaEquipo method, of class Controlador.
     */
    @Test
    public void testVentanaAltaEquipo() {
        System.out.println("VentanaAltaEquipo");
        String[] args = null;
        Controlador.main(args);
        JFrame anterior = new VLogin();
        Controlador.VentanaAltaEquipo(anterior);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
    /**
     * Test of AltaJefe method, of class Controlador.
     */
    @Test
    public void testAltaJefeYEquipo() {
        System.out.println("AltaJefe");
        String[] args = null;
        Controlador.main(args);
        String dni = "";
        String nombre = "";
        String apellido = "";
        String nickname = "";
        String email = "";
        Controlador.AltaJefe(dni, nombre, apellido, nickname, email);
        String nombreEquipo = "";
        String nombreJefe = "";
        String apellidoJefe = "";
        boolean expResult = false;
        boolean result = Controlador.AltaEquipo(nombreEquipo, nombreJefe, apellidoJefe);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of ComprobarJefe method, of class Controlador.
     */
    @Test
    public void testComprobarJefe() {
        System.out.println("ComprobarJefe");
        String[] args = null;
        Controlador.main(args);
        String nombreJ = "";
        String apellidoJ = "";
        int expResult = 0;
        int result = Controlador.ComprobarJefe(nombreJ, apellidoJ);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of VentanaBajaEquipo method, of class Controlador.
     */
    @Test
    public void testVentanaBajaEquipo() {
        System.out.println("VentanaBajaEquipo");
        String[] args = null;
        Controlador.main(args);
        JFrame anterior = new VLogin();
        Controlador.VentanaBajaEquipo(anterior);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
//
    /**
     * Test of BajaEquipo method, of class Controlador.
     */
    @Test
    public void testBajaEquipo() {
        System.out.println("BajaEquipo");
        String[] args = null;
        Controlador.main(args);
        String nombre = "EquipoTest";
        boolean expResult = false;
        boolean result = Controlador.BajaEquipo(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of VentanaModificacionEquipo method, of class Controlador.
     */
    @Test
    public void testVentanaModificacionEquipo() {
        System.out.println("VentanaModificacionEquipo");
        String[] args = null;
        Controlador.main(args);
        JFrame anterior = new VLogin();
        Controlador.VentanaModificacionEquipo(anterior);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
//
    /**
     * Test of DatosEquipo method, of class Controlador.
     */
    @Test
    public void testDatosEquipo() {
        System.out.println("DatosEquipo");
        String[] args = null;
        Controlador.main(args);
        int id_equipo = 0;
        String[] expResult = null;
        String[] result = Controlador.DatosEquipo(id_equipo);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of ModificarEquipo method, of class Controlador.
     */
    @Test
    public void testModificarEquipo() {
        System.out.println("ModificarEquipo");
        String[] args = null;
        Controlador.main(args);
        String nombreE = "EquipoTest";
        int idJefe = 0;
        int idEquipo = 0;
        boolean expResult = false;
        boolean result = Controlador.ModificarEquipo(nombreE, idJefe, idEquipo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of VentanaAltaJugador method, of class Controlador.
     */
    @Test
    public void testVentanaAltaJugador() {
        System.out.println("VentanaAltaJugador");
        String[] args = null;
        Controlador.main(args);
        JFrame anterior = new VLogin();
        Controlador.VentanaAltaJugador(anterior);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of ValidarNombreEquipo method, of class Controlador.
     */
    @Test
    public void testValidarNombreEquipo() {
        System.out.println("ValidarNombreEquipo");
        String nombre = "G2 Esports";
        boolean expResult = true;
        boolean result = Controlador.ValidarNombreEquipo(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of AltaJugador method, of class Controlador.
     */
    @Test
    public void testAltaJugador() {
        System.out.println("AltaJugador");
        String[] args = null;
        Controlador.main(args);
        String dni = "";
        String nombre = "";
        String apellido = "";
        String nickname = "";
        String rol = "";
        int dorsal = 0;
        int sueldo = 0;
        String nombreEquipo = "";
        boolean expResult = false;
        boolean result = Controlador.AltaJugador(dni, nombre, apellido, nickname, rol, dorsal, sueldo, nombreEquipo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of VentanaBajaJugador method, of class Controlador.
     */
    @Test
    public void testVentanaBajaJugador() {
        System.out.println("VentanaBajaJugador");
        String[] args = null;
        Controlador.main(args);
        JFrame anterior = new VLogin();
        Controlador.VentanaBajaJugador(anterior);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of BorrarJugador method, of class Controlador.
     */
    @Test
    public void testBorrarJugador() {
        System.out.println("BorrarJugador");
        String[] args = null;
        Controlador.main(args);
        String nombre = "";
        String apellido = "";
        boolean expResult = false;
        boolean result = Controlador.BorrarJugador(nombre, apellido);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of VentanaModificarJugador method, of class Controlador.
     */
    @Test
    public void testVentanaModificarJugador() {
        System.out.println("VentanaModificarJugador");
        String[] args = null;
        Controlador.main(args);
        JFrame anterior = new VLogin();
        Controlador.VentanaModificarJugador(anterior);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of DatosJugador method, of class Controlador.
     */
    @Test
    public void testDatosJugador() {
        System.out.println("DatosJugador");
        String nombre = "";
        String[] expResult = null;
        String[] result = Controlador.DatosJugador(nombre);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of ModificarJugador method, of class Controlador.
     */
    @Test
    public void testModificarJugador() {
        System.out.println("ModificarJugador");
        String[] args = null;
        Controlador.main(args);
        String dni = "";
        String rol = "";
        int dorsal = 0;
        int sueldo = 0;
        String nEquipo = "";
        boolean expResult = false;
        boolean result = Controlador.ModificarJugador(dni, rol, dorsal, sueldo, nEquipo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of VentanaAltaJefe method, of class Controlador.
     */
    @Test
    public void testVentanaAltaJefe() {
        System.out.println("VentanaAltaJefe");
        String[] args = null;
        Controlador.main(args);
        JFrame anterior = new VLogin();
        Controlador.VentanaAltaJefe(anterior);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of VentanaBajaJefe method, of class Controlador.
     */
    @Test
    public void testVentanaBajaJefe() {
        System.out.println("VentanaBajaJefe");
        String[] args = null;
        Controlador.main(args);
        JFrame anterior = new VLogin();
        Controlador.VentanaBajaJefe(anterior);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of VentanaLogin method, of class Controlador.
     */
    @Test
    public void testVentanaLogin() {
        System.out.println("VentanaLogin");
        String[] args = null;
        Controlador.main(args);
        JFrame anterior = new VLogin();
        Controlador.VentanaLogin(anterior);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of BajaJefe method, of class Controlador.
     */
    @Test
    public void testBajaJefe() {
        System.out.println("BajaJefe");
        String[] args = null;
        Controlador.main(args);
        String nombre = "";
        String apellido = "";
        boolean expResult = false;
        boolean result = Controlador.BajaJefe(nombre, apellido);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of VentanaModificarJefes method, of class Controlador.
     */
    @Test
    public void testVentanaModificarJefes() {
        System.out.println("VentanaModificarJefes");
        String[] args = null;
        Controlador.main(args);
        JFrame anterior = new VLogin();
        Controlador.VentanaModificarJefes(anterior);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
    /**
     * Test of DatosJefe method, of class Controlador.
     */
    @Test
    public void testDatosJefe() {
        System.out.println("DatosJefe");
        String[] args = null;
        Controlador.main(args);
        String nombreJefe = "";
        String[] expResult = null;
        String[] result = Controlador.DatosJefe(nombreJefe);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of ModificarJefe method, of class Controlador.
     */
    @Test
    public void testModificarJefe() {
        System.out.println("ModificarJefe");
        String[] args = null;
        Controlador.main(args);
        String dni = "";
        String nombre = "";
        String apellido = "";
        String nickname = "";
        String email = "";
        boolean expResult = false;
        boolean result = Controlador.ModificarJefe(dni, nombre, apellido, nickname, email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of VentanaAltaPerfil method, of class Controlador.
     */
    @Test
    public void testVentanaAltaPerfil() {
        System.out.println("VentanaAltaPerfil");
        String[] args = null;
        Controlador.main(args);
        JFrame anterior = new VLogin();
        Controlador.VentanaAltaPerfil(anterior);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of InsertarPerfil method, of class Controlador.
     */
    @Test
    public void testInsertarPerfil() {
        System.out.println("InsertarPerfil");
        String[] args = null;
        Controlador.main(args);
        String NombreUsuario = "";
        String contrasena = "";
        String email = "";
        String tipo = "";
        boolean expResult = false;
        boolean result = Controlador.InsertarPerfil(NombreUsuario, contrasena, email, tipo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of VentanaBajaPerfil method, of class Controlador.
     */
    @Test
    public void testVentanaBajaPerfil() {
        System.out.println("VentanaBajaPerfil");
        String[] args = null;
        Controlador.main(args);
        JFrame anterior = new VLogin();
        Controlador.VentanaBajaPerfil(anterior);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
//
    /**
     * Test of BajaPerfil method, of class Controlador.
     */
    @Test
    public void testBajaPerfil() {
        System.out.println("BajaPerfil");
        String[] args = null;
        Controlador.main(args);
        String nombreUsu = "";
        String contrasena = "";
        boolean expResult = false;
        boolean result = Controlador.BajaPerfil(nombreUsu, contrasena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of VentanaModificarPerfil method, of class Controlador.
     */
    @Test
    public void testVentanaModificarPerfil() {
        System.out.println("VentanaModificarPerfil");
        String[] args = null;
        Controlador.main(args);
        JFrame anterior = new VLogin();
        Controlador.VentanaModificarPerfil(anterior);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
    /**
     * Test of DatosPerfil method, of class Controlador.
     */
    @Test
    public void testDatosPerfil() {
        System.out.println("DatosPerfil");
        String[] args = null;
        Controlador.main(args);
        String nombrePerfil = "";
        String[] expResult = null;
        String[] result = Controlador.DatosPerfil(nombrePerfil);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of ModificarPerfil method, of class Controlador.
     */
    @Test
    public void testModificarPerfil() {
        System.out.println("ModificarPerfil");
        String[] args = null;
        Controlador.main(args);
        String nombreUsu = "";
        String contrasenna = "";
        String email = "";
        String tipo = "";
        boolean expResult = false;
        boolean result = Controlador.ModificarPerfil(nombreUsu, contrasenna, email, tipo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of VentanaAltaTecnico method, of class Controlador.
     */
    @Test
    public void testVentanaAltaTecnico() {
        System.out.println("VentanaAltaTecnico");
        String[] args = null;
        Controlador.main(args);
        JFrame anterior = new VLogin();
        Controlador.VentanaAltaTecnico(anterior);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of ValidarTecnicos method, of class Controlador.
     */
    @Test
    public void testValidarTecnicos() {
        System.out.println("ValidarTecnicos");
        String[] args = null;
        Controlador.main(args);
        String tipo = "PRINCIPAL";
        String nombreEquipo = "G2 Esports";
        boolean expResult = true;
        boolean result = Controlador.ValidarTecnicos(tipo, nombreEquipo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of ValidarSueldo method, of class Controlador.
     */
    @Test
    public void testValidarSueldo() {
        System.out.println("ValidarSueldo");
        String[] args = null;
        Controlador.main(args);
        String nombre = "";
        int sueldoExtra = 0;
        boolean expResult = false;
        boolean result = Controlador.ValidarSueldo(nombre, sueldoExtra);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
//
    /**
     * Test of AltaTecnico method, of class Controlador.
     */
    @Test
    public void testAltaTecnico() {
        System.out.println("AltaTecnico");
        String[] args = null;
        Controlador.main(args);
        String dni = "";
        String nombre = "";
        String apellido = "";
        String nickname = "";
        int sueldo = 0;
        String tipo = "";
        String nombreEquipo = "";
        boolean expResult = false;
        boolean result = Controlador.AltaTecnico(dni, nombre, apellido, nickname, sueldo, tipo, nombreEquipo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of VentanaBajaTecnico method, of class Controlador.
     */
    @Test
    public void testVentanaBajaTecnico() {
        System.out.println("VentanaBajaTecnico");
        String[] args = null;
        Controlador.main(args);
        JFrame anterior = new VLogin();
        Controlador.VentanaBajaTecnico(anterior);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of BajaTecnico method, of class Controlador.
     */
    @Test
    public void testBajaTecnico() {
        System.out.println("BajaTecnico");
        String[] args = null;
        Controlador.main(args);
        String nombre = "";
        String apellido = "";
        boolean expResult = false;
        boolean result = Controlador.BajaTecnico(nombre, apellido);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of VentanaModificarTecnico method, of class Controlador.
     */
    @Test
    public void testVentanaModificarTecnico() {
        System.out.println("VentanaModificarTecnico");
        String[] args = null;
        Controlador.main(args);
        JFrame anterior = new VLogin();
        Controlador.VentanaModificarTecnico(anterior);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of DatosTecnico method, of class Controlador.
     */
    @Test
    public void testDatosTecnico() {
        System.out.println("DatosTecnico");
        String[] args = null;
        Controlador.main(args);
        String nombre = "";
        String[] expResult = null;
        String[] result = Controlador.DatosTecnico(nombre);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of ModificarTecnico method, of class Controlador.
     */
    @Test
    public void testModificarTecnico() {
        System.out.println("ModificarTecnico");
        String[] args = null;
        Controlador.main(args);
        String dni = "";
        String nombre = "";
        String apellido = "";
        String nickname = "";
        int sueldo = 0;
        String tipo = "";
        String nombreEquipo = "";
        boolean expResult = false;
        boolean result = Controlador.ModificarTecnico(dni, nombre, apellido, nickname, sueldo, tipo, nombreEquipo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of VentanaConsulta method, of class Controlador.
     */
    @Test
    public void testVentanaConsulta() {
        System.out.println("VentanaConsulta");
        String[] args = null;
        Controlador.main(args);
        JFrame anterior = new VLogin();
        int elect = 0;
        Controlador.VentanaConsulta(anterior, elect);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of PedirJornada method, of class Controlador.
     */
    @Test
    public void testPedirJornada() {
        System.out.println("PedirJornada");
        String[] args = null;
        Controlador.main(args);
        Controlador.PedirJornada();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getDatosPartido method, of class Controlador.
     */
    @Test
    public void testGetDatosPartido() throws Exception {
        System.out.println("getDatosPartido");
        String[] args = null;
        Controlador.main(args);
        int idPartido = 0;
        ArrayList<String> expResult = null;
        Controlador.PedirJornada();
        ArrayList<String> result = Controlador.getDatosPartido(idPartido);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of existeJornada method, of class Controlador.
     */
    @Test
    public void testExisteJornada() throws Exception {
        System.out.println("existeJornada");
        String[] args = null;
        Controlador.main(args);
        int posicion = -1;
        boolean expResult = false;
        boolean result = Controlador.existeJornada(posicion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaJornada method, of class Controlador.
     */
    @Test
    public void testGetFechaJornada() throws Exception {
        System.out.println("getFechaJornada");
        String[] args = null;
        Controlador.main(args);
        int posicion = -1;
        String expResult = null;
        String result = Controlador.getFechaJornada(posicion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of VentanaPartidos method, of class Controlador.
     */
    @Test
    public void testVentanaPartidos() {
        System.out.println("VentanaPartidos");
        String[] args = null;
        Controlador.main(args);
        JFrame anterior = new VLogin();
        Controlador.VentanaPartidos(anterior);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of VentanaClasificacion method, of class Controlador.
     */
    @Test
    public void testVentanaClasificacion() {
        System.out.println("VentanaClasificacion");
        String[] args = null;
        Controlador.main(args);
        try
        {
            Controlador.comprobarUsuario("RaulMelgosa", "12345Abcd");
        }
        catch(Exception e)
        {
            
        }
        JFrame anterior = new VLogin();
        Controlador.VentanaClasificacion(anterior);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
