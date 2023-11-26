package ec.edu.espol.poo1;
public class POO1{
    public static void main(String[] args){
        Juego juego = new Juego();
        juego.agregarJugador("Salado3000");
        juego.agregarJugador("Maquina");
        while (!juego.getJugadores().get(0).getMano().isEmpty() && !juego.getJugadores().get(1).getMano().isEmpty()){
            //Juega el humano
            System.out.println("\nTurno de " + juego.getJugadores().get(0).getNombre());
            juego.mostrarLinea();
            juego.getJugadores().get(0).imprimirMano();
            juego.agregarFichaLinea(juego.getJugadores().get(0).getFicha(0), juego.getJugadores().get(0));
            juego.machinePlay();

            //Juega la maquina
            System.out.println("\nTurno de " + juego.getJugadores().get(juego.getJugadores().size()-1).getNombre());
            juego.mostrarLinea();
            juego.getJugadores().get(1).imprimirMano();
            juego.agregarFichaLinea(juego.getJugadores().get(1).getFicha(0), juego.getJugadores().get(1));
            juego.machinePlay();
        }//hay que considerar quien juega primero en tal caso si la maquina o el jugador xd
    }
}
