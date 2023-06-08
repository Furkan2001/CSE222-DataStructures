/**
*
*@author Ahmet Furkan Ekinci - 200104004063
*
*/

package homework;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * MyMap class represents a custom map implementation that stores letters as keys and corresponding info objects as values.
 * It provides various methods for manipulating and accessing the map.
 */
public class MyMap 
{
	private LinkedHashMap <String, info> map;
	private int mapSize;
	private String str;
	
	/**
     * Constructs a new MyMap object by copying the contents of another MyMap object.
     *
     * @param temp the MyMap object to be copied
     */
	public MyMap(MyMap temp)
	{
		map = new LinkedHashMap<>();
		mapSize = temp.getMapSize();
		str = temp.getStr();
	}
	
	/**
     * Constructs a new MyMap object based on the given string input.
     * The string is processed to extract letters and create key-value pairs in the map.
     *
     * @param dummy the input string
     */
	public MyMap(String dummy)
	{
        boolean control;
        
        control = false;
        if (dummy.length() == 0)
        {
            System.out.println("There is no any letter in string!!!");
            System.exit(0);
        }
        map = new LinkedHashMap<>();
        mapSize = 0;
        int j;
        char[] arr = new char[dummy.length()];
        
        j = 0;
        for (int i = 0; i < dummy.length(); i++)
        {
            if ((dummy.charAt(i) >= 'A' && dummy.charAt(i) <= 'Z'))
            {
                char temp = dummy.charAt(i);
                arr[j] = (char) (temp + 32);
                j++;
                control = true;
            }
            else if ((dummy.charAt(i) >= 'a' && dummy.charAt(i) <= 'z'))
            {
                arr[j] = dummy.charAt(i);
                j++;
                control = true;
            }
            else if (j != 0)
            {
                if ((dummy.charAt(i) == ' ') && (arr[j-1] != ' '))
                {
                    arr[j] = dummy.charAt(i);
                    j++;
                }
            }
        }
        if (control == false)
        {
            System.out.println("There is no any letter in string!!!");
            System.exit(0);
        }
        char[] temp = new char[j];
        for (int i = 0; i < j; i++)
        {
            temp[i] = arr[i];
        }
        str = new String(temp);
        
    //--------------------------------------------------------------------------------------------------
        
        char[] ch1 = new char[str.length()];
        boolean flag;
        
        flag = false;
        j = 0;
        for (int i = 0; i < str.length(); i++)
        {
            flag = false;
            for (int k = 0; k < j; k++)
            {
                if (str.charAt(i) == ch1[k])
                {
                    flag = true;
                }
            }
            if (flag == false)
            {
                ch1[j] = str.charAt(i);
                j++;
            }
        }
        
        for (int i = 0; i < j; i++)
        {
            if (ch1[i] != ' ')
            {
                map.put(String.valueOf(ch1[i]), new info(str,ch1[i]));
                mapSize++;
            }
        }
	}
	
	 /**
     * Returns the original string used to create the MyMap object.
     *
     * @return the original string
     */
	public String getStr()
	{
		return str;
	}
	
	/**
     * Returns the map stored in the MyMap object.
     *
     * @return the map
     */
	public LinkedHashMap<String, info> getMap()
	{
		return map;
	}
	
	/**
     * Returns the size of the map.
     *
     * @return the size of the map
     */
	public int getMapSize()
	{
		return mapSize;
	}
	
	/**
	 * Prints the map.. 
	 */
	public void printMap()
	{
		for (Map.Entry<String, info> entry : map.entrySet()) 
		{
		    System.out.print("Letter: " + entry.getKey());
		    entry.getValue().getWords();
		    System.out.println("");
		}
	}
	
	/**
	 * Returns a String array that is twice as long as the number of key values ​​of the map variable and holds the key values ​​twice in a row.
	 * The purpose of this method is to help me set up the merge sort algorithm.
	 * 
	 * @return a String array.
	 */
	public String[] stringOfMapForMerge()
	{
		char[] ch1 = new char[str.length()];
		boolean flag;
		int j;
		
		flag = false;
		j = 0;
		for (int i = 0; i < str.length(); i++)
		{
			flag = false;
			for (int k = 0; k < j; k++)
			{
				if (str.charAt(i) == ch1[k])
				{
					flag = true;
				}
			}
			if (flag == false)
			{
				ch1[j] = str.charAt(i);
				j++;
			}
		}
		String[] temp = new String[2 * (j-1)];
		int z;
		
		z = 0;
		for (int i = 0; i < j; i++)
		{
			if (ch1[i] != ' ')
			{
				temp[z] = String.valueOf(ch1[i]);
				z++;
			}
		}
		for (int i = 0; i < j; i++)
		{
			if (ch1[i] != ' ')
			{
				temp[z] = String.valueOf(ch1[i]);
				z++;
			}
		}
		return temp;
	}
	
	/**
	 * Returns a String array that is once as long as the number of key values ​​of the map variable and holds the key values ​​twice in a row.
	 * The purpose of this method is to help me set up the selection sort algorithm.
	 * 
	 * @return a String array.
	 */
	public String[] stringOfMapForOthers()
	{
		char[] ch1 = new char[str.length()];
		boolean flag;
		int j;
		
		flag = false;
		j = 0;
		for (int i = 0; i < str.length(); i++)
		{
			flag = false;
			for (int k = 0; k < j; k++)
			{
				if (str.charAt(i) == ch1[k])
				{
					flag = true;
				}
			}
			if (flag == false)
			{
				ch1[j] = str.charAt(i);
				j++;
			}
		}
		String[] temp = new String[(j-1)];
		int z;
		
		z = 0;
		for (int i = 0; i < j; i++)
		{
			if (ch1[i] != ' ')
			{
				temp[z] = String.valueOf(ch1[i]);
				z++;
			}
		}
		return temp;
	}
}
