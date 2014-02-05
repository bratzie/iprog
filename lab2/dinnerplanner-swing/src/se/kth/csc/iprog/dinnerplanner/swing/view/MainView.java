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

        JComponent panelStarter = makeTextPanel("Panel #1");
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
	
}
