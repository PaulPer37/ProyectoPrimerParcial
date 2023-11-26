package ec.edu.espol.poo1;
import java.util.ArrayList;
public class Jugador{
    private String nombre;
    private ArrayList<Ficha>mano = new ArrayList<Ficha>();

    public Jugador(String n, ArrayList<Ficha> mano){
        this.nombre = n;
        this.mano = mano;
    }

    public String getNombre(){
        return nombre;
    }

    public Ficha getFicha(int i){
        if(i>=0 && i<this.mano.size()){
            return this.mano.get(i);
        }else{
            return null;
        }
    }
    
    public void removerFicha(Ficha f){
        this.mano.remove(f);
    }
    public void imprimirMano(){
        for (int i = 0; i < mano.size(); i++) {
            System.out.print(mano.get(i).toString());
            if (i < mano.size() - 1) {
                System.out.print("-");
            }
        }
    }
    
    public ArrayList<Ficha> getMano(){
        return this.mano;
    }
     public void machinePlay(){
     if (!jugadores.isEmpty()){//Si hay jugadores
            //Para que la siguiente linea sea valida, se debe crear un jugador maquina manualmente en el ultimo indice de jugadores
            Jugador maquina = jugadores.get(jugadores.size()-1);
            //otra alternativa seria crearlo como el primer jugador
            //Jugador maquina = jugadores.get(0); 
            if (!maquina.getMano().isEmpty()) {//Si no tiene la mano vacia para evitar el nullPointerException
                //Si la mano de la máquina no está vacía
                Ficha fichaMaquina = maquina.getMano().get(0);//Juega la primera ficha
                if (agregarFichaLinea(fichaMaquina, maquina)) {
                    System.out.println("La máquina jugó la ficha: " + fichaMaquina.toString());
                }else{//Si no puede jugar la primera ficha optara por el comodin
                    for(Ficha ficha : maquina.getMano()){
                        if (ficha instanceof FichaComodin){//Jugara la primera ficha comodin que tenga en la mano la maquina
                            if (agregarFichaLinea(ficha, maquina)) {
                                System.out.println("La máquina jugó la ficha comodín.");
                            }
                        }
                    }
                }
            }
            else{//Si no esta vaciala mano y no pudo jugar una ficha normal o comodin tonces no hace nada
                System.out.println("La máquina no pudo jugar ninguna ficha en este turno.");
            }
        }
    }
}
