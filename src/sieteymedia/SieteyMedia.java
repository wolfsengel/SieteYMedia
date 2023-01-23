//GameControler.java
package sieteymedia;
import recursos.Baraja;
import recursos.Carta;
public class SieteyMedia {
    static Baraja baraja;
    static Carta[] cartasJugador;
    static Carta[] cartasBanca;
    public SieteyMedia() {
        baraja = new Baraja();
        baraja.barajar();
        cartasJugador = new Carta[15];
        cartasBanca = new Carta[15];
    }
    public static double valorCartas(Carta[] cartas) {
        double total = 0.0;
        int val;
        int i = 0;
        while (cartas[i] != null) {
            val = cartas[i].getNumero();
            total += (val > 7) ? 0.5 : val;
            i++;
        }
        return total;
    }
    public static void insertarCartaEnArray(Carta[] cartas, Carta c) {
        int i = 0;
        while (cartas[i] != null) {
            i++;
        }
        cartas[i] = c;
    }
    public static void mostrarCartas(Carta[] cartas) {
        int i = 0;
        while (cartas[i] != null) {
            System.out.print("\t" + cartas[i]);
            i++;
        }
    }
}
