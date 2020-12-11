package ui.app;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import javafx.application.Application;
import javafx.stage.Stage;
import ui.game.GameStage;
import ui.settings.SettingsStage;

public class App extends Application {

    private final AppPresenter appPresenter = new AppPresenter();
    private GameStage gameStage;
    private SettingsStage settingsStage;

    @Override
    public void start(Stage primaryStage){
        //SettingsStage settingsStage = new SettingsStage(this, 300, 500, "Ustawienia");
        GameStage gameStage = new GameStage(this, 900, 600, "Symulacja");
        gameStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public AppPresenter getPresenter(){
        return appPresenter;
    }
}
