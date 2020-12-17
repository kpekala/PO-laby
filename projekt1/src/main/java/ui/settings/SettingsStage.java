package ui.settings;

import javafx.scene.control.Button;
import logic.model.GameConfig;
import ui.app.App;
import ui.base.BaseStage;

public class SettingsStage extends BaseStage {

    public SettingsStage(App app, int width, int height, String title, String pathToResource) {
        super(app, width, height, title, pathToResource);
    }

    @Override
    public void initListeners() {
        Button startButton = (Button) getScene().lookup("#buttonStart");
        startButton.setOnMouseClicked(event ->{
            //app.onStartGame(new GameConfig(10, 10, 10, false));
        });
    }
}
