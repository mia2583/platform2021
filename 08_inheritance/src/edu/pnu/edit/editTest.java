package edu.pnu.edit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import edu.pnu.shape.*;

enum operator{ ADD, PRINTALL, PRINT, REMOVEALL, TOTALAREA, INVALID, QUIT };
enum shapeKind { T, R, C };
public class editTest {
	private static List<Shape> shapes = new ArrayList<>();
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		while(true) {
			final operator op = getOperator(scanner);
			if(op == operator.QUIT) {
				System.out.println("Bye!"); break;
			}
			if(op == operator.INVALID) {
				System.out.println("Invalid operation!"); continue;
			}
			switch(op) {
				case ADD : {
					Shape newShape = getShape(scanner);
					System.out.println(newShape) ;
					addShape(newShape);
					break;
				}
				case PRINTALL: printAll(); break;
				case PRINT: print(scanner); break;
				case REMOVEALL: shapes.clear(); break;
				case TOTALAREA: area(); break;
			}
		}
		
		scanner.close();
	}
	
	public static operator getOperator(Scanner scanner) {
		System.out.println("Enter command: ");
		operator command = operator.INVALID;
		
		try {
			final String opIn = scanner.next();
			command = operator.valueOf( opIn.toUpperCase() );
		}
		catch(IllegalArgumentException e) {
			command = operator.valueOf("INVALID");
		}
		return command;
	}
	
	public static Shape getShape(Scanner scanner) {
		final String newShape = scanner.next();
		final shapeKind figure = shapeKind.valueOf( newShape.toUpperCase() );
		switch (figure) {
			case T : {
				int width = scanner.nextInt();
				int height = scanner.nextInt();
				Triangle newTri = new Triangle(width, height); 
				return newTri;
			}
			case R : {
				int width = scanner.nextInt();
				int height = scanner.nextInt();
				Rectangle newRec = new Rectangle(width, height); 
				return newRec;
			}
			case C : {
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				int radian = scanner.nextInt();
				Circle newCir = new Circle( new Point(x, y), radian); 
				return newCir;
			}
		}
		return null;
	}
	public static void addShape(Shape newShape) {
		shapes.add(newShape);
	}
	
	public static void printAll() {
		for(Shape s : shapes) 
			System.out.println(s);
	}
	
	public static void print(Scanner scanner) {
		Shape obj = getShape(scanner);
		for(Shape s :shapes) {
			if( s.getName() == obj.getName() )
				System.out.println(s);
		}
	}
	
	public static void area() {
		float total = 0;
		for(Shape s :shapes)
			total += s.getArea();
		System.out.println(total);
	}
	
	
}
