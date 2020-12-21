package ui.fragment;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.model.GameConfig;
import logic.model.Vector2d;
import ui.base.BaseFragment;
import ui.base.BaseStage;
import ui.game.GamePresenter;
import ui.model.StatisticsModel;
import utils.Colors;

public class StatisticsFragment extends BaseFragment {

    private final GamePresenter gamePresenter;
    private final int index;

    private VBox vbox;

    private Text textAnimalsNumber;
    private Text textGrassNumber;
    private Text textMostPopularGen;
    private Text textAvgEnergy;
    private Text textAvgLifeSpan;
    private Text textAvgChildNumber;
    private Text textTitle;

    Runnable updater = this::doUpdate;

    private StatisticsModel model;

    public StatisticsFragment(BaseStage stage, GamePresenter gamePresenter, Vector2d pos, Vector2d size, int index) {
        super(stage,pos,size);
        this.gamePresenter = gamePresenter;
        this.index = index;
    }

    @Override
    public void initViews() {

    }

    public void onStartGame(GameConfig config){
        textTitle = new Text();
        textTitle.setFont(new Font(20));
        textTitle.setText("Symulacja " + (index + 1));

        setUpStatisticViews();

        vbox = new VBox(16);
        vbox.setPadding(new Insets(20, 20, 0 ,20));
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setMinHeight(size.y);
        vbox.setMinWidth(size.x);

        vbox.getChildren().addAll(textTitle, textAnimalsNumber, textGrassNumber,
                textAvgEnergy, textAvgLifeSpan, textAvgChildNumber, textMostPopularGen);

        getChildren().add(vbox);
        setUpShadow();
    }

    private void setUpStatisticViews() {
        textAnimalsNumber = generateText(14);
        textGrassNumber = generateText(14);
        textAvgEnergy = generateText(14);
        textMostPopularGen = generateText(14);
        textAvgChildNumber = generateText(14);
        textAvgLifeSpan = generateText(14);
    }

    private void setUpShadow() {
        DropShadow shadow = new DropShadow();
        shadow.setHeight(0);
        setEffect(shadow);
    }

    public void update(StatisticsModel model){
        this.model = model;
        Platform.runLater(updater);
    }

    private void doUpdate() {
        textTitle.setText("Symulacja " + (index + 1) + " (dzień " + model.getDay() + ")");
        textAnimalsNumber.setText("Liczba zwierząt: " + model.getAnimalsNumber());
        textGrassNumber.setText("Liczba traw: " + model.getGrassNumber());
        textAvgEnergy.setText("Srednia energia: " + model.getAvgEnergy());
        textAvgLifeSpan.setText("Srednia długość życia: " + model.getAvgLifeSpan());
        textAvgChildNumber.setText("Srednia liczba dzieci: " + model.getAvgChildNumber());
        textMostPopularGen.setText("Najpopularniejszy gen: " + model.getMostPopularGen());
    }


    @Override
    public void initFragment() {
        setStyle("-fx-background-color: " + Colors.getGrey(0.9));
    }
}
