package ec.edu.espol.poo1;
import java.util.ArrayList;
import java.util.Random;
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
        if(i>=0 || i<this.mano.size()){
            return this.mano.get(i+1);
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
     public boolean machinePlay(Juego juego){
         Random random = new Random();
         FichaComodin fichacomodin = new FichaComodin();
         for(Ficha ficha:mano){
            if(ficha.getClass() != fichacomodin.getClass()) {
            if(juego.agregarFichaLinea(ficha, this)){
                return true;
            }
            
            }
        }for(Ficha ficha:mano){
            if(ficha.getClass() == fichacomodin.getClass()) {
                
            if (juego.getLineaJuego().isEmpty()){
                int lado1 = random.nextInt(1,7);
                int lado2 = random.nextInt(1,7);
                
                Ficha ficha2 = new Ficha(lado1,lado2);
                this.mano.set(this.mano.indexOf(ficha), ficha2);
                juego.agregarFichaLinea(ficha2,this);
                return true;
            }else{
                int opcion = random.nextInt(1,3);
                if (opcion == 1){
                    int lado1 = random.nextInt(1,7);
                    int lado2 = juego.obtenerValorInicioLinea();
                    Ficha ficha2 = new Ficha(lado1,lado2);
                this.mano.set(this.mano.indexOf(ficha), ficha2);
                juego.agregarFichaLinea(ficha2,this);
                return true;
                }else if (opcion == 2) {
                    int lado1 = juego.obtenerValorFinLinea();
                    int lado2 = random.nextInt(1,7);
                    Ficha ficha2 = new Ficha(lado1,lado2);
                this.mano.set(this.mano.indexOf(ficha), ficha2);
                juego.agregarFichaLinea(ficha2,this);
                return true;
                }
            
            }
            
            }
        }
        return false;
         
     }
}
