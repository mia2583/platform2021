public class Student {
	private final String name ;
	private int year ;
	private final School theSchool ;
	
	public String toString() {	
		String msg = "[Name: " + name + ", School:" + theSchool 
				+ ", " + year + "ÇÐ³â]";

		return msg ;
	}
	
	public int getYear() {
		return year;
	}

	public String getName() {
		return name;
	}

	public Student(final School theSchool, final String name, final int year) {
		this.theSchool = theSchool;
		this.name = name ;
		this.year = year;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((theSchool == null) ? 0 : theSchool.hashCode());
		result = prime * result + year;
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
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (theSchool == null) {
			if (other.theSchool != null)
				return false;
		} else if (!theSchool.equals(other.theSchool))
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
}
