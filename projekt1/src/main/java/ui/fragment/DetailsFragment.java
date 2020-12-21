package ui.fragment;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.model.Vector2d;
import logic.model.map.animal.Animal;
import ui.base.BaseFragment;
import ui.base.BaseStage;
import ui.model.StatisticsModel;
import utils.Colors;

import java.util.Arrays;

public class DetailsFragment extends BaseFragment {

    private Animal chosenAnimal;

    private Text textGenes;
    private Text textDeathDay;
    private Text textChildCount;
    private VBox vbox;

    Runnable updater = this::doUpdate;

    public DetailsFragment(BaseStage baseStage, Vector2d pos, Vector2d size) {
        super(baseStage, pos, size);
    }

    @Override
    public void initViews() {
        textChildCount = generateText(14);
        textGenes = generateText(10);
        textDeathDay = generateText(14);

        vbox = new VBox(16);
        vbox.setPadding(new Insets(20, 20, 0 ,20));
        vbox.setAlignment(Pos.TOP_LEFT);
        vbox.setMinHeight(size.y);
        vbox.setMinWidth(size.x);

        vbox.getChildren().addAll(textGenes,textChildCount,textDeathDay);

        getChildren().add(vbox);
        setUpShadow();
        setStyle("-fx-background-color: " + Colors.getGrey(0.9));
    }

    private void setUpShadow() {
        DropShadow shadow = new DropShadow();
        setEffect(shadow);
    }

    @Override
    public void initFragment() {

    }

    public void update(){
        Platform.runLater(updater);
    }

    private void doUpdate() {
        if(chosenAnimal == null)return;

        textChildCount.setText("Liczba dzieci: " + chosenAnimal.getChildNumber());
        textGenes.setText(Arrays.toString(chosenAnimal.getGenes()));
        if(chosenAnimal.getEnergy() <= 0)
            textDeathDay.setText("Epoka śmierci(poprawka): " + chosenAnimal.getLifeSpan());

    }



    public void setChosenAnimal(Animal animal) {
        this.chosenAnimal = animal;
        update();
    }
}
