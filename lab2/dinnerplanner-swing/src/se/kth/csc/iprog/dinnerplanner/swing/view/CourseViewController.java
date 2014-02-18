package se.kth.csc.iprog.dinnerplanner.swing.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import se.kth.csc.iprog.dinnerplanner.model.*;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Created by limbero on 18/02/14.
 */

public class CourseViewController implements DocumentListener {
    DinnerModel model;
    CourseView view;

    public CourseViewController (DinnerModel model, CourseView view) {
        this.model = model;
        this.view = view;

        view.searchField.getDocument().addDocumentListener(this);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        System.out.println("input added");
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        System.out.println("input removed");
    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}
