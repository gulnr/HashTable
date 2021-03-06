import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * Implement your hash table here.  You are required to use the separate
 * chaining strategy that we discussed in lecture, meaning that collisions
 * are resolved by having each cell in the table be a linked list of all of
 * the strings that hashed to that cell.
 */

public class HashTable
{
	private HashMap table = new HashMap();
	private int tableSize;
	private StringHasher hasher;
	private LinkedList[] hashArray; 
	
	/**
   * The constructor is given a table size (i.e. how big to make the array)
   * and a StringHasher, which is used to hash the strings.
   *
   * @param tableSize number of elements in the hash array
   *        hasher    Object that creates the hash code for a string
   * @see StringHasher
   */	
	public HashTable(int tableSize, StringHasher hasher)
	{

		this.tableSize=tableSize;
		this.hasher=hasher;
		hashArray= new LinkedList[tableSize];
	
	}


	/**
   * Takes a string and adds it to the hash table, if it's not already
   * in the hash table.  If it is, this method has no effect.
   *
   * @param s String to add
   */
	
	public void add(String s)
	{

		if(!table.containsValue(s))
		{
			if(table.containsKey(hasher.hash(s))){
		hashArray[].addFirst(s);
		table.put(hasher.hash(s)%tableSize, hashArray[0]);
			}
			else
				
		}
	}
	

	/**
  * Takes a string and returns true if that string appears in the
	* hash table, false otherwise.
  *
  * @param s String to look up
  */
	
	public boolean lookup(String s)
	{
		if (table.containsValue(hasher.hash(s)))
			return true;
		else
			return false;

	}
	

	/**
   * Takes a string and removes it from the hash table, if it
   * appears in the hash table.  If it doesn't, this method has no effect.
   *
   * @param s String to remove
  */
	/*Silinmek istenen kelime(parametre olarak alýnýr) hash tablosunda varsa kaldýrýlýr. 
	*Tabloda yoksa metot birþey yapmayacaktýr.
	*/
	public void remove(String s)
	{

		if(table.containsValue(s))
			table.remove(hasher.hash(s));
	}
}