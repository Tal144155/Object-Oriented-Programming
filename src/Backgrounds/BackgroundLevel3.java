package Backgrounds;

import Interfaces.Sprite;
import RunGame.GameLevel;
import biuoop.DrawSurface;

import java.awt.Polygon;
import java.awt.Color;

/**
 * The type Background level 3.
 */
public class BackgroundLevel3 implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new java.awt.Color(119, 231, 121));
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.RED);
        d.fillCircle(125, 250, 25);
        d.setColor(Color.WHITE);
        d.fillPolygon(new Polygon(new int[]{100, 150, 175, 75}, new int[]{300, 300, 600, 600}, 4));
        d.setColor(Color.GRAY);
        d.fillRectangle(100, 250, 50, 50);
        d.setColor(new java.awt.Color(255, 204, 0));
        d.fillPolygon(new Polygon(new int[]{125, 125, 800, 800}, new int[]{275, 275, 400, 150}, 4));
        d.setColor(Color.BLACK);
        d.fillRectangle(120, 275, 10, 25);
        d.fillCircle(125, 275, 5);
        d.setColor(Color.RED);
        d.fillPolygon(new Polygon(new int[]{155, 158, 88, 93}, new int[]{350, 400, 430, 380}, 4));
        d.fillPolygon(new Polygon(new int[]{164, 168, 79, 83}, new int[]{470, 520, 550, 500}, 4));
        d.setColor(Color.WHITE);
        d.fillCircle(150, 110, 30);
        d.fillCircle(110, 100, 30);
        d.fillCircle(150, 125, 30);
        d.fillCircle(115, 125, 30);
        d.fillCircle(350, 140, 30);
        d.fillCircle(310, 130, 30);
        d.fillCircle(350, 155, 30);
        d.fillCircle(315, 155, 30);
        d.fillCircle(600, 90, 30);
        d.fillCircle(560, 80, 30);
        d.fillCircle(600, 105, 30);
        d.fillCircle(565, 105, 30);
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel g) {

    }
}
