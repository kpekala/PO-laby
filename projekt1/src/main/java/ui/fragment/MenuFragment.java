package ui.fragment;

import logic.model.Vector2d;
import ui.base.BaseFragment;
import ui.base.BaseStage;
import ui.game.GamePresenter;
import utils.Colors;

public class MenuFragment extends BaseFragment {

    private final GamePresenter gamePresenter;

    public MenuFragment(BaseStage stage, GamePresenter gamePresenter) {
        super(stage,new Vector2d(0, (int) (stage.getStageHeight() * 0.8)),
                new Vector2d((int) (stage.getStageWidth() * 0.7), (int) (stage.getStageHeight() * 0.2)));
        this.gamePresenter = gamePresenter;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initFragment() {
        setStyle("-fx-background-color: " + Colors.getGrey(0.9));
    }
}
