package edu.pnu.shape;

public class Rectangle {
	private int width, height ;
	
	public String toString() {
		
		String msg = "[ Rectangle " + width + " " + height + " "
			+ String.format( "%.6f", getArea(width, height) ) + "]";
		return msg ;
	}

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	private float getArea(int width, int height) {
		return width*height;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + height;
		result = prime * result + width;
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
		Rectangle other = (Rectangle) obj;
		if (height != other.height)
			return false;
		if (width != other.width)
			return false;
		return true;
	}
}
