package se.kth.csc.iprog.dinnerplanner.swing.view;

import com.sun.codemodel.internal.*;
import se.kth.csc.iprog.dinnerplanner.model.*;
import se.kth.csc.iprog.dinnerplanner.swing.DinnerPlanner;

import javax.swing.*;
import javax.swing.JLabel;
import java.awt.*;
import java.util.*;

/**
 *
 * Created by bratzie on 07/02/14.
 */
public class DishView extends JPanel {

    Dish dish;

    JPanel topPanel;
    JSplitPane botPanel; // container for prep and ingredient panels
    JTextArea preparationPanel;
    IngredientView ingredientPanel;

    /**
     * Constructor for the DishView class. Uses the dish to get dish information.
     */
    public DishView(Dish dish) {

        // save the dish
        this.dish = dish;

        // set the layout we want
        setLayout(new BorderLayout());

        // get the dish name for the top panel
        JLabel dishName = new JLabel(dish.getName());
        dishName.setFont(new Font("Sans Serif", Font.BOLD, 30));
        dishName.setVerticalAlignment(JLabel.CENTER);
        topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(DinnerPlanner.SW_WIDTH, (DinnerPlanner.SW_HEIGHT/10)*2));
        topPanel.add(dishName);

        // get preparation for a text field in the bottom left.
        preparationPanel = new JTextArea(dish.getDescription());
        preparationPanel.setLineWrap(true);
        preparationPanel.setWrapStyleWord(true);
        preparationPanel.setPreferredSize(new Dimension(DinnerPlanner.SW_WIDTH/2, (DinnerPlanner.SW_HEIGHT/10)*8));
        preparationPanel.setMinimumSize(new Dimension(DinnerPlanner.SW_WIDTH / 6, (DinnerPlanner.SW_HEIGHT / 10) * 8));

        // get ingredient view for the dish
        ingredientPanel = new IngredientView(dish);
        ingredientPanel.setPreferredSize(new Dimension(DinnerPlanner.SW_WIDTH/2, (DinnerPlanner.SW_HEIGHT/10)*8));
        ingredientPanel.setMinimumSize(new Dimension(DinnerPlanner.SW_WIDTH/6, (DinnerPlanner.SW_HEIGHT/10)*8));

        // adjust the splitpane
        botPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, preparationPanel, ingredientPanel);

        botPanel.setDividerLocation((DinnerPlanner.SW_WIDTH/6)*2);

        add(topPanel, BorderLayout.NORTH);
        add(botPanel, BorderLayout.CENTER);
    }
}

