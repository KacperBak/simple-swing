package ui.mvc;

import domainobjects.User;
import service.DataService;
import ui.observer.UserObservable;
import ui.observer.UserObserver;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: kacper
 * Date: 29.07.12
 * Time: 21:03
 * To change this template use File | Settings | File Templates.
 */
public class StatisticModel extends AbstractGuiModel implements UserObservable{

    private ArrayList<User> users;

    public StatisticModel(DataService service) {
        dataService = service;
        initModel();
    }

    public void initModel(){
        users = dataService.getUsers();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    @Override
    protected void load() {
        initModel();
        notifyUserObserver();
    }

    /**
     * Observer Logic
     */
    ArrayList<UserObserver> observers = new ArrayList<UserObserver>();

    @Override
    public void registerUserObserver(UserObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyUserObserver() {
        for(UserObserver o : observers){
            o.updateAllUserInList(users);
        }
    }

    @Override
    public void removeUserObserver(UserObserver observer) {
        observers.remove(observer);
    }
}
