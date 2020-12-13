package ui.game;

import javafx.scene.Group;
import javafx.scene.Scene;
import logic.model.Vector2d;
import ui.app.App;
import ui.base.BaseStage;
import ui.fragment.GameFragment;
import ui.fragment.MenuFragment;
import ui.fragment.StatisticsFragment;

public class GameStage extends BaseStage {

    private GameFragment[] gameFragments;
    private final StatisticsFragment statisticsFragment;
    private  MenuFragment[] menuFragments;

    private final GamePresenter gamePresenter = new GamePresenter(this);

    public GameStage(App app, int width, int height, String title, boolean singleSimulation) {
        super(app, width, height);
        setUpGameFragments(singleSimulation);
        setUpMenuFragments(singleSimulation);

        statisticsFragment = new StatisticsFragment(this, gamePresenter);

        setUpScene(width, height);
        setTitle(title);
    }

    private void setUpGameFragments(boolean singleSimulation) {
        int factor = singleSimulation ? 1 : 2;
        int w = (int) ((width * 0.7) / factor);
        int h = (int) (height * 0.8);
        gameFragments = new GameFragment[factor];
        gameFragments[0] = new GameFragment(this,gamePresenter,
                new Vector2d(0,0),
                new Vector2d(w, h), 0);
        if(!singleSimulation)
            gameFragments[1] = new GameFragment(this,gamePresenter,
                    new Vector2d(w,0),
                    new Vector2d(w, h), 1);
    }

    private void setUpMenuFragments(boolean singleSimulation) {
        int factor = singleSimulation ? 1 : 2;
        int w = (int) ((width * 0.7) / factor);
        int h = (int) (height * 0.2);
        int y = (int) (height * 0.8);
        menuFragments = new MenuFragment[factor];
        menuFragments[0] = new MenuFragment(this,gamePresenter,
                new Vector2d(0,y),
                new Vector2d(w, h), 0);
        if(!singleSimulation)
            menuFragments[1] = new MenuFragment(this,gamePresenter,
                    new Vector2d(w,y),
                    new Vector2d(w, h), 1);
    }

    private void setUpScene(int width, int height){
        Group root = new Group();

        for(GameFragment gameFragment: gameFragments){
            root.getChildren().add(gameFragment);
        }
        for(MenuFragment menuFragment: menuFragments){
            root.getChildren().add(menuFragment);
        }
        root.getChildren().add(statisticsFragment);

        Scene scene = new Scene(root, width, height);
        setScene(scene);
    }

    @Override
    public void initListeners() {

    }

    public GameFragment getGameFragment(int index) {
        return gameFragments[index];
    }

    public StatisticsFragment getStatisticsFragment() {
        return statisticsFragment;
    }

    public MenuFragment getMenuFragment(int index) {
        return menuFragments[index];
    }

    public GamePresenter getPresenter() {
        return gamePresenter;
    }
}
