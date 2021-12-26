public class Rectangle {
	private int width;
	private int height;
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public void setRatio(int ratio) {
		this.width *= ratio;
		this.height *= ratio;
	}

	@Override
	public String toString() {
		return "Rectangle: width " + width + ", height " + height;
	}
	
	
}
