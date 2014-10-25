package poker;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Input {
	
	private static BufferedReader brd = new BufferedReader(
			new InputStreamReader(System.in));
	private static String input;
	
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
