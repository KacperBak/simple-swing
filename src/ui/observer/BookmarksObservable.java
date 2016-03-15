package ui.observer;

/**
 * Created with IntelliJ IDEA.
 * User: kacper
 * Date: 17.07.12
 * Time: 20:29
 * To change this template use File | Settings | File Templates.
 */
public interface BookmarksObservable {

    public void registerBookmarksObserver(BookmarksObserver observer);

    public void notifyBookmarksObserver();

    public void removeBookmarksObserver(BookmarksObserver observer);
}
