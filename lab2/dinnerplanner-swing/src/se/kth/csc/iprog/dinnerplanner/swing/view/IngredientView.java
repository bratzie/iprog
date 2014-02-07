package se.kth.csc.iprog.dinnerplanner.swing.view;
import se.kth.csc.iprog.dinnerplanner.model.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Ingredientview. Creates a table with the headers Name, Quantity and Cost.
 *
 * Created by Axl & Bratzie on 07/02/14.
 *
 */
public class IngredientView extends JPanel {

    private static final long serialVersionUID = 1L;

    DinnerModel model;

    String[] columnNames = {"Name", "Quantity", "Cost"};

    /**
     * Creates a tableview to list ingredients
     *
     * @param dish Object[][] containing a list<String> of list<String>
     *                  The first list<String> should contain one list<String> per item.
     *                  The second list<String> should contain name, quantity and cost.
     */
    public IngredientView(Dish dish) {
        //this.model = model;

        Object[][] tableData = ingredientsForTable(dish);

        JTable ingredientTable = new JTable(tableData, columnNames);

        JScrollPane tableContainer = new JScrollPane(ingredientTable);
        ingredientTable.setFillsViewportHeight(true);

        this.add(tableContainer);
    }

    public Object[][] ingredientsForTable (Dish dish) {
        Set<Ingredient> ingredients = dish.getIngredients();
        Object[][] data = new Object[15][3];

        int i = 0;
        for(Ingredient ing : ingredients) {
            data[i] = new Object[] {ing.getName(), String.valueOf(ing.getQuantity())+" "+ing.getUnit(), String.valueOf(ing.getPrice())};
            i++;
        }

        return data;
    }
}

