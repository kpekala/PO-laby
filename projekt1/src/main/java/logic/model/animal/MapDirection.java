package logic.model.animal;

public class MapDirection {
    private int angle;
    public static int ANGLES_NUMBER = 8;

    public MapDirection(int angle){
        this.angle = angle;
    }

    public void update(int angeDelta){
        angle = (angle + angeDelta) % ANGLES_NUMBER;
    }
}