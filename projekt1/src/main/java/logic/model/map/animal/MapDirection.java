package logic.model.map.animal;

import logic.model.Vector2d;

public class MapDirection {
    private int angle;
    public static int ANGLES_NUMBER = 8;

    int[] kx = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] ky = {1, 1, 0, -1, -1, -1, 0, 1};

    public MapDirection(int angle){
        this.angle = angle;
    }

    public void update(int angeDelta){
        angle = (angle + angeDelta) % ANGLES_NUMBER;
    }

    public Vector2d getCoordinates(){
        return new Vector2d(kx[angle], ky[angle]);
    }
}