package ui.observer;

/**
 * Created with IntelliJ IDEA.
 * User: kacper
 * Date: 29.07.12
 * Time: 21:18
 * To change this template use File | Settings | File Templates.
 */
public interface UserObservable {

    public void registerUserObserver(UserObserver observer);

    public void notifyUserObserver();

    public void removeUserObserver(UserObserver observer);
}
