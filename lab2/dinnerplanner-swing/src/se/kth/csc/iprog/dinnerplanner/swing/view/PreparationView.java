package se.kth.csc.iprog.dinnerplanner.swing.view;

import se.kth.csc.iprog.dinnerplanner.model.*;
import se.kth.csc.iprog.dinnerplanner.swing.DinnerPlanner;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 *
 * Created by bratzie on 07/02/14.
 */
public class PreparationView extends JPanel implements Observer {

    Set<Dish> dishes;
    JPanel topPanel;
    JPanel botPanel;

    public PreparationView (Set<Dish> dishes) {

        this.dishes = dishes;
        setLayout(new BorderLayout());

        // set the title for the top panel
        JLabel title = new JLabel("Dinner menu preparation");
        title.setFont(new Font("Sans Serif", Font.BOLD, 30));
        title.setVerticalAlignment(JLabel.CENTER);
        title.setHorizontalAlignment(JLabel.LEFT);
        topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(DinnerPlanner.SW_WIDTH, (DinnerPlanner.SW_HEIGHT/10)*2));
        topPanel.add(title);

        botPanel = new JPanel(new GridLayout(0, 1));
        botPanel.setPreferredSize(new Dimension(DinnerPlanner.SW_WIDTH / 2, (DinnerPlanner.SW_HEIGHT / 10) * 8));
        botPanel.setMinimumSize(new Dimension(DinnerPlanner.SW_WIDTH / 6, (DinnerPlanner.SW_HEIGHT / 10) * 8));

        for (Dish dish : dishes) {
            botPanel.add(generateDishInfo(dish));
        }

        add(topPanel, BorderLayout.NORTH);
        add(botPanel, BorderLayout.CENTER);
    }

    public JPanel generateDishInfo (Dish dish) {
        JPanel dishInfo = new JPanel();
        dishInfo.setLayout(new BoxLayout(dishInfo, BoxLayout.Y_AXIS));

        JLabel dishTitle = new JLabel(dish.getTypeText() + ": " +  dish.getName());
        dishTitle.setFont(new Font("Sans Serif", Font.BOLD, 20));
        dishTitle.setHorizontalAlignment(JLabel.CENTER);
        dishInfo.add(dishTitle);

        JTextArea dishDesc = new JTextArea(dish.getDescription());
        dishDesc.setLineWrap(true);
        dishDesc.setPreferredSize(dishDesc.getPreferredSize());
        dishInfo.add(dishDesc);

        return dishInfo;
    }

    public void update(Observable obj, Object arg) {
        System.out.println("Update called");
    }
}
