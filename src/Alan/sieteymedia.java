package Alan;

import recursos.Baraja;
import recursos.Carta;

public class sieteymedia {
    Baraja baraja;
    Carta[] cartasJugador;
    Carta[] cartasBanca;
    public sieteymedia(){
        baraja = new Baraja();
        baraja.barajar();
        cartasJugador = new Carta[15];
        cartasBanca = new Carta[15];
    }

    public  void  jugador() {
        Carta c = baraja.darCartas(1)[0];
        insertarCartaEnArray(cartasJugador, c);
    }
    public void banca(){
        while (valorCartas(cartasBanca) < valorCartas(cartasJugador)) {
            Carta c = baraja.darCartas(1)[0];
            insertarCartaEnArray(cartasBanca, c);
        }
    }
    double valorCartas(Carta[] cartas) {
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
    void insertarCartaEnArray(Carta[] cartas, Carta c) {

        int i = 0;
        while (cartas[i] != null) {
            i++;
        }
        cartas[i] = c;
    }

}
