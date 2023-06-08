/**
 *
 *@author Ahmet Furkan Ekinci - 200104004063
 *
 */

package homework1;

/**
 *
 * This class is Account class.
 *
 */

public class Account 
{
	private int 		 accountId;  //accountId[0] = accountId        accountId[1] = post sayisi...
	private int 		 numberPost;
	private int 		 numberMessages;
	private int 		 numberFollowing;
	private int 		 numberFollowers;
	private int			 numberLikes;
	private int 		 numberComments;
	private int			 numberBlocks;
	private boolean		 control; // bu hesapta mıyız kontrolü yapar
	private boolean		 controlView;  // her fonksiyon icersine koyuucam controlView = false;  viewingPost;
	private boolean		 controlInteraction; // Postlara mı bakıyoruz kontrolü yapar
	private String		 username;
	private String		 birthDate;
	private String 		 location;
	private Post[] 		 posts;
	private Message[]	 messages;
	private String[]	 following;
	private String[]	 followers;
	private String[]	 blockUsers;
	
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
		this.numberFollowing = 0;
		this.numberFollowers = 0;
		this.numberLikes = 0;
		this.numberComments = 0;
		this.numberBlocks = 0;
		this.controlView = false;
		this.control = false;
		this.controlInteraction = false;
		this.username = name;
		this.birthDate = birth;
		this.location = place;
		this.posts = new Post[0];
		this.messages = new Message[0]; 
		this.following = new String[0];
		this.followers = new String[0];
		this.blockUsers = new String[0];
	}
	
    /**
     *This is login method to account.
     *
     *@param people is a object of Account class' array as a paramete for this method.
     *@param index is a int parameter that hold how many people there is in people array.
     *
     */
	public void Login(Account[] people, int index)
	{
        int flagControl = 0;
        for (int i = 0; i < index; i++)
        {
            if (people[i].control == true)
            {
                flagControl++;
            }
        }
        if (flagControl == 0)
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
		int flagControl = 0;
		
		if (control == true)
		{
			for (int i = 0; i < blockUsers.length; i++)
			{
				if (person.GetName() == blockUsers[i])
				{
					flagControl++;
					break;
				}
			}
            for (int i = 0; i < person.blockUsers.length; i++)
            {
                if (this.GetName() == person.blockUsers[i])
                {
                    flagControl++;
                    break;
                }
            }
			if (flagControl == 0)
			{
				System.out.println("User ID: " + person.accountId);
				System.out.println("Username: " + person.username);
				System.out.println("Location: " + person.location);
				System.out.println("Birth Date: " + person.birthDate);
				System.out.println(person.username + " is following " + person.following.length + " account(s) and has " + person.followers.length + " follower(s)");
				if (person.following.length != 0)
				{
					System.out.print(person.username + " is following: ");
                    for (int i = 0; i < person.numberFollowing; i++)
                    {
                        System.out.print(person.following[i] + ", ");
                    }
                    System.out.println("");
				}
				if (person.followers.length != 0)
				{
					System.out.print("The followers of " + person.username + " are: ");
                    for (int i = 0; i < person.numberFollowers; i++)
                    {
                        System.out.print(person.followers[i] + ", ");
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
		int flagControl = 0;
		if (control == true)
		{
			for (int i = 0; i < blockUsers.length; i++)
			{
				if (person.GetName() == blockUsers[i])
				{
					flagControl++;
					break;
				}
			}
            for (int i = 0; i < person.blockUsers.length; i++)
            {
                if (this.GetName() == person.blockUsers[i])
                {
                    flagControl++;
                    break;
                }
            }
			if (flagControl == 0)
			{
				if (person.controlView == true)
				{
					for (int i = 0; i < person.numberPost; i++)
					{
						System.out.println(person.posts[i].printPost(person));
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
	public void ViewingPostInteractions(Account person, Account[] people, int numberPeople)
	{
		int flagControl = 0;
		if (control == true)
		{
			for (int i = 0; i < blockUsers.length; i++)
			{
				if (person.GetName() == blockUsers[i])
				{
					flagControl++;
					break;
				}
			}
            for (int i = 0; i < person.blockUsers.length; i++)
            {
                if (this.GetName() == person.blockUsers[i])
                {
                    flagControl++;
                    break;
                }
            }
			if (flagControl == 0)
			{
				if (person.controlInteraction == true)
				{
					if (person.numberPost > 0)
					{
						for (int i = 0; i < person.numberPost; i++)
						{
							person.posts[i].PrintPostInteractions(people, numberPeople);
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
			Post[] dummy = new Post[numberPost];
			for (int i = 0; i < posts.length; i++)
			{
				dummy[i] = posts[i];
			}
			Post temp = new Post(numberPost, accountId, postContext);
			dummy[numberPost - 1] = temp;
			posts = dummy;
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
		int flagControl = 0;
		if (control == true)
		{
			if (person.controlInteraction == true)
			{
				for (int i = 0; i < blockUsers.length; i++)
				{
					if (person.GetName() == blockUsers[i])
					{
						flagControl++;
						break;
					}
				}
                for (int i = 0; i < person.blockUsers.length; i++)
                {
                    if (this.GetName() == person.blockUsers[i])
                    {
                        flagControl++;
                        break;
                    }
                }
				if (flagControl == 0)
				{
					if (person.controlInteraction == true)
					{
						if (index < person.posts.length)
						{
							numberComments++;
							person.posts[index].ForComment(numberComments, this.accountId, person.posts[index].PostId(), content);
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
		int flagControl = 0;
		if (control == true)
		{
			if (person.controlInteraction == true)
			{
				for (int i = 0; i < blockUsers.length; i++)
				{
					if (person.GetName() == blockUsers[i])
					{
						flagControl++;
						break;
					}
				}
                for (int i = 0; i < person.blockUsers.length; i++)
                {
                    if (this.GetName() == person.blockUsers[i])
                    {
                        flagControl++;
                        break;
                    }
                }
				if (flagControl == 0)
				{
					if (person.controlInteraction == true)
					{	
						if (index < person.posts.length)
						{
							person.numberLikes++;
							person.posts[index].ForLike(numberLikes, this.accountId, person.posts[index].PostId());
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
		int flagControl = 0;
		if (control == true)
		{
			for (int i = 0; i < blockUsers.length; i++)
			{
				if (person.GetName() == blockUsers[i])
				{
					flagControl++;
					break;
				}
			}
            for (int i = 0; i < person.blockUsers.length; i++)
            {
                if (this.GetName() == person.blockUsers[i])
                {
                    flagControl++;
                    break;
                }
            }
			if (flagControl == 0)
			{
				this.numberFollowing++;
				person.numberFollowers++;
				String[] dummy = new String[this.numberFollowing];
				String[] dummy2 = new String[person.numberFollowers];
				for (int i = 0; i < following.length; i++)
				{
					dummy[i] = following[i];
				}
				for (int i = 0; i < person.followers.length; i++)
				{
					dummy2[i] = person.followers[i];
				}
				dummy2[person.numberFollowers - 1] = this.GetName();
				person.followers = dummy2;
				dummy[this.numberFollowing - 1] = person.GetName();
				this.following = dummy;
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
     *This method sends a message for an object to another object.
     *
     *@param person is a object of Account class as a paramete for this method.
     *@param content is a object of String. It holds a text for messsage...
     *
     */
	public void SendMessage(Account person, String content)
	{
        int flagControl = 0;
		int flag = 0; //takip ediliyor mu edilmiyor mu kontrol etmek için koyuyorum bunu
		if (control == true)
		{
            for (int i = 0; i < blockUsers.length; i++)
            {
                if (person.GetName() == blockUsers[i])
                {
                    flagControl++;
                    break;
                }
            }
            for (int i = 0; i < person.blockUsers.length; i++)
            {
                if (this.GetName() == person.blockUsers[i])
                {
                    flagControl++;
                    break;
                }
            }
            if (flagControl == 0)
            {
                for (int i = 0; i < following.length; i++)
                {
                    if (person.GetName() == following[i])
                    {
                        this.numberMessages++;
                        person.numberMessages++;
                        Message[] dummy = new Message[this.numberMessages];
                        Message[] dummy2 = new Message[person.numberMessages];
                        if (this.numberMessages > 1)
                        {
                            for (int j = 0; j < this.numberMessages - 1; j++)
                            {
                                dummy[j] = this.messages[j];
                            }
                        }
                        if (person.numberMessages > 1)
                        {
                            for (int j = 0; j < person.numberMessages - 1; j++)
                            {
                                dummy2[j] = person.messages[j];
                            }
                        }
                        Message temp = new Message(this.numberMessages + person.numberMessages - 1, this.accountId, person.accountId, content);
                        dummy[this.numberMessages - 1] = temp;
                        dummy2[person.numberMessages - 1] = temp;
                        this.messages = dummy;
                        person.messages = dummy2;
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
					if (this.accountId == this.messages[i].GetSenderId())
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
					if (this.accountId == this.messages[i].GetReceiverId())
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
	public void ViewingOutbox(Account[] people, int index)
	{
		if (control == true)
		{
			System.out.println("        Viewing outbox");
			System.out.println("--------------------------------");
			for (int i = 0; i < this.numberMessages; i++)
			{
				if (this.accountId == this.messages[i].GetSenderId())
				{
					System.out.println(this.messages[i].toString());
					for (int j = 0; j < index; j++)
					{
						if (this.messages[i].GetSenderId() == people[j].GetAccountId())
						{
							System.out.println("From: " + people[j].GetName());
						}
						if (this.messages[i].GetReceiverId() == people[j].GetAccountId())
						{
							System.out.println("To: " + people[j].GetName());
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
	public void ViewingInbox(Account[] people, int index)
	{
		if (control == true)
		{
			System.out.println("        Viewing inbox");
			System.out.println("--------------------------------");
			for (int i = 0; i < this.numberMessages; i++)
			{
				if (this.accountId == this.messages[i].GetReceiverId())
				{
					System.out.println(this.messages[i].toString());
					for (int j = 0; j < index; j++)
					{
						if (this.messages[i].GetSenderId() == people[j].GetAccountId())
						{
							System.out.println("From: " + people[j].GetName());
						}
						if (this.messages[i].GetReceiverId() == people[j].GetAccountId())
						{
							System.out.println("To: " + people[j].GetName());
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
     *@param name is a object of String. It holds a text. There is a name inside that text.
     *
     */
	public void BlockUsers(String name)
	{
		if (control == true)
		{
			this.numberBlocks++;
			String[] dummy = new String[numberBlocks];
			for (int i = 0; i < blockUsers.length; i++)
			{
				dummy[i] = blockUsers[i];
			}
			dummy[numberBlocks - 1] = name;
			blockUsers = dummy;
			for (int i = 0; i < following.length; i++)
			{
				if (following[i] == name)
				{
					String temp = following[i];
					following[i] = following[following.length - 1];
					following[following.length - 1] = temp;
					numberFollowing--;
					String[] dummy2 = new String[numberFollowing];
					for (int k = 0; k < numberFollowing; k++)
					{
						dummy2[k] = following[k];
					}
					following = dummy2;
					break;
				}
			}
			for (int i = 0; i < followers.length; i++)
			{
				if (followers[i] == name)
				{
					String temp = followers[i];
					followers[i] = followers[followers.length - 1];
					followers[followers.length - 1] = temp;
					numberFollowers--;
					String[] dummy2 = new String[numberFollowers];
					for (int k = 0; k < numberFollowers; k++)
					{
						dummy2[k] = followers[k];
					}
					followers = dummy2;
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
