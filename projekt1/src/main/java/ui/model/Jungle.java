package ui.model;

import logic.model.GameConfig;
import logic.model.Vector2d;

public class Jungle {
    private Vector2d lowerRight;
    private Vector2d upperLeft;

    public Jungle(Vector2d lowerRight, Vector2d upperLeft) {
        this.lowerRight = lowerRight;
        this.upperLeft = upperLeft;
    }

    public Jungle(GameConfig config){
        int jx = config.getJungleSize().x;
        int jy = config.getJungleSize().y;
        this.upperLeft = new Vector2d(config.getWidth()/2 - jx/2, config.getHeight()/2 - jy/2);
        this.lowerRight = new Vector2d(config.getWidth()/2 + jx/2 - (1 - jx%2), config.getHeight()/2 + jy/2 -(1 - jy%2));
    }

    public Vector2d getLowerRight() {
        return lowerRight;
    }

    public void setLowerRight(Vector2d lowerRight) {
        this.lowerRight = lowerRight;
    }

    public Vector2d getUpperLeft() {
        return upperLeft;
    }

    public void setUpperLeft(Vector2d upperLeft) {
        this.upperLeft = upperLeft;
    }
}
