package com.wayneschools;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class BubbleParticle {

    int locationX, locationY;
    Random r;
    boolean removeMe;
    Color color;
    boolean isPop;
    int life;
    int ticks, ticks2;
    ArrayList<FireworkParticle> pop;

    public BubbleParticle(int locationX, int locationY) {
        this.locationX = locationX;
        this.locationY = locationY;
        r = new Random();
        color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
        isPop = false;
        life = r.nextInt(100) + 1;
        ticks = 0;
        ticks2 = 0;
        pop = new ArrayList<FireworkParticle>();

    }

    public void draw(Graphics g) {
        if (!isPop) {
            g.setColor(color);
            g.drawOval(locationX, locationY, 30, 30);
            g.setColor(new Color(color.getRed(), color.getBlue(), color.getGreen(), 30));
            g.fillOval(locationX, locationY, 30, 30);
            g.setColor(Color.white);
            g.drawArc(locationX + 5, locationY + 5, 20, 20, 180, -90);
        }
        if (isPop) {
            for (int i = 0; i < pop.size(); i++) {
                if (ticks2 < 500) {
                    pop.get(i).draw(g);
                    pop.get(i).move();
                    ticks2++;
                } else {
                    pop.clear();
                }
            }
        }
    }

    public void move() {
        if (locationY < 0) {
            removeMe = true;
        }

        if (ticks > life) {
            isPop = true;
            for (int i = 0; i < 50; i++) {
                pop.add(new FireworkParticle(20, 20, color, locationX + 15, locationY + 15));
            }
        } else {
            locationY--;
        }
        ticks++;
    }

    public boolean getRemoveMe() {
        return removeMe;
    }

}