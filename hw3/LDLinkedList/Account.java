/**
*
*@author Ahmet Furkan Ekinci - 200104004063
*
*/

package LDLinkedList;

/**
*
* This class is Account class.
*
*/

public class Account 
{
	private int 		 					accountId; 
	private int 		 					numberPost;
	private int 							numberMessages;
	private int			 					numberLikes;
	private int 		 					numberComments;
	private boolean		 					control; 
	private boolean		 					controlView;  
	private boolean		 					controlInteraction; 
	private String		 					username;
	private String		 					birthDate;
	private String 		 					location;
	private LDLinkedList<Post> 				posts;
	private LDLinkedList<Message>			messages;
	private LDLinkedList<String> 	 		following;
	private LDLinkedList<String> 	 		followers;
	private LDLinkedList<String> 	 		blockUsers;
	private LDLinkedList<String> 			history;
	
   /**
    *This is a four parameter constructor
    *
    *@param id is a ID for account class.
    *@param name is variable that hold name of person.
    *@param birth is variable that hold birthdate of person.
    *@param place is variable that hold place of birth.
    *
    */
	public Account(int id, String name, String birth, String place)
	{
		this.accountId = id;
		this.numberPost = 0;
		this.numberMessages = 0;
		this.numberLikes = 0;
		this.numberComments = 0;
		this.controlView = false;
		this.control = false;
		this.controlInteraction = false;
		this.username = name;
		this.birthDate = birth;
		this.location = place;
		this.posts = new LDLinkedList<>();
		this.messages = new LDLinkedList<>(); 
		this.following = new  LDLinkedList<>();
		this.followers = new  LDLinkedList<>();
		this.blockUsers = new LDLinkedList<>();
		this.history = new LDLinkedList<>();
	}
	
   /**
    *This is login method to account.
    *
    *@param people is a object of Account class' array as a paramete for this method.
    *@param index is a int parameter that hold how many people there is in people array.
    *
    */
	public void Login(LDLinkedList<Account> people, int index)
	{
		int flagControl = 0;
		for (int i = 0; i < index; i++)  //Checks to see if an account is currently open.
	    {
			if (people.get(i).control == true)
	        {
				flagControl++;
	        }
	    }
	    if (flagControl == 0) // if flag == 0 there is no any open account now.
	    {
	    	control = true;
	    }
	    else
	    {
	    	System.out.println("You can not Login because There is another account now...\n");
	    }
	       
	}
	
   /**
    *This is logout method from the account.
    *
    */
   
	public void Logout()
	{
		if (control == true)
		{
			control = false;
			controlView = false;
			controlInteraction = false;
		}
		else
		{
			System.out.println("You can not this because you did not enter to this account!!!\n");
		}
	}
	
   /**
    *This method views profile of object in parameter.
    *
    *@param person is a object of Account class as a paramete for this method.
    *
    */
	public void ViewProfile(Account person)
	{
		if (control == true)
		{
			if (this.isBlocked(person) == false)
			{
				System.out.println("User ID: " + person.accountId);
				System.out.println("Username: " + person.username);
				System.out.println("Location: " + person.location);
				System.out.println("Birth Date: " + person.birthDate);
				System.out.println(person.username + " is following " + person.following.size() + " account(s) and has " + person.followers.size() + " follower(s)");
				if (person.following.size() != 0)
				{
					System.out.print(person.username + " is following: ");
	               for (int i = 0; i < person.following.size(); i++)
	               {
	                   System.out.print(person.following.get(i) + ", ");
	               }
	               System.out.println("");
				}
				if (person.followers.size() != 0)
				{
					System.out.print("The followers of " + person.username + " are: ");
					for (int i = 0; i < person.followers.size(); i++)
					{
						System.out.print(person.followers.get(i) + ", ");
					}
					System.out.println("");
				}
				System.out.println(person.username + " has " + person.numberPost + " post(s)");
				System.out.println("\n\n");
				person.controlView = true;
			}
			else
			{
				System.out.println("This account is blocked...\n");
			}
		}
		else
		{
			System.out.println("You can not this because you did not enter to this account!!!\n");
		}
		person.controlInteraction = false;
		this.controlInteraction = false;
	}
	
