/**
*
*@author Ahmet Furkan Ekinci - 200104004063
*
*/
package Security;

import java.util.Stack;

/**
 * 
 * This is a Password1 class.
 *
 */

public class Password1 
{

	private String password1;
	
	/**
	 * Constructs an empty Password1 object with default values.
	 */
	public Password1()
	{
		password1 = new String();
	}
	
	/**
	 * Constructs a Password1 object with the specified password.
	 * 
	 * @param password1 the password string
	 */
	public Password1(String password1)
	{
		this.password1 = password1;
	}
	
	/**
	 * Checks whether the password contains at least one character from the username.
	 * 
	 * @param username the username string
	 * @return true if the password contains at least one character from the username, false otherwise
	 */
	public boolean containsUserNameSpirit(String username)
	{
		int counter = 0;
		
		Stack<Character> stackUsername = new Stack<>();
		Stack<Character> stackPassword1 = new Stack<>();
		
		for (int i = 0; i < username.length(); i++)
		{
			stackUsername.push(username.charAt(i));
		}
		for (int i = 0; i < password1.length(); i++)
		{
			stackPassword1.push(password1.charAt(i));
		}
		
		while (stackPassword1.empty() == false)
		{
			if (stackUsername.search(stackPassword1.pop()) != -1)
			{
				counter++;
				break;
			}
		}
		if (counter == 0)
		{
			System.out.println("The password1 is invalid. It should have at least 1 character from the username.");
			return false;
		}
		return true;
	}
	
	/**
	 * Checks whether the password has balanced parentheses.
	 * 
	 * @return true if the password has balanced parentheses, false otherwise
	 */
	public boolean isBalancedPassword()
	{
		Stack<Character> stack = new Stack<>();
	    
	    for (int i = 0; i < password1.length(); i++)
        {
            char c = password1.charAt(i);
            
            if (c == '(' || c == '{' || c == '[') 
            {
                stack.push(c);
            } 
            else if (c == ')') 
            {
                if (stack.empty() || stack.pop() != '(') 
                {
                	System.out.println("The password1 is invalid. It should be balanced.");
                    return false;
                }
            }
            else if (c == '}')
            {
                if (stack.empty() || stack.pop() != '{')
                {
                	System.out.println("The password1 is invalid. It should be balanced.");
                    return false;
                }
            }
            else if (c == ']')
            {
                if (stack.empty() || stack.pop() != '[')
                {
                	System.out.println("The password1 is invalid. It should be balanced.");
                    return false;
                }
            }
        }
	    if (stack.empty() != true) // en basa bir bos parantez koyunca true dönmesin diye
	    {
	    	System.out.println("The password1 is invalid. It should be balanced.");
	    	return false;
	    }
	    return true;
	}
	
	/**
	 * Checks whether it is possible to obtain a palindrome from the password.
	 * 
	 * @param index the index of the last character in the alphabet
	 * @return true if it is possible to obtain a palindrome from the password, false otherwise
	 */
	public boolean isPalindromePossible(int index) // !!!!!!   index must be 25
	{
		if (index < 0)
		{
			return true;
		}
		
		int[] arr = new int[26];
		String dummyPassword1 = this.removeBracketsAndLowerCase();
        
		this.addNumberOfLetter(dummyPassword1, arr); 
	
		if (arr[index] % 2 == 1)
		{
			System.out.println("The password1 is invalid. It should be possible to obtain a palindrome from the password1.");
			return false;
		}
		else
		{
			return isPalindromePossible(index - 1);
		} 
	}
	
	/**
	 * Removes all brackets and converts all characters to lowercase in the password.
	 * Time complexity: O(n)
	 * 
	 * @return the password without brackets and in lowercase
	 */
	public String removeBracketsAndLowerCase()  // O(n)
	{
		int size = password1.length();

		for (int i = 0; i < password1.length(); i++)
		{
			if (password1.charAt(i) == '(' || password1.charAt(i) == ')' || password1.charAt(i) == '[' || password1.charAt(i) == ']' || password1.charAt(i) == '{' || password1.charAt(i) == '}')
			{
				size--;
			}
		}
		
		char[] temp = new char[size];
		
		size = 0;
		for (int i = 0; i < password1.length(); i++)
		{
			if (!(password1.charAt(i) == '(' || password1.charAt(i) == ')' || password1.charAt(i) == '[' || password1.charAt(i) == ']' || password1.charAt(i) == '{' || password1.charAt(i) == '}'))
			{
				temp[size] = password1.charAt(i);
				if (temp[size] >= 'A' && temp[size] <= 'Z')
				{
					temp[size] += 'a' - 'A';
				}
				size++;
			}
		}
		return (new String(temp));
	}
	
	/**
	 * Counts the number of occurrences of each letter in the given string and stores them in an array.
	 * Time complexity: O(n)
	 * 
	 * @param dummy the string to count the letters
	 * @param arr the array to store the counts
	 */
	public void addNumberOfLetter(String dummy, int[] arr)  // O(n)
	{
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = 0;
		}
		for (int i = 0; i < dummy.length(); i++)
		{
			arr[dummy.charAt(i) - 97]++;
		}
		for (int i = 0; i < dummy.length(); i++) // If there is an odd occurrence of a letter, it increments it to make it even.
		{
			if (arr[dummy.charAt(i) - 97] % 2 == 1)
			{
				arr[dummy.charAt(i) - 97]++;
				break;
			}
		}
	}
	
	/**
	 * Checks if the password length is at least 8 characters.
	 * Time complexity: O(1)
	 * 
	 * @return true if the password length is at least 8 characters, false otherwise
	 */
	public boolean sizeControl() // O(1)
	{
		if (password1.length() < 8)
		{
			System.out.println("The password1 is invalid. It should have at least 8 characters..");
			return false;
		}
		return true;
	}
	
	/**
	 * Checks if the password contains at least 2 brackets.
	 * Time complexity: O(n)
	 * 
	 * @return true if the password contains at least 2 brackets, false otherwise
	 */
	public boolean bracketControl()   // O(n)
	{
		for (int i = 0; i < password1.length(); i++)
		{
			if (password1.charAt(i) == '(' || password1.charAt(i) == ')' || password1.charAt(i) == '[' || password1.charAt(i) == ']' || password1.charAt(i) == '{' || password1.charAt(i) == '}')
			{
				return true;
			}
		}
		System.out.println("The password1 is invalid. It should have at least 2 brackets.");
		return false;
	}
	
	/**
	 * Checks if the password contains only letters and brackets.
	 * Time complexity: O(n)
	 * 
	 * @return true if the password contains only letters and brackets, false otherwise
	 */
	public boolean justLatterAndBracketControl()  // O(n)
	{
		for (int i = 0; i < password1.length(); i++)
		{
			if(!(password1.charAt(i) == '{' || password1.charAt(i) == '[' || password1.charAt(i) == '(' || password1.charAt(i) == '}' || password1.charAt(i) == ')' || password1.charAt(i) == ']' || (password1.charAt(i) >= 'a' && password1.charAt(i) <= 'z') || (password1.charAt(i) >= 'A' && password1.charAt(i) <= 'Z')))
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Sets the password to the given string.
	 * 
	 * @param password1 the password to set
	 */
	public void set(String password1)
	{
		this.password1 = password1;
	}
	
	/**
	 * Gets the password.
	 * 
	 * @return the password
	 */
	public String get()
	{
		return password1;
	}
}
