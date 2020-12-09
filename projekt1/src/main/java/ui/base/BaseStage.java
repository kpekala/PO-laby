package ui.base;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BaseStage extends Stage {

    public BaseStage(int width, int height, String title, String pathToResource){
        super();
        try{
            System.out.println(getClass().getPackage().getName());
            Parent root = FXMLLoader.load(getClass().getResource(pathToResource));
            setTitle(title);
            setScene(new Scene(root, width, height));
        }catch (IOException exception){
            System.out.println("auć");
            exception.printStackTrace();
        }
    }
}
