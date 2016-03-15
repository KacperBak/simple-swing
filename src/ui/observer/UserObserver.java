package ui.observer;

import domainobjects.Bookmark;
import domainobjects.User;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: kacper
 * Date: 29.07.12
 * Time: 21:18
 * To change this template use File | Settings | File Templates.
 */
public interface UserObserver {

    public void updateAllUserInList(ArrayList<User> users);
}
