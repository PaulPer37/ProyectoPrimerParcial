package ec.edu.espol.poo1;

import java.util.Locale;
import java.util.Scanner;

public class POO1{
    public void jugar(){
        Juego juego = new Juego();
        int i = 1;
        System.out.println("Escoja una opcion: ");
         Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        sc.useLocale(Locale.US);
        do{
        System.out.println("1. Agregar Jugador");
        System.out.println("2. Agregar maquina");
        System.out.println("3. Empezar Partida");
        int opcion = Integer.parseInt(sc.next());
                while(opcion < 1 || opcion > 3){
                System.out.println("Opción no válida, ingrese una valida:");
                opcion = Integer.parseInt(sc.next());}
                while(opcion == 1 || opcion == 2){
                if (opcion == 1){
                    System.out.println("Ingrese el nombre del jugador: ");
                    String nombre = sc.next();
                    juego.agregarJugador(nombre);
                    System.out.println("1. Agregar Jugador");
                    System.out.println("2. Agregar maquina");
                    System.out.println("3. Empezar Partida");
                    opcion = Integer.parseInt(sc.next());
                }else if (opcion == 2) {
                    System.out.println("Maquina agregada");
                    juego.agregarJugador("Maquina"+i);
                    System.out.println("1. Agregar Jugador");
                    System.out.println("2. Agregar maquina");
                    System.out.println("3. Empezar Partida");
                    opcion = Integer.parseInt(sc.next());
                }
                }
    }while(juego.getJugadores().size()<2);
        System.out.println("1. Agregar Jugador");
        System.out.println("2. Agregar maquina");
        System.out.println("3. Empezar Partida");
        int opcion = Integer.parseInt(sc.next());
            while(opcion < 1 || opcion > 3){
            System.out.println("Opción no válida, ingrese una valida:");
            opcion = Integer.parseInt(sc.next());}
            while(opcion == 1 || opcion == 2){
                if (opcion == 1){
                    System.out.println("Ingrese el nombre del jugador: ");
                    String nombre = sc.next();
                    juego.agregarJugador(nombre);
                    System.out.println("1. Agregar Jugador");
                    System.out.println("2. Agregar maquina");
                    System.out.println("3. Empezar Partida");
                    opcion = Integer.parseInt(sc.next());
                }else if (opcion == 2) {
                    System.out.println("Maquina agregada");
                    
                    juego.agregarJugador("maquina"+i);
                    System.out.println("1. Agregar Jugador");
                    System.out.println("2. Agregar maquina");
                    System.out.println("3. Empezar Partida");
                    opcion = Integer.parseInt(sc.next());
                }
                }
        System.out.println("Que empieze el juego");
    }
    public static void main(String[] args){
        
        while (!juego.getJugadores().get(0).getMano().isEmpty() && !juego.getJugadores().get(1).getMano().isEmpty()){
            //Juega el humano
            System.out.println("\nTurno de " + juego.getJugadores().get(0).getNombre());
            juego.mostrarLinea();
            juego.getJugadores().get(0).imprimirMano();
            juego.agregarFichaLinea(juego.getJugadores().get(0).getFicha(0), juego.getJugadores().get(0));
            juego.machinePlay();

            //Juega la maquina
            System.out.println("\nTurno de " + juego.getJugadores().get(juego.getJugadores().size()-1).getNombre());
            juego.mostrarLinea();
            juego.getJugadores().get(1).imprimirMano();
            juego.agregarFichaLinea(juego.getJugadores().get(1).getFicha(0), juego.getJugadores().get(1));
            juego.machinePlay();
        }//hay que considerar quien juega primero en tal caso si la maquina o el jugador xd
        if(juego.getJugadores().get(0).getMano().isEmpty()){
            System.out.println("Gano "+juego.getJugadores().get(0).getNombre());
        }
        if(juego.getJugadores().get(1).getMano().isEmpty()){
            System.out.println("Gano "+juego.getJugadores().get(1).getNombre());
        }
    }
}
