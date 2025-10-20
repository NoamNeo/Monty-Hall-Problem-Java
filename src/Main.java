import java.util.Arrays;
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
    public static void main(String[] args){
        Puerta puerta0 = new Puerta();
        Puerta puerta1 = new Puerta();
        Puerta puerta2 = new Puerta();
        Puerta[] puertas = new Puerta[]{puerta0, puerta1, puerta2};

        boolean[] estado = localPremio(); //Iniciar un nuevo etado de las puertas
        puerta0.premio = estado[0];
        puerta1.premio = estado[1];
        puerta2.premio = estado[2];
        
        for(int i = 0; i < puertas.length; i++){
            System.out.println("Premio detrás de puerta "+i+":"+ puertas[i].premio);
        }
    }
}
