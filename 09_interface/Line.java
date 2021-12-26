package interfaces.basic_practice;

import java.util.Objects;

public class Line implements MyComparable {
	private final Point point1, point2 ;

	public Line(final Point point1, final Point point2) {
		this.point1 = point1 ; this.point2 = point2 ;
	}

	@Override
	public int compareTo(final MyComparable other) {
		final long thisSize = getSize() ;
		final long otherSize = other.getSize() ;
		
		if ( thisSize > otherSize ) return 1 ;
		if ( thisSize == otherSize ) return 0 ;
		return -1 ;
	}

	@Override
	public long getSize() {
		final int differenceX = point1.getDifferenceX(point2) ;
		final int differenceY = point1.getDifferenceY(point2) ;
		
		return Math.round(Math.sqrt(differenceX*differenceX + differenceY*differenceY)) ;
	}

	@Override
	public String toString() {
		return String.format("[%s %s %d]", point1, point2, getSize()) ;
	}

	@Override
	public int hashCode() {
		return Objects.hash(point1, point2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Line other = (Line) obj;
		return Objects.equals(point1, other.point1) && Objects.equals(point2, other.point2);
	}

}
