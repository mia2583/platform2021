package interfaces.basic_practice;

import java.util.Objects;

public class Point {
	private final int x, y ;

	public Point(final int x, final int y) {
		this.x = x ; this.y = y ;
	}
	
	@Override
	public String toString() {
		return String.format("[%d, %d]", x, y) ;
	}

	public int getDifferenceX(final Point point) {
		return x - point.x ;
	}

	public int getDifferenceY(final Point point) {
		return y - point.y ;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		return x == other.x && y == other.y;
	}
}
