import java.util.Scanner;

enum Command {
	ADD, LIST, SUM, QUIT, INVALID
};
public class ArrayEnum {
	public static void main(String[] args) {
		Integer [] values = new Integer[100];
		int index =0;
		final Scanner scanner = new Scanner(System.in);
		while ( true ) {
			final Command command = getCommand(scanner); // Command is enum
			if ( command == Command.QUIT ) {
				System.out.println("Bye!");
				break;
			}
			switch ( command ) {
			case ADD:
				final int newValue = getValue(scanner);
				values[index] = newValue;
				index++;
				break;
			case LIST:
				printList(values, index);
				break;
			case SUM:
				System.out.println(getSum(values, index));
				break;
			case INVALID:
				System.out.println("Invalid Command");
				default: break;
			}
		}
		scanner.close();
	}
	
	public static Command getCommand(Scanner scanner) {
		final String actionIn = scanner.next();
		Command action;
		try {
			action = Command.valueOf(actionIn.toUpperCase());
		} catch (IllegalArgumentException e) {
			action = Command.valueOf("INVALID");
		}
		return action;
	}
	
	public static int getValue(Scanner scanner) {
		final int num = scanner.nextInt();
		return num;
	}
	
	public static void printList(Integer[] values, int index) {
		for(int item=0; item <index; item++) {
			System.out.printf("%d ", values[item]);
		}
		System.out.println();
	}

	public static int getSum(Integer[] values, int index) {
		int sum = 0;
		for(int item=0; item <index; item++) {
			sum += values[item];
		}
		return sum;
		
	}
	
}
