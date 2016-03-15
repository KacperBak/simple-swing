package ui.mvc;

import domainobjects.User;
import service.DataService;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: kacper
 * Date: 09.07.12
 * Time: 08:43
 * To change this template use File | Settings | File Templates.
 */
public class LoginModel extends AbstractGuiModel {

    private User user;

    public LoginModel(DataService service) {
        dataService = service;
    }

    public User getUser() {
        return user;
    }

    public boolean passwordConfirmed(String name, String password) {
        boolean result = false;
        user = dataService.findUserByName(name);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    protected void load() {
        //nothing to load
    }
}
