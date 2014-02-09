package se.kth.csc.iprog.dinnerplanner.swing.view;

import se.kth.csc.iprog.dinnerplanner.model.*;

import javax.swing.*;
import java.util.*;

/**
 *
 * Created by bratzie on 07/02/14.
 */
public class DishView extends JPanel{

    public DishView() {

    }

    /**
     * Creating
     * @param dish
     * @return
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

