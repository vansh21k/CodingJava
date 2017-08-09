package com.vansh.divideandconquer;

public class ClosestPoints {
	
	public static double distance(Point one, Point two) {
		return Math.sqrt((one.getX() - two.getX())^2 + (one.y - two.y)^2);
	}
	
	
}

class Point {
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	int x;
	int y;
}