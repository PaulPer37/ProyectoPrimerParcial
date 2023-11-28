package ec.edu.espol.poo1;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
public class Juego {
    private ArrayList<Jugador> jugadores;
    private ArrayList<Ficha> lineaJuego;

    public Juego() {
        this.jugadores = new ArrayList<Jugador>();
        this.lineaJuego = new ArrayList<Ficha>();
    }
    
    public void agregarJugador(String nombre) {
        jugadores.add(new Jugador(nombre, Utilitaria.crearManoJugador()));
    }

    public int obtenerValorInicioLinea() {
        return lineaJuego.get(0).getLado1();
    }

    public int obtenerValorFinLinea() {
        return lineaJuego.get(lineaJuego.size() - 1).getLado2();
    }

    public void mostrarLinea() {
        for (Ficha ficha : lineaJuego) {
            System.out.print(ficha.toString()); //Muestra cada ficha
            if(lineaJuego.indexOf(ficha) < lineaJuego.size() - 1){
                System.out.print(" - "); //Cuando llegue a la ultima no añadira el guión
            }
        }
    }
    
    public boolean agregarFichaLinea(Ficha f, Jugador j) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        sc.useLocale(Locale.US);
        FichaComodin fichacomodin = new FichaComodin();
        if(f.getClass() == fichacomodin.getClass()) {
            FichaComodin fich = (FichaComodin) f;
            if (lineaJuego.isEmpty()){
                System.out.println("Ingrese el valor del lado1: ");
                fich.setLado1(Integer.parseInt(sc.next()));
                System.out.println("Ingrese el valor del lado2: ");
                fich.setLado2(Integer.parseInt(sc.next()));
                lineaJuego.add(fich);
                j.removerFicha(f);
            }else{
                // Si hay fichas en línea de juego, pide al jugador la posición donde desea agregar la ficha
                System.out.println("Seleccione la posición para agregar la ficha:");
                System.out.println("1. Inicio");
                System.out.println("2. Fin");
                int opcion = Integer.parseInt(sc.next());
                while(opcion < 1 || opcion > 2){
                System.out.println("Opción no válida, ingrese una valida:");
                opcion = Integer.parseInt(sc.next());}
                if (opcion == 1){
                    System.out.println("Ingrese el valor del lado 1: ");
                    fich.setLado1(Integer.parseInt(sc.next()));
                    j.removerFicha(f);
                    lineaJuego.add(0, fich);
                }else if (opcion == 2) {
                    System.out.println("Ingrese el valor del lado 2: ");
                    fich.setLado2(Integer.parseInt(sc.next()));
                    j.removerFicha(f);
                    lineaJuego.add(fich);
                }
            
            }
        }else{
            if(lineaJuego.isEmpty()){
                lineaJuego.add(f);
                j.removerFicha(f);
            }else{
                if(f.getLado2() == obtenerValorInicioLinea()){
                    lineaJuego.add(0, f);
                    j.removerFicha(f);
                   
                }else if(f.getLado1() == obtenerValorFinLinea()){
                    lineaJuego.add(f);
                    j.removerFicha(f); 
                    
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    
   

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public ArrayList<Ficha> getLineaJuego() {
        return lineaJuego;
    }

    
}
