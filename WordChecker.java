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
	final static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	
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
	
	
	public String printSuggestions(String input) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> print = getSuggestions(input);
        if (print.size() == 0) {
            return "No suggestion.\n";
        }
        sb.append("perhaps you meant:\n");
        for (String s : print) {
            sb.append("\n  -" + s);
        }
        return sb.toString();
    }

    public ArrayList<String> getSuggestions(String input) {
        ArrayList<String> toReturn = new ArrayList<>();
        toReturn.addAll(charAppended(input));
        toReturn.addAll(charMissing(input));
        toReturn.addAll(charsSwapped(input));
        return toReturn;
    }
    
    private ArrayList<String> charAppended(String input) { 
        ArrayList<String> toReturn = new ArrayList<>();
        for (char c : alphabet) {
            String atFront = c + input;
            String atBack = input + c;
            if (wordlist.lookup(atFront)) {
                toReturn.add(atFront);
            }
            if (wordlist.lookup(atBack)) {
                toReturn.add(atBack);
            }
        }
        return toReturn;
    }

    private ArrayList<String> charMissing(String input) {   
        ArrayList<String> toReturn = new ArrayList<>();

        int len = input.length() - 1;
        //try removing char from the front
        if (wordlist.lookup(input.substring(1))) {
            toReturn.add(input.substring(1));
        }
        for (int i = 1; i < len; i++) {
            //try removing each char between (not including) the first and last
            String working = input.substring(0, i);
            working = working.concat(input.substring((i + 1), input.length()));
            if (wordlist.lookup(working)) {
                toReturn.add(working);
            }
        }
        if (wordlist.lookup(input.substring(0, len))) {
            toReturn.add(input.substring(0, len));
        }
        return toReturn;
    }

    private ArrayList<String> charsSwapped(String input) {   
        ArrayList<String> toReturn = new ArrayList<>();

        for (int i = 0; i < input.length() - 1; i++) {
            String working = input.substring(0, i);// System.out.println("    0:" + working);
            working = working + input.charAt(i + 1);  //System.out.println("    1:" + working);
            working = working + input.charAt(i); //System.out.println("    2:" + working);
            working = working.concat(input.substring((i + 2)));//System.out.println("    FIN:" + working); 
            if (wordlist.lookup(working)) {
                toReturn.add(working);
            }
        }
        return toReturn;
    }
}
