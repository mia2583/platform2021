package interfaces.basic_practice;

import java.util.Objects;

public class Circle implements MyComparable {	
	private final Point center ;
	private final int radius ;

	public Circle(final Point center, final int radius) {
		this.center = center ;
		this.radius = radius ;
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
		return Math.round(Math.PI * radius * radius) ;
	}
	@Override
	public String toString() {
		return String.format("[%s %d %d]", center, radius, getSize()) ;
	}

	@Override
	public int hashCode() {
		return Objects.hash(center, radius);
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
		return Objects.equals(center, other.center) && radius == other.radius;
	}
}
