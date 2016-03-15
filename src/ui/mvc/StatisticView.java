package ui.mvc;

import domainobjects.User;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import ui.observer.UserObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: kacper
 * Date: 29.07.12
 * Time: 21:02
 * To change this template use File | Settings | File Templates.
 */
public class StatisticView extends AbstractGuiView implements UserObserver {

    private StatisticModel model;

    private StatisticController controller;
    private DefaultCategoryDataset dataset;

    public StatisticView(StatisticModel model, StatisticController controller) {
        this.model = model;
        this.controller = controller;
        model.registerUserObserver(this);
    }

    @Override
    protected JPanel createMainPanel() {
        JPanel panel = new JPanel(new GridBagLayout(),true);
        panel.setBorder(BorderFactory.createTitledBorder("Statistics"));
        setComponentSize(panel,mainPanelDimension);
        return panel;
    }

    @Override
    protected JPanel createContentPanel() {
        createDataset(model.getUsers());
        ChartPanel chartPanel = createChartPanel(dataset);
        chartPanel.setPreferredSize(contentPanelDimension);
        return chartPanel;
    }

    private ChartPanel createChartPanel(DefaultCategoryDataset ds){
        JFreeChart chart = ChartFactory.createBarChart(
                "Statistics",
                "User",
                "Number of bookmarks",
                ds,
                PlotOrientation.VERTICAL,
                false,
                false,
                false
        );
        return new ChartPanel(chart, true);
    }

    /**
     * IMPORTANT
     * Use this method only once, to initilaize the dataset
     * To update the data inside the chart, use the updateChart() method
     * @param users
     */
    private void createDataset(ArrayList<User> users){
        dataset = new DefaultCategoryDataset();
        updateChart(users);
    }

    /**
     * Use this mehtod to update the data inside jFreechart
     * @param users
     */
    private void updateChart(ArrayList<User> users){
        dataset.clear();
        String rowKey = "";
        for(User user : users){
            double bookmarkNumber = user.getCollectionOfBookmarks().size();
            dataset.addValue(bookmarkNumber, rowKey, user.getName());
        }
    }

    @Override
    public void updateAllUserInList(ArrayList<User> users) {
        updateChart(users);
    }
}
