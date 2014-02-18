package se.kth.csc.iprog.dinnerplanner.swing.view;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by elvea on 2014-02-18.
 */
public class OptionsViewController implements ActionListener{

    DinnerModel model;
    OptionsView view;

    public OptionsViewController(DinnerModel model, OptionsView view) {

        this.model = model;
        this.view = view;

        view.numOfGuests.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == view.numOfGuests) {
            model.setNumberOfGuests(view.numOfGuests.getSelectedIndex());
        }

    }

}
