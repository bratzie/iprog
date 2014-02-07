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

    public IngredientView() {
        //this.model = model;

        JList<String> listNames = new JList<String>();
        JList<String> listQuantity = new JList<String>();
        JList<String> listCost = new JList<String>();

        JPanel topPanel = new JPanel(new GridLayout(0, 3));
        topPanel.setMinimumSize(new Dimension(600, 600));
        topPanel.setMaximumSize(new Dimension(600, 600));

        JPanel namePanel = new JPanel(new BorderLayout());
        JPanel quantityPanel = new JPanel(new BorderLayout());
        JPanel costPanel = new JPanel(new BorderLayout());

        JLabel nameLabel = new JLabel("Ingredients");
        JLabel quantityLabel = new JLabel("Quantity");
        JLabel costLabel = new JLabel("Cost");

        namePanel.add(nameLabel, BorderLayout.NORTH);
        namePanel.add(listNames, BorderLayout.CENTER);

        quantityPanel.add(quantityLabel, BorderLayout.NORTH);
        quantityPanel.add(listQuantity, BorderLayout.CENTER);

        costPanel.add(costLabel, BorderLayout.NORTH);
        costPanel.add(listCost, BorderLayout.CENTER);

        topPanel.add(namePanel);
        topPanel.add(quantityPanel);
        topPanel.add(costPanel);
    }
}

