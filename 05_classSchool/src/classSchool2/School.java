package classSchool2;

import java.util.ArrayList;
import java.util.List;

public class School {
	private String name;
	private int count;
	private List<Student> schools = new ArrayList<>();
	
	public School(String name) {
		this.name = name;
		this.count = 0;
	}
	
	public void add(Student stu) {
		schools.add(stu);
	}
	
	public void countUp() {
		count++;	
	}
	
	@Override
	public String toString() {
		return "School Name: " + name + ", Student Count: " + count;
	}

	public void showList() {
		for(Student s: schools)
			System.out.println(s);
	}
	
	public boolean sameStu(Student s, String name, int grade) {
		final Student newStu = new Student(name, grade);
		return s.equals(newStu);
	}
	
	public void find(String name, int grade) {
		for(Student s: schools)
			if( sameStu(s, name, grade) ) {
				System.out.println(s); return;
			}
		System.out.println("Student Not Fount with name " + name + " and year" + grade);
	}
	
	public void clear() {
		count = 0;
		schools.clear();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		School other = (School) obj;
		if (count != other.count)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (schools == null) {
			if (other.schools != null)
				return false;
		} else if (!schools.equals(other.schools))
			return false;
		return true;
	}
	
	
}
