package se.kth.csc.iprog.dinnerplanner.swing.view;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 *
 *
 * Created by bratzie on 07/02/14.
 */
public class OptionsView extends JPanel implements Observer {

    private static final long serialVersionUID = 1L;

    DinnerModel model;
    JPanel topPanel;
    JPanel menuPanel;
    JPanel buttonPanel;
    JComboBox numOfGuests;
    JButton ingButton;
    JButton prepButton;

    public OptionsView(DinnerModel model) {

        this.model = model;
        model.addObserver(this);


        // the panels in the view
        setLayout(new BorderLayout());

        // init guest/cost panel
        topPanel = new JPanel(new GridLayout(2,2)); // top panel with guests and cost
        ArrayList<Integer> g = new ArrayList<Integer>();

        for (int i = 0; i < 25; i++) {
            g.add(i);
        }

        numOfGuests = new JComboBox(g.toArray());

        JLabel numGuestsTitle = new JLabel("Number of guests:");
        JLabel totCostTitle = new JLabel();
        totCostTitle.setText("Total cost:");
        JLabel totCostValue = new JLabel("  " + model.getTotalMenuPrice());
        topPanel.add(numGuestsTitle);
        topPanel.add(numOfGuests);
        topPanel.add(totCostTitle);
        topPanel.add(totCostValue);

        // init Dinner menu panel
        menuPanel = new JPanel(new BorderLayout());
        JLabel menuTitle = new JLabel("Dinner Menu");

        Set<Dish> dishes = new HashSet<Dish>(model.getFullMenu());
        JPanel dishPanel = new JPanel();
        dishPanel.setLayout(new BoxLayout(dishPanel, BoxLayout.PAGE_AXIS));

        for (Dish dish:dishes) {
            JComponent temp = makeDishPanel(dish);
            dishPanel.add(temp);
        }

        JScrollPane menuScroll = new JScrollPane(dishPanel); // TODO add interactivity? Make it scrollable.

        menuPanel.add(menuTitle, BorderLayout.NORTH);
        menuPanel.add(menuScroll, BorderLayout.CENTER);

        //NOTE TO SELF, MAEK TEBUL!

        // init button panel
        buttonPanel = new JPanel(new GridLayout(1, 2));
        ingButton = new JButton("Ingredients");
        prepButton = new JButton("Preparation");
        buttonPanel.add(ingButton);
        buttonPanel.add(prepButton);

        // Add label to the view
        add(topPanel, BorderLayout.NORTH);
        add(menuPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void update(Observable obj, Object arg) {
        System.out.println("Update called");
    }

    protected JComponent makeDishPanel (Dish dish){

        // set layout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        panel.setPreferredSize(new Dimension(400, 100));

        // determine type of dish
        int dishType = dish.getType();
        String type;
        if (dishType == 1 ){
            type = "Starter";
        } else if(dishType == 2){
            type = "Main";
        } else {
            type = "Dessert";
        }

        // get dish-specific data
        ImageIcon image = createImageIcon("/images/" + dish.getImage(), dish.getDescription());
        JLabel imageLabel = new JLabel(image); // insert image into label to display it
        JLabel label = new JLabel(type + ": " + dish.getName(), JLabel.LEFT);
        JButton removeButton = new JButton("X");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //menuPanel.remove(panel);
            }
        });
        removeButton.setAlignmentX(JButton.RIGHT_ALIGNMENT);

        // add components to panel
        panel.add(imageLabel);
        panel.add(label);
        panel.add(removeButton);

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
