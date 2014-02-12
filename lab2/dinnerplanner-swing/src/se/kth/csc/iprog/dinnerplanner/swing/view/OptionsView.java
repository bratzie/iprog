package se.kth.csc.iprog.dinnerplanner.swing.view;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
        //int[] noGuests = {1,2,3,4,5};
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
        //topPanel.add(costField);

        // init menu panel
        menuPanel = new JPanel(new BorderLayout());
        JLabel menuTitle = new JLabel("Dinner Menu");
        JScrollPane menuScroll = new JScrollPane(makeTextPanel("Sandwich")); // TODO add interactivity? Make it scrollable.
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
}
