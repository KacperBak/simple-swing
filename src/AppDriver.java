import service.DataService;
import ui.mvc.MainController;
import ui.mvc.MainModel;

/**
 * Created with IntelliJ IDEA.
 * User: kacper
 * Date: 28.06.12
 * Time: 08:22
 * To change this template use File | Settings | File Templates.
 */
public class AppDriver {

    public static void main(String[] args) {
        DataService dataService = new DataService();
        MainModel mainModel = new MainModel(dataService);
        MainController mainController = new MainController(mainModel);
    }
}
