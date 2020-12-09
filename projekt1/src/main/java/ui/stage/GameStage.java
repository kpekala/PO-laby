package main.java.ui.stage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.ui.base.BaseStage;

import java.io.IOException;

public class GameStage extends BaseStage {

    public GameStage(int width, int height, String title, String pathToResource) {
        super(width, height, title, pathToResource);
    }
}
