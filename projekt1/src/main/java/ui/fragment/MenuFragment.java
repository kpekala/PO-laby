package ui.fragment;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import logic.model.GameConfig;
import logic.model.Vector2d;
import ui.base.BaseFragment;
import ui.base.BaseStage;
import ui.game.GamePresenter;
import utils.Colors;

public class MenuFragment extends BaseFragment {

    private final GamePresenter gamePresenter;
    private int index;

    private Button buttonResume;
    private Button buttonStop;

    private HBox hBox;

    public MenuFragment(BaseStage stage, GamePresenter gamePresenter, Vector2d pos, Vector2d size, int index) {
        super(stage,pos, size);
        this.gamePresenter = gamePresenter;
        this.index = index;
    }


    public void onStartGame(GameConfig config){
        setStyle("-fx-background-color: " + Colors.getGrey(0.9));
        if(index == 1)
            setStyle("-fx-background-color: blue");
    }

    @Override
    public void initFragment() {

    }

    @Override
    public void initViews() {
        buttonResume = buildButton("Start");
        buttonStop = buildButton("Stop");
        initClickListeners();

        hBox = new HBox(16);
        hBox.setStyle("-fx-background-color: " + Colors.getGrey(0.8));
        hBox.setPadding(new Insets(20, 20, 0 ,20));
        hBox.setAlignment(Pos.TOP_CENTER);
        hBox.setMinHeight(size.y);
        hBox.setMinWidth(size.x);

        hBox.getChildren().addAll(buttonResume, buttonStop);
        getChildren().add(hBox);
    }

    private Button buildButton(String text){
        Button button = new Button(text);
        button.setFont(new Font(20));
        button.setMinWidth(100);
        return button;
    }

    private void initClickListeners() {
        buttonResume.setOnMouseClicked(event -> {
            gamePresenter.onResumeGame(index);
        });
        buttonStop.setOnMouseClicked(event -> {
            gamePresenter.onStopGame(index);
        });
    }
}
