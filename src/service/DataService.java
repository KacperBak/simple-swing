package service;

import domainobjects.Bookmark;
import domainobjects.User;

import java.io.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: kacper
 * Date: 09.07.12
 * Time: 21:56
 * To change this template use File | Settings | File Templates.
 */
public class DataService {

    private ArrayList<User> users;

    public DataService() {
        this.users = createBasicData();
    }

    public User findUserByName(String name){
        User result = null;
        for(User item : users){
            if(item.getName().equals(name)){
                result = item;
            }
        }
        return result;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Bookmark> findAllBookmarks(String name){
        return findUserByName(name).getCollectionOfBookmarks();
    }

    private ArrayList<User> createBasicData(){

        ArrayList<User> userList = new ArrayList<User>();

        /**
         * Dummy
         */
        User dummy = new User("","");
        dummy.addBookmark(new Bookmark("dummy1", "www.dummy1.de"));
        dummy.addBookmark(new Bookmark("dummy2", "www.dummy2.de"));


        /*
        * create kacper with bookmarks
        * */
        User kacper = new User("kacper","pwkacper");
        kacper.addBookmark(new Bookmark("google","www.google.de"));
        kacper.addBookmark(new Bookmark("yahoo","www.yahoo.de"));

        /*
        * create jakob
        * */
        User jakob = new User("jakob","pwjakob");

        /*
        * add created users to users
        * */
        userList.add(dummy);
        userList.add(kacper);
        userList.add(jakob);

        return userList;
    }

    public void save(String fileName){
        try{
            FileOutputStream fs = new FileOutputStream(fileName);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(users);
            os.close();
            System.out.println("--- All user has been saved ---");
        }catch (IOException e){
            System.err.println(e);
        }
    }

    public void load(String fileName){
        try{
            FileInputStream fs = new FileInputStream(fileName);
            ObjectInputStream is = new ObjectInputStream(fs);
            users = (ArrayList<User>)is.readObject();
            is.close();
            System.out.println("--- All user has been load ---");
        }catch(ClassNotFoundException e){
            System.err.println(e);
        }catch(IOException e){
            createBasicData();
            System.err.println(e);
        }
    }
}
