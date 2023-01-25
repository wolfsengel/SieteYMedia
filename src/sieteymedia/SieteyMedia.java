//GameControler.java
package sieteymedia;
import recursos.Baraja;
import recursos.Carta;


public class SieteyMedia {
    static String auxiliar="menosiete";
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
        Carta[] cartasxogador=SieteyMedia.cartasJugador;
        Carta c = SieteyMedia.baraja.darCartas(1)[0];

            SieteyMedia.insertarCartaEnArray(cartasxogador, c);
            InterfaceConsola.mostrarCartas(cartasxogador);
            if (SieteyMedia.valorCartas(cartasxogador) < 7.5) {
                auxiliar="menosiete";
            }else{
                auxiliar="pierjug";
            }
    }
    public static void turnoBanca() {
        Carta[] cartasxogador=SieteyMedia.cartasJugador;
        Carta[] cartasbanca=SieteyMedia.cartasBanca;
        if (SieteyMedia.valorCartas(cartasxogador) > 7.5) {
            auxiliar="pierjug";
            return;
        }
        while (SieteyMedia.valorCartas(cartasbanca) < SieteyMedia.valorCartas(cartasxogador)) {
            Carta c = SieteyMedia.baraja.darCartas(1)[0];
            SieteyMedia.insertarCartaEnArray(cartasbanca, c);
        }
        InterfaceConsola.mostrarCartas(cartasbanca);
        if (SieteyMedia.valorCartas(cartasbanca) > 7.5) {
            auxiliar2="massiete";
        }
    }
}
