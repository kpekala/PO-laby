package ui.app;

import javafx.application.Application;
import javafx.stage.Stage;
import logic.model.GameConfig;
import ui.game.GameStage;
import ui.settings.SettingsStage;

public class App extends Application {

    private final AppPresenter appPresenter = new AppPresenter();
    private GameStage gameStage;
    private SettingsStage settingsStage;

    @Override
    public void start(Stage primaryStage){
        settingsStage = new SettingsStage(this, 300, 500, "Ustawienia", "/settings.fxml");
        gameStage = new GameStage(this, 1200, 800, "Symulacja");
        settingsStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public AppPresenter getPresenter(){
        return appPresenter;
    }

    public void onStartGame(GameConfig gameConfig){
        settingsStage.hide();
        gameStage.show();
        gameStage.getPresenter().startGame(gameConfig);
    }
}
