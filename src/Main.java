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

    static int funcPuertaJugador(int puerJugador, int puerPresentador) {
        switch (puerJugador) {
            case 0:
                if (puerPresentador == 1) {
                    puerJugador = 2;
                } else {
                    puerJugador = 1;
                }
                break;
            case 1:
                if (puerPresentador == 2) {
                    puerJugador = 0;
                } else {
                    puerJugador = 2;
                }
                break;
            case 2:
                if (puerPresentador == 0) {
                    puerJugador = 1;
                } else {
                    puerJugador = 0;
                }
                break;
            default:
                System.out.println("Ponte a llorar que se ha roto");
        }
        return puerJugador;
    }

    static int funcPuertaPresentador(int randInt, int puertaJugador, boolean[] resultados) {
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
        int decisionJugador, decisionCambio, puertaPresentador, contador = 0, victoria = 0, numTest;
        boolean cambioJugador;
        double porcentaje;
        //Creamos las clases de las puertas para el problema
        boolean puerta0 = false;
        boolean puerta1 = false;
        boolean puerta2 = false;
        Scanner usrInput = new Scanner(System.in);
        System.out.println("Escribe la cantidad de veces que quieres simular el Monty Hall problem");
        numTest = usrInput.nextInt();
        System.out.println("Escribe 0 para no cambiar y 1 para cambiar siempre");
        decisionCambio = usrInput.nextInt();
        for (int i = 0; i < numTest; i++) {
            boolean[] estado = localPremio(); //Iniciar un nuevo etado de las puertas
            puerta0 = estado[0];
            puerta1 = estado[1];
            puerta2 = estado[2];
            boolean[] puertas = {puerta0, puerta1, puerta2};
            decisionJugador = (int) (Math.random() * 3);

            //Puerta del presentador
            puertaPresentador = funcPuertaPresentador((int) (Math.random() * 3), decisionJugador, puertas);
            //Poner sí el jugador quiere cambiar de puerta
            if (decisionCambio == 0) {
                cambioJugador = false;
            } else {
                cambioJugador = true;
                decisionJugador = funcPuertaJugador(decisionJugador, puertaPresentador);
            }

            if (puertas[decisionJugador]) {
                victoria = victoria + 1;
            }
            contador = contador + 1;
        }
        System.out.println("De " + contador + " partidas se ganaron " + victoria + " veces");
        porcentaje = (double) victoria * 100 / (double) contador;
        System.out.println("El porcentaje es de " + porcentaje + " de cada 100");
    }
}
