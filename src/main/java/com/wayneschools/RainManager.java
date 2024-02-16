package com.wayneschools;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class RainManager {
    ArrayList<RainParticle> rain;
    int locationX, locationY;
    Random r = new Random();
    MouseEvent e;

    public RainManager() {
        rain = new ArrayList<RainParticle>();
    }

    public void newParticle(MouseEvent e) {
        rain.add(new RainParticle(e.getX(), e.getY(), 1));
    }

    public void draw(Graphics g) {
        for (int i = 0; i < rain.size(); i++) {
            rain.get(i).draw(g);
        }
    }

    public void move() {
        for (int i = 0; i < rain.size(); i++) {
            rain.get(i).move();
        }
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

}
