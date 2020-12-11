package logic.model;

public class GameConfig {
    private int animalsNumber;
    private int sizeX;
    private int sizeY;

    public GameConfig(int animalsNumber, int sizeX, int sizeY) {
        this.animalsNumber = animalsNumber;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
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
}
