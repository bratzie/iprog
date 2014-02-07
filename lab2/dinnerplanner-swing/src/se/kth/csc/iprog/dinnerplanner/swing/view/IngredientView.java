package se.kth.csc.iprog.dinnerplanner.swing.view;
import se.kth.csc.iprog.dinnerplanner.model.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created by bratzie on 07/02/14.
 */
public class IngredientView extends JPanel {

    private static final long serialVersionUID = 1L;

    DinnerModel model;

    String[] columnNames = {"Name", "Quantity", "Cost"};

    /**
     * Creates a tableview to list ingredients
     *
     * @param tableData Object[][] containing a list<String> of list<String>
     *                  The first list<String> should contain one list<String> per item.
     *                  The second list<String> should contain name, quantity and cost.
     */
    public IngredientView(Object[][] tableData) {
        //this.model = model;

        JTable ingredientTable = new JTable(tableData, columnNames);

        JScrollPane tableContainer = new JScrollPane(ingredientTable);
        ingredientTable.setFillsViewportHeight(true);

        this.add(tableContainer);
    }
}

