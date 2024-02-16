package com.wayneschools;

import java.awt.*;
import java.util.ArrayList;

public class BubbleManager {

    ArrayList<BubbleParticle> bubbles;

    public BubbleManager() {
        bubbles = new ArrayList<BubbleParticle>();
    }

    public void draw(Graphics g) {
        for (int i = 0; i < bubbles.size(); i++) {
            bubbles.get(i).draw(g);
        }
    }

    public void addParticle(int locationX, int locationY) {
        bubbles.add(new BubbleParticle(locationX, locationY));
    }

    public void move() {
        for (int i = 0; i < bubbles.size(); i++) {
            bubbles.get(i).move();
        }

        for (int i = 0; i < bubbles.size(); i++) {
            if (bubbles.get(i).getRemoveMe()) {
                bubbles.remove(i);
            }
        }
    }

}