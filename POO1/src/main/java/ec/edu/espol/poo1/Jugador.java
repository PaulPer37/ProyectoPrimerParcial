/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.poo1;

import java.util.ArrayList;

/**
 *
 * @author RUCO HOUSE
 */
public class Jugador {
    private String nombre;
    private ArrayList<Ficha> mano;

    public String getNombre() {
        return nombre;
    }

    public Ficha getFicha(int i) {
        if (i>= 0 && i< mano.size()) {
            // Retorna la ficha en el índice especificado
            return mano.get(i);
        } else {
            // Retorna null si el índice es inválido
            return null;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
