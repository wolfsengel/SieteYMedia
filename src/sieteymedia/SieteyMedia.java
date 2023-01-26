//GameControler.java
package sieteymedia;
import recursos.Baraja;
import recursos.Carta;


public class SieteyMedia {
    String auxiliar;
    String auxiliar2;
    Baraja baraja;
    Carta[] cartasJugador;
    Carta[] cartasBanca;
    public SieteyMedia() {
        auxiliar="menosiete";
        auxiliar2="";
        baraja = new Baraja();
        baraja.barajar();
        cartasJugador = new Carta[15];
        cartasBanca = new Carta[15];
    }
    public double valorCartas(Carta[] cartas) {
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
    public void insertarCartaEnArray(Carta[] cartas, Carta c) {
        int i = 0;
        while (cartas[i] != null) {
            i++;
        }
        cartas[i] = c;
    }

    public void turnoJugador() {
        Carta[] cartasxogador=cartasJugador;
        Carta c = baraja.darCartas(1)[0];
            insertarCartaEnArray(cartasxogador, c);
            if (valorCartas(cartasxogador) < 7.5) {
                auxiliar="menosiete";
            }else{
                auxiliar="pierjug";
            }
    }
    public void turnoBanca() {
        Carta[] cartasxogador=cartasJugador;
        Carta[] cartasbanca=cartasBanca;
        if (valorCartas(cartasxogador) > 7.5) {
            auxiliar="pierjug";
            return;
        }
        while (valorCartas(cartasbanca) < valorCartas(cartasxogador)) {
            Carta c = baraja.darCartas(1)[0];
            insertarCartaEnArray(cartasbanca, c);
        }
        if (valorCartas(cartasbanca) > 7.5) {
            auxiliar2="massiete";
        }
    }
}
