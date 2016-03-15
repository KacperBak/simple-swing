package ui.mvc;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: kacper
 * Date: 15.07.12
 * Time: 10:23
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractBasicView {

    protected JFrame frame;

    protected JPanel mainPanel;

    protected JPanel contentPanel;

    protected Dimension mainPanelDimension = new Dimension(600,500);

    protected Dimension contentPanelDimension = new Dimension(550,450);

    protected Dimension buttonDimension = new Dimension(100,30);

    protected void setComponentSize(Component component, Dimension dimension){
        component.setPreferredSize(dimension);
    }

    protected int subtractDimensionWidth(Dimension d1, Dimension d2){
        return (int)(d1.width - d2.width);
    }

    protected int subtractDimensionHeight(Dimension d1, Dimension d2){
        return (int)(d1.height - d2.height);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

}
