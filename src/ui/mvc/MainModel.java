package ui.mvc;

import service.DataService;

/**
 * Created with IntelliJ IDEA.
 * User: kacper
 * Date: 29.07.12
 * Time: 14:43
 * To change this template use File | Settings | File Templates.
 */
public class MainModel extends AbstractBasicModel{

    private String defaultFileName = "savedBookmarks.ser";

    private LoginModel loginModel;
    private ManageBookmarksModel manageBookmarksModel;
    private StatisticModel statisticModel;


    public MainModel(DataService service) {
        dataService = service;
    }

    public DataService getDataService() {
        return dataService;
    }

    public void setLoginModel(LoginModel loginModel) {
        this.loginModel = loginModel;
    }

    public LoginModel getLoginModel() {
        return loginModel;
    }

    public ManageBookmarksModel getManageBookmarksModel() {
        return manageBookmarksModel;
    }

    public void setManageBookmarksModel(ManageBookmarksModel manageBookmarksModel) {
        this.manageBookmarksModel = manageBookmarksModel;
    }

    public StatisticModel getStatisticModel() {
        return statisticModel;
    }

    public void setStatisticModel(StatisticModel statisticModel) {
        this.statisticModel = statisticModel;
    }

    public void load(String fileName) {
        dataService.load(fileName);
    }

    public void save(String fileName){
        dataService.save(fileName);
    }

    public void init(){
        load(defaultFileName);
        statisticModel.initModel();
    }
}
