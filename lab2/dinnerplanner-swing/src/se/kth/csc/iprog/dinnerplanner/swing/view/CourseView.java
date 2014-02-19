package se.kth.csc.iprog.dinnerplanner.swing.view;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    JPanel dishPanel;
    JScrollPane dishContainer;
  //  OptionsView oView;

    /**
     * Constructor for the CourseView class.
     */
    public CourseView(DinnerModel localmodel, int course) {

        this.model = localmodel;
        this.course = course;
        //this.oView = oView;
        localmodel.addObserver(this);

        // set the layout of the panel
        setLayout(new BorderLayout());

        // init searchfield
        searchField = new JTextField("");

        // init course panel
        dishPanel = new JPanel(new GridLayout(0, 4));
        //dishPanel.setLayout(new BoxLayout(dishPanel, BoxLayout.PAGE_AXIS));
        Set<Dish> dishes = new HashSet<Dish>(model.getDishesOfType(course));

        for (final Dish dish:dishes) {
            final JPanel dishBox = new JPanel();
            dishBox.setLayout(new BoxLayout(dishBox, BoxLayout.Y_AXIS));
            ImageIcon image = createImageIcon("/images/" + dish.getImage(), dish.getDescription());
            JLabel imageLabel = new JLabel(image);
            JLabel label = new JLabel(dish.getName(),JLabel.CENTER);
            JButton addButton = new JButton("+");
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.addSelectedDish(dish.getName());
                    //oView.menuPanel.add(dishBox);

                }
            });

            dishBox.add(addButton);
            dishBox.add(imageLabel);
            dishBox.add(label);

            dishPanel.add(dishBox);
        }
        dishContainer = new JScrollPane(dishPanel);

        // add the panels to the top panel
        add(searchField, BorderLayout.NORTH);
        add(dishContainer, BorderLayout.CENTER);
    }

    public void resetDishes() {
        System.out.println("resetting");

        remove(dishContainer);
        dishPanel = new JPanel(new GridLayout(0, 4));

        Set<Dish> dishes = new HashSet<Dish>(model.getDishesOfType(course));

        String searchString = searchField.getText();

        for (final Dish dish:dishes) {
            if(dish.getName().toLowerCase().contains(searchString.toLowerCase())) {
                final JPanel dishBox = new JPanel();
                dishBox.setLayout(new BoxLayout(dishBox, BoxLayout.Y_AXIS));
                ImageIcon image = createImageIcon("/images/" + dish.getImage(), dish.getDescription());
                JLabel imageLabel = new JLabel(image);
                JLabel label = new JLabel(dish.getName(),JLabel.CENTER);
                JButton addButton = new JButton("+");
                addButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        model.addSelectedDish(dish.getName());
                        //oView.menuPanel.add(dishBox);

                    }
                });

                dishBox.add(addButton);
                dishBox.add(imageLabel);
                dishBox.add(label);

                dishPanel.add(dishBox);
            }
        }

        dishContainer = new JScrollPane(dishPanel);
        add(dishContainer, BorderLayout.CENTER);

        this.revalidate();
        this.repaint();
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
