/**
*
*@author Ahmet Furkan Ekinci - 200104004063
*
*/

package LinkedList;

import java.util.LinkedList;

/**
*
* This class is Post class.
*
*/

public class Post 
{
	private int					postId;
	private int					accountId;
	private int					numberLikes;
	private int					numberComments;
	private LinkedList<Like>		likes;
	private LinkedList<Comment>	comments;
	private String				content;
	
   /**
    *This is a three parameter constructor
    *
    *@param idPost is a ID for Post class.
    *@param idAccount is variable that hold id of person which shares the post.
    *@param content is variable that hold birthdate of person.
    *
    */
	public Post(int idPost, int idAccount, String content)
	{
		this.postId = idPost;
		this.accountId = idAccount;
		this.content = content;
		this.numberComments = 0;
		this.numberLikes = 0;
		this.likes = new LinkedList<>();
		this.comments = new LinkedList<>();
	}
	
   /**
    *This is a method. This method provide to print post in another place.
    *
    *@param person is a object of Account class as a paramete for this method.
    *
    *@return This method returns a String.
    *
    */
	public String printPost(Account person)
	{
		return ("(PostID: " + postId + ")   " + person.GetName() + ": " + this.content);
	}
	
   /**
    *This is a method. This method provide to print post interactions.
    *
    *@param people is a object of account class' array.
    *@param numberPeople is a integer variable that hold how many person there is in people object array.
    *
    */
	public void PrintPostInteractions(LinkedList<Account> people, int numberPeople)
	{
		System.out.println("(PostID: " + postId + "):   " + this.content);
		if (numberLikes > 0)
		{
			System.out.print("The post was liked by the following account(s) :  ");
			for (int i = 0; i < numberLikes; i++)
			{
				for (int j = 0; j < numberPeople; j++)
				{
					if (likes.get(i).GetAccountId() == people.get(j).GetAccountId())
					{
						System.out.print(people.get(j).GetName());
					}
				}
				System.out.print(", ");
			}
			System.out.println("");
		}
		else
		{
			System.out.println("The post has no likes.");
		}
		if (numberComments > 0)
		{
			System.out.println("The post has " + numberComments + " comment(s)...");
			for (int i = 0; i < numberComments; i++)
			{
				for (int j = 0; j < numberPeople; j++)
				{
					if (comments.get(i).GetAccountId() == people.get(j).GetAccountId())
					{
						System.out.println("Comment " + (i+1) + ": '" + people.get(j).GetName() + "' said '" + comments.get(i).GetContent() + "'");
					}
				}
				System.out.println("");
			}
		}
		else
		{
			System.out.println("The post has no comments.");
		}
		System.out.println("------------------------------------------------------\n");
	}
	
   /**
    *This is a method. This method returns an integer value.
    *
    *@return This method returns an integer value. That value holds id of post.
    *
    */
	public int PostId()
	{
		return (postId);
	}
	
   /**
    *This is a method. This method create a comment for a post.
    *
    *@param idInteraction is an integer variable. It holds id for interaction of post.
    *@param idAccount is an integer variable. It holds id for account which make a comment.
    *@param idPost is an integer variable. It holds id for post which make a comment.
    *@param content is an object of String. It includes a text for comment.
    *
    */
	public void ForComment(int idInteraction, int idAccount, int idPost, String content)
	{
		numberComments++;
		this.comments.add(new Comment(idInteraction, idAccount, idPost, content));
	}
	
		/**
	    *This is a method. This method uncreate a comment for a post.
	    *
	    *@param idAccount is an integer variable. It holds id for account which make a comment.
	    *
	    */
		public void ForUncomment(int idAccount)
		{
			int flag = 0;
			for (int i = 0; i < numberComments; i++)
			{
				if (comments.get(i).accountId == idAccount) 
				{
					flag++;
					break;
				}
			}
			if (flag != 0)
			{
				for (int i = 0; i < numberComments; i++)
				{
					if (comments.get(i).accountId == idAccount)
					{
						this.comments.remove(i);
					}
				}
				numberComments--;
			}
			else 
			{
				System.out.println("You did not comment this post so you can not uncomment for this post.!!");
			}
		}
	
   /**
    *This is a method. This method create a like for a post.
    *
    *@param idInteraction is an integer variable. It holds id for interaction of post.
    *@param idAccount is an integer variable. It holds id for account which make a comment.
    *@param idPost is an integer variable. It holds id for post which make a comment.
    *
    */
	public void ForLike(int idInteraction, int idAccount, int idPost)
	{
		numberLikes++;
		this.likes.add(new Like(idInteraction, idAccount, idPost));
	}
	
	/**
	 *This is a method. This method unlike to a post.
	 *
	 *@param idAccount is an integer variable. It holds id for account which make a comment.
	 *
	 */
	public void ForUnlike(int idAccount)
	{
		int flag = 0;
		for (int i = 0; i < numberLikes; i++)
		{
			if (likes.get(i).accountId == idAccount) 
			{
				flag++;
				break;
			}
		}
		if (flag != 0)
		{
			for (int i = 0; i < numberLikes; i++)
			{
				if (likes.get(i).accountId == idAccount)
				{
					this.likes.remove(i);
				}
			}
			numberLikes--;
		}
		else 
		{
			System.out.println("You did not like this post so you can not unlike for this post.!!");
		}
	}
	
   /**
    *This is a method. This method returns a integer value.
    *
    *@return is an integer value. This value holds id of account.
    *
    */
	public int GetAccountId()
	{
		return (accountId);
	}
	
   /**
    *This is a method. This method returns a integer value.
    *
    *@return is an integer value. This value holds number of likes.
    *
    */
	public int GetNumberLike()
	{
		return (numberLikes);
	}	
}
