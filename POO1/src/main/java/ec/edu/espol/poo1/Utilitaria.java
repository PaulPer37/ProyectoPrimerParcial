package ec.edu.espol.poo1;
import java.util.ArrayList;
import java.util.Random;
public class Utilitaria{
    public static ArrayList<Ficha> crearManoJugador() {
        ArrayList<Ficha> mano = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int lado1 = random.nextInt(1,7);
            int lado2 = random.nextInt(1,7);
            Ficha ficha = new Ficha(lado1, lado2){};
            mano.add(ficha);
        }
        FichaComodin fichaComodin = new FichaComodin();
        mano.add(fichaComodin);
        return mano;
    }
}
