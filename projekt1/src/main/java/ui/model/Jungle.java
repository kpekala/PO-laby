package ui.model;

import logic.model.GameConfig;
import logic.model.Vector2d;

public class Jungle {
    private Vector2d upperRight;
    private Vector2d lowerLeft;

    public Jungle(Vector2d upperRight, Vector2d lowerLeft) {
        this.upperRight = upperRight;
        this.lowerLeft = lowerLeft;
    }

    public Jungle(GameConfig config){
        int jx = config.getJungleSize().x;
        int jy = config.getJungleSize().y;
        this.lowerLeft = new Vector2d(config.getWidth()/2 - jx/2, config.getHeight()/2 - jy/2);
        this.upperRight = new Vector2d(config.getWidth()/2 + jx/2 - (1 - jx%2), config.getHeight()/2 + jy/2 -(1 - jy%2));
    }

    public boolean in(Vector2d pos){
        return pos.follows(lowerLeft) && pos.precedes(upperRight);
    }

    public Vector2d getUpperRight() {
        return upperRight;
    }

    public void setUpperRight(Vector2d upperRight) {
        this.upperRight = upperRight;
    }

    public Vector2d getLowerLeft() {
        return lowerLeft;
    }

    public void setLowerLeft(Vector2d lowerLeft) {
        this.lowerLeft = lowerLeft;
    }
}
