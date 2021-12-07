/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcadopsm;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author santiagochaparromartin
 */
public class JugadorTest {
    
    public JugadorTest() {
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
    
    @Test
    public void testTamanoPalabrasInicial() {
        String palabra = "hola";
        Jugador instance = new Jugador();
        instance.empezarJuegoTest(palabra);
        assertEquals(instance.getPalabra().length(), instance.getPalabraFiltrada().length());
    }
    
    @Test
    public void testTamanoPalabrasConLetras() {
        String palabra = "hola";
        Jugador instance = new Jugador();
        instance.empezarJuegoTest(palabra);
        instance.adivinarPalabrasTest("a", "o");
        assertEquals(instance.getPalabra().length(), instance.getPalabraFiltrada().length());
    }
    
    @Test
    public void testIntroducirSoloLetras() {
        String palabra = "hol$";
        Jugador instance = new Jugador();
        instance.empezarJuegoTest(palabra);
        assertEquals(instance.getPalabra(), "invalida");
    }
    
    @Test
    public void testIntroducirSoloLetrasMinusculas() {
        String palabra = "HOLA";
        Jugador instance = new Jugador();
        instance.empezarJuegoTest(palabra);
        assertEquals(instance.getPalabra(), "hola");
    }
    
    @Test
    public void testIntroducirSoloLetrasAlAdivinar() {
        String palabra = "hola";
        Jugador instance = new Jugador();
        instance.empezarJuegoTest(palabra);
        
        assertEquals(instance.adivinarPalabrasTest("%", "h"), false);
    }
    
    @Test
    public void testIntroducirSoloLetrasMayusculas() {
        String palabra = "hola";
        Jugador instance = new Jugador();
        instance.empezarJuegoTest(palabra);
        instance.adivinarLetra("H");
        
        assertEquals(instance.getPalabraFiltrada(), "h---");
    }
    
}
