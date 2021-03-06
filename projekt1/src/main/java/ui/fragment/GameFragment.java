package ui.fragment;


import javafx.application.Platform;
import javafx.scene.layout.Region;
import logic.model.GameConfig;
import logic.model.Vector2d;
import logic.model.map.animal.Animal;
import ui.base.BaseFragment;
import ui.base.BaseStage;
import ui.game.GamePresenter;
import ui.model.AnimalModel;
import ui.model.Cell;
import ui.model.Jungle;
import ui.model.MapModel;
import utils.Colors;
import utils.Styles;

public class GameFragment extends BaseFragment {

    private final GamePresenter gamePresenter;

    private Region[][] cells;
    private int index;

    private MapModel lastModel;
    private MapModel model;
    private Jungle jungle;
    private boolean rendering = false;
    private Animal chosenAnimal = null;

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
        jungle = new Jungle(config);
        cells = new Region[config.getHeight()][config.getWidth()];
        int cellSize = Math.min(size.x / config.getWidth(), size.y / config.getHeight());
        int factorX = (size.x - cellSize * config.getWidth()) / 2;
        int factorY = (size.y - cellSize * config.getHeight()) / 2;
        //int cellSizeY = size.y / config.getSizeY();

        for(int i = 0; i<config.getHeight(); i++)
            for(int j = 0; j<config.getWidth(); j++){
                Cell cell = new Cell(j,i,gamePresenter);
                int cellX = j * cellSize;
                int cellY = (config.getHeight() -(i+1)) * cellSize;
                cell.setStyle(Styles.getCSSBackground(getMapColor(j, i)));

                cell.setTranslateX(cellX + factorX);
                cell.setTranslateY(cellY + factorY);
                cell.setMinWidth(cellSize);
                cell.setMinHeight(cellSize);
                cells[i][j] = cell;
                getChildren().add(cell);
                cell.setOnMouseClicked(mouseEvent -> handleCellClicked(cell));
            }
    }

    private void handleCellClicked(Cell cell) {
        gamePresenter.onCellClicked(cell.getMapX(), cell.getMapY(), index);
    }

    private String getMapColor(int x, int y){
        Vector2d v = new Vector2d(x,y);
        return (jungle.getLowerLeft().precedes(v) && jungle.getUpperRight().follows(v))? "yellow" : Colors.getMapColor(index);
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initFragment() {

    }

    public  void update(){
        if(chosenAnimal != null){
            Vector2d pos = chosenAnimal.getPosition();
            cells[pos.y][pos.x].setStyle("-fx-background-color: " + getMapColor(pos.x, pos.y));
        }
        if(lastModel!= null){
            for(AnimalModel animal: lastModel.getAnimalModels()){
                Vector2d pos = animal.getPosition();
                cells[pos.y][pos.x].setStyle("-fx-background-color: " + getMapColor(pos.x, pos.y));
            }
            for(Vector2d grass: lastModel.getGrassModels()){
                cells[grass.y][grass.x].setStyle("-fx-background-color: " + getMapColor(grass.x, grass.y));
            }
        }
        for(Vector2d grass: model.getGrassModels()){
            cells[grass.y][grass.x].setStyle("-fx-background-color: " + Colors.getGrassColor());
        }
        for(AnimalModel animal: model.getAnimalModels()){
            Vector2d pos = animal.getPosition();
            cells[pos.y][pos.x].setStyle("-fx-background-color: " +Colors.getGrey(animal.getRelativeEnergy()));
        }
        if(chosenAnimal != null){
            Vector2d pos = chosenAnimal.getPosition();
            cells[pos.y][pos.x].setStyle("-fx-background-color: darkBlue");
        }
        lastModel = model;
    }

    public  void update(MapModel mapModel){
        model = mapModel;
        Platform.runLater(updater);
    }

    public void setChosenAnimal(Animal animal) {
        this.chosenAnimal = animal;
    }

    public void addAnimalsWithMostPopularGen(Animal[] animals){
        for(Animal animal: animals){
            Vector2d pos = animal.getPosition();
            cells[pos.y][pos.x].setStyle("-fx-background-color: purple");
        }
    }
}
