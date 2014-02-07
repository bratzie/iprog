package se.kth.csc.iprog.dinnerplanner.swing.view;

import javax.swing.*;
import java.awt.*;

/**
 *
 *
 * Created by bratzie on 07/02/14.
 */
public class OptionsView extends JPanel {

    private static final long serialVersionUID = 1L;

    JPanel optionsPanel;
    JPanel guestCostPanel;
    JPanel menuPanel;

    public OptionsView() {

        // options panel
        optionsPanel = new JPanel(new GridLayout(3, 1)); // container
        guestCostPanel = new JPanel(new GridLayout(2,2)); // top panel with guests and cost
        menuPanel = new JPanel(new BorderLayout()); // showing full menu

        // init guest/cost panel
        JComboBox numOfGuests = new JComboBox();
        JLabel numGuestsTitle = new JLabel("Number of guests:");
        JLabel totCostTitle = new JLabel("Total cost:");
        JTextField costField = new JTextField("100€");
        guestCostPanel.add(numGuestsTitle);
        guestCostPanel.add(numOfGuests);
        guestCostPanel.add(totCostTitle);
        guestCostPanel.add(costField);

        /*
        // init menu panel
        JLabel menuTitle = new JLabel("Dinner Menu");
        JScrollPane menuScroll = new JScrollPane();
        menuPanel.add(menuTitle, BorderLayout.NORTH);
        menuPanel.add(menuScroll, BorderLayout.CENTER);
        //menuPanel.setPreferredSize(new Dimension(200, 500));
        */

        makeTextPanel("Dinner Menu");


        // init button panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.setMaximumSize(new Dimension(200, 50));
        JButton ingButton = new JButton("Ingredients");
        JButton prepButton = new JButton("Preparation");
        buttonPanel.add(ingButton);
        buttonPanel.add(prepButton);

        // init options panel
        optionsPanel.add(guestCostPanel);
        optionsPanel.add(menuPanel);
        optionsPanel.add(buttonPanel);
        optionsPanel.setMinimumSize(new Dimension(200, 768));
        optionsPanel.setMaximumSize(new Dimension(200, 768));

        // Add label to the view
        JScrollPane scrollPane = new JScrollPane(optionsPanel);
        this.add(scrollPane);
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
