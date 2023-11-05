package Backgrounds;

import Interfaces.Sprite;
import RunGame.GameLevel;
import biuoop.DrawSurface;


/**
 * The type Background level 1.
 */
public class BackgroundLevel1 implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(java.awt.Color.PINK);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(java.awt.Color.WHITE);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                d.setColor(java.awt.Color.WHITE);
                d.fillCircle(40 + j * 100 + 4, 50 + i * 100, 6);
                d.fillCircle(40 + j * 100 - 4, 50 + i * 100, 6);
                d.fillCircle(40 + j * 100 - 3, 50 + i * 100 - 3, 6);
                d.fillCircle(40 + j * 100 - 3, 50 + i * 100 + 3, 6);
                d.fillCircle(40 + j * 100, 50 + i * 100 + 4, 6);
                d.fillCircle(40 + j * 100, 50 + i * 100 - 4, 6);
                d.fillCircle(40 + j * 100 + 3, 50 + i * 100 - 3, 6);
                d.fillCircle(40 + j * 100 + 3, 50 + i * 100 + 3, 6);
                d.setColor(new java.awt.Color(238, 0, 255));
                d.fillCircle(40 + j * 100, 50 + i * 100, 5);
            }
        }
        d.setColor(java.awt.Color.GREEN);
        d.fillRectangle(380, 240, 40, 800);
        d.setColor(java.awt.Color.WHITE);
        d.fillCircle(400, 220, 50);
        d.fillCircle(400, 170, 30);
        d.fillCircle(350, 220, 30);
        d.fillCircle(400, 270, 30);
        d.fillCircle(450, 220, 30);
        d.fillCircle(364, 184, 30);
        d.fillCircle(364, 252, 30);
        d.fillCircle(435, 252, 30);
        d.fillCircle(435, 184, 30);
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel g) {

    }
}