   /**
    *This method views posts of object in parameter.
    *
    *@param person is a object of Account class as a paramete for this method.
    *
    */
	public void ViewingPosts(Account person)
	{
		if (control == true)
		{
			if (this.isBlocked(person) == false)
			{
				if (person.controlView == true)
				{
					for (int i = 0; i < person.numberPost; i++)
					{
						System.out.println(person.posts.get(i).printPost(person));
					}
					System.out.println("\n\n");
					person.controlInteraction = true;
				}
				else
				{
					System.out.println("You can not this because you did not enter View Profile of " + person.username + "!!!\n");
				}
			}
			else
			{
				System.out.println("This account is blocked...\n");
			}
		}
		else
		{
			System.out.println("You can not this because you did not enter to this account!!!\n");
		}
	}
	
   /**
    *This method views posts' interactions of object in parameter.
    *
    *@param person is a object of Account class as a paramete for this method.
    *@param people is a object of account class' array.
    *@param numberPeople is a integer variable that hold how many person there is in people object array.
    *
    */
	public void ViewingPostInteractions(Account person, LDLinkedList<Account> people, int numberPeople)
	{
		if (control == true)
		{
           if (this.isBlocked(person) == false)
           {
				if (person.controlInteraction == true)
				{
					if (person.numberPost > 0)
					{
						for (int i = 0; i < person.numberPost; i++)
						{
							person.posts.get(i).PrintPostInteractions(people, numberPeople);
						}
					}
					else
					{
						System.out.println("There is no any post in here...\n");
					}
				}
				else
				{
					System.out.println("You are not in " + person.username + "'s posts\n");
				}
           }
           else
           {
        	   System.out.println("This account is blocked...\n");
           }
		}
		else
		{
			System.out.println("You can not this because you did not enter to this account!!!\n");
		}
	}
	
   /**
    *This method shares post for an object.
    *
    *@param postContext is a object of String. This object provide to share a post. It include the text of post...
    *
    */
	public void SharePost(String postContext)
	{
		if (control == true)
		{
			numberPost++;
			posts.add(new Post(numberPost, accountId, postContext));
			history.add("You posted: " + postContext);
		}
		else
		{
			System.out.println("You can not this because you did not enter to this account!!!\n");
		}
		this.controlInteraction = false;
		this.controlView = false;
	}
	
   /**
    *This method comments to post for an object.
    *
    *@param person is a object of Account class as a paramete for this method.
    *@param index is a variable. It holds you want to comment which post.
    *@param content is a object of String. This object provide to make a comment to sharing. It include the text of post...
    *
    */
	public void CommentPost(Account person, int index, String content)
	{
		if (control == true)
		{
			if (person.controlInteraction == true)
			{
				if (this.isBlocked(person) == false)
				{
					if (person.controlInteraction == true)
					{
						if (index < person.posts.size())
						{
							numberComments++;
							person.posts.get(index).ForComment(numberComments, this.accountId, person.posts.get(index).PostId(), content);
							this.history.add( "You commented " + person.GetName() + "'s post id: " + person.posts.get(index).PostId());
							person.history.add(this.GetName() + " commented your post. Post id: " + person.posts.get(index).PostId());
						}
						else
						{
							System.out.println("This index is not in posts of that person!!!\n");
						}
					}
					else
					{
						System.out.println("You are not in " + person.username + "'s posts\n");
					}
				}
				else
				{
					System.out.println("This account is blocked...\n");
				}
			}
			else
			{
				System.out.println("You are not in " + person.username + "'s posts\n");
			}
		}
		else
		{
			System.out.println("You can not this because you did not enter to this account!!!\n");
		}
	}
	
		/**
	    *This method uncomments from post for an object.
	    *
	    *@param person is a object of Account class as a paramete for this method.
	    *@param index is a variable. It holds you want to comment which post.
	    *
	    */
		public void UncommentPost(Account person, int index)
		{
			if (control == true)
			{
				if (person.controlInteraction == true)
				{
					if (this.isBlocked(person) == false)
					{
						if (person.controlInteraction == true)
						{
							if (index < person.posts.size())
							{
								numberComments--;
								person.posts.get(index).ForUncomment(this.accountId);
								this.history.add("You uncommented " + person.GetName() + "'s post id: " + person.posts.get(index).PostId());
								person.history.add(this.GetName() + " uncommented your post. Post id: " + person.posts.get(index).PostId());
							}
							else
							{
								System.out.println("This index is not in posts of that person!!!\n");
							}
						}
						else
						{
							System.out.println("You are not in " + person.username + "'s posts\n");
						}
					}
					else
					{
						System.out.println("This account is blocked...\n");
					}
				}
				else
				{
					System.out.println("You are not in " + person.username + "'s posts\n");
				}
			}
			else
			{
				System.out.println("You can not this because you did not enter to this account!!!\n");
			}
		}
	
