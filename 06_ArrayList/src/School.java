import java.util.ArrayList;
import java.util.List;

public class School {
	private final String name ;
	private List<Student> students = new ArrayList<>() ;

	public School(final String name) { this.name = name ; }

	public String getName() {
		return name;
	}
	
	public List<Student> getstudents() {
		return students;
	}
	
	public String toString() {	
		return name;
	}
	
	
	public void addStudent(Student newStudent) {
		students.add(newStudent);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((students == null) ? 0 : students.hashCode());
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
		School other = (School) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (students == null) {
			if (other.students != null)
				return false;
		} else if (!students.equals(other.students))
			return false;
		return true;
	}
}
