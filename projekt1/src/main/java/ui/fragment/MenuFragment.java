package ui.fragment;

import logic.Vector2d;
import ui.app.App;
import ui.base.BaseFragment;
import ui.base.BaseStage;
import utils.Colors;

public class MenuFragment extends BaseFragment {


    public MenuFragment(BaseStage baseStage) {
        super(baseStage,new Vector2d(0, 400), new Vector2d(baseStage.getStageWidth(), baseStage.getStageHeight() - 400));
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initFragment() {
        setStyle("-fx-background-color: " + Colors.getGrey(0.7));
    }
}
