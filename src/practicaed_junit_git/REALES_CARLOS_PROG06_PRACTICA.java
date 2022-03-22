/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaed_junit_git;


import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author aisca
 */
public class REALES_CARLOS_PROG06_PRACTICA {
    
    

    
    /**
     * Metodo Principal
     * Basicamente inicializamos las variables basicas y llamamos en el orden 
     * necesario a las funciones creadas 
     * @param args 
     * @author Carlos Reales &
     */
    public static void main(String[]args){
        
        int players,rondas, score[];
        String nombres[];
        Scanner reader = new Scanner(System.in);
        
        players=asignarNJugadores(reader);
        nombres = new String[players];    
        ordenar_aleatoriamente(nombres);
        rondas = asignarRondas(reader);
        score = new int[players];
        Arrays.fill(score,0);
        
        desarrollarTurno(rondas, players, score, nombres, reader);
        
        declararGanadores(score, nombres); 
    }
    
    /**
     * Esta función se encarga de comprobar que el numero de jugadores esta dentro
     * de los valores permitidio (entre 1 y 6) 
     * @param reader alamcena el numero escrito
     * @return devuelve el numero de jugadores a la función principal
     */
    public static int asignarNJugadores(Scanner reader){
        int players=0;
        while (players<=0 || players >6){
        System.out.println("Dame el número de jugadores(entre 1 y 6)");
        players = reader.nextInt();
        
        }
        return players;
    }
    
    /**
     * Esta función se encarga de pedir los nombres de los jugadores y ordenarlos 
     * aleatoriamente, de manera que si al inclurilo en la lista, esta está
     * ocupada por otro nombre, vuelva a generar otro número aleatorio hasta que
     * esté llena- 
     * @param nombres:lista de nombres que genera 
     */
    public static void ordenar_aleatoriamente(String nombres[]){
        String nombre;
        Scanner reader = new Scanner(System.in);
        Arrays.fill(nombres,"null");
        String elementoVacio = "null";
        for (int i = 0; i < nombres.length;){

            System.out.println("Dame el nombre del jugador " + (i+1));
            nombre = reader.next();
            int j = 0;
            while(j == 0){
                int orden = (int) (Math.random() * nombres.length);


                if (nombres[orden].equals(elementoVacio) == true){
                    nombres[orden] = nombre;
                    j++;
                    i++;
                }
            }    
        }
        System.out.println("El orden en el que jugareis es el siguiente:");
        for(int i = 0;i < nombres.length;i++){

            System.out.print(i+1 + "º." + nombres[i] + " ");
        }
        System.out.print("\n");
    }
    
    /**
     * Este metodo pregunta al jugador el tipo de partida segun las rondas que quiere.
     * Comprobará que la eleccion esta dentro de los rangos (1 a 4)y dependiendo
     * de esta, llamará a otra funcion que devolvera el numero enetero de rondas.
     * Según este número, lo devolvera a la funcion principal. 
     * @param reader: pide el numero de rondas
     * @return rondas del juego
     */
    public static int asignarRondas(Scanner reader) {
        int rondas;

        do {
            System.out.println("Elige el numero de rondas:\n 1.Partida Rapida\n 2.Partida Corta\n 3.Partida Normal\n 4.Partida Larga" );
            rondas = reader.nextInt();}
        while(rondas < 1 || rondas > 4);
        rondas = calcularRondas(rondas);        
        return rondas;
    }
    
    /**
     * Metodo que calcula el numero de rondas de las que constará el juego
     * @param a:respuesta del jugador enter 1 y 4 segun partida
     * @return numero de rondas a la función asignarRondas
     */
    public static int calcularRondas(int a){
        switch(a){
            case 1:
             a = 3;
             System.out.println("Has elegido Partida Rapida que constará de " + 
                     a + " rondas.");
             break;

            case 2:
             a = 5;
             System.out.println("Has elegido Partida Corta que constará de " + 
                     a + " rondas.");
             break;

            case 3:
             a = 10;
             System.out.println("Has elegido Partida Normal que constará de " + 
                     a + " rondas.");
             break;


            case 4:
             a = 20;
             System.out.println("Has elegido Partida Larga que constará de " + 
                     a + " rondas.");
             break;
        }
        return a;
    }
    
    /**
     * Esta funcion se encarga de  desarrollar la partida segun los criterios
     * de numero de rondas y número de jugadores introducidos
     * @param rondas: numero de rondas previamente escogidas
     * @param players: numero de jugadores tambien previamente asignados
     * @param score: array que acumulara las puntuaciones
     * @param nombres: array que contiene los nombres de los participantes en el juego
     * @param reader:  variable que almacenará la respuesta de los jugadores
     */
    public static void desarrollarTurno(int rondas, int players, int[] score, String[] nombres, Scanner reader) {
        int resultado;
        int respuesta;
        
        for(int j = 0;j<rondas;j++){
            for(int i = 0; i < players; i++){
                System.out.println("Turno para " + nombres[i]);
                resultado = crearOperacion();
                respuesta = reader.nextInt();
                
                
                if (respuesta == resultado){
                    System.out.println("¡¡¡Correcto!!!");
                    score[i]++;
                }
                else{System.out.println("¡Fallaste! El resultado correcto es: " + resultado);
                }
               
            }
            puntuarRonda(score, nombres);
        }
    }
    
