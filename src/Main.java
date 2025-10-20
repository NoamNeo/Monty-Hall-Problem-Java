import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class Main {
    static boolean[] localPremio() {
        boolean[] seed = new boolean[0];
        int randValue = (int) (Math.random() * 3);
        if (randValue == 0) {
            seed = new boolean[]{false, false, true};
        } else if (randValue == 1) {
            seed = new boolean[]{false, true, false};
        } else if (randValue == 2) {
            seed = new boolean[]{true, false, false};
        }
        return seed;
    }

    static void estadoPartida(boolean estado, boolean cambio) {
        if (estado) {
            System.out.println("El jugador ganó");
        } else {
            System.out.println("El jugador perdió");
        }
        if (cambio) {
            System.out.println("Hubo cambio de puerta");
        } else {
            System.out.println("No hubo cambio de puerta");
        }
    }

    static int funcPuertaJugador(int puerJugador, int puerPresentador){
        switch (puerJugador){
            case 0:
                if(puerPresentador == 1){
                    puerJugador = 2;
                }else{
                    puerJugador = 1;
                }
                break;
            case 1:
                if(puerPresentador == 2){
                    puerJugador = 0;
                }else{
                    puerJugador = 2;
                }
                break;
            case 2:
                if(puerPresentador == 0){
                    puerJugador = 1;
                }else{
                    puerJugador = 0;
                }
                break;
            default:
                System.out.println("Ponte a llorar que se ha roto");
        }
        return puerJugador;
    }
    static int funcPuertaPresentador(int randInt, int puertaJugador , boolean[] resultados) {
        int puerta = 0;
        switch (puertaJugador) {
            case 0:
                puerta = (int) (Math.random() * 2) + 1;
                if (resultados[puerta]) {
                    if (puerta == 1) {
                        puerta = 2;
                    } else {
                        puerta = 1;
                    }
                }
                break;
            case 1:
                puerta = (int) (Math.random() * 2) * 2;
                if (resultados[puerta]) {
                    if (puerta == 2) {
                        puerta = 0;
                    } else {
                        puerta = 0;
                    }
                }
                break;
            case 2:
                puerta = (int) (Math.random() * 2);
                if (resultados[puerta]) {
                    if (puerta == 0) {
                        puerta = 1;
                    } else {
                        puerta = 0;
                    }
                }
                break;
            default:
                System.out.println("Se ha roto el programa");
        }
        return puerta;
    }

    public static void main(String[] args) {
        int decisionJugador, decisionCambio;
        boolean cambioJugador;
        int puertaPresentador;
        //Creamos las clases de las puertas para el problema
        boolean puerta0 = false;
        boolean puerta1 = false;
        boolean puerta2 = false;

        boolean[] estado = localPremio(); //Iniciar un nuevo etado de las puertas
        puerta0 = estado[0];
        puerta1 = estado[1];
        puerta2 = estado[2];
        boolean[] puertas = {puerta0, puerta1, puerta2};
        decisionJugador = (int) (Math.random() * 3);

        //Puerta del presentador
        puertaPresentador = funcPuertaPresentador((int) (Math.random() * 3), decisionJugador, puertas);
        //Poner sí el jugador quiere cambiar de puerta
        decisionCambio = (int) (Math.random() * 2);
        decisionCambio = 1;
        if (decisionCambio == 0) {
            cambioJugador = false;
        } else {
            cambioJugador = true;
            decisionJugador = funcPuertaJugador(decisionJugador, puertaPresentador);
        }

        estadoPartida(puertas[decisionJugador], cambioJugador);


    }
}
