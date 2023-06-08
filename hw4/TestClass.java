/**
*
*@author Ahmet Furkan Ekinci - 200104004063
*
*/
package Security;

/**
 * 
 * This is a TestClass class.
 *
 */
public class TestClass {
	
	/**
	 * 
     * Default constructor for creating TestClass objects without parameters.
     * 
     */
	public TestClass(){}
	
	
   /**
    *The main method of the program.
    *
	*@param args is a String[] parameter.
	*
	*/
	public static void main(String[] args)
	{
		System.out.print("1- ");
		TestClass.helperMethod("furkanEkinci", "[rac()ecar]", 125, new int[] {4,7,9});
		
		System.out.print("\n2- ");
		TestClass.helperMethod("", "[rac()ecar]", 125, new int[] {4,7,9});
		
		System.out.print("\n3- ");
		TestClass.helperMethod("furkanEkinci", "pass[]", 125, new int[] {4,7,9});
		
		System.out.print("\n4- ");
		TestClass.helperMethod("furkanEkinci1", "pass[]", 125, new int[] {4,7,9});
		
		System.out.print("\n5- ");
		TestClass.helperMethod("furkanEkinci", "abcddbac", 125, new int[] {4,7,9});
		
		System.out.print("\n6- ");
		TestClass.helperMethod("furkanEkinci", "[[[[]]]]", 125, new int[] {4,7,9});
		
		System.out.print("\n7- ");
		TestClass.helperMethod("furkanEkinci", "([[[asd]]]]", 125, new int[] {4,7,9});
		
		System.out.print("\n8- ");
		TestClass.helperMethod("furkanEkinci", "race(c)ars", 125, new int[] {4,7,9});
		
		System.out.print("\n9- ");
		TestClass.helperMethod("furkanEkinci", "race(c)ar", 12125, new int[] {4,7,9});
		
		System.out.print("\n10- ");
		TestClass.helperMethod("furkanEkinci", "race(c)ar", 254, new int[] {44,71,98});
	}
	
	/**
	 * A helper method for testing the validity of the inputs for opening a door.
	 * 
	 * @param name   the name to be checked as the username
	 * @param pass1  the password string to be checked for various properties
	 * @param pass2  the integer password to be checked for range and exact division properties
	 * @param arr    the array of denominations to be checked for exact division property
	 */
	public static void helperMethod(String name, String pass1, int pass2, int[] arr)
	{
		Username username = new Username(name);
		Password1 password1 = new Password1(pass1);
		Password2 password2 = new Password2(pass2);
		
		if (username.checkIfValidUsername(username.get(), username.size()))
		{
			if (password1.justLatterAndBracketControl())
			{
				if (password1.bracketControl())
				{
					if (password1.sizeControl())
					{
						if (password1.containsUserNameSpirit(username.get()))
						{
							if (password1.isBalancedPassword())
							{
								if (password1.isPalindromePossible(25))
								{
									if (password2.controlRange())
									{
										if (password2.isExactDivision(password2.get(), arr, 0))
										{
											System.out.println("The username and passwords are valid. The door is opening, please wait...");
										}
										else
										{
											System.out.println("The password2 is invalid. It is not compatible with the denominations.");
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}






