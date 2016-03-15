package ui.observer;

import domainobjects.Bookmark;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: kacper
 * Date: 17.07.12
 * Time: 20:28
 * To change this template use File | Settings | File Templates.
 */
public interface BookmarksObserver {

    public void updateAllBookmarksInList(ArrayList<Bookmark> bookmarks);

}
