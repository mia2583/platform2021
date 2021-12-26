public class InvalidRectangleException extends Exception {
	private final int width, height ;
	public InvalidRectangleException(int width, int height) {
		this.width = width ; this.height = height ;
	}
	
	@Override
	public String toString() {
		return "�簢���� ���̿� ���̴� ����̾�� �մϴ�. "+ width + " " + height;
	}

	public int getWidth() { return width; }
	public int getHeight() { return height; }
}
