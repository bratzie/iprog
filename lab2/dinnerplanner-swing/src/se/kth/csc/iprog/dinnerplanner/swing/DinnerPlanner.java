package se.kth.csc.iprog.dinnerplanner.swing;

import javax.swing.*;

import se.kth.csc.iprog.dinnerplanner.model.*;
import se.kth.csc.iprog.dinnerplanner.swing.view.*;

import java.awt.*;

public class DinnerPlanner extends JFrame {

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
    static MainView mainView = new MainView();
    static IngredientView ingredientView = new IngredientView(model.getSelectedDish(2));
    static OptionsView optionsView = new OptionsView();

	public static void main(String[] args) {
		//Initiating the main JFrame
		DinnerPlanner dinnerPlanner = new DinnerPlanner();
		dinnerPlanner.setTitle("Dinner Planner");

        // initialize the tabbed pane
        initTabbedPane();

        dinnerPlanner.setLayout(new BorderLayout());
		
		//Adding the view to the main JFrame
		dinnerPlanner.getContentPane().add(courseSwitcher, BorderLayout.CENTER);
        dinnerPlanner.getContentPane().add(optionsView, BorderLayout.EAST);

        // make sure it's not resizable
        dinnerPlanner.setResizable(true);
        dinnerPlanner.setPreferredSize(new Dimension(1024, 768));

		//Resize it so content fits
		dinnerPlanner.pack();
		
		//and starting the JFrame
		dinnerPlanner.setVisible(true);
    }

    private static void initTabbedPane() {
        // different course views
        CourseView starterCourseView = new CourseView();
        CourseView mainCourseView = new CourseView();
        CourseView dessertCourseView = new CourseView();

        // add the course views to different tabs
        courseSwitcher.add(starterCourseView, "Starter");
        courseSwitcher.add(mainCourseView, "Main");
        courseSwitcher.add(dessertCourseView, "Dessert");
    }

}
