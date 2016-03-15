package ui.mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: kacper
 * Date: 09.07.12
 * Time: 08:44
 * To change this template use File | Settings | File Templates.
 */
public class LoginView extends AbstractGuiView implements ActionListener {

    //MVC
    private LoginModel model;

    private LoginController controller;

    private JButton loginButton;

    private JTextField nameTextfield;
    private JPasswordField passwordTextFiled;
    private Dimension panelDimension = new Dimension(150 , 115);

    public LoginView(LoginModel model, LoginController controller) {
        this.model = model;
        this.controller = controller;
    }

    @Override
    protected JPanel createMainPanel(){
        JPanel panel = new JPanel(new GridBagLayout(),true);
        panel.setBorder(BorderFactory.createTitledBorder("Login"));
        setComponentSize(panel,mainPanelDimension);
        return panel;
    }

    @Override
    protected JPanel createContentPanel(){
        JPanel panel = new JPanel();

        //set components
        panel.add(createLabelPanel());
        panel.add(createFormPanel());

        return panel;
    }

    private JPanel createLabelPanel(){
        JPanel panel = new JPanel(new GridLayout(3,1,10,10));
        JLabel nameLabel = new JLabel("Name: ");
        JLabel passwordLabel = new JLabel("Password: ");
        JLabel blankLabel1 = new JLabel();
        panel.add(nameLabel);
        panel.add(passwordLabel);
        panel.add(blankLabel1);
        setComponentSize(panel, panelDimension);
        return panel;
    }

    private JPanel createFormPanel(){
        JPanel panel = new JPanel(new GridLayout(3,1,10,10));
        loginButton = new JButton("login");
        loginButton.addActionListener(this);
        setComponentSize(loginButton, buttonDimension);
        nameTextfield = createNameTextField();
        passwordTextFiled = createPasswordTextField();
        panel.add(nameTextfield);
        panel.add(passwordTextFiled);
        panel.add(loginButton);
        setComponentSize(panel,panelDimension);
        return panel;
    }

    private JTextField createNameTextField(){
        JTextField textField = new JTextField();
        setComponentSize(textField,buttonDimension);
        return textField;
    }

    private JPasswordField createPasswordTextField(){
        JPasswordField textField = new JPasswordField();
        setComponentSize(textField,buttonDimension);
        return textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton){
            controller.login(nameTextfield.getText(),passwordTextFiled.getText());
        }
    }

    public void clearInputFields(){
        nameTextfield.setText("");
        passwordTextFiled.setText("");
    }

    public void showError(String title, String message){
        JOptionPane.showMessageDialog(frame,message,title,JOptionPane.ERROR_MESSAGE);
    }
}
