package se.kth.csc.iprog.dinnerplanner.swing.view;

import javax.swing.*;
import java.awt.*;

/**
 *
 * Created by bratzie on 07/02/14.
 */
public class CourseView extends JPanel {

    /**
     * Constructor for the CourseView class.
     */
    public CourseView() {

        // set the layout of the panel
        setLayout(new BorderLayout());

        // init searchfield
        JTextField searchField = new JTextField("Search here...");

        // init course panel
        JPanel dishPanel = new JPanel(new GridLayout(0, 4));
        JScrollPane dishContainer = new JScrollPane(dishPanel);

        // add the panels to the top panel
        add(searchField, BorderLayout.NORTH);
        add(dishContainer, BorderLayout.CENTER);
    }
}
