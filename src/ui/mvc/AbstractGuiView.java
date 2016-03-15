package ui.mvc;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: kacper
 * Date: 28.06.12
 * Time: 08:42
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractGuiView extends AbstractBasicView{

    protected void createView(JFrame frame){
        mainPanel = createMainPanel();
        contentPanel = createContentPanel();
        mainPanel.add(contentPanel,new GridBagConstraints());
        this.frame = frame;
    }

    protected abstract JPanel createMainPanel();

    protected abstract JPanel createContentPanel();

}
