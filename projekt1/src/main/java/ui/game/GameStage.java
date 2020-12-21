package ui.game;

import javafx.scene.Group;
import javafx.scene.Scene;
import logic.model.Vector2d;
import ui.app.App;
import ui.base.BaseStage;
import ui.fragment.DetailsFragment;
import ui.fragment.GameFragment;
import ui.fragment.MenuFragment;
import ui.fragment.StatisticsFragment;

public class GameStage extends BaseStage {

    private GameFragment[] gameFragments;
    private StatisticsFragment[] statisticsFragments;
    private  MenuFragment[] menuFragments;
    private DetailsFragment detailsFragment;

    private final GamePresenter gamePresenter = new GamePresenter(this);

    public GameStage(App app, int width, int height, String title, boolean singleSimulation) {
        super(app, width, height);
        setUpGameFragments(singleSimulation);
        setUpStatisticsFragments(singleSimulation);
        setUpMenuFragments(singleSimulation);
        detailsFragment = new DetailsFragment(this,
                new Vector2d((int)(0.7 * width), (int) (0.8 * height)),
                new Vector2d((int)(0.3 * width),(int)(0.2 * height)));

        setUpScene(width, height);
        setTitle(title);
    }

    private void setUpStatisticsFragments(boolean singleSimulation) {
        int factor = singleSimulation ? 1 : 2;
        int w = (int) (width * 0.3);
        int h = (int) (height * 0.8)/factor;
        int x = (int) (width * 0.7);
        statisticsFragments = new StatisticsFragment[factor];
        statisticsFragments[0] = new StatisticsFragment(this,gamePresenter,
                new Vector2d(x,0),
                new Vector2d(w, h),0);
        if(!singleSimulation)
            statisticsFragments[1] = new StatisticsFragment(this, gamePresenter,
                    new Vector2d(x, h),
                    new Vector2d(w, h), 1);
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
        for(StatisticsFragment statisticsFragment: statisticsFragments){
            root.getChildren().add(statisticsFragment);
        }
        root.getChildren().add(detailsFragment);
        Scene scene = new Scene(root, width, height);
        setScene(scene);
    }

    @Override
    public void initListeners() {

    }

    public GameFragment getGameFragment(int index) {
        return gameFragments[index];
    }

    public StatisticsFragment getStatisticsFragment(int index) {
        return statisticsFragments[index];
    }

    public MenuFragment getMenuFragment(int index) {
        return menuFragments[index];
    }

    public GamePresenter getPresenter() {
        return gamePresenter;
    }

    public DetailsFragment getDetailsFragment() {
        return detailsFragment;
    }
}
