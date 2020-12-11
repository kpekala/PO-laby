package ui.fragment;

import logic.Vector2d;
import ui.app.App;
import ui.base.BaseFragment;
import ui.base.BaseStage;
import utils.Colors;

public class StatisticsFragment extends BaseFragment {


    public StatisticsFragment(BaseStage stage) {
        super(stage,
                new Vector2d((int) (stage.getStageWidth() * 0.7), 0),
                new Vector2d((int) (stage.getStageWidth() * 0.3), stage.getStageHeight()));
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initFragment() {
        setStyle("-fx-background-color: " + Colors.getGrey(0.3));
    }
}
