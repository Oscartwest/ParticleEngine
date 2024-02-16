package com.wayneschools;

import java.awt.*;

public class RainParticle {
    int locationX, locationY, speed;

    public RainParticle(int locationX, int locationY, int speed) {
        this.speed = speed;
        this.locationX = locationX;
        this.locationY = locationY;
    }

    public void draw(Graphics g) {
        g.fillOval(locationX, locationY, 5, 5);
        g.setColor(new Color(133, 210, 255));
    }

    public void move() {
        locationY += speed;
    }

    public void setSpeed(int newSpeed) {
        speed = newSpeed;
    }

    public int getLocationY() {
        return locationY;
    }

    public int getLocationX() {
        return locationX;
    }
}