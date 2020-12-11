package ui.base;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.app.App;

import java.io.IOException;

public abstract class BaseStage extends Stage {

    protected App app;
    protected int width;
    protected int height;


    public BaseStage(App app, int width, int height, String title, String pathToResource){
        super();
        try{
            Parent root = FXMLLoader.load(getClass().getResource(pathToResource));
            setTitle(title);
            setScene(new Scene(root, width, height));
        }catch (IOException exception){
            System.out.println("auć");
            exception.printStackTrace();
        }
        setUpStage(app, width, height);
    }
    public BaseStage(App app, int width, int height){
        setUpStage(app, width, height);
    }

    private void setUpStage(App app, int width, int height){
        this.app = app;
        this.width = width;
        this.height = height;
        setResizable(false);
        initListeners();
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

    public abstract void initListeners();
}
