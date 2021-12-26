package interfaces.basic_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum OperationKind {
	ADDC("ADDC"), ADDL("ADDL"), LIST("LIST"), CLEAR("CLEAR"),
	SORTA("SORTA"), SORTD("SORTD"), QUIT("QUIT"), INVALID("INVALID");
	
	@SuppressWarnings("unused")
	private final String value;
	private OperationKind(String value ) {
		this.value = value;
	}	
}
enum SortKind {ASCENDING, DESCENDING} ;

public class ComparableInterfaceTest {

	private static Scanner scanner = new Scanner(System.in);
	private static List<MyComparable> comparableList = new ArrayList<>() ;

	public static void main(String[] args) {
		while ( true ) {
			final OperationKind op = getOperation(scanner) ;
			if ( op == OperationKind.QUIT ) {
				System.out.println("Bye") ;
				break;
			}
			if ( op == OperationKind.INVALID ) {
				System.out.println("Invalid Operation!") ;
				continue ;
			}
			switch ( op ) {
			case ADDL : {
				final Line newLine = createLine(scanner) ;
				comparableList.add(newLine);
				
				System.out.println(newLine) ;
				break ;
			}
			case ADDC : {
				final Circle newCircle = createCircle(scanner) ;
				comparableList.add(newCircle);
				
				System.out.println(newCircle) ;
				break ;
			}
			case SORTA:
				sortList(comparableList, SortKind.ASCENDING) ;
				break ;
			case SORTD:
				sortList(comparableList, SortKind.DESCENDING) ;
				break ;
			case CLEAR:
				comparableList.clear() ;
				break ;
			case LIST: 
				System.out.println(comparableList) ;
				break ;
			default:
				break;
			}
		}
	}
	private static void sortList(final List<MyComparable> comparableList, final SortKind sortKind) {
		for ( int i = 0 ; i < comparableList.size() - 1; i ++ ) {
			for ( int j = i + 1 ; j < comparableList.size() ; j ++ ) {
				final boolean swapNeeded = needToSwap(sortKind, comparableList, i, j);
				
				if ( swapNeeded ) { 
					swap(comparableList, i, j);
					
					// 아래와 같이 element를 전달하면 swap이 안됨
					//swap(comparableList.get(i), comparableList.get(j));
				}
			}
		}		
	}
	private static boolean needToSwap(final SortKind sortKind, final List<MyComparable> comparableList, final int i, final int j) {
		boolean needToSwap = false ;
		if ( sortKind == SortKind.ASCENDING && comparableList.get(i).compareTo(comparableList.get(j)) > 0 )
			needToSwap = true ;
		
		if ( sortKind == SortKind.DESCENDING && comparableList.get(i).compareTo(comparableList.get(j)) < 0 )
			needToSwap = true ;
		
		return needToSwap;
	}
	private static void swap(final List<MyComparable> comparableList, final int i, final int j) {
		final MyComparable temp = comparableList.get(i);
		comparableList.set(i, comparableList.get(j));
		comparableList.set(j, temp);
	}
	
	private static void swap(MyComparable i, MyComparable j) {
		final MyComparable temp = j ;
		j = i ;
		i = temp ;
	}
	private static Circle createCircle(final Scanner scanner) {
		final int x = scanner.nextInt() ;
		final int y = scanner.nextInt() ;		
		final int radius = scanner.nextInt() ;
		
		final Circle newCircle = new Circle(new Point(x, y), radius) ;
		return newCircle ;
	}
	private static Line createLine(final Scanner scanner) {
		final int x1 = scanner.nextInt() ;
		final int y1 = scanner.nextInt() ;
		
		final int x2 = scanner.nextInt() ;
		final int y2 = scanner.nextInt() ;
		
		final Line newLine = new Line(new Point(x1, y1), new Point(x2, y2)) ;
		return newLine ;
	}
	private static OperationKind getOperation(final Scanner scanner) {
		System.out.print("Enter Operation String! ") ;
		final String operation = scanner.next() ;
		
		OperationKind kind;
		try {
			kind = OperationKind.valueOf(operation.toUpperCase());
		}
		catch ( IllegalArgumentException e ) {
			kind = OperationKind.INVALID;
		}
		return kind ;
	}
}
