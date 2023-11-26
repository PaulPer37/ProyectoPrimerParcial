package ec.edu.espol.poo1;
import java.util.ArrayList;
public class Jugador{
    private String nombre;
    private ArrayList<Ficha>mano = new ArrayList<Ficha>();

    public Jugador(String n, ArrayList<Ficha> mano){
        this.nombre = n;
        this.mano = new ArrayList<Ficha>();
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
    
}
