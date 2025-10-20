import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class Main {
    static boolean[] localPremio(){
        boolean[] seed = new boolean[0];
        int randValue = (int) (Math.random()*3);
        if(randValue == 0){
            seed = new boolean[]{false, false, true};
        }else if(randValue == 1){
            seed = new boolean[]{false, true, false};
        }else if (randValue == 2){
            seed = new boolean[]{true, false, false};
        }
        return seed;
    }
    static void estadoPartida(boolean estado){
        if(estado){
            System.out.println("El jugador ganó");
        }else {
            System.out.println("El jugador perdió");
        }
    }
    public static void main(String[] args){
        int decisionJugador;
        //Creamos las clases de las puertas para el problema
        boolean puerta0 = false;
        boolean puerta1 = false;
        boolean puerta2 = false;
        boolean[] puertas = {puerta0, puerta1, puerta2};

        boolean[] estado = localPremio(); //Iniciar un nuevo etado de las puertas
        puerta0= estado[0];
        puerta1= estado[1];
        puerta2= estado[2];

        decisionJugador = (int) (Math.random()*3);

        estadoPartida(puertas[decisionJugador]);
    }
}
