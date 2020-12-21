package ui.model;

import javafx.scene.layout.Region;
import ui.game.GamePresenter;

public class Cell extends Region {
    private final int mapX;
    private final int mapY;
    private final GamePresenter presenter;

    public Cell(int mapX, int mapY, GamePresenter presenter){
        this.mapX = mapX;
        this.mapY = mapY;
        this.presenter = presenter;
    }

    public int getMapX() {
        return mapX;
    }

    public int getMapY() {
        return mapY;
    }
}
