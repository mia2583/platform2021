import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RectangleManager {
	private List<Rectangle> rectangles = new ArrayList<>() ;
	private Scanner scannerObject ;
	
	public RectangleManager(Scanner ScannerObject) {
		this.scannerObject = ScannerObject;
	}

	public static void main(String[] args) {
		Scanner scannerObject = new Scanner(System.in) ;
		RectangleManager manager = new RectangleManager(scannerObject) ;
		while ( true ) {
			System.out.println("Enter a command: [create width height, zoom id ratio or quit]") ;
			final String command = scannerObject.next() ;
				if ( command.equalsIgnoreCase("create")) { manager.create() ; }
				else if ( command.equalsIgnoreCase("zoom")) { manager.zoom() ; }
				else if ( command.equalsIgnoreCase("showAll")) { manager.showAll() ; }
				else if ( command.equalsIgnoreCase("quit")) { System.out.println("Bye") ; break ; }
		}
		scannerObject.close();
	}
	
	public void create() {
		try {
			int width = this.scannerObject.nextInt();
			int height = this.scannerObject.nextInt(); 
			if ( width <= 0 || height <= 0 ) throw new InvalidRectangleException(width, height) ;
			Rectangle newRectangle = new Rectangle(width, height);
			this.rectangles.add(newRectangle);
			System.out.println(newRectangle + " is added at " + (this.rectangles.size() - 1) );
		} catch(java.util.InputMismatchException e) {
			System.out.println("입력된 인자의 형식이 맞지 않습니다.");
		} catch ( InvalidRectangleException e ) { System.out.println(e); }
	}
	
	public void zoom() {
		try {
			int id = this.scannerObject.nextInt();
			int ratio = this.scannerObject.nextInt();
			System.out.println("Before: " + this.rectangles.get(id));
			this.rectangles.get(id).setRatio(ratio);
			System.out.println("After: " + this.rectangles.get(id));
		} catch(IndexOutOfBoundsException e) {
			System.out.println("존재하지 않는 배열의 원소를 접근했습니다." + e);
		}
	}
	
	public void showAll() {
		for(Rectangle r : this.rectangles)
			System.out.println( r );
	}

}