   /**
    *This method like to post for an object.
    *
    *@param person is a object of Account class as a paramete for this method.
    *@param index is a variable. It holds you want to comment which post.
    *
    */
	public void LikePost(Account person, int index)
	{
		if (control == true)
		{
			if (person.controlInteraction == true)
			{
				if (this.isBlocked(person) == false)
				{
					if (person.controlInteraction == true)
					{	
						if (index < person.posts.size())
						{
							person.numberLikes++;
							person.posts.get(index).ForLike(numberLikes, this.accountId, person.posts.get(index).PostId());
							this.history.add("You liked " + person.GetName() + "'s post id: " + person.posts.get(index).PostId());
							person.history.add(this.GetName() + " liked your post. Post id: " + person.posts.get(index).PostId());
						}
						else
						{
							System.out.println("This index is not in posts of that person!!!\n");
						}
					}
					else
					{
						System.out.println("You are not in " + person.username + "'s posts\n");
					}
				}
				else
				{
					System.out.println("This account is blocked...\n");
				}
			}
			else
			{
				System.out.println("You are not in " + person.username + "'s posts\n");
			}
		}
		else
		{
			System.out.println("You can not this because you did not enter to this account!!!\n");
		}	
	}
	
		/**
	    *This method unlike to post for an object.
	    *
	    *@param person is a object of Account class as a paramete for this method.
	    *@param index is a variable. It holds you want to comment which post.
	    *
	    */
		public void UnlikePost(Account person, int index)
		{
			int flagControl = 0;
			if (control == true)
			{
				if (person.controlInteraction == true)
				{
					
					if (flagControl == 0)
					{
						if (person.controlInteraction == true)
						{	
							if (index < person.posts.size())
							{
								person.numberLikes--;
								person.posts.get(index).ForUnlike(this.accountId);
								this.history.add("You unliked " + person.GetName() + "'s post id: " + person.posts.get(index).PostId());
								person.history.add(this.GetName() + " unliked your post. Post id: " + person.posts.get(index).PostId());
							}
							else
							{
								System.out.println("This index is not in posts of that person!!!\n");
							}
						}
						else
						{
							System.out.println("You are not in " + person.username + "'s posts\n");
						}
					}
					else
					{
						System.out.println("This account is blocked...\n");
					}
				}
				else
				{
					System.out.println("You are not in " + person.username + "'s posts\n");
				}
			}
			else
			{
				System.out.println("You can not this because you did not enter to this account!!!\n");
			}	
		}
	
	
	
   /**
    *This method follow the account for an object.
    *
    *@param person is a object of Account class as a paramete for this method.
    *
    */
	public void FollowPerson(Account person)
	{
		if (control == true)
		{
			if (this.isBlocked(person) == false)
			{
				if (this.GetName() != person.GetName())
				{
					this.following.add(person.GetName());
					person.followers.add(this.GetName());
					this.history.add("You followed " + person.GetName());
					person.history.add("You are followed by " + this.GetName());
				}
				else
				{
					System.out.println("The account can not follow itself...\n");
				}
			}
			else
			{
				System.out.println("This account is blocked...\n");
			}
		}
		else
		{
			System.out.println("You can not this because you did not enter to this account!!!\n");
		}
		this.controlInteraction = false;
		this.controlView = false;
		person.controlInteraction = false;
		person.controlView = false;
	}
	
