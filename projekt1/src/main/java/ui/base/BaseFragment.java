package main.java.ui.base;

import javafx.scene.layout.Pane;
import main.java.ui.app.App;
import main.java.ui.app.AppPresenter;

public abstract class BaseFragment extends Pane {

    protected AppPresenter appPresenter;
    protected App app;

    public BaseFragment(App app){
        this.app = app;
        this.appPresenter = appPresenter;
        this.appPresenter = appPresenter;

        initFragment();
        initViews();
    }

    public abstract void initViews();
    public abstract void initFragment();

}