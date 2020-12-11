package ui.fragment;

import logic.Vector2d;
import ui.app.App;
import ui.base.BaseFragment;
import ui.base.BaseStage;
import utils.Colors;

public class MenuFragment extends BaseFragment {


    public MenuFragment(BaseStage stage) {
        super(stage,new Vector2d(0, (int) (stage.getStageHeight() * 0.8)),
                new Vector2d((int) (stage.getStageWidth() * 0.7), (int) (stage.getStageHeight() * 0.2)));
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initFragment() {
        setStyle("-fx-background-color: " + Colors.getGrey(0.9));
    }
}
