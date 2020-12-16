package logic;

import logic.map.WorldMap;
import ui.game.GamePresenter;

public abstract class ThreadSimulation {

    protected final int index;
    protected boolean isRunning = true;
    protected boolean finished = false;


    public ThreadSimulation(int index) {
        this.index = index;
    }
    protected void run(){
        Thread thread = new Thread(){
            @Override
            public void run() {
                mainLoop();
            }
        };
        thread.start();
    }

    protected void mainLoop(){
        while (!finished){
            if(isRunning)
                processDay();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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

    public void finish(){
        finished = true;
    }

    abstract protected void processDay();
}
