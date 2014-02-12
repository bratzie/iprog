package se.kth.csc.iprog.dinnerplanner.swing;

import javax.swing.*;

import se.kth.csc.iprog.dinnerplanner.model.*;
import se.kth.csc.iprog.dinnerplanner.swing.view.*;

import java.awt.*;

public class DinnerPlanner extends JFrame {

    // specify size for MW (Main Window)
    public static final int MW_WIDTH = 1024;
    public static final int MW_HEIGHT = 768;

    // specify size for SW (Sub Window)
    public static final int SW_WIDTH = 700;
    public static final int SW_HEIGHT = 500;

	private static final long serialVersionUID = 1L;

	public DinnerPlanner() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    // fix model issues
	private static DinnerModel model = new DinnerModel();
	public DinnerModel getModel() {
		return model;
	}
	public void setModel(DinnerModel model) {
		this.model = model;
	}

    // initialize panels
    static JTabbedPane courseSwitcher = new JTabbedPane();
    // static MainView mainView = new MainView(model); //ADDED
    static IngredientView ingredientView = new IngredientView(model.getSelectedDish(2));
    static OptionsView optionsView = new OptionsView(model);
    static DishView dishView = new DishView(model.getSelectedDish(2));

	public static void main(String[] args) {

		// initiating the main JFrame
		DinnerPlanner dinnerPlanner = new DinnerPlanner();
		dinnerPlanner.setTitle("Dinner Planner");

        // initialize the panes
        initTabbedPane(model);

        // set the layout we want for this JFrame
        dinnerPlanner.setLayout(new BorderLayout());
		
		// adding the view to the main JFrame
        /*
        dinnerPlanner.getContentPane().add(dishView, BorderLayout.CENTER);
        */

		dinnerPlanner.getContentPane().add(courseSwitcher, BorderLayout.CENTER);
        dinnerPlanner.getContentPane().add(optionsView, BorderLayout.EAST);

        // make sure it's resizable
        dinnerPlanner.setResizable(true);
        dinnerPlanner.setPreferredSize(new Dimension(MW_WIDTH, MW_HEIGHT));

		// resize it so content fits
		dinnerPlanner.pack();
		
		// and starting the JFrame
		dinnerPlanner.setVisible(true);
    }

    private static void initTabbedPane(DinnerModel model) {
        // different course views
        CourseView starterCourseView = new CourseView(model, 1);
        CourseView mainCourseView = new CourseView(model, 2);
        CourseView dessertCourseView = new CourseView(model, 3);

        // add the course views to different tabs
        courseSwitcher.add(starterCourseView, "Starter");
        courseSwitcher.add(mainCourseView, "Main");
        courseSwitcher.add(dessertCourseView, "Dessert");
    }

}
