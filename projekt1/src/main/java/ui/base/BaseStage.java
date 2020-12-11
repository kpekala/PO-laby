package ui.base;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.app.App;

import java.io.IOException;

public class BaseStage extends Stage {

    private final App app;
    private int width;
    private int height;


    public BaseStage(App app, int width, int height, String title, String pathToResource){
        super();
        this.app = app;
        this.width = width;
        this.height = height;
        try{
            Parent root = FXMLLoader.load(getClass().getResource(pathToResource));
            setTitle(title);
            setScene(new Scene(root, width, height));
        }catch (IOException exception){
            System.out.println("auć");
            exception.printStackTrace();
        }
    }
    public BaseStage(App app, int width, int height){
        this.app = app;
        this.width = width;
        this.height = height;
    }

    public App getApp(){
        return this.app;
    }

    public int getStageWidth() {
        return width;
    }

    public int getStageHeight() {
        return height;
    }
}
