package ui.mvc;

import domainobjects.Bookmark;
import ui.observer.BookmarksObserver;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: kacper
 * Date: 11.07.12
 * Time: 08:59
 * To change this template use File | Settings | File Templates.
 */
public class ManageBookmarksView extends AbstractGuiView implements ActionListener, ListSelectionListener, BookmarksObserver
{

    private ManageBookmarksModel model;

    private ManageBookmarksController controller;

    private Dimension buttonPanelDimension = new Dimension(150, 450);

    private JButton createBookmarkButton;
    private JButton deleteBookmarkButton;
    private JButton updateBookmarkButton;
    private JTextField titleTextField;
    private JTextField urlTextFiled;
    private JList bookmarkList;
    private Bookmark currentSelectedBookmark;

    public ManageBookmarksView(ManageBookmarksModel model, ManageBookmarksController controller) {
        this.model = model;
        this.controller = controller;
        model.registerBookmarksObserver(this);
    }

    @Override
    protected JPanel createMainPanel() {
        JPanel panel = new JPanel(new GridBagLayout(),true);
        panel.setBorder(BorderFactory.createTitledBorder("ManageBookmarks"));
        setComponentSize(panel,mainPanelDimension);
        return panel;
    }

    @Override
    protected JPanel createContentPanel() {
        JPanel panel = new JPanel(new BorderLayout(10,10));
        panel.add(createWestPanel(), BorderLayout.WEST);
        panel.add(createCenterPanel(), BorderLayout.CENTER);
//        panel.setBackground(Color.red);
        setComponentSize(panel,contentPanelDimension);
        return panel;
    }

    private JPanel createWestPanel(){
        JPanel panel = new JPanel(new GridLayout(2,1,10,10));
        JPanel textPanel = new JPanel(new GridLayout(6,1,10,10));
        JPanel buttonPanel = new JPanel(new GridLayout(6,1,10,10));

        JLabel titleLabel = new JLabel("Title");
        titleTextField = new JTextField("");

        JLabel urlLabel = new JLabel("URL:");
        urlTextFiled = new JTextField("");

        createBookmarkButton = new JButton("create");
        createBookmarkButton.addActionListener(this);

        updateBookmarkButton = new JButton("update");
        updateBookmarkButton.addActionListener(this);

        deleteBookmarkButton = new JButton("delete");
        deleteBookmarkButton.addActionListener(this);


        textPanel.add(titleLabel);
        textPanel.add(titleTextField);
        textPanel.add(urlLabel);
        textPanel.add(urlTextFiled);

        buttonPanel.add(createBookmarkButton);
        buttonPanel.add(updateBookmarkButton);
        buttonPanel.add(deleteBookmarkButton);

        panel.add(textPanel);
        panel.add(buttonPanel);

        setComponentSize(panel, buttonPanelDimension);
        return panel;
    }

    private JPanel createCenterPanel(){
        ArrayList data = new ArrayList();
        bookmarkList = new JList(data.toArray());
        bookmarkList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        bookmarkList.addListSelectionListener(this);
        JScrollPane scrollPane = new JScrollPane(bookmarkList);
        setComponentSize(scrollPane,new Dimension(
                subtractDimensionWidth(contentPanelDimension, buttonPanelDimension) -10,
                (int)contentPanelDimension.getHeight() -10
        ));
        JPanel panel = new JPanel();
        panel.add(scrollPane);
//        panel.setBackground(Color.orange);
        return panel;
    }

    @Override
    public void updateAllBookmarksInList(ArrayList<Bookmark> bookmarks) {
        bookmarkList.setListData(bookmarks.toArray());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == createBookmarkButton){
            controller.createBookmark(titleTextField.getText(), urlTextFiled.getText());
        }
        if(e.getSource() == deleteBookmarkButton){
            controller.deleteBookmark(currentSelectedBookmark);
        }
        if(e.getSource() == updateBookmarkButton){
            controller.updateBookmark(currentSelectedBookmark, new Bookmark(titleTextField.getText(),urlTextFiled.getText()));
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if( !e.getValueIsAdjusting() && e.getSource() == bookmarkList){
            currentSelectedBookmark = (Bookmark)((JList) e.getSource()).getSelectedValue();
            if(currentSelectedBookmark != null){
                titleTextField.setText(currentSelectedBookmark.getTitle());
                urlTextFiled.setText(currentSelectedBookmark.getUrl());
            }
        }
    }

    public void clearTextFields(){
        titleTextField.setText("");
        urlTextFiled.setText("");
    }

    public void showError(String title, String message){
        JOptionPane.showMessageDialog(frame,message,title,JOptionPane.ERROR_MESSAGE);
    }
}
