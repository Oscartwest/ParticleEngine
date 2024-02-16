package com.wayneschools;

import java.awt.*;
import java.util.Random;

public class FireworkParticle {
    int locationX, locationY, life, speed, centerX, centerY, moves;
    Color color;
    Random r;
    double angle, radius;
    boolean removeMe;

    public FireworkParticle(int life, int speed, Color color, int centerX, int centerY) {
        r = new Random();
        this.locationX = centerX;
        this.locationY = centerY;
        this.life = life;
        this.speed = speed;
        this.color = new Color(color.getRed(), color.getGreen(), color.getBlue(), 255);
        this.centerX = centerX;
        this.centerY = centerY;
        moves = 0;
        radius = 5;
        angle = r.nextDouble() * 6.28;
        removeMe = false;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(locationX, locationY, 5, 5);
    }

    public void move() {

        if (moves < life) {
            locationX = locationX + (int) (radius * Math.cos(angle));
            locationY = locationY + (int) (radius * Math.sin(angle));
            locationY = locationY + 1;
            if (color.getAlpha() <= 0) {
                removeMe = true;
            } else {
                color = new Color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha() - 15);
            }
        } else {
            locationY = locationY + 1;
            if (color.getAlpha() == 1) {
                removeMe = true; //dont uncomment this idk why it makes the firework go boom.
            } else {
                color = new Color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha() - 2);
            }

        }
        moves++;
    }

    public void fade() {
        locationY = locationY + 1;
        if (color.getAlpha() <= 1) {
            removeMe = true;
        } else {
            color = new Color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha() - 1);
        }
    }


    public boolean getRemoveMe() {
        return removeMe;
    }

    public FireworkParticle save() {
        return this;
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public int getLife() {
        return life;
    }

    public int getSpeed() {
        return speed;
    }

    public Color getColor() {
        return color;
    }
}