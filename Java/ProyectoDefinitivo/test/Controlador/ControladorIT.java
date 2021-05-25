/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

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

    /**
     * Test of comprobarUsuario method, of class Controlador.
     */
    public void testComprobarUsuario() throws Exception {
        System.out.println("comprobarUsuario");
        String username = "";
        String password = "";
        boolean expResult = false;
        boolean result = Controlador.comprobarUsuario(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
