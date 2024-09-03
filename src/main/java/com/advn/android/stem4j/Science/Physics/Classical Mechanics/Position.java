package com.advn.android.stem4j;

import android.view.*;

public class Position {
    private double posX;
    private double posY;
    public Position(double x, double y) {
        this.posX = x;
        this.posY = y;
    }
    public void setPosX(double x) {
        this.posX = x;
    }
    public void setPosY(double y) {
        this.posY = y;
    }
    public void setCoords(double x, double y) {
        this.posX = x;
        this.posY = y;
    }
    public double getPosX() {
        return posX;
    }
    public double getPosY() {
        return posY;
    }
    public void movePosX(double x) {
        this.posX += x;
    }
    public void movePosY(double y) {
        this.posY += y;
    }
    public void adjustCoords(double x, double y) {
        this.posX += x;
        this.posY += y;
    }
    public void inversePosX() {
        this.posX = this.posX * -1;
    }
    public void inversePosY() {
        this.posY = this.posY * -1;
    }
    public void addPosX(Position other) {
        this.posX += other.getPosX();
    }
    public void addPosY(Position other) {
        this.posY += other.getPosY();
    }
    public void resetPosX() {
        this.posX = 0;
    }
    public void resetPosY() {
        this.posY = 0;
    }
    public void resetCoords() {
        this.posX = 0;
        this.posY = 0;
    }
    public void normalize(double minX, double maxX, double minY, double maxY) {
        if ((maxX - minX) != 0 && (maxY - minY) != 0) {
            this.posX = (this.posX - minX) / (maxX - minX);
            this.posY = (this.posY - minY) / (maxY - minY);
        }
    }
    public void rotate(double angleDegrees) {
     double radians = Math.toRadians(angleDegrees);
        double newX = this.posX * Math.cos(radians) - this.posY * Math.sin(radians);
        double newY = this.posX * Math.sin(radians) + this.posY * Math.cos(radians);
        this.posX = newX;
        this.posY = newY;
        }
    public Position copy() {
        return new Position(this.posX, this.posY);
    }
    public boolean isWithinBounds(double minX, double maxX, double minY, double maxY) {
        return this.posX >= minX && this.posX <= maxX && this.posY >= minY && this.posY <= maxY;
    }
    public Position fromView(View v) {
        return new Position(v.getX(), v.getY());
    }
    public void applyTo(View v) {
        v.setX((float) this.posX);
        v.setY((float) this.posY);
    }
    
    @Override
    public String toString() {
        return "Position{" +
               "x=" + posX +
               ", y=" + posY +
               "};";
    }
}
