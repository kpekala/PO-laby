package ui.fragment;

import logic.model.Vector2d;
import ui.base.BaseFragment;
import ui.base.BaseStage;
import ui.game.GamePresenter;
import utils.Colors;

public class StatisticsFragment extends BaseFragment {

    private final GamePresenter gamePresenter;


    public StatisticsFragment(BaseStage stage, GamePresenter gamePresenter) {
        super(stage,
                new Vector2d((int) (stage.getStageWidth() * 0.7), 0),
                new Vector2d((int) (stage.getStageWidth() * 0.3), stage.getStageHeight()));
        this.gamePresenter = gamePresenter;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initFragment() {
        setStyle("-fx-background-color: " + Colors.getGrey(0.3));
    }
}
