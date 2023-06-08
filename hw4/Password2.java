/**
*
*@author Ahmet Furkan Ekinci - 200104004063
*
*/
package Security;

/**
 * 
 * This is a Password2 class.
 *
 */
public class Password2 
{
	/**
     * The password2 integer value.
     */
	private int password2;
	
	 /**
     * Constructs a Password2 object with the given integer value.
     * 
     * @param number the integer value to set as password2
     */
	public Password2(int number)
	{
		this.password2 = number;
	}
	
	 /**
     * Checks if the password2 value is within the valid range of 10 to 10,000.
     * 
     * @return true if password2 is within range, false otherwise
     */
	public boolean controlRange()
	{
		if (password2 >= 10 && password2 <= 10000)
		{
			return true;
		}
		System.out.println("The password2 is invalid. It should be between 10 and 10,000.");
		return false;
	}
	
	 /**
     * Checks if the password2 value can be divided exactly into the given denominations.
     * Uses a recursive approach.
     * 
     * @param password2 the value to check for exact division
     * @param denominations an array of integers representing the denominations to use for division
     * @param index the current index in the denominations array
     * @return true if password2 can be exactly divided into the given denominations, false otherwise
     */
	public boolean isExactDivision(int password2, int[] denominations, int index)
    {
        if (password2 == 0) 
        {
            return true;
        }
        if (index >= denominations.length) 
        {
            return false;
        }
        for (int i = 0; i <= password2 / denominations[index]; i++)
        {
            if (isExactDivision(password2 - i * denominations[index], denominations, index + 1))
            {
                return true;
            }
        }
        return false;
    }
	
	/**
     * Gets the password2 value.
     * 
     * @return the password2 value as an integer
     */
	public int get()
	{
		return password2;
	}
}
