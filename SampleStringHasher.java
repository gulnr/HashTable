/**
 *
 * A hash function for strings that uses multiplications and additions on
 * each character to ensure that the characters *and* the order in which
 * the characters appear are both considered significant.
 */

public class SampleStringHasher implements StringHasher
{
	public int hash(String s)
	{
		int h = 0;
		
		for (int i = 0; i < s.length(); ++i)
		{
			h *= 37;
			h += s.charAt(i);
		}
		
		return h;
	}
}