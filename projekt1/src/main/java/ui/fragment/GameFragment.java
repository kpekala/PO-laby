package ui.fragment;


import javafx.application.Platform;
import javafx.scene.layout.Region;
import logic.model.GameConfig;
import logic.model.Vector2d;
import ui.base.BaseFragment;
import ui.base.BaseStage;
import ui.game.GamePresenter;
import ui.model.AnimalModel;
import ui.model.MapModel;
import utils.Colors;
import utils.Styles;

public class GameFragment extends BaseFragment {

    private final GamePresenter gamePresenter;

    private Region[][] cells;
    private int index;

    private MapModel lastModel;
    private MapModel model;

    Runnable updater = new Runnable() {

        @Override
        public void run() {
            update();
        }
    };

    public GameFragment(BaseStage baseStage, GamePresenter gamePresenter, Vector2d pos, Vector2d size, int index) {
        super(baseStage, pos, size);
        this.gamePresenter = gamePresenter;
        this.index = index;
    }

    public void init(GameConfig config){
        cells = new Region[config.getHeight()][config.getWidth()];
        int cellSize = Math.min(size.x / config.getWidth(), size.y / config.getHeight());
        int factorX = (size.x - cellSize * config.getWidth()) / 2;
        int factorY = (size.y - cellSize * config.getHeight()) / 2;
        //int cellSizeY = size.y / config.getSizeY();

        for(int i = 0; i<config.getHeight(); i++)
            for(int j = 0; j<config.getWidth(); j++){
                Region cell = new Region();

                cell.setStyle(Styles.getCSSBackground(Colors.getMapColor(index)));
                int cellX = j * cellSize;
                int cellY = (config.getHeight() -(i+1)) * cellSize;

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

    public void update(){
        for(int i = 0; i<cells.length; i++)
            for(int j = 0; j<cells[i].length; j++){
                cells[i][j].setStyle(Styles.getCSSBackground(Colors.getMapColor(index)));
            }
        System.out.println(index + " : " + model.getAnimalModels().size());
        for(AnimalModel animal: model.getAnimalModels()){
            Vector2d pos = animal.getPosition();
            cells[pos.y][pos.x].setStyle("-fx-background-color: " +Colors.getGrey(0.3));
        }
        lastModel = model;
    }

    public void update(MapModel mapModel){
        model = mapModel;
        Platform.runLater(updater);
        /*if(lastModel != null){
            for(AnimalModel animal: lastModel.getAnimalModels()){
                Vector2d pos = animal.getPosition();
                cells[pos.y][pos.x].setStyle(Styles.getCSSBackground(Colors.getMapColor(index)));
            }
        }*/
        /*for(int i = 0; i<cells.length; i++)
            for(int j = 0; j<cells[i].length; j++){
                cells[i][j].setStyle(Styles.getCSSBackground(Colors.getMapColor(index)));
            }
        System.out.println(index + " : " + mapModel.getAnimalModels().size());
        for(AnimalModel animal: mapModel.getAnimalModels()){
            Vector2d pos = animal.getPosition();
            cells[pos.y][pos.x].setStyle("-fx-background-color: " +Colors.getGrey(0.3));
        }
        lastModel = mapModel;*/
    }
}
