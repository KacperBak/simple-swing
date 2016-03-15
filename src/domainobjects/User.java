package domainobjects;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: kacper
 * Date: 09.07.12
 * Time: 12:16
 * To change this template use File | Settings | File Templates.
 */
public class User implements Serializable {
    private String name;
    private String password;
    private ArrayList<Bookmark> collectionOfBookmarks;

    public User(String name, String pw){
        this.name=name;
        this.password=pw;
        this.collectionOfBookmarks = new ArrayList<Bookmark>();
    }

    public void addBookmark(Bookmark bookmark){
        collectionOfBookmarks.add(bookmark);
    }

    public void deleteBookmark(Bookmark bookmark){
        collectionOfBookmarks.remove(bookmark);
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Bookmark> getCollectionOfBookmarks() {
        return collectionOfBookmarks;
    }

    public Bookmark findBookmarkByIndex(int index){
        Bookmark result = null;
        //Check for negative integer
        //Check for index is inbound of bookmark-collection
        //Check for bookmark-collection is not empty
        if(index >= 0 && index < collectionOfBookmarks.size() && !collectionOfBookmarks.isEmpty()){
            result = collectionOfBookmarks.get(index);
        }
        return result;
    }

    public Bookmark findBookmarkByName(String name){
        Bookmark result = null;
        for(Bookmark bookmark: this.collectionOfBookmarks){
            if(bookmark.getTitle().equals(name)){
                result = bookmark;
            }
        }
        return result;
    }

    @Override
    public String toString(){
        String back = "Name: " + name + ", Passwort: " + password + "\n Bookmarks:";
        for(Bookmark bookmark : collectionOfBookmarks){
            back += bookmark.toString() ;
        }
        return back;
    }
}
