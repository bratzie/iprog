package se.kth.csc.iprog.dinnerplanner.swing.view;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

/**
 *
 * Created by bratzie on 07/02/14.
 */
public class CourseView extends JPanel implements Observer {

    DinnerModel model;
    int course;
    public JTextField searchField;

    /**
     * Constructor for the CourseView class.
     */
    public CourseView(DinnerModel model, int course) {

        this.model = model;
        this.course = course;
        model.addObserver(this);

        // set the layout of the panel
        setLayout(new BorderLayout());

        // init searchfield
        searchField = new JTextField("");

        // init course panel
        JPanel dishPanel = new JPanel(new GridLayout(0, 4));
        //dishPanel.setLayout(new BoxLayout(dishPanel, BoxLayout.PAGE_AXIS));
        Set<Dish> dishes = new HashSet<Dish>(model.getDishesOfType(course));

        for (Dish dish:dishes) {
            JPanel dishBox = new JPanel();
            dishBox.setLayout(new BoxLayout(dishBox, BoxLayout.Y_AXIS));
            ImageIcon image = createImageIcon("/images/" + dish.getImage(), dish.getDescription());
            JLabel imageLabel = new JLabel(image);
            JLabel label = new JLabel(dish.getName(),JLabel.CENTER);
            dishBox.add(imageLabel);
            dishBox.add(label);

            dishPanel.add(dishBox);
        }
        JScrollPane dishContainer = new JScrollPane(dishPanel);

        // add the panels to the top panel
        add(searchField, BorderLayout.NORTH);
        add(dishContainer, BorderLayout.CENTER);
    }

    public void update(Observable obj, Object arg) {
        System.out.println("Update called");
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }


}
