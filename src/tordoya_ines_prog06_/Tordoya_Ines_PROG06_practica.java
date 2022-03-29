/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tordoya_ines_prog06_;

import java.util.Scanner;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 *
 * @author p
 */
public class Tordoya_Ines_PROG06_practica {

    /**
     * @param args the command line arguments
     */
    //funciones de nuestro programa
    /*Esta funcion nos ayudara a evaluar la operacion matematica, esto quiere decir que opere en orden de prioridades
     (primero multiplicaciones y luego sumas y restas
    //al evaluar la operacion esta recorriendo un orden que no lleva al resultado con calculadora
    */
    public static int evaluarExpresion(String expresion) {
        int valor = 0;
        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("javascript");
            Object result = engine.eval(expresion);
            valor = Integer.decode(result.toString());

        } catch (Exception e) {
            e.getMessage();
        }
        return valor;
    }
    //esta funcion nos permitira saber el ganador
    
    public static String firts(String[]concursantes,int[]puntuacionJug) {
		//este string almacenala posicion  de primer concursantes  
		String rpta=concursantes[0];
                //este contador tendra la primera puntuacion 
		int cont=puntuacionJug[0];
                
                /*si i es menor a la longitud de concursantes ;se incremeta y con el siguiente if comprobamos que la puntuacion 
                de i jugador sea el mayor por lo tanto lo guardamos en nuestro contador la puntuaciony en el string rpta (respuesta) 
                el nombre de la puntuacion mas alta 
		*/
                
                for(int i=0;i<concursantes.length;i++) {
			
			if(cont<puntuacionJug[i]) {
				cont=puntuacionJug[i];
				rpta=concursantes[i];
			}	
		}
		return rpta;
	}
	//Hace un listado final de todos los jugadores con el total de puntos 
	public static int endJug(String[]concursantes,int[]puntuacionJug) {
            /*si i es menor de la longitud de concursantes ,incrementa 
            y asi recorremos cada jugador con su respectiva puntuacion
            */
		for(int i=0;i<concursantes.length;i++) {
			System.out.println(concursantes[i]+" ha conseguido una puntuación de "+puntuacionJug[i]);
			}
        return 0;
        
	}
        
        
        /*
/* Esta funcion nos permite generar la operacion matematica para nuestra rondas de pregunta a cada jugador  
    
    
     */
    public static String generarOperacion() {
 //generamos la cantidad de numeros que tendra la operacion
       int nEnteros = (int) (Math.random() *(8-4)+4);
       //creamos este string expresion que almacena el numero aleatorio y el signo matematico tambien generado de forma aleatoria
        String expresion = "", signo;

     int nValores = (int)  (Math.random() * (12-2)+2);

        // System.out.println(nValores);
        //para podercompletar la cantidad de nEnteros recorremos el siguiente array
        //mientras i siga siendo menor a nEnteros -1 ya que el primer numero lo generamos fuera de este se incrementa
        
        for (int i = 0; i < (nEnteros - 1); i++) {
            nValores =(int) (Math.random()*(12-2)+2);

            expresion += nValores;

           int operador = (int)  (Math.random() * (3-1)+1);
        //con el siguiente switch  asignamos el signo segun el numero aleatorio generado anteriormente
            switch (operador) {

                case 1:
                    signo = "+";
                    expresion += signo;
                    break;
                case 2:
                    signo = "-";
                    expresion += signo;
                    break;
                case 3:
                    signo = "*";
                    expresion += signo;
                    break;
            }
        //y para terminar nuestra operacion un numero aleatorio mas y no quede finalizando con un signo matematico
            expresion += nValores =  (int) (Math.random() * (12-2)+2);
        }

        return expresion;

    }

    //con esta funcion verificamos que las rondas sean entre 3,5,10 o 20 
    public static int rondas(int r) {
 Scanner sc = new Scanner(System.in);
 //mientras sean 3,5,10 o 20 continuara a la partida
 //sino pedira el numero nuevamente al jugador
        if (r == 3 || r == 5 || r == 10 || r == 20) {
            System.out.print("Perfecto! Ahora empezamos la partida");

        } else {
            System.out.print("No es valido; elige entre 3,5,10 o 20:");
            r=sc.nextInt();

        }

        return r;

    }
//comienza nuestro programa
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);

        /*"Este programa simulará un juego de diferentes preguntas matemáticas, donde tú decides el número de concursantes con sus respectivos nombres, además de elegir la longitud de las rondas"*/
        int numJugadores, nRondas;
    //declaramosvariables numJugadores y nRondas
    //comienzan las preguntas 
        System.out.println("¿Cuantos jugadores son?");
        //lee numJUgadores
        numJugadores = sc.nextInt();
        //si el numjugadores es menor igual a 6 continuamos sino volvera a pedir el numero nuevamente
        if (numJugadores <= 6) {
            System.out.print("continuamos");
        } else {
            System.out.print("Solo pueden ser de 1 a 6 jugadores, introduce numero valido :");
            numJugadores = sc.nextInt();
        }
        //creaamos string concursantes donde almacenamos los nombres 
        String concursantes[] = new String[numJugadores];
