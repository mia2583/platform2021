package edu.pnu.shape;

public class Rectangle extends Shape{
	private int width;
	private int height;
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public Character getName() {
		return 'T';
	}
	
	public float getArea() {
		return width*height;
	}

	
	@Override
	public String toString() {
		return "Rectangle " + width + height + getArea();
	}
	
	
}
