package edu.pnu.edit;

import java.util.ArrayList;
import java.util.List;

public class Editor {
	private List<Object> shapes = new ArrayList<>();
	
	public void add(Object ob) {
		shapes.add(ob);
	}
	
	public void clear() {
		shapes.clear();
	}
	
	public void list() {
		System.out.println(shapes);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((shapes == null) ? 0 : shapes.hashCode());
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
		Editor other = (Editor) obj;
		if (shapes == null) {
			if (other.shapes != null)
				return false;
		} else if (!shapes.equals(other.shapes))
			return false;
		return true;
	}
}
