package ui.fragment;


import com.sun.prism.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import logic.model.GameConfig;
import logic.model.Vector2d;
import ui.base.BaseFragment;
import ui.base.BaseStage;
import ui.game.GamePresenter;
import ui.model.AnimalModel;
import ui.model.MapModel;
import utils.Colors;
import utils.Styles;

import java.util.Random;

public class GameFragment extends BaseFragment {

    private final GamePresenter gamePresenter;

    private Region[][] cells;
    private int index;

    private MapModel lastModel;

    public GameFragment(BaseStage baseStage, GamePresenter gamePresenter, Vector2d pos, Vector2d size, int index) {
        super(baseStage, pos, size);
        this.gamePresenter = gamePresenter;
        this.index = index;
    }

    public void init(GameConfig config){
        cells = new Region[config.getSizeY()][config.getSizeX()];
        int cellSize = Math.min(size.x / config.getSizeX(), size.y / config.getSizeY());
        int factorX = (size.x - cellSize * config.getSizeX()) / 2;
        int factorY = (size.y - cellSize * config.getSizeY()) / 2;
        //int cellSizeY = size.y / config.getSizeY();

        for(int i=0; i<config.getSizeY(); i++)
            for(int j=0; j<config.getSizeX(); j++){
                Region cell = new Region();

                //cell.setStyle("-fx-background-color: " + Colors.getGrey(new Random().nextDouble()));
                cell.setStyle(Styles.getCSSBackground(Colors.getMapColor(index)));
                int cellX = j * cellSize;
                int cellY = (config.getSizeY() -(i+1)) * cellSize;

                cell.setTranslateX(cellX + factorX);
                cell.setTranslateY(cellY + factorY);
                cell.setMinWidth(cellSize);
                cell.setMinHeight(cellSize);
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

    public void update(MapModel mapModel){
        if(lastModel != null){
            for(AnimalModel animal: lastModel.getAnimalModels()){
                Vector2d pos = animal.getPosition();
                cells[pos.y][pos.x].setStyle(Styles.getCSSBackground(Colors.getMapColor(index)));
            }
        }
        for(AnimalModel animal: mapModel.getAnimalModels()){
            Vector2d pos = animal.getPosition();
            cells[pos.y][pos.x].setStyle("-fx-background-color: " +Colors.getGrey(0.3));
        }
        lastModel = mapModel;
    }
}
