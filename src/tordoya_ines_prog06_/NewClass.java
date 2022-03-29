/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tordoya_ines_prog06_;

import java.util.Scanner;

/**
 *
 * @author p
 */
public class NewClass {
    //Hace un cambio para elegir el numero de rondas
	public static int rondas(int partida) {
		int res=0;
		switch(partida) {
		case 1:
			res=3;
			break;
		case 2:
			res=5;
			break;
		case 3:
			res=10;
			break;
		case 4:
			res=20;
			break;
		}
		return res;
	}
	//Recorre el array de jugadores y los puntos para mostrar qué jugador tiene mayor puntuación 
	public static String ganador(String[]nombres,int[]puntuacion) {
		//digo que el ganador es el primero y si no lo es lo cambio más adelante
		String res=nombres[0];
		//utilizo el contador del primer jugador para saber cuando cambiar de jugador si hay uno con
		//más puntos que el anterior
		int contador=puntuacion[0];
		for(int i=0;i<nombres.length;i++) {
			//si la puntuacion del jugador i es mayor actualizo al nuevo ganador
			if(contador<puntuacion[i]) {
				contador=puntuacion[i];
				res=nombres[i];
			}	
		}
		return res;
	}
	//Hace un listado final de todos los jugadores con el total de puntos 
	public static void listaFinal(String[]nombres,int[]puntuacion) {
		for(int i=0;i<nombres.length;i++) {
			System.out.println(nombres[i]+" ha conseguido una puntuación de "+puntuacion[i]);
			}
	}
	//Se crean las expresiones matemáticas, se muestra el turno del jugador 
	//y aumenta la puntuación si está bien la respuesta, al final de cada ronda 
	//se muestra la puntuacion actual de cada jugador
	public static int[]puntuacion(String[]nombres,int[]puntuacion,int partida){
		//me creo el array con los elementos de puntuación que estan inicializados a 0
		int[]res=puntuacion;
		Scanner ag=new Scanner(System.in);
		int valor,resultado;
		for(int j=1;j<=partida;j++) {
			for(int i=0;i<nombres.length;i++) {
				//son los numeros aleatorios para las expresiones matematicas
				int numero1=(int)(Math.floor(Math.random()*(12-2+1)+2));
				int numero2=(int)(Math.floor(Math.random()*(12-2+1)+2));
				int numero3=(int)(Math.floor(Math.random()*(12-2+1)+2));
				int numero4=(int)(Math.floor(Math.random()*(12-2+1)+2));
				int numero5=(int)(Math.floor(Math.random()*(12-2+1)+2));
				//escribo por pantalla el turno de la persona
				System.out.println("\nTurno de: "+ nombres[i]);
				//imprimo la la expresion mtemática
				System.out.println(numero1+"+("+numero2+"*("+numero3+"+"+numero4+"-"+numero5+"))");
				//el usuario escribe el numero por teclado
				System.out.print("Introduce el valor de la operacion: ");
				valor=ag.nextInt();
				resultado=numero1+(numero2*(numero3+numero4-numero5));
				//compara si el resultado es el correcto
				if(valor==resultado) {
					System.out.println("Número correcto, ha obtenido un punto");
					res[i]++;
				}else {
					System.out.println("El valor de la operacion es: "+resultado);
				}
			}
			//bucle para mostrar la puntuacion de cada jugador en cada ronda
			for(int w=0;w<puntuacion.length;w++) {
				System.out.println("--------------------------------------------------------------");
				System.out.println(nombres[w]+"tiene actualmente una puntuación de "+ puntuacion[w]);
				System.out.println("--------------------------------------------------------------");
			}
		}
		ag.close();
		return puntuacion;
	}
	public static void main(String[] args) {
		//secrean las variables necesarias
		int numJugadores,aux;
		int partida;
		String ganadorr;
		Scanner sc= new Scanner(System.in);
		Scanner sc1= new Scanner(System.in);
		//introduce el usuario el numero de participantes que van a jugar
		System.out.print("Introduce el numero de jugadores (1-6): ");
		aux=sc.nextInt();
		numJugadores=aux;
		//Rellenamos el array de jugadores
		String[]jugadores=new String[numJugadores];
		for(int i=0;i<jugadores.length;i++) {
			System.out.println("Escribe el nombre");
			String nombre=sc1.nextLine();
			jugadores[i]=nombre;
		}
		int[]puntuacionArr=new int[numJugadores];
		//introduce el usuario el tipo de partida que quiere
		System.out.println("Elige el tipo de partida que quieres jugar (1-4): ");
		System.out.println("1-->Partida rápida (3 rondas)");
		System.out.println("2-->Partida corta (5 rondas)");
		System.out.println("3-->Partida normal (10 rondas)");
		System.out.println("4-->Partida larga (20 rondas)");
		aux=sc.nextInt();
		partida=rondas(aux);
		puntuacionArr=puntuacion(jugadores,puntuacionArr,partida);
		//se muestra por pantalla la lista final
		System.out.println("==========================================================");
		listaFinal(jugadores,puntuacionArr);
		System.out.println("==========================================================");
		//se muestra por pantalla el ganador final
		ganadorr=ganador(jugadores,puntuacionArr);
		System.out.println("El ganador es: "+ganadorr);
		
	}

}
    

