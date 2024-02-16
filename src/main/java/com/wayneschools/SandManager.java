package com.wayneschools;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class SandManager {
    ArrayList<SandParticle> sand;
    ArrayList<SandParticle> sandPerm;
    int locationX, locationY;
    Random r = new Random();
    MouseEvent e;

    public SandManager() {
        sand = new ArrayList<SandParticle>();
        sandPerm = new ArrayList<SandParticle>();
    }

    public void newParticle(MouseEvent e) {
        sand.add(new SandParticle(e.getX() + r.nextInt(10) - 5, e.getY(), 1));
    }

    public void draw(Graphics g) {
        for (int i = 0; i < sand.size(); i++) {
            sand.get(i).draw(g);
        }
        for (int i = 0; i < sandPerm.size(); i++) {
            sandPerm.get(i).draw(g);
        }
    }

    public void move(int floor) {
        boolean isBellow = false;
        for (int i = 0; i < sand.size(); i++) {
            for (int y = 0; y < sand.size(); y++) {
                if (sand.get(i).getLocationY() + 1 == sand.get(y).getLocationY() && sand.get(i).getLocationX() == sand.get(y).getLocationX()) {
                    isBellow = true;
                    break;
                }
            }
            for (int y = 0; y < sandPerm.size(); y++) {
                for (int z = 0; z < sandPerm.get(y).getWidth(); z++) {
                    if (sand.get(i).getLocationY() + 1 == sandPerm.get(y).getLocationY() && sand.get(i).getLocationX() == sandPerm.get(y).getLocationX() + z) {
                        isBellow = true;
                        break;
                    }
                }
            }
            if (sand.get(i).getLocationY() < floor && !isBellow) {
                sand.get(i).move();
                sand.get(i).resetNoMove();
            } else {
                sand.get(i).addNoMove();
            }

            if (sand.get(i).getNoMove() == 30) {
                sand.get(i).setColor(r.nextInt(255), r.nextInt(255), r.nextInt(255));
                sandPerm.add(sand.get(i));

                sand.remove(i);
            }
            isBellow = false;

        }
    }

    public void consolidate() {
        for (int i = 0; i < sandPerm.size(); i++) {
            for (int y = 0; y < sandPerm.size(); y++) {
                if (y != i) {
                    if (i >= sandPerm.size()) {
                        break;
                    }
                    if ((sandPerm.get(i).getLocationY() == sandPerm.get(y).getLocationY()) && (sandPerm.get(i).getLocationX() + sandPerm.get(i).getWidth() == sandPerm.get(y).getLocationX())) {
                        sandPerm.get(i).addRight(sandPerm.get(y).getWidth());
                        sandPerm.remove(y);
                    }
                }
            }
        }


    }


    public void removeAll() {
        sand.removeAll(sand);
        sandPerm.removeAll(sandPerm);
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

}