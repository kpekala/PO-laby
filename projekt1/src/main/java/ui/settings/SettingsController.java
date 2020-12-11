package ui.settings;

import com.google.common.eventbus.EventBus;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class SettingsController {
    @FXML
    public Button buttonStart;

    @FXML
    public Text text;

    private EventBus eventBus = new EventBus();


    @FXML
    void onStartClicked(MouseEvent event){
        eventBus.post("Zaczynajmy");
    }
}
