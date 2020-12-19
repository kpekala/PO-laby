package logic.model;

public class GameConfig {


    private int animalsNumber;
    private int width;
    private int height;
    private boolean singleSimulation;
    private int startEnergy;
    private int moveEnergy;
    private int plantEnergy;
    private Vector2d jungleSize;

    public GameConfig(int animalsNumber, int width, int height, boolean singleSimulation, int startEnergy, int moveEnergy, int plantEnergy, Vector2d jungleSize) {
        this.animalsNumber = animalsNumber;
        this.width = width;
        this.height = height;
        this.singleSimulation = singleSimulation;
        this.startEnergy = startEnergy;
        this.moveEnergy = moveEnergy;
        this.plantEnergy = plantEnergy;
        this.jungleSize = jungleSize;
    }

    public int getStartEnergy() {
        return startEnergy;
    }

    public int getMoveEnergy() {
        return moveEnergy;
    }

    public Vector2d getJungleSize() {
        return jungleSize;
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

    public boolean isSingleSimulation() {
        return singleSimulation;
    }

    public void setSingleSimulation(boolean singleSimulation) {
        this.singleSimulation = singleSimulation;
    }

    public int getPlantEnergy() {
        return plantEnergy;
    }

    public void setPlantEnergy(int plantEnergy) {
        this.plantEnergy = plantEnergy;
    }
}
