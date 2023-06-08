/**
 *
 *@author Ahmet Furkan Ekinci - 200104004063
 *
 */

package homework1;

/**
 *
 * This class is Interaction class.
 *
 */

public class Interaction 
{
    /** The unique identifier of the interaction. */
	protected int interactionId;
    /** The unique identifier of the account that made the interaction. */
	protected int accountId;
    /** The unique identifier of the post that the interaction was made on. */
	protected int postId;
	
    /**
     * Default constructor for creating Interaction objects without parameters.
     */
    public Interaction(){}
    
    /**
     *
     *This method returns an integer value.
     *
     *@return This method returns an integer value. This value includes id of account.
     *
     */
	public int GetAccountId()
	{
		return (this.accountId);
	}
}
