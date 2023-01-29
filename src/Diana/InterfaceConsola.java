package Diana;

import java.util.Scanner;
import recursos.Carta;


public class InterfaceConsola{
    public InterfaceConsola(){
        presentarJuego();
        juego();
    }
    public static void main(String[] args) {
        new InterfaceConsola();
        System.out.println("Adios");
    }
    public void presentarJuego() {
        System.out.println("- El usuario es el jugador y el ordenador la banca.");
        System.out.println("- No hay en la baraja 8s y 9s. El 10 es la sota, el 11 el caballo y el 12 el Rey.");
        System.out.println("- las figuras (10-sota, 11-caballo y 12-rey) valen medio punto y, el resto, su valor.");
        System.out.println("- Hay dos turnos de juego: el turno del jugador y el turno de la banca. Se comienza por el turno del jugador.");
        System.out.println("- El jugador va pidiendo cartas a la banca de una en una.");
        System.out.println("- El jugador puede plantarse en cualquier momento.");
        System.out.print("- Si la suma de los valores de las cartas sacadas es superior ");
        System.out.println("a 7 y medio, el jugador 'se pasa de siete y medio' y pierde.");
        System.out.println("- Si el jugador no se pasa, comienza a sacar cartas la banca y Ã©sta estÃ¡ obligada a sacar cartas hasta empatar o superar al jugador.");
        System.out.println("- Si la banca consigue empatar o superar la puntuaciÃ³n del jugador 'sin pasarse de siete y medio', gana la banca.");
        System.out.println( "- La banca no se puede plantar y tiene que empatar o superar la puntuaciÃ³n del jugador sin pasarse.");
        System.out.println("- En este proceso puede ocurrir que la banca 'se pase' y entonces pierde la banca y gana el jugador.");
        System.out.println("\nEmpecemos!!!\n");
        System.out.println("Como mÃ­nimo recibes una carta, luego puedes decidir si seguir o plantarte");
    }
        public void juego(){
            Scanner sc = new Scanner(System.in);
            SieteYMedia juego = new SieteYMedia();
            char opc = 'C';
            while (juego.valorCartas(juego.cartasJugador) < 7.5 && opc == 'C') {
                juego.turnoJugador();
                System.out.println("Ã‰stas son tus cartas jugador:");
                mostrarCartas(juego.cartasJugador);
                double valor = juego.valorCartas(juego.cartasJugador);
                System.out.println("\n\tValor de cartas: " + valor);
                if (valor < 7.5) {
                    System.out.println("\nÂ¿Pides [C]arta o te [P]lantas?");
                    opc = sc.next().trim().toUpperCase().charAt(0);
                }
            }



            if (juego.valorCartas(juego.cartasJugador)  > 7.5) {
                System.out.println("Jugador, te has pasado en tu jugada anterior, gana la banca");
                return;
            }
            System.out.println("\n\nTurno de banca ...");
            juego.turnoBanca();
            System.out.println("Ã‰stas son mis cartas:");
            mostrarCartas(juego.cartasBanca);
            System.out.println("\nValor de mis cartas(banca): " + juego.valorCartas(juego.cartasBanca));
            if (juego.valorCartas(juego.cartasBanca) > 7.5) {
                System.out.println("me pasÃ©, ganas tÃº,jugador");
            } else {
                System.out.println("Gana la banca");
            }
        }

    public void mostrarCartas(Carta[] cartas) {
        int i = 0;
        while (cartas[i] != null) {
            System.out.print("\t" + cartas[i]);
            i++;
        }
    }

}

