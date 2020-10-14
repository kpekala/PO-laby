package agh.cs.lab1;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static java.lang.System.out;
public class World {

    public static void main(String[] args) {
        out.println("Start systemu");
        Direction[] directions = getDirections(args);
        run(directions);
        out.println("Koniec działania systemu");
    }

    static void run(Direction[] tab){
        /*for(int i=0; i<tab.length - 1; i++){
            out.print(tab[i] + ", ");
        }
        out.print(tab[tab.length - 1] + "\n");*/

        for(Direction element: tab){
            switch (element) {
                case FORWARD -> out.println("Zwierzak idzie do przodu");
                case BACKWARD-> out.println("Zwierzak idzie do tyłu");
                case RIGHT -> out.println("Zwierzak idzie w prawo");
                case LEFT-> out.println("Zwierzak idzie w lewo");
            }
        }
    }
    static Direction[] getDirections(String[] tab){
        var directions = new Direction[tab.length];
        for(int i=0; i<tab.length; i++){
            switch (tab[i]) {
                case "f" -> directions[i] = Direction.FORWARD;
                case "b" -> directions[i] = Direction.BACKWARD;
                case "r" -> directions[i] = Direction.RIGHT;
                case "l" -> directions[i] = Direction.LEFT;
            }
        }
        return directions;
    }
}