package ui.base;

import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.model.Vector2d;
import ui.app.App;
import ui.app.AppPresenter;

public abstract class BaseFragment extends Pane {

    protected AppPresenter appPresenter;
    protected App app;
    protected final Vector2d size;
    protected BaseStage baseStage;

    public BaseFragment(BaseStage baseStage, Vector2d pos, Vector2d size){
        this.baseStage = baseStage;
        this.app = baseStage.getApp();
        this.size = size;
        this.appPresenter = this.app.getPresenter();

        setUpCoordinates(pos, size);
        initFragment();
        initViews();
    }
    private void setUpCoordinates(Vector2d pos, Vector2d size){
        setTranslateX(pos.x);
        setTranslateY(pos.y);
        setMinHeight(size.y);
        setMinWidth(size.x);
    }


    protected Text generateText(int font){
        Text text = new Text();
        text.setFont(new Font(font));
        return text;
    }



    public abstract void initViews();
    public abstract void initFragment();

}