/**
 *
 *@author Ahmet Furkan Ekinci - 200104004063
 *
 */

package homework1;

/**
 *
 * This class is Comment class.
 *
 */

public class Comment extends Interaction
{
	private String content;
	
    /**
     *
     *This is a four parameter constructor.
     *
     *@param idInteraction is integer variable. It includes id of interaction.
     *@param idAccount is integer variable. It includes id of account.
     *@param idPost is integer variable. It includes id of post.
     *@param content is object of String. It includes content of comment.
     *
     */
	public Comment(int idInteraction, int idAccount, int idPost, String content)
	{
        super();
		this.interactionId = idInteraction;
		this.accountId = idAccount;
		this.postId = idPost;
		this.content = content;
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
	
    /**
     *
     *This method returns a String.
     *
     *@return This method returns a String. This value means content of comment.
     *
     */
	public String GetContent()
	{
		return (content);
	}
	
}
