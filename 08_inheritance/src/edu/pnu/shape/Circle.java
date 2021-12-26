package edu.pnu.shape;

public class Circle extends Shape{
	private Point center;
	private int radian;
	
	public Circle(Point center, int radian) {
		this.center = center;
		this.radian = radian;
	}
	
	public float getArea() {
		return (float) (3.141592*radian*radian);
	}
	
	public Character getName() {
		return 'T';
	}

	@Override
	public String toString() {
		return "Circle " + center + getArea() ;
	}
	
}
