package com.advn.android.stem4j.physics;

public class Position {
	private double posX, posY;
	public Position(double x, double y) {
		posX = x;
		posY = y;
	}
	public double getPosX() {
		return posX;
	}
	public double getPosY() {
		return posY
	}
	public void setPosX(double x) {
		posX = x;
	}
	public void setPosY(double y) {
		posY = y;
	}
	public void changePosX(double x) {
		posX += x;
	}
	public void changePosY(double y) {
		posY += y;
	}
	public double distance(Position other) {
		return Math.sqrt(Math.pow(posX - , 2));
	}
}
