package com.wayneschools;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FireworkManager {
    ArrayList<FireworkParticle> particles;
    ArrayList<FireworkParticle> particlesSaved;
    Random r = new Random();
    int x, y, z;

    public FireworkManager(int locationX, int locationY) {

        particles = new ArrayList<FireworkParticle>();
        particlesSaved = new ArrayList<FireworkParticle>();
        x = r.nextInt(255);
        y = r.nextInt(255);
        z = r.nextInt(255);
        for (int i = 0; i < 200; i++) {

            particles.add(new FireworkParticle(12, 5, new Color(x, y, z, 255), locationX, locationY));
        }

    }

    public void draw(Graphics g) {
        for (int i = 0; i < particles.size(); i++) {
            particles.get(i).draw(g);
        }
        for (int i = 0; i < particlesSaved.size(); i++) {
            particlesSaved.get(i).draw(g);
        }
    }

    public void move() {
        for (int i = 0; i < particles.size(); i++) {
            particlesSaved.add(new FireworkParticle(particles.get(i).getLife(), particles.get(i).getSpeed(), particles.get(i).getColor(), particles.get(i).getLocationX(), particles.get(i).getLocationY()));
            particles.get(i).move();
            if (particles.get(i).getRemoveMe()) {
                particles.remove(i);
            }
        }
        for (int i = 0; i < particlesSaved.size(); i++) {
            particlesSaved.get(i).fade();
            if (particlesSaved.get(i).getRemoveMe()) {
                particlesSaved.remove(i);
            }
        }
        if (particlesSaved.size() == 4900) {
            //particles.clear();
        }
    }

    public int size() {
        return particles.size();
    }

}