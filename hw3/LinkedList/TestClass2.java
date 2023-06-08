/**
*
*@author Ahmet Furkan Ekinci - 200104004063
*
*/

package LinkedList;

import java.util.LinkedList;

/**
*
* This class is TestClass2 class.
*
*/

public class TestClass2
{
   /**
    * Default constructor for creating TestClass2 objects without parameters.
    */
   public TestClass2(){}
   
   /**
    *The main method of the program.
    *
    *@param args is a String[] parameter.
    *
    */
   public static void main(String[] args)
   {
	   LinkedList<Account> account = new LinkedList<>();
       System.out.println("1) An acoount with username gizemsungu has been created.");
       account.add(new Account(1, "gizemsungu", "13.01.1993", "Antalya"));
       System.out.println("   An acoount with username sibelgulmez has been created.");
       account.add(new Account(2, "sibelgulmez", "10.03.1995", "Istanbul"));
       System.out.println("   An acoount with username gokhankaya has been created.");
       account.add(new Account(3, "gokhankaya", "10.23.1984", "Erzincan"));
       System.out.println("\n");
       
       System.out.println("2)  Logging into an account (username: sibelgulmez) ...");
       account.get(1).Login(account, 3);
       System.out.println("\n");
       
       System.out.println("3)  Sharing two posts...\n");
       account.get(1).SharePost("BESIKTAS");
       account.get(1).SharePost("LOVE");
       System.out.println("4)  Following gizemsungu and gokhankaya\n\n");
       account.get(1).FollowPerson(account.get(2));
       account.get(1).FollowPerson(account.get(0));
       System.out.println("5)  Logging out from account 'sibelgulmez'\n\n");
       account.get(1).Logout();
       System.out.println("6)  Logging into another account (username: gokhankaya) ...\n");
       account.get(2).Login(account, 3);
       System.out.println("7)  Viewing sibelgulmez's profile ...\n");
       account.get(2).ViewProfile(account.get(1));
       System.out.println("8)  Viewing sibelgulmez's posts ...\n");
       account.get(2).ViewingPosts(account.get(1));
       System.out.println("9)  Liking a post of sibelgulmez ...\n");
       account.get(2).LikePost(account.get(1), 0);
       System.out.println("10)  Adding a comment on a post of sibelgulmez...\n");
       account.get(2).CommentPost(account.get(1), 0, "The club is really amazing...");
       System.out.println("11)  Following sibelgulmez and gizemsungu...\n");
       account.get(2).FollowPerson(account.get(0));
       account.get(2).FollowPerson(account.get(1));
       System.out.println("12)  Sending a message to gizemsungu...\n");
       account.get(2).SendMessage(account.get(0), "Hi Gizem..");
       System.out.println("13)  Logging out from account 'gokhankaya'...\n");
       account.get(2).Logout();
       System.out.println("14)  Logging into another account (username: gizemsungu)...\n");
       account.get(0).Login(account, 3);
       account.get(0).CheckingOutbox();
       account.get(0).CheckingInbox();
       account.get(0).ViewingOutbox(account, 3);
       account.get(0).ViewingInbox(account, 3);
       System.out.println("18)  Viewing sibelgulmez's profile...\n");
       account.get(0).ViewProfile(account.get(1));
       System.out.println("19)  Viewing sibelgulmez's posts...\n");
       account.get(0).ViewingPosts(account.get(1));
       System.out.println("20)  Viewing sibelgulmez's posts' interactions...\n");
       account.get(0).ViewingPostInteractions(account.get(1), account, 3);
       System.out.println("21)  Liking sibelgulmez's posts...\n");
       account.get(0).LikePost(account.get(1), 0);
       account.get(0).LikePost(account.get(1), 1);
       System.out.println("22)  Viewing sibelgulmez's posts' interactions...\n");
       account.get(0).ViewingPostInteractions(account.get(1), account, 3);
       System.out.println("23)  Logging out from account 'gizemsungu'...\n");
       account.get(0).Logout();
       System.out.println("24)  Logging into another account 'gizemsungu'...\n");
       account.get(0).Login(account, 3);
       System.out.println("25)  Share two post from account of 'gizemsungu'\n");
       account.get(0).SharePost("This homework is too easy...");
       account.get(0).SharePost("I am sure that this homework is so nice..");
       System.out.println("26)  Logging out from account of 'gizemsungu'\n");
       account.get(0).Logout();
       System.out.println("27)  Logging into another account 'sibelgulmez'\n");
       account.get(1).Login(account, 3);
       System.out.println("28)  Views post to account of 'gizemsungu'");
       account.get(1).ViewingPosts(account.get(0));
       System.out.println("29)  Views the profile of 'gizemsungu'\n");
       account.get(1).ViewProfile(account.get(0));
       System.out.println("30)  Like  post which in account of 'gizemsungu'...");
       account.get(1).LikePost(account.get(0), 0);
       System.out.println("31)  Views the posts of 'gizemsungu'\n");
       account.get(1).ViewingPosts(account.get(0));
       System.out.println("32)  Like  post which in account of 'gizemsungu'...");
       account.get(1).LikePost(account.get(0), 0);
       System.out.println("33)  Views the posts of 'gizemsungu'\n");
       account.get(1).ViewingPosts(account.get(0));
       System.out.println("34)  Views theinteraction of posts of 'gizemsungu'\n");
       account.get(1).ViewingPostInteractions(account.get(0), account, 3);
       System.out.println("35)  Logging out from account of 'sibelgulmez'\n");
       account.get(1).Logout();
       System.out.println("36)  Logging into account of 'gokhankaya'\n");
       account.get(2).Login(account, 3);
       System.out.println("37)  Views the profile of 'gizemsungu'\n");
       account.get(2).ViewProfile(account.get(0));
       System.out.println("38)  Comment post2 of 'gizemsungu'\n");
       account.get(2).CommentPost(account.get(0), 1, "Yess, you should grade as 120 :)");
       System.out.println("39)  Views the posts of 'gizemsungu'\n");
       account.get(2).ViewingPosts(account.get(0));
       System.out.println("40)  Comment post2 of 'gizemsungu'\n");
       account.get(2).CommentPost(account.get(0), 1, "Yess, you should grade as 120 :)");
       System.out.println("41)  View the interactions of gizemsungu's posts...");
       account.get(2).ViewingPostInteractions(account.get(0), account, 3);
       System.out.println("42)  Send a message to 'gizemsungu'\n");
       account.get(2).SendMessage(account.get(0), "Please be understanding when checking homework.. ");
       System.out.println("43)  Logging out from account of 'gokhankaya'\n");
       account.get(2).Logout();
       System.out.println("44)  Logging into 'gizemsungu' account..\n");
       account.get(0).Login(account, 3);
       System.out.println("45)  View the profile of 'gizemsungu'\n");
       account.get(0).ViewProfile(account.get(0));
       System.out.println("46)  Check inbox and outbox..\n");
       account.get(0).CheckingOutbox();
       account.get(0).CheckingInbox();
       System.out.println("47)  View inbox and outbox..\n");
       account.get(0).ViewingOutbox(account, 3);
       account.get(0).ViewingInbox(account, 3);
       System.out.println("48)  Logging out from account of 'gizemsungu'\n");
       account.get(0).Logout();
   }

}
