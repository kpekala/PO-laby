package ui.base;

import javafx.scene.layout.Pane;
import ui.app.App;
import ui.app.AppPresenter;

public abstract class BaseFragment extends Pane {

    protected AppPresenter appPresenter;
    protected App app;

    public BaseFragment(App app){
        this.app = app;
        this.appPresenter = this.app.getPresenter();

        initFragment();
        initViews();
    }

    public abstract void initViews();
    public abstract void initFragment();

}