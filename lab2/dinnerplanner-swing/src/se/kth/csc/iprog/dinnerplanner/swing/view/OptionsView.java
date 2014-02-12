package se.kth.csc.iprog.dinnerplanner.swing.view;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 *
 *
 * Created by bratzie on 07/02/14.
 */
public class OptionsView extends JPanel {

    private static final long serialVersionUID = 1L;

    DinnerModel model;
    JPanel topPanel;
    JPanel menuPanel;
    JPanel buttonPanel;

    public OptionsView(DinnerModel model) {

        this.model = model;

        // the panels in the view
        setLayout(new BorderLayout());

        // init guest/cost panel
        topPanel = new JPanel(new GridLayout(2,2)); // top panel with guests and cost
        ArrayList<Integer> g = new ArrayList<Integer>();
        g.add(1);
        g.add(2);
        JComboBox numOfGuests = new JComboBox(g.toArray());

        JLabel numGuestsTitle = new JLabel("Number of guests:");
        JLabel totCostTitle = new JLabel();
        totCostTitle.setText("Total cost: " + model.getTotalMenuPrice());
        topPanel.add(numGuestsTitle);
        topPanel.add(numOfGuests);
        topPanel.add(totCostTitle);

        // init Dinner menu panel
        menuPanel = new JPanel(new BorderLayout());
        JLabel menuTitle = new JLabel("Dinner Menu");


        Set<Dish> dishes = new HashSet<Dish>(model.getFullMenu());
        JPanel dishPanel = new JPanel();
        dishPanel.setLayout(new BoxLayout(dishPanel, BoxLayout.PAGE_AXIS));

        for (Dish dish:dishes){
            JComponent temp = makeDishPanel(dish); //TODO get images to work
            dishPanel.add(temp);
        }
        JScrollPane menuScroll = new JScrollPane(dishPanel); // TODO add interactivity? Make it scrollable.

        menuPanel.add(menuTitle, BorderLayout.NORTH);
        menuPanel.add(menuScroll, BorderLayout.CENTER);

        //NOTE TO SELF, MAEK TEBUL!

        // init button panel
        buttonPanel = new JPanel(new GridLayout(1, 2));
        JButton ingButton = new JButton("Ingredients");
        JButton prepButton = new JButton("Preparation");
        buttonPanel.add(ingButton);
        buttonPanel.add(prepButton);

        // Add label to the view
        add(topPanel, BorderLayout.NORTH);
        add(menuPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public JComponent makeTextPanel (String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout (new GridLayout(1,1));
        panel.add(filler);
        return panel;
    }

    public JComponent makeDishPanel (Dish dish){
        JPanel panel = new JPanel(false);
        JButton removeButton = new JButton("X");
        ImageIcon icon = createImageIcon("/images/" + dish.getImage(),"");
        int dishType = dish.getType();
        String type;
        if (dishType == 1 ){
            type = "Starter";
        } else if(dishType == 2){
            type = "Main";
        } else {
            type = "Dessert";
        }

        JLabel label = new JLabel(type + " : " + dish.getName(), icon, JLabel.HORIZONTAL);
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
