
//NAME: SISKA KRISTANTI LIM
//STUDENT NO.: 170281939
import java.util.*;
import java.io.*;

/*
 *
 * 1. loop showing a list of options (including quit)
 * 2. go back to 1 each time the user selects an option that isn't 'quit' (after performing the option)
 * 3. when the user selects 'quit', end the program
 *
 */

public class DictionaryMethods {

	private Scanner in;
	private boolean proceed;
	private static String filename;
	private ArrayList<String> dictionary;

	public DictionaryMethods() {
		in = new Scanner(System.in);
		proceed = true;
		filename = "smallDictionary.txt";
		dictionary = new ArrayList<String>();
		readDictionary(filename);
		startLoop();
	}

	private void readDictionary(String dictFile) {
		Scanner in = null;
		try {
			in = new Scanner(new FileReader(dictFile));
		} catch (IOException e) {
			System.err.println("Dictionary file does not exist! Aborting.");
		}

		while (in.hasNextLine()) {
			String word = in.nextLine();
			addWord(word);
		}
		in.close();
		sortDictionary();
	}

	private void addWord(String word) {
		dictionary.add(sanitiseWord(word));
	}

	private String sanitiseWord(String word) {
		return word.toLowerCase();
	}

	private boolean isWordInDictionary(String word) {
		return dictionary.contains(sanitiseWord(word));
	}

	private void sortDictionary() {
		Collections.sort(dictionary);
	}

	private void startLoop() {
		// main loop. when we exit this loop the program is over
		while (proceed) {
			showOptions();
			String userInput = getUserSelectedOption();

			int option = validateUserInput(userInput);
			if (option == 8) { // option to quit
				proceed = false;
			} else {
				executeUserSelectedOption(option);
			}
		}
		// the end.
		System.out.println("Bye.");
		System.out.println("Press any key to continue...");
		in.close();
	}

	private String getUserInput() {
		return in.nextLine();
	}

	private void showOptions() {
		System.out.println("Choose one of the following options:");
		System.out.println();
		System.out.println("1) check that a word is in the dictionary");
		System.out.println("2) show all words in dictionary");
		System.out.println("3) show all words in dictionary containing a search String");
		System.out.println("4) show all words in dictionary starting with a search String");
		System.out.println("5) show all words in dictionary ending with a search String");
		System.out.println("6) show all words in dictionary of a certain length");
		System.out.println("7) change the current dictionary file to another dictionary file");
		System.out.println("8) Quit");
		System.out.println();
	}

	private String getUserSelectedOption() {
		System.out.print("Enter your choice: ");
		String s = getUserInput();
		System.out.println();
		return s;
	}

	private int validateUserInput(String data) {
		if (data == null || data.trim().length() == 0) {
			return -1;
		}

		String possibleNumber = data.trim();
		if (possibleNumber.length() > 1) { // length will be > 1 if a number greater than 9 entered
			return -1;
		}

		if (possibleNumber.equals("1"))
			return 1;
		if (possibleNumber.equals("2"))
			return 2;
		if (possibleNumber.equals("3"))
			return 3;
		if (possibleNumber.equals("4"))
			return 4;
		if (possibleNumber.equals("5"))
			return 5;
		if (possibleNumber.equals("6"))
			return 6;
		if (possibleNumber.equals("7"))
			return 7;
		if (possibleNumber.equals("8"))
			return 8;

		return -1;
	}

	private void executeUserSelectedOption(int option) {
		if (option < 1) {
			System.out.println("Unknown option.");
			return;
		}

		switch (option) {
		case 1:
			findWord();
			break;
		case 2:
			display();
			break;
		case 3:
			contains();
			break;
		case 4:
			startsWith();
			break;
		case 5:
			endsWith();
			break;
		case 6:
			thisLong();
			break;
		case 7:
			changeDictionary();
			break;

		default:
			System.out.print("Error executing option.");
		}
		System.out.println();
	}

	private void findWord() {
		System.out.println("This method checks if your word is in the dictionary ");
		System.out.println("Enter your word ");
		String word = getUserInput();
		System.out.println();
		if (isWordInDictionary(word)) {
			System.out.println(word + " is in the dictionary");
		} else if (!(isWordInDictionary(word)))
			System.out.println(word + " is not in the dictionary");
	}

	private void display() {
		for (int i = 0; i < dictionary.size(); i++) {
			StringBuilder sb = new StringBuilder();
			String text = dictionary.get(i);
			sb.append(text);
			System.out.println(sb.toString());
		}

	}

	private void errorMessage() {
		System.out.println("I don't know how to do that!");
	}

	private void changeDictionary() {
		boolean state;
		dictionary.clear();
		System.out.println("This method changes the file used to load the dictionary");
		System.out.println("Enter the filename ");
		filename = getUserInput();
		do {
			try {
				FileReader in = new FileReader(filename);
				readDictionary(filename);
				System.out.println("Dictionary has been changed");
				System.out.println("Choose option 2 to view the new dictionary");
				state = false;
			} catch (FileNotFoundException e) {
				System.out.println(filename + " file does not exist! Please re-enter:");
				filename = getUserInput();
				state = true;
			}
		} while (state);
	}

	private void contains() {
		boolean state = false;
		System.out.println("This method outputs words that contain your search String");
		System.out.println("Enter your String");
		String word = getUserInput();
		System.out.println();
		for (int i = 0; i < dictionary.size(); i++) {
			String x = dictionary.get(i);
			if (x.contains(word)) {
				System.out.println(x);
				state = true;
			}
		}
		if (state == false)
			System.out.println("Nothing found with words containing " + word);

	}

	private void startsWith() {
		boolean state = false;
		System.out.println("This method outputs words that start with your search String");
		System.out.println("Enter your String");
		String word = getUserInput();
		System.out.println();
		for (int i = 0; i < dictionary.size(); i++) {
			String x = dictionary.get(i);
			if (x.startsWith(word)) {
				System.out.println(x);
				state = true;
			}
		}
		if (state == false) {
			System.out.println("Nothing found starting with " + word);
		}

	}

	private void endsWith() {
		boolean state = false;
		System.out.println("This method outputs words that end with your search String");
		System.out.println("Enter your String");
		String word = getUserInput();
		System.out.println();
		for (int i = 0; i < dictionary.size(); i++) {
			String x = dictionary.get(i);
			if (x.endsWith(word)) {
				System.out.println(x);
				state = true;
			}
		}
		if (state == false)
			System.out.println("Nothing found ending with " + word);

	}

	private void thisLong() {
		boolean state = false;
		System.out.println("This method outputs words of a certain length");
		System.out.println("Enter the length of the word");
		int length = in.nextInt();
		System.out.println();
		for (int i = 0; i < dictionary.size(); i++) {
			if (length == dictionary.get(i).length()) {
				String x = dictionary.get(i);
				System.out.println(x);
				state = true;
			}
		}
		if (state == false)
			System.out.println("Nothing found with length " + length);
	}

	public static void main(String[] args) {
		new DictionaryMethods();
	}
}
