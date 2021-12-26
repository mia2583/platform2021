package classSchool2;

import java.util.Scanner;

enum Operator { ADD, LIST, FIND, CLEAR, INVALID, QUIT};

public class SchoolTest {
	public static void main(String[] args) {
		School school = new School("PNU");
		final Scanner scanner = new Scanner(System.in);
		while( true ) {
			System.out.print("Enter Command String! ");
			Operator op = getOperator(scanner);
			if(op == Operator.QUIT) { System.out.println("Bye!"); break; }
			if(op == Operator.INVALID) { System.out.println("again!"); continue; }
			switch (op) {
				case ADD : addStudent(scanner, school); break;
				case LIST : showStudent(school); break;
				case FIND : find(scanner, school); break;
				case CLEAR : school.clear(); break;
			}
		}
	}
	
	public static Operator getOperator(Scanner scanner) {
		Operator command = Operator.INVALID;
		try {
			String enterIn = scanner.next();
			command = Operator.valueOf( enterIn.toUpperCase() );
		}
		catch (IllegalArgumentException e) {
			command = Operator.valueOf("INVALID");
		}
		return command;
	}
	
	public static void addStudent(Scanner scanner, School school) {
		final String name = scanner.next();
		final int grade = scanner.nextInt();
		
		final Student newStu = new Student(name, grade);
		school.add(newStu);
		school.countUp();
	}
	
	public static void showStudent(School school) {
		System.out.println(school);
		school.showList();
		System.out.println();
	}
	
	public static void find(Scanner scanner, School school) {
		final String name = scanner.next();
		final int grade = scanner.nextInt();
		school.find(name, grade);
	}
	
}
