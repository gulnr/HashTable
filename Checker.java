import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Checker {

	/* Main class, it will read the wordlist.txt file and store words into a hash table. 
	*then spell-check an input sentence.*/
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a sentence >>");
		String input=sc.nextLine();
		
		File wordList = new File("/home/gulnur/workspace/HW5/src/wordlist.txt");
		
//		Add Scanner to read from file
		Scanner list = new Scanner(wordList);
		
//		Create a hasher for using hash table 
		SampleStringHasher hasher = new SampleStringHasher();
		
// 		to find table size
		int size=0;
		while(list.hasNextLine()){
			String str = list.nextLine();
			size++;
		}
		
//		create a hash table		
		HashTable table = new HashTable(size, hasher);
		
//		store words into a hash table
		while(list.hasNextLine()){
			String str = list.nextLine();
			table.add(str);
		}
		
//		create a word checker inside wordlist.txt
		WordChecker checker =new WordChecker(table);
		
		boolean misspelling = false;
		String[] words = input.split(" ");
		
		System.out.println("Result\n ********");
		
		for (int i = 0; i < words.length; i ++){
			if (!(checker.wordExists(words[i]))){
				System.out.println("Word not found:" + words[i]);
				System.out.println("perhaps you meant:" + checker.getSuggestions(words[i]));
				misspelling = true;
			}
			
		}
		if (misspelling = false)
			System.out.println("No misspelling in the sentence.");
		
		

	}

}