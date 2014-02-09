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
    JPanel buttonPanel;

    public OptionsView() {

        // the panels in the view
        setLayout(new BorderLayout());
        guestCostPanel = new JPanel(new GridLayout(2,2)); // top panel with guests and cost
        menuPanel = new JPanel(new BorderLayout()); // showing full menu
        buttonPanel = new JPanel(new GridLayout(1, 2));

        // init guest/cost panel
        JComboBox numOfGuests = new JComboBox();
        JLabel numGuestsTitle = new JLabel("Number of guests:");
        JLabel totCostTitle = new JLabel("Total cost:");
        JTextField costField = new JTextField("100€");
        guestCostPanel.add(numGuestsTitle);
        guestCostPanel.add(numOfGuests);
        guestCostPanel.add(totCostTitle);
        guestCostPanel.add(costField);

        // init menu panel
        JLabel menuTitle = new JLabel("Dinner Menu");
        JScrollPane menuScroll = new JScrollPane(makeTextPanel("Sandwich"));
        menuPanel.add(menuTitle, BorderLayout.NORTH);
        menuPanel.add(menuScroll, BorderLayout.CENTER);
        //menuPanel.setPreferredSize(new Dimension(200, 500));

        //NOTE TO SELF, MAEK TEBUL!

        // init button panel
        //buttonPanel.setMaximumSize(new Dimension(200, 50));
        JButton ingButton = new JButton("Ingredients");
        JButton prepButton = new JButton("Preparation");
        buttonPanel.add(ingButton);
        buttonPanel.add(prepButton);

        // Add label to the view
        add(guestCostPanel, BorderLayout.NORTH);
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
