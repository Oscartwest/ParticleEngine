package com.wayneschools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Panel extends JPanel implements ActionListener, MouseListener, MouseMotionListener {

    JRadioButton fireworks = new JRadioButton("Fireworks");
    JRadioButton rain = new JRadioButton("Rain");
    JRadioButton bubbles = new JRadioButton("Bubbles");
    JRadioButton sand = new JRadioButton("Sand");
    ButtonGroup group = new ButtonGroup();
    ArrayList<FireworkManager> f;
    SandManager s;
    RainManager r;
    BubbleManager b;
    Timer t;

    public Panel() {
        group.add(fireworks);
        group.add(rain);
        group.add(bubbles);
        group.add(sand);
        add(fireworks);
        add(rain);
        add(bubbles);
        add(sand);
        t = new Timer(15, this);
        t.start();
        f = new ArrayList<FireworkManager>();
        s = new SandManager();
        r = new RainManager();
        b = new BubbleManager();
        addMouseListener(this);
        addMouseMotionListener(this);
        setBackground(Color.BLACK);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < f.size(); i++) {
            f.get(i).draw(g);
        }
        s.draw(g);
        r.draw(g);
        b.draw(g);
    }

    public void actionPerformed(ActionEvent e) {
        s.move(getHeight());
        r.move();
        b.move();
        for (int i = 0; i < f.size(); i++) {
            f.get(i).move();
            if (f.get(i).size() == 0) {
                f.remove(i);
            }
        }
        repaint();
        if (!sand.isSelected()) {
            s.removeAll();
        }
        if (!fireworks.isSelected()) {
            f.clear();

        }
        if (!rain.isSelected()) {

        }
        s.consolidate();
        repaint();

    }

    public void mouseClicked(MouseEvent e) {
        if (fireworks.isSelected()) {
            f.add(new FireworkManager(e.getX(), e.getY()));

            repaint();
        }
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {
        if (sand.isSelected()) {
            for (int i = 0; i < 10; i++) {
                s.newParticle(e);
                repaint();
            }
        }

        if (bubbles.isSelected()) {
            b.addParticle(e.getX(), e.getY());
            repaint();
        }
    }

    public void mouseReleased(MouseEvent e) {


    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {
        if (rain.isSelected()) {
            for (int i = 0; i < 10; i++) {
                r.newParticle(e);
                repaint();
            }
        }
    }
}