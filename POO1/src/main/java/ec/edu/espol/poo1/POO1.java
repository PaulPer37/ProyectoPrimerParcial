package ec.edu.espol.poo1;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class POO1{
    public static boolean existeFichaComodin(ArrayList<Ficha> lista) {
        FichaComodin fichaComodinBuscada=new FichaComodin();
        for (Ficha ficha : lista) {
            if (ficha.getClass()==fichaComodinBuscada.getClass()) {
                return true; // Se encontró la ficha comodín en la lista
            }
        }
        return false; // No se encontró la ficha comodín en la lista
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
        
        int opcion = Integer.parseInt(sc.next());
                while(opcion < 1 || opcion > 3){
                System.out.println("Opción no válida, ingrese una valida:");
                opcion = Integer.parseInt(sc.next());}
                if (opcion == 1){
                    System.out.println("Ingrese el nombre del jugador: ");
                    String nombre = sc.next();
                    juego.agregarJugador(nombre);
                }else if (opcion == 2) {
                    System.out.println("Maquina agregada");
                    juego.agregarJugador("maquina");
                
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
                System.out.println("\n");
                if(!POO1.existeFichaComodin(jugador.getMano())){
                    System.out.println("Hola");
                }
                if(!jugador.getNombre().equals("maquina")){
                    jugador.imprimirMano();
                    System.out.println("\nIngrese la posicion de la ficha que quiere usar");
                    opcion = Integer.parseInt(sc.next());
                    System.out.println(jugador.getFicha(opcion-1));
                    boolean a = juego.agregarFichaLinea(jugador.getFicha(opcion-1), jugador);
                    while(!a){
                        System.out.println("Ficha no valida, ingrese otra: ");
                        jugador.imprimirMano();
                        System.out.println("\n");
                        opcion = Integer.parseInt(sc.next());
                        System.out.println(jugador.getFicha(opcion-1));
                        a = juego.agregarFichaLinea(jugador.getFicha(opcion-1), jugador);
                    }
                    if(jugador.getMano().isEmpty()){
                        System.out.println("Gano "+jugador.getNombre());
                        break;
                    }
                }else{
                    jugador.machinePlay(juego);
                    if(jugador.getMano().isEmpty()){
                        System.out.println("Gano "+jugador.getNombre());
                        break;
                    }
                }
            }
                    
        }System.out.println("Se acabo el juego :D");
    }
    public static void main(String[] args){
        
        POO1.jugar();
    }
}
