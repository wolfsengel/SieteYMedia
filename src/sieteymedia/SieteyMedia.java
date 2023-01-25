//GameControler.java
package sieteymedia;
import recursos.Baraja;
import recursos.Carta;

import java.util.Scanner;

public class SieteyMedia {
    static String auxiliar;
    static String auxiliar2;
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

    public static void turnoJugador() {
            Carta c = SieteyMedia.baraja.darCartas(1)[0];
            SieteyMedia.insertarCartaEnArray(SieteyMedia.cartasJugador, c);
            InterfaceConsola.mostrarCartas(SieteyMedia.cartasJugador);
            if (SieteyMedia.valorCartas(SieteyMedia.cartasJugador) < 7.5) {
                auxiliar="menosiete";
            }
    }
    public static void turnoBanca() {
        double valorCartasJugador = SieteyMedia.valorCartas(SieteyMedia.cartasJugador);
        if (valorCartasJugador > 7.5) {
            auxiliar="pierjug";
            return;
        }
        while (SieteyMedia.valorCartas(SieteyMedia.cartasBanca) < valorCartasJugador) {
            Carta c = SieteyMedia.baraja.darCartas(1)[0];
            SieteyMedia.insertarCartaEnArray(SieteyMedia.cartasBanca, c);
        }
        InterfaceConsola.mostrarCartas(SieteyMedia.cartasBanca);
        if (SieteyMedia.valorCartas(SieteyMedia.cartasBanca) > 7.5) {
            auxiliar2="massiete";
        }
    }
}
