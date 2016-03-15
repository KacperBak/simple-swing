package ui.mvc;

import domainobjects.Bookmark;
import domainobjects.User;
import service.DataService;
import ui.observer.BookmarksObservable;
import ui.observer.BookmarksObserver;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created with IntelliJ IDEA.
 * User: kacper
 * Date: 11.07.12
 * Time: 08:59
 * To change this template use File | Settings | File Templates.
 */
public class ManageBookmarksModel extends AbstractGuiModel implements BookmarksObservable {

    private User user;

    private ArrayList<Bookmark> bookmarks;

    public ManageBookmarksModel(DataService service) {
        dataService = service;
    }

    public void initModel(User currentUser) {
        user = currentUser;
        setBookmarks(dataService.findAllBookmarks(user.getName()));
    }

    public ArrayList<Bookmark> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(ArrayList<Bookmark> bookmarks) {
        this.bookmarks = bookmarks;
        notifyBookmarksObserver();
    }

    public void createBookmark(String title, String url) {
        Bookmark bookmark = new Bookmark(title, url);
        bookmarks.add(bookmark);
        notifyBookmarksObserver();
    }

    public void deleteBookmark(Bookmark selectedBookmark){
        bookmarks.remove(selectedBookmark);
        notifyBookmarksObserver();
    }

    public void updateBookmark(Bookmark selectedBookmark, Bookmark updatedBookmark){

        if(bookmarks.contains(selectedBookmark)){
            int index = bookmarks.indexOf(selectedBookmark);
            bookmarks.set(index, updatedBookmark);
            notifyBookmarksObserver();
        }
    }

    @Override
    public void load(){
        setBookmarks(dataService.findUserByName(user.getName()).getCollectionOfBookmarks());
    }

    /**
     * Observer Logic
     */
    ArrayList<BookmarksObserver> observers = new ArrayList<BookmarksObserver>();

    @Override
    public void registerBookmarksObserver(BookmarksObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyBookmarksObserver() {
        for (BookmarksObserver o : observers) {
            o.updateAllBookmarksInList(bookmarks);
        }
    }

    @Override
    public void removeBookmarksObserver(BookmarksObserver observer) {
        observers.remove(observer);
    }
}
