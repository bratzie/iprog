package se.kth.csc.iprog.dinnerplanner.swing.view;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * Created by bratzie on 07/02/14.
 */
public class CourseView extends JPanel {

    DinnerModel model;
    int course;

    /**
     * Constructor for the CourseView class.
     */
    public CourseView(DinnerModel model, int course) {

        this.model = model;
        this.course = course;

        // set the layout of the panel
        setLayout(new BorderLayout());

        // init searchfield
        JTextField searchField = new JTextField("Search here...");

        // init course panel
        JPanel dishPanel = new JPanel(new GridLayout(0, 4));
        Set<Dish> dishes = new HashSet<Dish>(model.getDishesOfType(course));

        for (Dish dish:dishes){
         //   JComponent temp = makeTextPanel(dish);
            ImageIcon temp = createImageIcon(dish.getImage(), dish.getDescription()); //TODO get images to work
            JLabel tempLabel = new JLabel(dish.getName(),temp,JLabel.CENTER);
            dishPanel.add(tempLabel);
        }
        JScrollPane dishContainer = new JScrollPane(dishPanel);


        // add the panels to the top panel
        add(searchField, BorderLayout.NORTH);
        add(dishContainer, BorderLayout.CENTER);
    }


    public JComponent makeTextPanel (Dish dish) {
        JPanel panel = new JPanel(false);
        String  text = dish.getName();
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout (new GridLayout(1,1));
        panel.add(filler);
        return panel;
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected ImageIcon createImageIcon(String path,
                                        String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
