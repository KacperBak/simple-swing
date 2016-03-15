package ui.mvc;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: kacper
 * Date: 09.07.12
 * Time: 08:44
 * To change this template use File | Settings | File Templates.
 */
public class LoginController extends AbstractGuiController {

    LoginModel model;

    LoginView view;

    public LoginController(LoginModel model, MainController mainController, JFrame frame) {
        this.model = model;
        view = new LoginView(model,this);
        view.createView(frame);
        super.mainController = mainController;
    }

    public void login(String name, String password){
        if(model.passwordConfirmed(name, password)){
            mainController.showManageBookmarks();
            clearInputFields();
        }else{
            view.showError("Error!", "Login failed: Wrong username and/or password.");
        }
    }

    public void clearInputFields(){
        view.clearInputFields();
    }

    public LoginView getView() {
        return view;
    }

    @Override
    public JPanel getMainPanel(){
        return view.getMainPanel();
    }

    @Override
    public JPanel getContentPanel(){
        return view.getContentPanel();
    }
}
