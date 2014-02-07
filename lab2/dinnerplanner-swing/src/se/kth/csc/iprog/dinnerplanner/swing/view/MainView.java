package se.kth.csc.iprog.dinnerplanner.swing.view;

import javax.swing.*;
import java.awt.*;

public class MainView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	// The components of our view
	JButton plusButton = new JButton();
	JButton minusButton = new JButton();

    JPanel topPanel;
    JPanel optionsPanel;
    JPanel starterPanel;
    JPanel mainPanel;
    JPanel dessertPanel;
    JPanel guestCostPanel;
    JPanel menuPanel;
    JTabbedPane tabbedPanel = new JTabbedPane();
	
	public MainView(){

        topPanel = new JPanel(new BorderLayout());
        topPanel.setPreferredSize(new Dimension(1024, 768));

        starterPanel = new JPanel(new BorderLayout());
        mainPanel = new JPanel(new BorderLayout());
        dessertPanel = new JPanel(new BorderLayout());

        optionsPanel = new JPanel(new GridLayout(3, 1));
        guestCostPanel = new JPanel(new GridLayout(2,2));
        menuPanel = new JPanel(new BorderLayout());

        optionsPanel.setMinimumSize(new Dimension(200, 768));
        optionsPanel.setMaximumSize(new Dimension(200, 768));

        topPanel.add(tabbedPanel, BorderLayout.CENTER);
        topPanel.add(optionsPanel, BorderLayout.EAST);

        tabbedPanel.addTab("Starter", starterPanel);
        tabbedPanel.addTab("Main", mainPanel);
        tabbedPanel.addTab("Dessert", dessertPanel);

        // init menu panel
        JLabel menuTitle = new JLabel("Dinner Menu");
        JScrollPane menuScroll = new JScrollPane();
        menuPanel.add(menuTitle, BorderLayout.NORTH);
        menuPanel.add(menuScroll, BorderLayout.CENTER);
        menuPanel.setPreferredSize(new Dimension(200, 500));

        // init guest/cost panel
        JComboBox numOfGuests = new JComboBox();
        JLabel numGuestsTitle = new JLabel("Number of guests:");
        JLabel totCostTitle = new JLabel("Total cost:");
        guestCostPanel.add(numGuestsTitle);
        guestCostPanel.add(numOfGuests);
        guestCostPanel.add(totCostTitle);



        // init options panel
        optionsPanel.add(guestCostPanel);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        JButton ingButton = new JButton("Ingredients");
        JButton prepButton = new JButton("Preparation");
        buttonPanel.add(ingButton);
        buttonPanel.add(prepButton);
        buttonPanel.setPreferredSize(new Dimension(200, 50));

        optionsPanel.add(menuPanel);
        optionsPanel.add(buttonPanel);

        // search field
        JTextField searchField1 = new JTextField("");
        JTextField searchField2 = new JTextField("");
        JTextField searchField3 = new JTextField("");

        // init starter panel

        JPanel dishPanelStart = new JPanel(new GridLayout(0, 4));
        JScrollPane dishContainerStart = new JScrollPane();
        dishContainerStart.add(dishPanelStart);

        starterPanel.add(searchField1, BorderLayout.NORTH);
        starterPanel.add(dishContainerStart, BorderLayout.CENTER);

        // init main panel
        mainPanel.add(searchField2, BorderLayout.NORTH);
        mainPanel.add(dishContainerStart, BorderLayout.CENTER);

        // init dessert panel
        dessertPanel.add(searchField3, BorderLayout.NORTH);
        dessertPanel.add(dishContainerStart, BorderLayout.CENTER);

        /*
        // dishes
        ImageIcon icon1 = createImageIcon("/images/toast.jpg", "toast");
        ImageIcon icon2 = createImageIcon("/images/icecream.jpg", "ice cream");
        ImageIcon icon3 = createImageIcon("/images/meatballs.jpg", "meatballs");
        ImageIcon icon4 = createImageIcon("/images/sourdough.jpg", "sourdough");
        JComponent dish1 = new JLabel(icon1);
        JComponent dish2 = new JLabel(icon2);
        JComponent dish3 = new JLabel(icon3);
        JComponent dish4 = new JLabel(icon4);
        dishContainerStart.add(dish1);
        dishContainerStart.add(dish2);
        dishContainerStart.add(dish3);
        dishContainerStart.add(dish4);
        starterPanel.add(dishContainerStart, BorderLayout.CENTER);
        */

		// Add label to the view
        this.add(topPanel);
		
		// Setup the rest of the view layout
	}

    public JComponent makeTextPanel (String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout (new GridLayout(1,1));
        panel.add(filler);
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
