/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package practicaed_junit_git;

import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aisca
 */
public class REALES_CARLOS_PROG06_PRACTICATest {
    
    public REALES_CARLOS_PROG06_PRACTICATest() {
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
     * Es un metodo que no devuelve nada, solo construye una frase y la imprime
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        REALES_CARLOS_PROG06_PRACTICA.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     *  Al ser un metodo que utiliza la libreria Scanner y espera la respuesta del
     * usuario, no puede automatizarse
     */
    @Test
    public void testAsignarNJugadores() {
        System.out.println("asignarNJugadores");
        Scanner reader = null;
        int expResult = 0;
        int result = REALES_CARLOS_PROG06_PRACTICA.asignarNJugadores(reader);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     *  Al ser un metodo que utiliza la libreria Scanner y espera la respuesta del
     * usuario, no puede automatizarse
     */
    @Test
    public void testOrdenar_aleatoriamente() {
        System.out.println("ordenar_aleatoriamente");
        String[] nombres = null;
        REALES_CARLOS_PROG06_PRACTICA.ordenar_aleatoriamente(nombres);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     *  Al ser un metodo que utiliza la libreria Scanner y espera la respuesta del
     * usuario, no puede automatizarse
     */
    @Test
    public void testAsignarRondas() {
        System.out.println("asignarRondas");
        Scanner reader = null;
        int expResult = 0;
        int result = REALES_CARLOS_PROG06_PRACTICA.asignarRondas(reader);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularRondas method, of class REALES_CARLOS_PROG06_PRACTICA.
     */
    @Test
    public void testCalcularRondas() {
        System.out.println("calcularRondas");
        
        int a = 1;
        int expResult = 3;
        int result = REALES_CARLOS_PROG06_PRACTICA.calcularRondas(a);
        assertEquals(expResult, result);
        
        a = 2;
        expResult = 5;
        result = REALES_CARLOS_PROG06_PRACTICA.calcularRondas(a);
        assertEquals(expResult, result);
        
        a = 3;
        expResult = 10;
        result = REALES_CARLOS_PROG06_PRACTICA.calcularRondas(a);
        assertEquals(expResult, result);
        
        a = 4;
        expResult = 20;
        result = REALES_CARLOS_PROG06_PRACTICA.calcularRondas(a);
        assertEquals(expResult, result);

        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Método que muestra al jugador la pregunta planteada en el método anterior
     * y compara la respuesta  escrita en el teclado con el resultado de la operación, 
     * calculado en anteriores métodos. En caso de acertar devolverá un string y
     * sumará un punto. En caso de fallar devolverá otro string diferente
     * 
    * Clases de equivalencia:
    *   Respuesta igual a Resultado
    *   Respuesta diferente a resultado

     */
    @Test
    public void testCompararResultado() {
        System.out.println("compararResultado");
        int resultado = 18;
        int respuesta = 18;
        int[] score = new int[1];
        int i = 0;
        String expResult = "¡¡¡Correcto!!!";
        String result = REALES_CARLOS_PROG06_PRACTICA.compararResultado(resultado, respuesta, score, i);
        assertEquals(expResult, result);

        respuesta = 20;
        resultado = 18;
        String expResult2 = "¡Fallaste! El resultado correcto es: 18";
        String result2 = REALES_CARLOS_PROG06_PRACTICA.compararResultado(resultado, respuesta, score, i);
        assertEquals(expResult2, result2);

        // TODO review the generated test code and remove the default call to fail.
 
    }

    /**
     * Al ser un metodo que utiliza el metodo externo Math.random, y por  no se puede automatizar
     */
    @Test
    public void testCrearOperacion() {
        System.out.println("crearOperacion");
        int expResult = 0;
        int result = REALES_CARLOS_PROG06_PRACTICA.crearOperacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   /**
     * Al ser un metodo que utiliza el metodo externo Math.random, he hecho una simulacion 
     * modificada en los 3 casos supuestos de math random sobre un supuesto de 
     * 5 operaciones (0:suma, 1:resta, 2:multiplicación,1:resta,0:suma)
     * tal y como se ha plasmado en el documento diseño de pruebas
     */
    @Test
    public void testConstruirPregunta() {
        System.out.println("construirPregunta");
        
        int[] numeros = new int[]{2,12,7,3,8,5};
        int resultado = numeros[0];
      
        int expResult = 18;
        int[] signos = new int[]{0,1,2,1,0};
        
        for (int i = 0; i< signos.length;i++){
            switch(signos[i]){
                case 0:
                     resultado += numeros[i+1];
                     break;
                     
                case 1:
                    resultado -= numeros[i+1];
                    break;
                case 2: 
                      resultado *= numeros[i+1];
                      break;
            }
  

            
        }
        assertEquals(expResult, resultado);

        // TODO review the generated test code and remove the default call to fail.

    }


    /**
     *  Es un metodo que no devuelve nada, solo construye una frase y la imprime
     */
    @Test
    public void testPlantearPregunta() {
        System.out.println("plantearPregunta");
        int nEnteros = 0;
        int[] numeros = null;
        String[] signos = null;
        int resultado = 0;
        REALES_CARLOS_PROG06_PRACTICA.plantearPregunta(nEnteros, numeros, signos, resultado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     *Es un metodo que no devuelve nada, solo construye una frase y la imprime
     */
    @Test
    public void testPuntuarRonda() {
        System.out.println("puntuarRonda");
        int[] score = null;
        String[] nombres = null;
        REALES_CARLOS_PROG06_PRACTICA.puntuarRonda(score, nombres);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

        /**
     * Es un metodo que recoge los parametros de la lista score y nombres, los compara
     * para obtener un ganador (o varios, en caso de empate) y lo devuelve en forma de String
     */
    @Test
    public void testDeclararGanadores() {
        System.out.println("declararGanadores");
        int[] score = {5, 5 ,5};
        String[] nombres = {"Carlos", "Ana", "Alberto"};
        String expResult = "Carlos, Ana, Alberto, con 5 puntos.";
        String result = REALES_CARLOS_PROG06_PRACTICA.declararGanadores(score, nombres);
        System.out.println(result);
        assertEquals(expResult, result);
        
        System.out.println("declararGanadores");
        int[] score2 = {6, 5 ,5};
        String[] nombres2 = {"Carlos", "Ana", "Alberto"};
        String expResult2 = "Carlos, con 6 puntos.";
        String result2 = REALES_CARLOS_PROG06_PRACTICA.declararGanadores(score2, nombres2);
        System.out.println(result2);
        assertEquals(expResult2, result2);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
