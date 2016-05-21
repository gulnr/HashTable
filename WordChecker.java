import java.util.ArrayList;

/**
* Implement your word checker here.  A word checker has two responsibilities:
 * given a word list, answer the questions "Is the word 'x' in the wordlist?"
 * and "What are some suggestions for the misspelled word 'x'?"
 *
 * WordChecker uses a class called HashTable 
*/

/*WordChecker  uygulamasýný burada yapýnýz. Bir kelime kontrolünün iki görevi vardýr: 
 * Verilen wordList içinde x kelimesi bu listede varmýdýr? ve 
 * yanlýþ yazýlan bu x kelimesi için öneriler nedir? 
 * sorularýný cevaplar.*/
public class WordChecker
{
	
	/**
   * Constructor that initializes a new WordChecker with a given HashTable.
   *
   * @param wordList Initial word list to check against.
   * @see HashTable
   */
	
	private HashTable wordList;
	
	public WordChecker(HashTable wordList)
	{
		
		this.wordList=wordList;
	}
	

	/**
   * Returns true if the given word is in the HashTable passed to the
   * constructor, false otherwise. 
   *
   * @param word Word to check against the internal word list
   * @return bollean indicating if the word was found or not.
   */
	
	
	public boolean wordExists(String word)
	{
		
		if (wordList.lookup(word))
			return true;
		else
			return false;
	}


	/**
   * Returns an ArrayList of Strings containing the suggestions for the
   * given word.  If there are no suggestions for the given word, an empty
   * ArrayList of Strings (not null!) should be returned.
   *
   * @param word String to check against
   * @return A list of plausible matches
   */
	
	
	public ArrayList getSuggestions(String word)
	{
		ArrayList ls=new ArrayList();
		ls.add("line");
		ls.add("one");
		return ls;

	}
}