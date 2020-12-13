package logic.model;

public class GameConfig {
    private int animalsNumber;
    private int sizeX;
    private int sizeY;
    private boolean singleSimulation;

    public GameConfig(int animalsNumber, int sizeX, int sizeY, boolean singleSimulation) {
        this.animalsNumber = animalsNumber;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.singleSimulation = singleSimulation;
    }

    public int getAnimalsNumber() {
        return animalsNumber;
    }

    public void setAnimalsNumber(int animalsNumber) {
        this.animalsNumber = animalsNumber;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public boolean isSingleSimulation() {
        return singleSimulation;
    }

    public void setSingleSimulation(boolean singleSimulation) {
        this.singleSimulation = singleSimulation;
    }
}
