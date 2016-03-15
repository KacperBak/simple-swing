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
public class Bookmark implements Serializable {
    private String title;
    private String url;

    public Bookmark(String title, String url){
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString(){
        return "Title: " + title + " url: " + url;
    }

}
