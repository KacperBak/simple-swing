package ui.mvc;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: kacper
 * Date: 28.06.12
 * Time: 18:46
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractGuiController extends AbstractBasicController {

    public abstract JPanel getMainPanel();

    public abstract JPanel getContentPanel();

}
