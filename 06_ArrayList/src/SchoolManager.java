import java.util.ArrayList;
import java.util.List;

public class SchoolManager {
	private List<School> schools = new ArrayList<>() ;
	
	
	public String toString() {	
		String msg = "Total School count: " + schools.size();
		for(final School school : schools) {
			msg += "\nSchool Name: " + school 
					+ " Student Count: " + school.getstudents().size() + "\n";
			for(final Student student : school.getstudents()) msg += student + "\n";
		}
		return msg;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((schools == null) ? 0 : schools.hashCode());
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
		SchoolManager other = (SchoolManager) obj;
		if (schools == null) {
			if (other.schools != null)
				return false;
		} else if (!schools.equals(other.schools))
			return false;
		return true;
	}

	public void removeAllSchools() {
		schools.clear();
	}

	public School findSchool(String schoolName) {
		for(final School school: schools) {
			if( school.getName().equals(schoolName) ) return school;
		}
		return null;

	}
	
	public List<Student> findStudent(String studentName, int schoolYear) {
		List<Student> studentsFound = new ArrayList<>();
		for(final School school : schools) {
			for(final Student student: school.getstudents()) {
				if( student.getName().equals(studentName) && student.getYear()==(schoolYear)) 
					studentsFound.add(student);
			}
		}
		return studentsFound;
	}
	
	public School createSchool(String schoolName) {
		School newSchool = new School(schoolName);
		schools.add(newSchool);
		return newSchool;
	}
}
