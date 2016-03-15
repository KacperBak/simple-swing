package ui.mvc;

import domainobjects.Bookmark;
import domainobjects.User;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: kacper
 * Date: 11.07.12
 * Time: 08:59
 * To change this template use File | Settings | File Templates.
 */
public class ManageBookmarksController extends AbstractGuiController{

    private ManageBookmarksModel model;

    private ManageBookmarksView view;

    public ManageBookmarksController(ManageBookmarksModel model, MainController controller, JFrame frame) {
        mainController = controller;
        this.model = model;
        view = new ManageBookmarksView(model,this);
        view.createView(frame);
    }

    public ManageBookmarksView getView() {
        return view;
    }

    @Override
    public JPanel getMainPanel(){
        return view.getMainPanel();
    }

    @Override
    public JPanel getContentPanel(){
        return view.getContentPanel();
    }

    public void initManageBookmarksModel(User user){
        model.initModel(user);
    }

    public void createBookmark(String title, String url){
        model.createBookmark(title, url);
    }

    public void deleteBookmark(Bookmark selectedBookmark){
        model.deleteBookmark(selectedBookmark);
    }

    public void updateBookmark(Bookmark selectedBookmark, Bookmark updatedBookmark){
        model.updateBookmark(selectedBookmark, updatedBookmark);
    }

    public void clearTextFields(){
        view.clearTextFields();
    }
}
