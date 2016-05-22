
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Checker {

	/* Main class, it will read the wordlist.txt file and store words into a hash table. 
	*then spell-check an input sentence.*/
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a sentence >>");
		String input = sc.nextLine();
		
//		Define wordList file
		File wordList = new File("/Users/aysenur/Documents/workspace/CENG_201_HW5/src/WorkChecker/wordlist.txt");
		
//		Add Scanner to read from file
		Scanner list = new Scanner(wordList);
		
//		Create hasher to add words into hash table
		SampleStringHasher hasher = new SampleStringHasher();
		
//		Create a hash table
		HashTable table = new HashTable(2500, hasher);
		
		
		
		while(list.hasNextLine()){
			
			String s = list.nextLine();
			table.add(s);
		}
		
//		Create word checker to check if hash table contains input
		WordChecker checker = new WordChecker(table);
		
		boolean misspelling = false;
		String[] words = input.split(" ");
			
			
		
		System.out.println("Result\n ********");
		
		for (int i = 0; i < words.length; i ++){
			if (!checker.wordExists(words[i])){
				System.out.println("Word not found:" + words[i]);
				System.out.println("perhaps you meant:" + checker.printSuggestions(words[i]));
				misspelling = true;
			}
		}
		if (misspelling == false)
			System.out.println("No misspelling in the sentence.");
	}

}
