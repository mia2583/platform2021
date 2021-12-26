import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


enum StringCommand { ADD, REMOVE, CLEAN, QUIT, INVALID};
public class StringSetManager {
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		String[] stringSet = new String[100];
		while ( true ) {
			final StringCommand command = getCommand(scanner);
			if ( command == StringCommand.QUIT ) {
				System.out.println("BYE!"); break;
			}
			switch ( command ) {
			case ADD: {
				final String str = getString(scanner);
				executeAdd(stringSet, str);
				break;
			}
			case REMOVE: {
				final String str = getString(scanner);
				executeRemove(stringSet, str);
				break;
			}
			case CLEAN: {
				executeClear(stringSet);
				break;
			}
			default:
				System.out.println("Unknown Command!");
				break;
			}
			executePrint(stringSet);
		}
	}
	public static StringCommand getCommand(Scanner scanner) {
		final String actionIn = scanner.next();
		StringCommand action;
		try {
			action = StringCommand.valueOf(actionIn.toUpperCase());
		} catch (IllegalArgumentException e) {
			action = StringCommand.valueOf("INVALID");
		}
		
		/*Á¤´ä
		 * stringCommend command = StringCommand.INVALID;
		try {
		final string commandStr = scanner.next();
		command = StringCommand.valueOf(commandStr.toUpperCase());
		}
		catch (IllegalArgumentException e) {
		
		return command;*/
		return action;
	}
	
	public static String getString(Scanner scanner) {
		final String word = scanner.next();
		/* return scanner.next();*/
		return word;
	}
	
	public static void executeAdd(String[] stringSet, String str) {
		List<String> words = new ArrayList<>(Arrays.asList(stringSet));
		int item = words.indexOf(null);
		if(item==-1) System.out.println("Over 100 words is added");
		if(!words.contains(str)) stringSet[item] = str;
	}
	/* final boolean found = excuteFind(stringSet, str);
	 * if(!found) {
	 * 	//add
	 * 	for(int i=0; i<stringSet.length; i++) {
	 * 		final String currentString = stringSet[i];
	 * 		(currentString ==null) {
	 * 			stringSet[i] = str;
	 * 		break;
	 * }
	 * }
	 */
	
	public static void executeRemove(String[] stringSet, String str) {
		List<String> words = new ArrayList<>(Arrays.asList(stringSet));
		if(words.contains(str)) words.remove(str); 
		words.toArray(stringSet);
	}
	
	public static void executeClear(String[] stringSet) {
		Arrays.fill(stringSet, null);	
	}
	
	public static void executePrint(String[] stringSet) {
		List<String> words = new ArrayList<>(Arrays.asList(stringSet));
		int item = words.indexOf(null);
		if(item==-1) item = 100;
		Arrays.sort(stringSet, 0, item);
		System.out.printf("Element Size: %d, Values = ", item);
		if(item!=0) System.out.printf("%s", stringSet[0]);
		for(int i=1; i<item; i++) {
			System.out.printf(", %s", stringSet[i]);
		}
		System.out.println();
	}
}
