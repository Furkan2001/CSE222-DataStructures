/**
*
*@author Ahmet Furkan Ekinci - 200104004063
*
*/

package homework;

import java.util.ArrayList;

/**
 * The info class represents information related to a specific letter in the MyMap class.
 * It stores the words that contain the letter and provides methods for accessing and manipulating them.
 */
public class info 
{
	private ArrayList<String> words;
	
	 /**
     * Constructs a new info object based on the given string and letter.
     * The words that contain the letter are extracted and stored in the object.
     *
     * @param str  the input string
     * @param ch1  the letter
     */
	public info(String str, char ch1)
	{
		words = new ArrayList<>();
		String[] temp = str.split(" ");
		int flag;
		
		flag = 0;
		for (int i = 0; i < temp.length; i++)
		{
			flag = 0;
			for (int j = 0; j < temp[i].length(); j++)
			{
				if (ch1 == temp[i].charAt(j))
				{
					flag++;
				}
			}
			while (flag > 0)
			{
				words.add(temp[i]);
				flag--;
			}
		}
	}
	
	/**
     * Prints the count and values of the words stored in the info object.
     */
	public void getWords()
	{
		System.out.print("\tCount: ");
		System.out.print(words.size());
	    System.out.print("\tValue: ");
	    System.out.print("[");
		for (int i = 0; i < words.size(); i++)
		{
			if (i != 0)
			{
				System.out.print(", ");
			}
			System.out.print(words.get(i));
		}
		System.out.print("]");
	}

	 /**
     * Returns the size (count) of the words stored in the info object.
     *
     * @return the size of the words
     */
	public int getSize()
	{
		return words.size();
	}
	
}
