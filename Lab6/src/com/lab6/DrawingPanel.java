package com.lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final static int W = 1200, H = 800;
    final MainFrame frame;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the "tools" needed to draw in the image
    List<Shape> shapeList = new ArrayList<>();
    List<Color> colorList = new ArrayList<>();
    int x1, y1, x2, y2;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    public DrawingPanel(MainFrame frame, BufferedImage image) {
        this.frame = frame;
        this.image = image;
        graphics = image.createGraphics();
        init();
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(0, 0, W, H);
    }

    private void init() {
        setPreferredSize(new Dimension(W, H)); //don’t use setSize. Why?
        setBorder(BorderFactory.createEtchedBorder()); //for fun
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (frame.configPanel.modeCombo.getSelectedItem() == "Draw") {
                    drawShape(e.getX(), e.getY());
                } else if (frame.configPanel.modeCombo.getSelectedItem() == "Delete") {
                    deleteShape(e.getX(), e.getY());
                    for (int i = 0; i < shapeList.size(); ++i) {
                        graphics.setColor(colorList.get(i));
                        graphics.fill(shapeList.get(i));
                    }
                } else if (frame.configPanel.modeCombo.getSelectedItem() == "Free drawing") {
                    x1 = e.getX();
                    y1 = e.getY();
                    String color = (String) frame.configPanel.colorCombo.getSelectedItem();
                    if (Objects.equals(color, "Black")) {
                        Color col = new Color(0, 0, 0);
                        graphics.setColor(col);
                    } else if (Objects.equals(color, "Random")) {
                        Random rand = new Random();
                        Color col = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
                        graphics.setColor(col);
                    }
                }
                repaint();
            } //Can’t use lambdas, JavaFX does a better job in these cases
        });

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (frame.configPanel.modeCombo.getSelectedItem() == "Free drawing") {
                    x2 = e.getX();
                    y2 = e.getY();

                    graphics.drawLine(x1, y1, x2, y2);
                    repaint();
                    x1 = x2;
                    y1 = y2;

                }
            }
        });
    }

    private void deleteShape(int x, int y) {
        for (int i = shapeList.size() - 1; i >= 0; --i) {
            if (shapeList.get(i).contains(x, y)) {
                shapeList.remove(i);
                colorList.remove(i);
                Graphics2D background = image.createGraphics();
                background.setColor(Color.WHITE);
                background.fillRect(0, 0, W, H);
                graphics = background;
                break;
            }
        }
    }

    private void drawShape(int x, int y) {
        Random random = new Random();
        int radius = random.nextInt(50) + 10;
        int sides = (int) frame.configPanel.sidesField.getValue();
        String color = (String) frame.configPanel.colorCombo.getSelectedItem();
        Color col;
        if (Objects.equals(color, "Black")) {
            col = new Color(0, 0, 0);
        } else {
            col = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        }
        graphics.setColor(col);
        colorList.add(col);
        String shape = (String) frame.configPanel.shapeCombo.getSelectedItem();
        switch (Objects.requireNonNull(shape)) {
            case "Polygon" -> {
                RegularPolygon polygon = new RegularPolygon(x, y, radius, sides);
                graphics.fill(polygon);
                shapeList.add(polygon);
            }
            case "Circle" -> {
                NodeShape circle = new NodeShape(x, y, radius);
                graphics.fill(circle);
                shapeList.add(circle);
            }
            case "Rectangle" -> {
                Rectangle rectangle = new Rectangle(x, y, radius, random.nextInt(50) + 10);
                graphics.fill(rectangle);
                shapeList.add(rectangle);
            }
            case "Oval" -> {
                Ellipse2D oval;
                int rand = random.nextInt(2);
                if (rand == 0) {
                    oval = new Ellipse2D.Double(x, y, radius, radius / 2d);
                    graphics.fill(new Ellipse2D.Double(x, y, radius, radius / 2d));
                } else {
                    oval = new Ellipse2D.Double(x, y, radius / 2d, radius);
                    graphics.fill(new Ellipse2D.Double(x, y, radius / 2d, radius));
                }
                shapeList.add(oval);
            }
        }
    }

    @Override
    public void update(Graphics g) {
    } //Why did I do that?

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}
