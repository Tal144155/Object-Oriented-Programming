package Backgrounds;

import Interfaces.Sprite;
import RunGame.GameLevel;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Background level 2.
 */
public class BackgroundLevel2 implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.CYAN);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(new java.awt.Color(255, 213, 0));
        for (int i = 0; i < 100; i++) {
            d.drawLine(200, 130, i * 8, 250);
        }
        d.setColor(new java.awt.Color(239, 222, 160));
        d.fillCircle(200, 130, 80);
        d.setColor(new java.awt.Color(246, 195, 153));
        d.fillCircle(200, 130, 60);
        d.setColor(new java.awt.Color(255, 213, 0));
        d.fillCircle(200, 130, 40);
        d.setColor(Color.WHITE);
        d.fillCircle(150, 410, 30);
        d.fillCircle(110, 400, 30);
        d.fillCircle(150, 425, 30);
        d.fillCircle(115, 425, 30);
        d.fillCircle(350, 460, 30);
        d.fillCircle(310, 450, 30);
        d.fillCircle(350, 475, 30);
        d.fillCircle(315, 475, 30);
        d.fillCircle(600, 380, 30);
        d.fillCircle(560, 370, 30);
        d.fillCircle(600, 395, 30);
        d.fillCircle(565, 395, 30);
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel g) {

    }
}
