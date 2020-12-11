package logic;

public class GameConfig {
    private int animalsNumber;
    private int width;
    private int height;

    public GameConfig(int animalsNumber, int width, int height) {
        this.animalsNumber = animalsNumber;
        this.width = width;
        this.height = height;
    }

    public int getAnimalsNumber() {
        return animalsNumber;
    }

    public void setAnimalsNumber(int animalsNumber) {
        this.animalsNumber = animalsNumber;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
