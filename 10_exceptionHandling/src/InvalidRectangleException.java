public class InvalidRectangleException extends Exception {
	private final int width, height ;
	public InvalidRectangleException(int width, int height) {
		this.width = width ; this.height = height ;
	}
	
	@Override
	public String toString() {
		return "사각형의 넓이와 높이는 양수이어야 합니다. "+ width + " " + height;
	}

	public int getWidth() { return width; }
	public int getHeight() { return height; }
}
