package ec.edu.espol.poo1;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class POO1{
        public static void jugarConMaquina(){
        Juego juego = new Juego();
        juego.agregarJugador("Salado3000");
        juego.agregarJugador("Maquina");
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        sc.useDelimiter("\n");
        while (!juego.getJugadores().get(0).getMano().isEmpty() && !juego.getJugadores().get(1).getMano().isEmpty()){
            System.out.print("\nTurno de " + juego.getJugadores().get(0).getNombre()+"\nFichas en el tablero: ");
            juego.mostrarLinea();
            System.out.print("\n");
            System.out.println("Seleccione la ficha que desea jugar");
            juego.getJugadores().get(0).imprimirMano();
            int fichaEscogida = Integer.parseInt(sc.next())-1;
            while (fichaEscogida<=0&&fichaEscogida>juego.getJugadores().get(0).getMano().size()){
                fichaEscogida = Integer.parseInt(sc.next())-1;
            }
            juego.agregarFichaLinea(juego.getJugadores().get(0).getFicha(fichaEscogida), juego.getJugadores().get(0));
            if (juego.getJugadores().get(0).getMano().isEmpty() || juego.getJugadores().get(1).getMano().isEmpty()){
                break;
            }
            System.out.print("\nTurno de la " + juego.getJugadores().get(1).getNombre()+"\nFichas en el tablero: ");
            juego.mostrarLinea();
            System.out.print("\n");
            juego.getJugadores().get(1).imprimirMano();
            juego.getJugadores().get(juego.getJugadores().size()-1).machinePlay(juego);
            System.out.print("\n");
        }
    }
    public static void jugar(){
        Juego juego = new Juego();
        
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
                    juego.agregarJugador("Maquina");
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
                    
                    juego.agregarJugador("maquina");
                    System.out.println("1. Agregar Jugador");
                    System.out.println("2. Agregar maquina");
                    System.out.println("3. Empezar Partida");
                    opcion = Integer.parseInt(sc.next());
                }
                }
        System.out.println("Que empieze el juego");
        int op = 0;
        while(op == 0){
            for(Jugador jugador:juego.getJugadores()){
                System.out.println("\nTurno de " + jugador.getNombre());
                juego.mostrarLinea();
                jugador.imprimirMano();
                if(!jugador.getNombre().equals("maquina")){
                    System.out.println("Ingrese la posicion de la ficha que quiere usar");
                    opcion = Integer.parseInt(sc.next());
                    boolean a = juego.agregarFichaLinea(jugador.getFicha(op-1), jugador);
                    while(!a){
                        System.out.println("Ficha no valida, ingrese otra: ");
                        opcion = Integer.parseInt(sc.next());
                        a = juego.agregarFichaLinea(jugador.getFicha(op-1), jugador);
                    }
                    if(jugador.getMano().isEmpty()){
                        System.out.println("Gano "+jugador.getNombre());
                        break;
                    }
                }else{
                    jugador.machinePlay();
                    if(jugador.getMano().isEmpty()){
                        System.out.println("Gano "+jugador.getNombre());
                        break;
                    }
                }
            }
                    
        }
    }
    public static void main(String[] args){
        
        POO1.jugar();
    }
}
