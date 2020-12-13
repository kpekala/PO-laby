package ui.fragment;

import javafx.scene.layout.Region;
import logic.model.GameConfig;
import logic.model.Vector2d;
import ui.base.BaseFragment;
import ui.base.BaseStage;
import ui.game.GamePresenter;
import utils.Colors;

import java.util.Random;

public class MenuFragment extends BaseFragment {

    private final GamePresenter gamePresenter;
    private int index;

    public MenuFragment(BaseStage stage, GamePresenter gamePresenter, Vector2d pos, Vector2d size, int index) {
        super(stage,pos, size);
        this.gamePresenter = gamePresenter;
        this.index = index;
    }

    @Override
    public void initViews() {

    }

    public void init(GameConfig config){
        setStyle("-fx-background-color: " + Colors.getGrey(0.9));
        if(index == 1)
            setStyle("-fx-background-color: blue");
    }

    @Override
    public void initFragment() {

    }
}
