package com.lab6;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel sidesLabel,colorLabel,shapeLabel,modeLabel; // we’re drawing regular polygons
    JSpinner sidesField; // number of sides
    JComboBox<String> colorCombo,shapeCombo,modeCombo; // the color of the shape

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //create the label and the spinner
        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(3, 3, 100, 1));
        sidesField.setValue(3); //default number of sides

        //create the colorCombo, containing the values: Random and Black
        colorLabel=new JLabel("Select color:");
        colorCombo = new JComboBox<String>();
        colorCombo.addItem("Black");
        colorCombo.addItem("Random");

        shapeLabel = new JLabel("Select Shape:");
        shapeCombo = new JComboBox<String>();
        shapeCombo.addItem("Polygon");
        shapeCombo.addItem("Circle");
        shapeCombo.addItem("Oval");
        shapeCombo.addItem("Rectangle");

        modeLabel = new JLabel("Mode:");
        modeCombo = new JComboBox<String>();
        modeCombo.addItem("Draw");
        modeCombo.addItem("Delete");
        modeCombo.addItem("Free drawing");

        add(modeLabel);
        add(modeCombo);
        add(shapeLabel);
        add(shapeCombo);
        add(sidesLabel); //JPanel uses FlowLayout by default
        add(sidesField);
        add(colorLabel);
        add(colorCombo);
    }
}