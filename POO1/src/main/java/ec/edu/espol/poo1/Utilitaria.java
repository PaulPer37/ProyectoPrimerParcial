/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.poo1;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author DHAMAR
 */
public class Utilitaria {
    
    public static void crearManoJugador(){
        ArrayList<Ficha> Fichas = new ArrayList <Ficha>();
        Random random = new Random();
        for (int i=1; i<=6; i++){
            Ficha f = new Ficha (random.nextInt(6) + 1,random.nextInt(6) + 1);
            Fichas.add(f);
        }
        Fichas.add( new FichaComodin() );
        
        
    }
}