    /**
     * Metodo que genera la operación a mostrar. 
    * Por lo tanto genera la cantidad de numeros de los que constará
    * y rellenará un array de esa cantidad con numeros aleatorios.
    * @return el resultado de la operacion creada
     */
        public static int crearOperacion(){
       
        int resultado=0;
        int nEnteros = (int) (Math.random()*(8-4)+ 4);
        int numeros[] = new int[nEnteros]; 
        String[] signos = new String[nEnteros];
        

       for(int i = 0; i < nEnteros; i++){
            numeros[i] =(int)  (Math.random() * (13 -2) + 2);
        }
        
        resultado = construirPregunta(resultado, numeros, signos);          
        plantearPregunta(nEnteros, numeros, signos, resultado);
        return resultado;
        
    
    }
        
/**
 * Metodo que construye calcula el resultado de las operaciones que va generando
 * y a la vez almacena los operadores en el array string signos
 * @param resultado: almacena el resultado con ayuda de las funciones de operaciones
 * @param numeros:lee la lista de números sobre los que va a operar
 * @param signos almacena los signos de las operaciones que se van creando
 * @return el resultado final de la operacion 
 */
    public static int construirPregunta(int resultado, int[] numeros, String[] signos) {
        int nOperador;
        resultado = numeros[0];
        for (int i = 1; i < numeros.length;i++ ){
            nOperador =(int)(Math.random()*3);
            
            switch(nOperador){
                case 0:
                    resultado = sumar(resultado,numeros[i]);
                    signos[i-1]=" + ";
                    break;
                    
                    
                case 1:
                    resultado = restar(resultado,numeros[i]);
                    signos[i-1]=" - ";
                    break;
                    
                    
                case 2:
                    resultado = multiplicar(resultado,numeros[i]);
                    signos[i-1]=" x ";
                    break;
            }
            
        }
        signos[signos.length-1]= " ? ";
        return resultado;
    }

  
/**
 * Metodo que combina el array de numeros y de signos para crear la cadena de 
 * teto que será la pregunta y la imprime al jugador
 * @param nEnteros:lee la cantidad de numeros que usara como guia para el bucle for
 * @param numeros:lee los nuemros sobre los que se ha operado
 * @param signos: intercala los signos de las operaciones que se han ido realizando
 * @param resultado para poner el resultado de la operacion(solo para pruebas)
 * Imprime la pregunta al jugador
 */
    public static void plantearPregunta( int nEnteros, int[] numeros, String[] signos, int resultado) {
        String pregunta;
        pregunta = "¿Cuanto es:";
        for(int i=0; i<nEnteros;i++){
            pregunta = pregunta.concat(String.valueOf(numeros[i]));
            pregunta = pregunta.concat(signos[i]);
            
        }
        
        System.out.println(pregunta);
        System.out.println("La respuesta seria: " + resultado);
    }
    /**
     * Funcion que realizara la suma
     * @param a primero numero
     * @param b segundo numero
     * @return resultado
     */
    public static int sumar(int a, int b){
        return a + b;
        
    }
        
        /**
        * Funcion que realizara la resta
        * @param a:primero numero
        * @param b segundo numero
        * @return resultado 
         */
    public static int restar(int a, int b){
        return a - b;
        
    }
          
          /**
        * Funcion que realizara la multiplicación
        * @param a:primero numero
        * @param b segundo numero
        * @return resultado 
           */
    public static int multiplicar(int a, int b){
        return a * b;
        
    }
    
    /**
     * Metodo que se encarga de dar la puntuacion al final de cada ronda
     * @param score:array de puntos
     * @param nombres:array de nombres de jugadores
     */
    public static void puntuarRonda(int[] score, String[] nombres) {
        System.out.println("La puntuacion de la ronda actual es:");
        for(int i = 0; i < score.length; i++){

            System.out.println(nombres[i] + ": " + score[i] + " ptos");
        }
    }

    /**
     * Función que se encarga de encontrar la puntuacion mayor y los jugadores 
     * que la han obtenido
     * @param score: puntos obtenidos en el juego
     * @param nombres lista de nombres de los jugadores
     */
    public static void declararGanadores(int[] score, String[] nombres) {
        int puntuacionMayor = 0;

        //Obtenemos la puntuación mayor
        for(int i = 0; i < score.length; i++){
            if(score[i]>puntuacionMayor){
                puntuacionMayor = score[i];
            }

        }
        //Comprobamos la lista de puntos para saber queienes han alcanzado la mayor puntuacion
        System.out.print("Ha ganado "); 
        for(int i = 0; i < nombres.length; i++){
            if(score[i] == puntuacionMayor){
                System.out.print(nombres[i] + ", ");
            }
        }
        System.out.println("con " + puntuacionMayor + " puntos.");
    }
        
        
     




        
         
    
}
