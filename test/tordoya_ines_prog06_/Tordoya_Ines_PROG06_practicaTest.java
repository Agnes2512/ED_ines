/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tordoya_ines_prog06_;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Tordoya_Ines_PROG06_practicaTest {
    
	public Tordoya_Ines_PROG06_practicaTest() {
	}

    

	/**
 	* Test of evaluarExpresion method, of class Tordoya_Ines_PROG06_practica.
 	*
 	*/
   /* @Test
	public void testEvaluarExpresion() {
    	System.out.println("evaluarExpresion");
    	String expresion = "";
    	int expResult = 0;
    	int result = Tordoya_Ines_PROG06_practica.evaluarExpresion(expresion);
    	assertEquals(expResult, result);
    	// TODO review the generated test code and remove the default call to fail.
  	//  fail("The test case is a prototype.");
	}
*/
	/**
 	* Test of firts method, of class Tordoya_Ines_PROG06_practica.
 	* PARA SABER NUESTRO GANADOR
 	*/
  @Test
	public void testFirts() {
    	System.out.println("firts");
 	 
    	String [] concursantes = new String[1];
            	concursantes[0]="Criss";
   	int[] puntuacionJug =  new int[1];
    	String expResult = "Criss";
    	String result = Tordoya_Ines_PROG06_practica.firts(concursantes, puntuacionJug);
    	assertEquals(expResult, result);
    	// TODO review the generated test code and remove the default call to fail.
    	//fail("The test case is a prototype.");
	}
 /**
 	* Test of rondas method, of class juego.
 	* PARA EL NUMERO DE RONDAS
 	*/
	@Test
	public void testRondas() {
    	System.out.println("rondas");
    	int r = 3;
    	int expResult = 3;
    	int result = Tordoya_Ines_PROG06_practica.rondas(r);
    	assertEquals(expResult, result);
    	// TODO review the generated test code and remove the default call to fail.
    	//fail("The test case is a prototype.");
	}
	/**
 	* Test of endJug method, of class Tordoya_Ines_PROG06_practica.
 	* PARA SABER LA PUNTUACION FINAL DE NUESTROS JUGADORES
 	* COMO DEVUELVE UN INT Y EL RESULTADO DEBERIA SER EL NUMJUGADOR + CONCURSANTES
 	* NO DEVUELVE UN RESULTADO CORRECTO
 	*/
 /* @Test
	public void testEndJug() {
    	System.out.println("endJug");
	 
    	String [] concursantes = new String[1];
            	concursantes[0]="Criss";
          	 
   	int[] puntuacionJug =  new int[1];
   	puntuacionJug [0]=20;
  	int expResult2 = 20;
  	String expResult1 ="Criss";
   	 
    	int result = Tordoya_Ines_PROG06_practica.endJug(concursantes, puntuacionJug);
    	assertEquals(expResult1 + " ha conseguido una puntuación de " + expResult2,result);
   	 
    	// TODO review the generated test code and remove the default call to fail.
   	// fail("The test case is a prototype.");
	}*/

    
}

