package se.kth.csc.iprog.dinnerplanner.swing.view;

import javax.swing.*;
import java.awt.*;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;


public class MainView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	// The components of our view
	JButton plusButton = new JButton();
	JButton minusButton = new JButton();
    JTabbedPane tabbedPane = new JTabbedPane();
	
	public MainView(){

        //JComponent panelStarter = makeTextPanel("Panel #1");
        JComponent panelStarter = new JPanel();
        JTextField jtext = new JTextField("Supposed to be Search field");
        panelStarter.add(jtext);

        JPanel dishContainer = new JPanel(new GridLayout(4,2));
        ImageIcon icon = createImageIcon("/images/bakedbrie.jpg", "baked brie");
        JComponent dish = new JLabel(icon);
        dishContainer.add(dish);
        panelStarter.add(dishContainer);

        JComponent panelMain = makeTextPanel("Panel #2");
        JComponent panelDessert = makeTextPanel("Panel #3");
        tabbedPane.addTab("Starter", panelStarter);
        tabbedPane.addTab("Main", panelMain);
        tabbedPane.addTab("Dessert", panelDessert);
		
		// Add label to the view
        this.add(tabbedPane);
		
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
