package com.wayneschools;

import java.awt.*;

public class SandParticle {
    int locationX, locationY, speed, noMove, width;
    Color color;

    public SandParticle(int locationX, int locationY, int speed) {
        this.speed = speed;
        this.locationX = locationX;
        this.locationY = locationY;
        noMove = 0;
        color = new Color(194, 178, 128);
        width = 1;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(locationX, locationY, width, 1);
    }

    public void addRight(int width) {
        this.width += width;
    }

    public int getWidth() {
        return width;
    }

    public void setColor(int r, int g, int b) {
        color = new Color(r, g, b);
    }

    public void addNoMove() {
        noMove++;
    }

    public void resetNoMove() {
        noMove = 0;
    }

    public int getNoMove() {
        return noMove;
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