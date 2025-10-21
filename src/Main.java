import java.util.Scanner;
import java.util.Random;

public class Main {
  static boolean[] localPremio() {
    boolean[] seed = new boolean[0];
    Random rand = new Random();
    int randValue = (rand.nextInt(3));
    if (randValue == 0) {
      seed = new boolean[] { false, false, true };
    } else if (randValue == 1) {
      seed = new boolean[] { false, true, false };
    } else if (randValue == 2) {
      seed = new boolean[] { true, false, false };
    }
    return seed;
  }

  static int funcPuertaPresentador(int puertaJugador, boolean[] resultados) {
    int puerta = 0;
    Random rand = new Random();
    switch (puertaJugador) {
      case 0:
        puerta = rand.nextInt(2) + 1;
        if (resultados[puerta]) {
          if (puerta == 1) {
            puerta = 2;
          } else {
            puerta = 1;
          }
        }
        break;
      case 1:
        puerta = rand.nextInt(2) * 2;
        if (resultados[puerta]) {
          if (puerta == 2) {
            puerta = 0;
          } else {
            puerta = 0;
          }
        }
        break;
      case 2:
        puerta = rand.nextInt(2);
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
    Scanner usrInput = new Scanner(System.in);
    Random rand = new Random();
    // Creamos las clases de las puertas para el problema
    boolean puerta0 = false;
    boolean puerta1 = false;
    boolean puerta2 = false;
    System.out.println("Escribe la cantidad de veces que quieres simular el Monty Hall problem");
    numTest = usrInput.nextInt();
    System.out.println("Escribe 0 para no cambiar y 1 para cambiar siempre");
    decisionCambio = usrInput.nextInt();
    if (decisionCambio == 0) {
      cambioJugador = false;
    } else {
      cambioJugador = true;
    }
    for (int i = 0; i < numTest; i++) {
      boolean[] estado = localPremio(); // Iniciar un nuevo etado de las puertas
      puerta0 = estado[0];
      puerta1 = estado[1];
      puerta2 = estado[2];
      boolean[] puertas = { puerta0, puerta1, puerta2 };
      decisionJugador = rand.nextInt(3);

      // Puerta del presentador
      puertaPresentador = funcPuertaPresentador(decisionJugador, puertas);
      // Poner sí el jugador quiere cambiar de puerta
      if (cambioJugador) {

        decisionJugador = 3 - puertaPresentador - decisionJugador; // Nos da el índice del array de la puerta que no
                                                                   // escogimos ni que escogio el presentador
      }

      if (puertas[decisionJugador]) {
        victoria = victoria + 1;
      }
      contador = contador + 1;
    }
    System.out.println("De " + contador + " partidas se ganaron " + victoria + " veces");
    porcentaje = (double) victoria * 100 / (double) contador;
    System.out.println("El porcentaje es " + porcentaje + " de cada 100");
    usrInput.close();
    System.out.println("pito");
  }
}
