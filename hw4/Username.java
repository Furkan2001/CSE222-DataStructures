/**
*
*@author Ahmet Furkan Ekinci - 200104004063
*
*/
package Security;

/**
 * 
 * This is Username class.
 *
 */
public class Username 
{

	private String username;
	
	/**
	 * Constructs an empty username.
	 */
	public Username()
	{
		username = new String();
	}
	
	/**
	 * Constructs a username with the given string.
	 * @param username the string to set as the username
	 */
	public Username(String username)
	{
		this.username = username;
	}
	
	/**
	 * Checks if the given username is valid.
	 * @param username the username to be checked
	 * @param size the size of the username
	 * @return true if the username is valid, false otherwise
	 */
	public boolean checkIfValidUsername(String username, int size)
	{
		if (username.length() < 1)
		{
			System.out.println("The username is invalid. It should have at least 1 character. Try again...");
			return false;
		}
		if (size == -1)
		{
			return true;
		}
		char c = username.charAt(size);
		if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'z')))
		{
			System.out.println("The username is invalid. It should have letters only. Try again...");
			return false;
		}
		return (this.checkIfValidUsername(username, size-1));
	}
	
	/**
	 * Sets the username to the given string.
	 * @param username the string to set as the username
	 */
	public void set(String username)
	{
		this.username = username;
	}
	
	/**
	 * Gets the current username.
	 * @return the current username
	 */
	public String get()
	{
		return (username);
	}
	
	/**
	 * Gets the size of the username.
	 * @return the size of the username
	 */
	public int size()
	{
		return username.length()-1;
	}
	
}