	/**
	 *This method follow the account for an object.
	 *
	 *@param person is a object of Account class as a paramete for this method.
	 *
	 */
	 public void UnfollowPerson(Account person)
	 {
		 int flag = 0;
		 for (int i = 0; i < following.size(); i++)
		 {
			 if (following.get(i) == person.GetName())
			 {
				 flag++;
				 break;
			 }
		 }
		 if (flag != 0)
		 {	 
			 for (int i = 0; i < following.size(); i++)
			 {
				 if (this.following.get(i) == person.GetName())
				 {
					 this.following.remove(i);
				 }
			 }
			 
			 for (int i = 0; i < person.followers.size(); i++)
			 {
				 if (person.followers.get(i) == this.GetName())
				 {
					 person.followers.remove(i);
				 }
			 }
			 this.history.add("You unfollowed " + person.GetName());
			 person.history.add("You are unfollowed by " + this.GetName()) ;
		 }
		 else
		 {
			 System.out.println("You did not follow this account.!!");
		 }
	 }
	
   /**
    *This method sends a message for an object to another object.
    *
    *@param person is a object of Account class as a paramete for this method.
    *@param content is a object of String. It holds a text for messsage...
    *
    */
	public void SendMessage(Account person, String content)
	{
		int flag = 0;
		if (control == true)
		{
           if (this.isBlocked(person) == false)
           {
               for (int i = 0; i < following.size(); i++)
               {
                   if (person.GetName() == following.get(i))
                   {
                       this.numberMessages++;
                       person.numberMessages++;
                       this.messages.add(new Message(this.numberMessages, this.accountId, person.accountId, content));
                       person.messages.add(new Message(person.numberMessages, this.accountId, person.accountId, content));
                       flag = 1;
                       break;
                   }
               }
               if (flag == 0)
               {
                   System.out.println("You did not follow this account so you can not send a message.!!!\n");
               }
           }
           else
           {
               System.out.println("This account is blocked...\n");
           }
		}
		else
		{
			System.out.println("You can not this because you did not enter to this account!!!\n");
		}
		this.controlInteraction = false;
		this.controlView = false;
		person.controlInteraction = false;
		person.controlView = false;
	}
	
   /**
    *This method checks outbox for an object.
    *
    */
	public void CheckingOutbox()
	{
		if (control == true)
		{
			System.out.println("-----  Checking outbox  -----");
			int counter = 0;
			
			if (this.numberMessages > 0)
			{
				for (int i = 0; i < this.numberMessages; i++)
				{
					if (this.accountId == this.messages.get(i).GetSenderId())
					{
						counter++;
					}
				}
			}
			System.out.println("There is/are " + counter + " message(s) in the outbox.\n");
		}
		else
		{
			System.out.println("You can not this because you did not enter to this account!!!\n");
		}
	}
	
   /**
    *This method checks inbox for an object.
    *
    */
	public void CheckingInbox()
	{	
		if (control == true)
		{
			System.out.println("----- Checking inbox  -----");
			int counter = 0;
			
			if (this.numberMessages > 0)
			{
				for (int i = 0; i < this.numberMessages; i++)
				{
					if (this.accountId == this.messages.get(i).GetReceiverId())
					{
						counter++;
					}
				}
			}
			System.out.println("There is/are " + counter + " message(s) in the inbox.\n");
		}
		else
		{
			System.out.println("You can not this because you did not enter to this account!!!\n");
		}
	}
	
   /**
    *This method views outbox for an object.
    *
    *@param people is a object of account class' array.
    *@param index is a integer variable. It holds how many person there is in people array.
    *
    */
	public void ViewingOutbox(LDLinkedList<Account> people, int index)
	{
		if (control == true)
		{
			System.out.println("        Viewing outbox");
			System.out.println("--------------------------------");
			for (int i = 0; i < this.numberMessages; i++)
			{
				if (this.accountId == this.messages.get(i).GetSenderId())
				{
					System.out.println(this.messages.get(i).toString());
					for (int j = 0; j < index; j++)
					{
						// is same sender id and people.accountid ?
						if (this.messages.get(i).GetSenderId() == people.get(j).GetAccountId())
						{
							System.out.println("From: " + people.get(j).GetName());
						}
						// is same receiver id and people.accountid ?
						if (this.messages.get(i).GetReceiverId() == people.get(j).GetAccountId())
						{
							System.out.println("To: " + people.get(j).GetName());
						}
					}
				}
			}
			System.out.println("--------------------------------\n\n");
		}
		else
		{
			System.out.println("You can not this because you did not enter to this account!!!\n");
		}
	}
	
