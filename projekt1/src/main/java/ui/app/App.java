package ui.app;

import javafx.application.Application;
import javafx.stage.Stage;
import ui.settings.SettingsStage;

public class App extends Application {

    private final AppPresenter appPresenter = new AppPresenter();

    @Override
    public void start(Stage primaryStage){
        SettingsStage settingsStage = new SettingsStage(300, 500, "Ustawienia", "/settings.fxml");
        settingsStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public AppPresenter getPresenter(){
        return appPresenter;
    }
}
