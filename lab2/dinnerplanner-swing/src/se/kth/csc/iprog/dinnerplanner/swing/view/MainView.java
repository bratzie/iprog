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
    JPanel dishPanel;
	
	public MainView(){

        topPanel = new JPanel(new BorderLayout());
        starterPanel = new JPanel(new BorderLayout());
        mainPanel = new JPanel(new BorderLayout());
        dessertPanel = new JPanel(new BorderLayout());
        dishPanel = new JPanel(new GridLayout(0, 4));

        optionsPanel = new JPanel(new GridLayout(4, 1));
        guestCostPanel = new JPanel(new GridLayout(2,2));
        menuPanel = new JPanel(new BorderLayout());

        topPanel.add(tabbedPanel, BorderLayout.CENTER);
        topPanel.add(optionsPanel, BorderLayout.EAST);

        tabbedPanel.setPreferredSize(new Dimension(500, 500));
        tabbedPanel.addTab("Starter", starterPanel);
        tabbedPanel.addTab("Main", mainPanel);
        tabbedPanel.addTab("Dessert", dessertPanel);

        // init manu panel
        JLabel menuTitle = new JLabel("Dinner Menu");
        JScrollPane menuScroll = new JScrollPane();
        menuPanel.add(menuTitle, BorderLayout.NORTH);
        menuPanel.add(menuScroll, BorderLayout.CENTER);
        menuPanel.setPreferredSize(new Dimension(200, 100));

        // init guest/cost panel

        // init options panel
        optionsPanel.add(guestCostPanel);
        JButton ingButton = new JButton("Ingredients");
        JButton prepButton = new JButton("Preparation");
        optionsPanel.add(menuPanel);
        optionsPanel.add(ingButton);
        optionsPanel.add(prepButton);

        // init starter panel


        // searchfield
        JTextField searchField = new JTextField("");
        starterPanel.add(searchField, BorderLayout.NORTH);

        /*
        // dishes
        JScrollPane dishContainer = new JScrollPane();
        ImageIcon icon1 = createImageIcon("/images/toast.jpg", "toast");
        ImageIcon icon2 = createImageIcon("/images/icecream.jpg", "ice cream");
        ImageIcon icon3 = createImageIcon("/images/meatballs.jpg", "meatballs");
        ImageIcon icon4 = createImageIcon("/images/sourdough.jpg", "sourdough");
        JComponent dish1 = new JLabel(icon1);
        JComponent dish2 = new JLabel(icon2);
        JComponent dish3 = new JLabel(icon3);
        JComponent dish4 = new JLabel(icon4);
        dishContainer.add(dish1);
        dishContainer.add(dish2);
        dishContainer.add(dish3);
        dishContainer.add(dish4);
        starterPanel.add(dishContainer, BorderLayout.CENTER);
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
