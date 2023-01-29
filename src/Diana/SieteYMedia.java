package Diana;

import recursos.Baraja;
import recursos.Carta;

public class SieteYMedia {
    public Baraja baraja;
    public Carta[] cartasJugador;
    public Carta[] cartasBanca;

    public SieteYMedia() {
        baraja= new Baraja();
        baraja.barajar();
        cartasJugador = new Carta[15];
        cartasBanca = new Carta[15];
    }

    public void turnoJugador() {
        Carta c = baraja.darCartas(1)[0];
        insertarCartaEnArray(cartasJugador, c);
    }

    public void turnoBanca() {
        double valorCartasJugador = valorCartas(cartasJugador);
        while (valorCartas(cartasBanca) < valorCartasJugador) {
            Carta c = baraja.darCartas(1)[0];
            insertarCartaEnArray(cartasBanca, c);
        }
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
}
