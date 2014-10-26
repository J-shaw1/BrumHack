package poker;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Input {

	private static BufferedReader brd = new BufferedReader(
			new InputStreamReader(System.in));
	private static String input;

	public static int readInt() {
		int retVal = Integer.MAX_VALUE;
		do {
			try {
				input = brd.readLine();
				retVal = Integer.parseInt(input.trim());
			} catch (Exception e) {
				System.out.print("Exception: \"" + input
						+ "\" is not a number! Please enter a number: ");
			}
		} while (retVal == Integer.MAX_VALUE);
		return retVal;
	}

	public static String readString() {
		String retStr = null;
		try {
			retStr = brd.readLine();
		} catch (Exception e) {
			System.out.println("Exception: Could not read a string from input");
		}
		return retStr;
	}
}
