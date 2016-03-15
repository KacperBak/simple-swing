package ui.mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: kacper
 * Date: 29.07.12
 * Time: 14:43
 * To change this template use File | Settings | File Templates.
 */
public class MainView extends AbstractBasicView implements ActionListener {

    //mvc
    private MainController mainController;
    private MainModel mainModel;

    //Usecase Views
    private LoginView loginView;
    private ManageBookmarksView manageBookmarksView;
    private StatisticView statisticView;

    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
    }

    public void setManageBookmarksView(ManageBookmarksView manageBookmarksView) {
        this.manageBookmarksView = manageBookmarksView;
    }

    public void setStatisticView(StatisticView statisticView) {
        this.statisticView = statisticView;
    }

    //MainView Elements
    protected JFrame frame;

    private JMenuBar menuBar;
    private JMenuItem saveItem;
    private JMenuItem loadItem;
    private JMenuItem exitItem;
    private JMenuItem logoutItem;
    private JMenuItem manageItem;
    private JMenuItem statisticItem;

    public MainView(MainController controller, MainModel model){
        this.mainController = controller;
        this.mainModel = model;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void createView(){
        frame = new JFrame("Bookmarkmanager2000",null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(createJMenuBar());
        hideMenuBar();
        mainPanel = loginView.getMainPanel();
        contentPanel = loginView.getContentPanel();
        frame.setContentPane(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public void showNewViewContent(JPanel newMainPanel, JPanel newContentPanel){
        frame.remove(mainPanel);
        mainPanel.remove(contentPanel);
        mainPanel = newMainPanel;
        frame.setContentPane(newMainPanel);
        mainPanel.add(newContentPanel);
        mainPanel.updateUI();
    }


    public void showMenuBar(){
        menuBar.setVisible(true);
    }

    public void hideMenuBar(){
        menuBar.setVisible(false);
    }

    private JMenuBar createJMenuBar(){

        //JMenu: File
        JMenu fileMenu = new JMenu("File");
        saveItem = new JMenuItem("save");
        loadItem = new JMenuItem("load");
        exitItem = new JMenuItem("exit");
        saveItem.addActionListener(this);
        loadItem.addActionListener(this);
        exitItem.addActionListener(this);
        fileMenu.add(saveItem);
        fileMenu.add(loadItem);
        fileMenu.add(new JSeparator());
        fileMenu.add(exitItem);

        //JMenu: View
        JMenu viewMenu = new JMenu("View");
        manageItem = new JMenuItem("manage Bookmarks");
        statisticItem = new JMenuItem("statistics");
        logoutItem = new JMenuItem("logout");
        manageItem.addActionListener(this);
        statisticItem.addActionListener(this);
        logoutItem.addActionListener(this);
        viewMenu.add(manageItem);
        viewMenu.add(statisticItem);
        viewMenu.add(new JSeparator());
        viewMenu.add(logoutItem);

        //JMenu: init
        menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        menuBar.add(viewMenu);
        return menuBar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == saveItem){
            JFileChooser fileChooser = createFileChooser();
            int result = fileChooser.showSaveDialog(null);
            if(result == JFileChooser.APPROVE_OPTION){
                File selectedFile = fileChooser.getSelectedFile();
                mainController.save(selectedFile.getAbsolutePath());
            }
        }
        if(e.getSource() == loadItem){
            JFileChooser fileChooser = createFileChooser();
            int result = fileChooser.showOpenDialog(null);
            if(result == JFileChooser.APPROVE_OPTION){
                File selectedFile = fileChooser.getSelectedFile();
                mainController.loadFromUi(selectedFile.getAbsolutePath());
            }
        }
        if(e.getSource() == exitItem){
            System.exit(0);
        }
        if(e.getSource() == logoutItem){
            mainController.logout();
        }
        if(e.getSource() == manageItem){
            mainController.showManageBookmarks();
        }
        if(e.getSource() == statisticItem){
            mainController.showStatistics();
        }
    }

    private JFileChooser createFileChooser(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setLocale(Locale.ENGLISH);
        return fileChooser;
    }
}
