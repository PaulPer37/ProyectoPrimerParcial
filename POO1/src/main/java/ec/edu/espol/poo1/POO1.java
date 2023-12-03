package ec.edu.espol.poo1;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class POO1{
    
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
            opcion = Integer.parseInt(sc.next());
        }
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
        System.out.println("Que empiece el juego");
        boolean fin = false;
        do{
            for(Jugador jugador:juego.getJugadores()){
                System.out.print("\nTurno de " + jugador.getNombre() + ": Mano -> ");
                jugador.imprimirMano();
                System.out.print("\nLinea de juego -> ");
                juego.mostrarLinea();
                System.out.println();
                if(!POO1.existeFichaComodin(jugador.getMano())){
                    if(POO1.terminar(jugador.getMano(), juego)){
                        System.out.println("Perdio "+jugador.getNombre()+", no tiene fichas usables");
                        fin = true;
                        break;
                    }
                }
                if(!jugador.getNombre().equals("maquina")){
                    System.out.print("\nÍndice de ficha para jugar (0 es el primero): ");
                    opcion = Integer.parseInt(sc.next());
                    while(opcion<0 || opcion>(jugador.getMano().size()-1)){
                        System.out.println("Ficha no válida");
                        System.out.print("\nLinea de juego -> ");
                        juego.mostrarLinea();
                        System.out.print("\nMano -> ");
                        jugador.imprimirMano();
                        System.out.println("\nIngrese nuevamente un indice de ficha (0 es el primero): ");
                        opcion = Integer.parseInt(sc.next());
                    }
                    boolean esFichaValida = juego.agregarFichaLinea(jugador.getFicha(opcion), jugador);
                    if (esFichaValida){
                        System.out.println("Movimiento Valido");
                        System.out.print("Nueva Línea de juego -> ");
                        juego.mostrarLinea();
                        System.out.println();
                    }
                    while(!esFichaValida){
                        System.out.print("Ficha no valida, ingrese otra: ");
                        jugador.imprimirMano();
                        System.out.println("\n");
                        opcion = Integer.parseInt(sc.next());
                        System.out.println(jugador.getFicha(opcion));
                        esFichaValida = juego.agregarFichaLinea(jugador.getFicha(opcion), jugador);
                        if (esFichaValida){
                            System.out.println("Movimiento Valido");
                            System.out.print("Nueva Línea de juego -> ");
                            juego.mostrarLinea();
                            System.out.println();
                        }
                    }
                    if(jugador.getMano().isEmpty()){
                        System.out.println("Gano "+jugador.getNombre());
                        fin = true;
                        break;
                    }
                }else{
                    jugador.machinePlay(juego);
                    if(jugador.getMano().isEmpty()){
                        System.out.println("Gano "+jugador.getNombre());
                        fin = true;
                        break;
                    }
                }
            }
                    
        }while(fin == false);
        System.out.println("Se acabo el juego :D");
    }
    public static boolean terminar(ArrayList<Ficha> lista,Juego juego){
        for(Ficha ficha:lista){
            if(ficha.getLado2() == juego.obtenerValorInicioLinea()){
                    return false;
                }else if(ficha.getLado1() == juego.obtenerValorFinLinea()){
                    return false;
        }
        }
        return true;
}
    public static boolean existeFichaComodin(ArrayList<Ficha> lista) {
        FichaComodin fichaComodinBuscada=new FichaComodin();
        for (Ficha ficha : lista) {
            if (ficha.getClass()==fichaComodinBuscada.getClass()) {
                return true; // Se encontró la ficha comodín en la lista
            }
        }
        return false; // No se encontró la ficha comodín en la lista
    }
    public static void main(String[] args){
        
        POO1.jugar();
    }
}
