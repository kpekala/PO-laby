package ui.app;

import javafx.application.Application;
import javafx.stage.Stage;
import logic.model.GameConfig;
import logic.model.Vector2d;
import ui.game.GameStage;
import ui.settings.SettingsStage;

public class App extends Application {

    private final AppPresenter appPresenter = new AppPresenter();
    private GameStage gameStage;
    private SettingsStage settingsStage;

    @Override
    public void start(Stage primaryStage){
       //settingsStage = new SettingsStage(this, 300, 500, "Ustawienia", "/settings.fxml");
        //settingsStage.show();
        onStartGame(new GameConfig(20, 10, 10, false, 10,1, 5, new Vector2d(5,5)));
    }

    public static void main(String[] args) {
        launch(args);
    }

    public AppPresenter getPresenter(){
        return appPresenter;
    }

    public void onStartGame(GameConfig gameConfig){
        gameStage = new GameStage(this, 1200, 800, "Symulacja", gameConfig.isSingleSimulation());

        //settingsStage.hide();
        gameStage.show();
        gameStage.getPresenter().startGame(gameConfig);
    }

    @Override
    public  void stop(){
        System.out.println("Stage is closing");
        gameStage.getPresenter().onAppStop();
    }
}
