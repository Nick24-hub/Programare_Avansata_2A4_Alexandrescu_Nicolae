package com.lab6;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    //create all buttons (Load, Reset, Exit)
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        //add all buttons
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);
        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
    }

    private void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    private void reset(ActionEvent actionEvent) {
        frame.remove(frame.canvas);
        frame.canvas=new DrawingPanel(frame);
        frame.add(frame.canvas);
        frame.setVisible(true);
    }

    private void load(ActionEvent actionEvent) {
        try {
            frame.remove(frame.canvas);
            frame.canvas = new DrawingPanel(frame);
            FileInputStream inputstream = new FileInputStream("C:\\images\\image.png");
            frame.canvas.image = ImageIO.read(inputstream);
            frame.add(frame.canvas);
            frame.setVisible(true);
        } catch (IOException e) {
            System.err.println((e));
        }
    }

    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("d:/test.png"));
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