//mientras i sea menor a numJugadores seguira pidiendo el nombre de jugadores
        for (int i = 0; i < numJugadores; i++) {
            System.out.println("\nDime el nombre del jugador " + (i + 1) + ":");
            concursantes[i] = sc.next();
           
        }
       
//INTENTOS DE COLOCAR LOS NOMBRES DE FORMA ALEATORIA QUE NO FUNCIONABA DEL TODO CORRECTO
        /*Cambiamos orden de los nombres al azar
        	Random nomAlt = new Random();
		for (int i=0; i<numJugadores; i++) {
 
			int posAleatoria = nomAlt.nextInt(numJugadores);
			//Hacemos copia del nombre actual
			String temp = concursantes[i];
			//En la posicion actual ponemos el nombre de la posicion random
			concursantes[i] =concursantes[posAleatoria];
			//En la posición random, ponemos la copia del nombre actual
			concursantes[posAleatoria] = temp;
		}
         */
        /*Array desordenado, volvemos a mostrar
		System.out.println("\nLos nombres desordenados son: ");
 
		for (int i=0; i<numJugadores; i++) {
 
			System.out.println(concursantes[i]); //Muestra los nombres que ingresamos anteriormente
		}*/
        //   int nomAlt = (int) (Math.random()*numJugadores);
        //creamos variable cantRondas que tendra la llamada a la funcion rondas 
        int cantRondas;
        //preguntamos
        System.out.println("¿Cuantas rondas son?");
        //leemos nRondas
        nRondas = sc.nextInt();
        cantRondas = rondas(nRondas);//llamamos a la funcion
        //creamos array que tendra la puntuacion dependiendo la cantidad de jugadores
         int[]puntuacionJug=new int[numJugadores];
         //le guardamos una puntuacion de o a cada uno
                   for (int n = 0; n < puntuacionJug.length; n++) {
           int puntuacion =0;
             }
//comenzamos las rondas,mientras sea i menor a cantRondas ,incrementara buble
        for (int i = 1; i <= cantRondas; i++) {
            System.out.print("\nComienza la ronda" + i);
            
             //este segundo for sera para recorrer los concursantes y realizarles las preguntas
            for (int j = 0; j < concursantes.length; j++) {
                  
               
		  System.out.print("\nPregunta para el jugador :  " + concursantes[j]);
                //llamamos a ambas funciones evaluar para que crealice la operacion y generar para obtener nuestra operacion aleatoria 
                int resp = evaluarExpresion(generarOperacion());
                //imprimo la respuesta para poder continuar
                System.out.print("\n" +resp);
                //mostramos la operacion y leemos su respuesta
                System.out.print("\nLa operacion es : " + generarOperacion() + " dime tu respuesta : ");
                int respuesta = sc.nextInt();
                   /*/si la respuesta del concursante es igual a la de nuestra funcion  sera correcta e incrementamos en la posicion
                   de nuestro puntuacionJug 
                    -si es incorrecto podemos mostrarle la respuesta o pasar al siguiente concursante
                -y mostramos los puntajes de cada ronda para ello utizo un bucle asi recorro los puntajes por cada concursante
                */
                  
                if (respuesta == resp) {
                    System.out.println("Es correcto");
                  
                     puntuacionJug[j]++;
                } else {
                    System.out.println("Incorrecto");}
                    // System.out.println("El resultado de la expresión matemática " +expMat+ " es: "+res);
                    //bucle para mostrar la puntuacion de cada jugador en cada ronda
		 for(int p=0;p<puntuacionJug.length;p++) {
				
				System.out.println("====" + concursantes[p] + "tiene actualmente una puntuación de " + puntuacionJug[p] + "========");
				
			}
            
                }
           
              
            }
        
            //vuelve al principio, pero pregunta al jugador Num2 ya que incrementa el contador y así hasta que termine de preguntar a todos los jugadores
//Terminada la ronda mostramos las puntuaciones finales de cada jugador
            System.out.println("Fin de la ronda");
       	//mostramos el final de nuestros puntajes y sus jugadores
		System.out.println("==========================================================");
		endJug(concursantes,puntuacionJug);
		System.out.println("==========================================================");
        /*mostramos el ganador creando un string para llamar a nuestra funcion ganador utillizando los datos de nuestros 
        concursantes y puntuacion */
        String ganadorJuego = firts(concursantes,puntuacionJug);
		System.out.println("-----El ganador es: " + ganadorJuego + "-----");
		System.out.println("----------------------------------FELLICIDADES-------------------------------------");
                System.out.println("----------------------------------END GAME GUYS-------------------------------------");
    }
    }

