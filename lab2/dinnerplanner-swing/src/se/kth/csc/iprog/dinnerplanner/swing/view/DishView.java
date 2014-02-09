package se.kth.csc.iprog.dinnerplanner.swing.view;

import se.kth.csc.iprog.dinnerplanner.model.*;

import javax.swing.*;
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
        topPanel.add(dishName);

        // get preparation for a text field in the bottom left.
        preparationPanel = new JTextArea(dish.getDescription());

        // get ingredient view for the dish
        ingredientPanel = new IngredientView(dish);

        // adjust the splitpane
        botPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, ingredientPanel, preparationPanel);
        botPanel.setDividerLocation(0.5);

        add(topPanel, BorderLayout.NORTH);
        add(botPanel, BorderLayout.CENTER);
    }


    /*
    THIS PROBABLY DOESN'T NEED TO BE HERE...
     */
    /**
     * Grabs ingredients from the Dish object passed as a parameter and
     * returns them as an array of array of strings. This is then used for
     * creating a table in the ingredient view.
     *
     * @param dish the dish you want ingredients of
     * @return a as an array of array of strings
     */
    public Object[][] ingredientsForTable (Dish dish) {
        Set<Ingredient> ingredients = dish.getIngredients();
        Object[][] data = {};

        int i = 0;
        for(Ingredient ing : ingredients) {
            data[i] = new Object[] {ing.getName(), String.valueOf(ing.getQuantity())+" "+ing.getUnit(), String.valueOf(ing.getPrice())};
            i++;
        }

        return data;
    }
}

