package edu.pnu.shape;

public class Triangle extends Shape{
	private int width;
	private int height;
	
	public Triangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public Character getName() {
		return 'T';
	}
	
	public float getArea() {
		return width*height/2;
	}

	@Override
	public String toString() {
		return "Triangle " + width + height + getArea();
	}
	
}
