package ui.mvc;

import domainobjects.User;

/**
 * Created with IntelliJ IDEA.
 * User: kacper
 * Date: 29.07.12
 * Time: 14:43
 * To change this template use File | Settings | File Templates.
 */
public class MainController extends AbstractBasicController {

    private MainModel mainModel;
    private MainView mainView;

    private LoginController loginController;
    private ManageBookmarksController manageBookmarksController;
    private StatisticController statisticController;

    public MainController(MainModel mainModel) {
        this.mainView = new MainView(this,mainModel);
        this.mainModel = mainModel;

        createLoginMVC();
        createManageBookmarksMVC();
        createStatisticsMVC();

        //init LoginView
        this.mainView.createView();

        //load from file
        mainModel.init();
    }

    /**
     * create MVC's
     */

    private void createLoginMVC(){
        //create and set model
        LoginModel loginModel = new LoginModel(mainModel.getDataService());
        mainModel.setLoginModel(loginModel);

        //create and set controller
        loginController = new LoginController(loginModel, this ,mainView.getFrame());

        //create and set view
        mainView.setLoginView(loginController.getView());
    }

    private void createManageBookmarksMVC(){
        ManageBookmarksModel manageBookmarksModel = new ManageBookmarksModel(mainModel.getDataService());
        mainModel.setManageBookmarksModel(manageBookmarksModel);
        manageBookmarksController = new ManageBookmarksController(manageBookmarksModel, this, mainView.getFrame());
        mainView.setManageBookmarksView(manageBookmarksController.getView());
    }

    private void createStatisticsMVC(){
        StatisticModel statisticModel = new StatisticModel(mainModel.getDataService());
        mainModel.setStatisticModel(statisticModel);
        statisticController = new StatisticController(statisticModel, this, mainView.getFrame());
        mainView.setStatisticView(statisticController.getView());
    }

    /**
     * switch to View
     */

    private void switchToLogin(){
        mainView.showNewViewContent(loginController.getMainPanel(),loginController.getContentPanel());
        mainView.hideMenuBar();
    }

    private void switchToManageBookmarks(User user){
        mainView.showNewViewContent(manageBookmarksController.getMainPanel(), manageBookmarksController.getContentPanel());
        mainView.showMenuBar();
        manageBookmarksController.initManageBookmarksModel(user);
    }

    private void switchToStatistic(){
        mainView.showNewViewContent(statisticController.getMainPanel(),statisticController.getContentPanel());
        mainView.showMenuBar();
        statisticController.initStatisticModel();
    }

    /**
     * Usecases
     */
    public void save(String fileName){
        mainModel.save(fileName);
    }

    /**
     * The load method of all ui-model has to be called to update their views
     */
    public void loadFromUi(String fileName){
        mainModel.load(fileName);
        mainModel.getLoginModel().load();
        mainModel.getManageBookmarksModel().load();
        mainModel.getStatisticModel().load();
    }

    public void logout(){
        switchToLogin();
        manageBookmarksController.clearTextFields();
    }

    public void showStatistics(){
        switchToStatistic();
    }

    public void showManageBookmarks(){
        User user = mainModel.getLoginModel().getUser();
        switchToManageBookmarks(user);
    }
}

