/**
 *
 *@author Ahmet Furkan Ekinci - 200104004063
 *
 */

package homework1;

/**
 *
 * This class is Like class.
 *
 */

public class Like extends Interaction
{
    /**
     *
     *This is a three parameter constructor.
     *
     *@param idInteraction is integer variable. It includes id of interaction.
     *@param idAccount is integer variable. It includes id of account.
     *@param idPost is integer variable. It includes id of post.
     *
     */
	public Like(int idInteraction, int idAccount, int idPost)
	{
        super();
		this.interactionId = idInteraction;
		this.accountId = idAccount;
		this.postId = idPost;
	}
	
    /**
     *
     *This method returns an integer value. Also this method overriden from Interaction class.
     *
     *@return This method returns an integer value. This value means account of id.
     *
     */
	@Override
	public int GetAccountId()
	{
		return (this.accountId);
	}
	
}
