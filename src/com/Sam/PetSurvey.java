package com.Sam;

import com.sun.codemodel.internal.JOp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by samagbeh on 3/22/17.
 */
public class PetSurvey extends JFrame{
    private JPanel mainPanel;
    private JCheckBox catCheckBox;
    private JCheckBox fishCheckBox;
    private JCheckBox dogCheckBox;
    private JButton submitButton;
    private JLabel surveyResultsLabel;
    private JButton quitButton;

    private boolean cat, dog, fish;

    PetSurvey() {
        setContentPane(mainPanel);
        pack();
        setVisible(true);
        setTitle("Pet Survey Program");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        dogCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println("The dog check box was checked or unchecked.");
                dog = dogCheckBox.isSelected();
                updateResults();

            }
        });
        fishCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println("The fish check box was checked or unchecked.");
                fish = fishCheckBox.isSelected();
                updateResults();

            }
        });
        catCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println("The cat check box was checked or unchecked.");
                cat = catCheckBox.isSelected();
                updateResults();

            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quit = JOptionPane.showConfirmDialog(PetSurvey.this,
                        "Are you sure you want to quit?",
                        "Confirm quit",
                        JOptionPane.OK_CANCEL_OPTION);
                if (quit == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }

            }
        });
    }

    private void updateResults() {

        String hasDog = dog ? "a dog" : "no dogs";
        String hasCat = cat ? "a cat" : "no cats";
        String hasFish = fish ? "a fish" : "no fish";

        String results = "User has " + hasCat +  " and " + hasDog + " and " + hasFish;
        surveyResultsLabel.setText(results);
    }
}
