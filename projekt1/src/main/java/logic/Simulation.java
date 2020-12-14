package logic;

import logic.map.WorldMap;
import logic.model.map.animal.Animal;
import logic.model.GameConfig;
import logic.model.map.Grass;
import logic.model.Vector2d;
import ui.game.GamePresenter;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Thread.sleep;

public class Simulation{
    private HashMap<Vector2d, ArrayList<Animal>> animals;
    private HashMap<Vector2d, Grass> grasses;

    private WorldMap map;
    private GamePresenter presenter;
    private final int index;
    private boolean isRunning = true;


    public Simulation(WorldMap map, GamePresenter presenter, int index) {
        this.map = map;
        this.presenter = presenter;
        this.index = index;
    }

    private void run(){
        Thread thread = new Thread(){
            @Override
            public void run() {
                mainLoop();
            }
        };
        thread.start();
    }

    private void mainLoop(){
        while (true){
            if(isRunning){
                processDay();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void processDay(){
        System.out.println("Simulation " + index + " is running");
    }

    public void stopGame(){
        isRunning = false;
    }

    public void startGame(){
        run();
    }
    public void resumeGame(){
        isRunning = true;
    }
}
