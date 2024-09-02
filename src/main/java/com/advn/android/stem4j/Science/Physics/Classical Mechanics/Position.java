package com.advn.android.stem4j.physics;

import android.view.View;

public class Position {
    private double posX, posY;

    public Position(double x, double y) {
        this.posX = x;
        this.posY = y;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosX(double x) {
        this.posX = x;
    }

    public void setPosY(double y) {
        this.posY = y;
    }

    public void movePosX(double deltaX) {
        this.posX += deltaX;
    }

    public void movePosY(double deltaY) {
        this.posY += deltaY;
    }

    public void applyTo(View v) {
        v.setX((float) posX); // Convert double to float
        v.setY((float) posY); // Convert double to float
    }

    public void updatePosition(View v) {
        this.posX = v.getX();
        this.posY = v.getY();
    }

    public void reset(double x, double y) {
        this.posX = 0;
        this.posY = 0;
    }

    public static Position fromView(View v) {
        return new Position(v.getX(), v.getY());
    }

    public void clampToScreenBounds(View v) {
        int viewWidth = v.getWidth();
        int viewHeight = v.getHeight();
        int screenWidth = v.getRootView().getWidth();
        int screenHeight = v.getRootView().getHeight();

        if (posX < 0) posX = 0;
        if (posY < 0) posY = 0;
        if (posX + viewWidth > screenWidth) posX = screenWidth - viewWidth;
        if (posY + viewHeight > screenHeight) posY = screenHeight - viewHeight;
    }

    @Override
    public String toString() {
        return "posX: " + posX + ", posY: " + posY;
    }
}
