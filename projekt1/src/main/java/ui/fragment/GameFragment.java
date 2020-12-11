package ui.fragment;


import logic.Vector2d;
import ui.app.App;
import ui.base.BaseFragment;
import ui.base.BaseStage;
import utils.Colors;

public class GameFragment extends BaseFragment {

    public GameFragment(BaseStage baseStage) {
        super(baseStage,
                new Vector2d(0, 0),
                new Vector2d((int) (baseStage.getStageWidth() * 0.7), (int) (baseStage.getStageHeight() * 0.8)));
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initFragment() {
        setStyle("-fx-background-color: " + Colors.getGrey(0.7));
    }
}
