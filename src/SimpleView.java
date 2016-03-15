import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.xy.DefaultXYDataset;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Created with IntelliJ IDEA.
 * User: kacper
 * Date: 25.07.12
 * Time: 09:01
 * To change this template use File | Settings | File Templates.
 */
public class SimpleView implements ActionListener {

    public SimpleView() {
    }

    public void createView(){
        JFrame frame = new JFrame();

//        DefaultPieDataset dataset = new DefaultPieDataset();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        String rowKey1 = "rowkey1";

        String user1 = "user1";
        String user2 = "user2";


        dataset.addValue(1.0,rowKey1,user1);
        dataset.addValue(5.0,rowKey1,user2);

        JFreeChart chart = ChartFactory.createBarChart(
          "myChart",
                "my_Y_Values",
                "my_X_Values",
                dataset,
                PlotOrientation.HORIZONTAL,
                true,
                false,
                false
        );

//        //1. create data
//        dataset.setValue("user1" , 1);
//        dataset.setValue("user2" , 3);
//        dataset.setValue("user3", 11);
//
//        //2. create chart
//        JFreeChart chart = ChartFactory.createPieChart(
//                "my title",
//                dataset,
//                true,
//                false,
//                false
//        );

        //3. display all together
        ChartPanel chartPanel = new ChartPanel(chart,true);
        chartPanel.setPreferredSize(new Dimension(400,400));


        frame.setLayout(new GridBagLayout());
        JPanel panel = new JPanel();
        panel.add(new JLabel("This is a label"));
        panel.setBorder(new LineBorder(Color.BLACK)); // make it easy to see
        frame.add(panel, new GridBagConstraints());
        frame.add(chartPanel);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("--- test ---");
        }
}
