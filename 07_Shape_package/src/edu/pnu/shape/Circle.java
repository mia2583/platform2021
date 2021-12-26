package edu.pnu.shape;

public class Circle {
	private Point center ;
	private int radius ;
	
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}
	
	public String toString() {
		
		String msg = "[ Circle " + center + " " + radius + " "
			+ String.format( "%.6f", getArea(radius) ) + "]";
		return msg ;
	}
	
	private double getArea(int radius) {
		return 3.14*radius*radius;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((center == null) ? 0 : center.hashCode());
		result = prime * result + radius;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circle other = (Circle) obj;
		if (center == null) {
			if (other.center != null)
				return false;
		} else if (!center.equals(other.center))
			return false;
		if (radius != other.radius)
			return false;
		return true;
	}
}
