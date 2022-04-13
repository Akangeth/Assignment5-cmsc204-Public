import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class converts morse code to english
 * 
 * @author Allan Kangethe
 *
 */
public class MorseCodeConverter {
	private static MorseCodeTree tree = new MorseCodeTree();

	/**
	 * Method that translates morse code to english
	 * 
	 * @param code the morse code
	 * @return string english translation of morse code
	 */
	protected static String convertToEnglish(String code) {
		String morseString[] = code.split("/");
		String str = "";
		String theLetters[];
		for (int i = 0; i < morseString.length; i++) {
			morseString[i] = morseString[i].trim();
			theLetters = morseString[i].split(" ");
			for (int j = 0; j < theLetters.length; j++) {
				str += tree.fetch(theLetters[j]);
			}
			str += " ";

		}

		return str.trim();
	}

	/**
	 * Method translates morse code from provided file
	 * 
	 * @param theFile the file with morse code
	 * @return the english translation of the morse code from file
	 * @throws FileNotFoundException if the file cannot be found
	 */
	protected static String convertToEnglish(File theFile) throws FileNotFoundException {
		BufferedReader fileReader = new BufferedReader(new FileReader(theFile));
		StringBuilder strBuilder = new StringBuilder();
		String line = null;
		
		try {
			while ((line = fileReader.readLine()) != null) {
				strBuilder.append(convertToEnglish(line));
				strBuilder.append("\n");
			}
			fileReader.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		String str = strBuilder.toString().trim();
		return str;
	}

	/**
	 * Method that will print out a tree (binary)
	 * 
	 * @return string with values of binary tree
	 */
	protected static String printTree() {
		ArrayList<String> entireTree = tree.toArrayList();
		String string = "";
		for (String letter : entireTree) {
			string += letter + " "; //the space
		}
		return string.trim();
	}
}