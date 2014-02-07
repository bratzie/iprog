package se.kth.csc.iprog.dinnerplanner.swing;

import javax.swing.JFrame;

import se.kth.csc.iprog.dinnerplanner.model.*;
import se.kth.csc.iprog.dinnerplanner.swing.view.*;

import java.awt.*;

public class DinnerPlanner extends JFrame {

    // testing stuff
    static Object[][] tempData = {
            {"Potato", "5st", "102kr"},
            {"Sauce", "2st", "1122kr"},
            {"Pineapple", "1st", "12302kr"},
            {"Axel", "10st", "80085kr"},
            {"Potato", "5102st", "2kr"}
    };

	private static final long serialVersionUID = 1L;

	public DinnerPlanner() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
	
	private DinnerModel model = new DinnerModel();

	public DinnerModel getModel() {
		return model;
	}

	public void setModel(DinnerModel model) {
		this.model = model;
	}

    /**
     * Main method, adding comment to test git. Now I'm testing again.
     *
     * @param args
     */
	public static void main(String[] args) {
		//Initiating the main JFrame
		DinnerPlanner dinnerPlanner = new DinnerPlanner();
		dinnerPlanner.setTitle("Dinner Planner");
		
		//Creating the first view
		MainView mainView = new MainView();
        IngredientView ingredientView = new IngredientView(tempData);
		
		//Adding the view to the main JFrame
		dinnerPlanner.getContentPane().add(ingredientView);
		
		//Resize it so content fits
		dinnerPlanner.pack();

        // make sure it's not resizable
        dinnerPlanner.setPreferredSize(new Dimension(400, 300));
        dinnerPlanner.setResizable(false);
		
		//and starting the JFrame
		dinnerPlanner.setVisible(true);

	}

}