   /**
    *This method views inbox for an object.
    *
    *@param people is a object of account class' array.
    *@param index is a integer variable. It holds how many person there is in people array.
    *
    */
	public void ViewingInbox(LDLinkedList<Account> people, int index)
	{
		if (control == true)
		{
			System.out.println("        Viewing inbox");
			System.out.println("--------------------------------");
			for (int i = 0; i < this.numberMessages; i++)
			{
				if (this.accountId == this.messages.get(i).GetReceiverId())
				{
					System.out.println(this.messages.get(i).toString());
					for (int j = 0; j < index; j++)
					{
						// is same sender id and people.accountid ?
						if (this.messages.get(i).GetSenderId() == people.get(j).GetAccountId())
						{
							System.out.println("From: " + people.get(j).GetName());
						}
						// is same receiver id and people.accountid ?
						if (this.messages.get(i).GetReceiverId() == people.get(j).GetAccountId())
						{
							System.out.println("To: " + people.get(j).GetName());
						}
					}
				}
			}
			System.out.println("--------------------------------\n\n");
		}
		else
		{
			System.out.println("You can not this because you did not enter to this account!!!\n");
		}
	}
	
   /**
    *This method blocks users for an object.
    *
    *@param person is a object of Account. It holds a person.
    *
    */
	public void BlockUsers(Account person)
	{
		if (control == true)
		{
			this.blockUsers.add(person.GetName());
			// if an account block any person then they can not follow each other..
			for (int i = 0; i < following.size(); i++)
			{
				if (this.following.get(i) == person.GetName())
				{
					this.following.remove(i);
					break;
				}
			}
			for (int i = 0; i < followers.size(); i++)
			{
				if (this.followers.get(i) == person.GetName())
				{
					this.followers.remove(i);
					break;
				}
			}
			for (int i = 0; i < person.following.size(); i++)
			{
				if (person.following.get(i) == this.GetName())
				{
					person.following.remove(i);
					break;
				}
			}
			for (int i = 0; i < person.followers.size(); i++)
			{
				if (person.followers.get(i) == this.GetName())
				{
					person.followers.remove(i);
					break;
				}
			}
		}
		else
		{
			System.out.println("You can not this because you did not enter to this account!!!\n");
		}
		this.controlInteraction = false;
		this.controlView = false;
	}
	
	/**
	    *This method unblocks users for an object.
	    *
	    *@param person is a object of Account. It holds a person.
	    *
	    */
		public void UnblockUsers(Account person)
		{
			if (control == true)
			{
				int flag = 0;
				for (int i = 0; i < blockUsers.size(); i++)
				{
					if (blockUsers.get(i) == person.GetName())
					{
						flag++;
						break;
					}
				}
				if (flag != 0)
				{
					for (int i = 0; i < blockUsers.size(); i++)
					{
						if (blockUsers.get(i) == person.GetName())
						{
							this.blockUsers.remove(i);
							break;
						}
					}
				}
				else
				{
					System.out.println("You did not block this name!!!\n");
				}
			}
			else
			{
				System.out.println("You can not this because you did not enter to this account!!!\n");
			}
			this.controlInteraction = false;
			this.controlView = false;
		}
		
		/**
		*This method print history of account..
		*
	    */
		public void ActionHistory()
		{
		    System.out.println("-------------------------------------------------------------");
			for (int i = 0; i < history.size(); i++)
			{
				System.out.println(history.get(i));
			}
            System.out.println("-------------------------------------------------------------\n\n");
		}
		
		/**
		 * This method control whether account is blocked or not
		 * 
		 * @param person is a object of account.
         * @return a boolean value
		 * 
		 */
		 public boolean isBlocked(Account person)
		 {
			 for (int i = 0; i < blockUsers.size(); i++)
				{
					if (person.GetName() == blockUsers.get(i))
					{
						return true;
					}
				}
            for (int i = 0; i < person.blockUsers.size(); i++)
            {
                if (this.GetName() == person.blockUsers.get(i))
                {
                    return true;
                }
            }
            return false;
		 }
	
	   /**
	    *This method return username.
	    *
	    *@return This method return a String. This String includes a username of this object.
	    *
	    */
		public String GetName()
		{
			return username;
		}
	
	   /**
	    *This method return account id.
	    *
	    *@return This method return a integer value. This value includes id of account.
	    *
	    */
		public int GetAccountId()
		{
			return (this.accountId);
		}	
}
