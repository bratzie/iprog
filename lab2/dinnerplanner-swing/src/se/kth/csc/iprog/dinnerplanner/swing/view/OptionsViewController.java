package se.kth.csc.iprog.dinnerplanner.swing.view;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by elvea on 2014-02-18.
 */
public class OptionsViewController implements ActionListener{

    DinnerModel model;
    OptionsView view;
    IngredientView inView;
    PreparationView prView;

    public OptionsViewController(DinnerModel model, OptionsView view, IngredientView inView, PreparationView prView) {

        this.model = model;
        this.view = view;
        this.inView = inView;
        this.prView = prView;

        view.numOfGuests.addActionListener(this);
        view.ingButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == view.numOfGuests) {
            model.setNumberOfGuests(view.numOfGuests.getSelectedIndex());
        }
        else if(e.getSource() == view.ingButton) {
            showPopUp(inView);

        }
        else if(e.getSource() == view.prepButton){
            showPopUpP(prView);
        }

    }

    public void showPopUp(IngredientView view) {

        JFrame frame = new JFrame();
        frame.getContentPane().add(view);
        frame.setVisible(true);

    }

    public void showPopUpP(PreparationView view) {
        JFrame prFrame = new JFrame();
        prFrame.getContentPane().add(view);
        prFrame.setVisible(true);
    }




}
