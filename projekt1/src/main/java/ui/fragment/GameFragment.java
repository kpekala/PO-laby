package ui.fragment;


import javafx.scene.layout.Region;
import logic.model.GameConfig;
import logic.model.Vector2d;
import ui.base.BaseFragment;
import ui.base.BaseStage;
import ui.game.GamePresenter;
import utils.Colors;

import java.util.Random;

public class GameFragment extends BaseFragment {

    private final GamePresenter gamePresenter;

    private Region[][] cells;
    private int index;


    public GameFragment(BaseStage baseStage, GamePresenter gamePresenter, Vector2d pos, Vector2d size, int index) {
        super(baseStage, pos, size);
        this.gamePresenter = gamePresenter;
        this.index = index;
    }

    public void init(GameConfig config){
        cells = new Region[config.getSizeY()][config.getSizeX()];
        int cellSizeX = size.x / config.getSizeX();
        int cellSizeY = size.y / config.getSizeY();

        for(int i=0; i<config.getSizeY(); i++)
            for(int j=0; j<config.getSizeX(); j++){
                Region cell = new Region();

                cell.setStyle("-fx-background-color: " + Colors.getGrey(new Random().nextDouble()));
                if (index == 1)
                    cell.setStyle("-fx-background-color: " + Colors.getGrey(1 - (new Random().nextDouble() / 5)));

                int cellX = j * cellSizeX;
                int cellY = i * cellSizeY;

                cell.setTranslateX(cellX);
                cell.setTranslateY(cellY);
                cell.setMinWidth(cellSizeX);
                cell.setMinHeight(cellSizeY);
                cells[i][j] = cell;
                getChildren().add(cell);
            }
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initFragment() {

    }
}
