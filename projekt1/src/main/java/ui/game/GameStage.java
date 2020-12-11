package ui.game;

import javafx.scene.Group;
import javafx.scene.Scene;
import ui.app.App;
import ui.base.BaseStage;
import ui.fragment.GameFragment;
import ui.fragment.MenuFragment;
import ui.fragment.StatisticsFragment;

public class GameStage extends BaseStage {

    private final GameFragment gameFragment;
    private final StatisticsFragment statisticsFragment;
    private final MenuFragment menuFragment;

    private final GamePresenter gamePresenter = new GamePresenter(this);

    public GameStage(App app, int width, int height, String title) {
        super(app, width, height);
        gameFragment = new GameFragment(this, gamePresenter);
        statisticsFragment = new StatisticsFragment(this, gamePresenter);
        menuFragment = new MenuFragment(this, gamePresenter);

        setUpScene(width, height);
        setTitle(title);
    }

    private void setUpScene(int width, int height){
        Group root = new Group();

        root.getChildren().add(gameFragment);
        root.getChildren().add(statisticsFragment);
        root.getChildren().add(menuFragment);

        Scene scene = new Scene(root, width, height);
        setScene(scene);
    }

    @Override
    public void initListeners() {

    }

    public GameFragment getGameFragment() {
        return gameFragment;
    }

    public StatisticsFragment getStatisticsFragment() {
        return statisticsFragment;
    }

    public MenuFragment getMenuFragment() {
        return menuFragment;
    }

    public GamePresenter getPresenter() {
        return gamePresenter;
    }
}
