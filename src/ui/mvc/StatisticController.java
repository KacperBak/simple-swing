package ui.mvc;

import domainobjects.User;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: kacper
 * Date: 29.07.12
 * Time: 21:03
 * To change this template use File | Settings | File Templates.
 */
public class StatisticController extends AbstractGuiController{

    private StatisticModel model;

    private StatisticView view;

    public StatisticController(StatisticModel model, MainController mainController, JFrame frame) {
        this.mainController = mainController;
        this.model = model;
        view = new StatisticView(model, this);
        view.createView(frame);
    }

    public StatisticView getView() {
        return view;
    }

    @Override
    public JPanel getMainPanel() {
        return view.getMainPanel();
    }

    @Override
    public JPanel getContentPanel() {
        return view.getContentPanel();
    }

    public void initStatisticModel(){
        model.initModel();
        model.notifyUserObserver();
    }


}
