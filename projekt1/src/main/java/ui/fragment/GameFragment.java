package ui.fragment;


import com.sun.javafx.geom.Rectangle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import logic.model.GameConfig;
import logic.model.Vector2d;
import ui.base.BaseFragment;
import ui.base.BaseStage;
import ui.game.GamePresenter;
import utils.Colors;

import java.util.ArrayList;
import java.util.Random;

public class GameFragment extends BaseFragment {

    private final GamePresenter gamePresenter;

    private Region[][] cells;

    public GameFragment(BaseStage baseStage, GamePresenter gamePresenter) {
        super(baseStage,
                new Vector2d(0, 0),
                new Vector2d((int) (baseStage.getStageWidth() * 0.7), (int) (baseStage.getStageHeight() * 0.8)));
        this.gamePresenter = gamePresenter;
    }

    public void init(GameConfig config){
        cells = new Region[config.getSizeY()][config.getSizeX()];
        int cellSizeX = size.x / config.getSizeX();
        int cellSizeY = size.y / config.getSizeY();

        for(int i=0; i<config.getSizeY(); i++)
            for(int j=0; j<config.getSizeX(); j++){
                Region cell = new Region();
                cell.setStyle("-fx-background-color: " + Colors.getGrey(new Random().nextDouble()));

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
