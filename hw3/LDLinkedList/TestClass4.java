/**
*
*@author Ahmet Furkan Ekinci - 200104004063
*
*/

package LDLinkedList;

/**
*
* This class is TestClass4 class.
*
*/
public class TestClass4 {

	   /**
	    * Default constructor for creating TestClass4 objects without parameters.
	    */
	   public TestClass4(){}
	
	   
	   /**
	    *The main method of the program.
	    *
	    *@param args is a String[] parameter.
	    *
	    */
		public static void main(String[] args) 
		{
			LDLinkedList<Account> account = new LDLinkedList<>();
			account.add(new Account(1, "furkan", "28.06.2001", "Erzincan"));
			account.add(new Account(2, "gizem", "13.01.1993", "Antalya"));
			account.add(new Account(3, "fatih", "24.01.1998", "Sivas"));
			account.add(new Account(4, "tugba", "16.02.2002", "Edirne"));
			account.add(new Account(5, "ahmet", "03.05.2004", "Malatya"));
			account.add(new Account(6, "fevzi", "28.06.2006", "Sakarya"));
			account.add(new Account(7, "gamze", "13.01.1998", "Kilis"));
			account.add(new Account(8, "faruk", "24.01.1991", "Konya"));
			account.add(new Account(9, "sena", "16.02.2003", "Ankara"));
			account.add(new Account(10, "yetgin", "03.05.2008", "Bolu"));
			System.out.println("1) An acoount with username furkan has been created.");
			System.out.println("2) An acoount with username gizem has been created.");
			System.out.println("3) An acoount with username fatih has been created.");
			System.out.println("4) An acoount with username tugba has been created.");
			System.out.println("5) An acoount with username ahmet has been created.");
			System.out.println("6) An acoount with username fevzi has been created.");
			System.out.println("7) An acoount with username gamze has been created.");
			System.out.println("8) An acoount with username faruk has been created.");
			System.out.println("9) An acoount with username sena has been created.");
			System.out.println("10) An acoount with username yetgin has been created.\n\n");
			System.out.println("11) (username: furkan) is logging into the account\n");
			account.get(0).Login(account, 10);
			
			System.out.println("12) furkan shared a post\n");
			account.get(0).SharePost("Weather is so good today..");
			
			System.out.println("13) furkan followed tugba\n");
			account.get(0).FollowPerson(account.get(3));
			
			System.out.println("14) furkan followed gizem\n");
			account.get(0).FollowPerson(account.get(1));
			
			System.out.println("15) furkan followed yetgin\n");
			account.get(0).FollowPerson(account.get(9));
			
			System.out.println("16) furkan sended a message to tugba\n");
			account.get(0).SendMessage(account.get(3), "Hi, How are you ?");
			
			System.out.println("17) furkan is trying to send a message to fevzi");
			account.get(0).SendMessage(account.get(5), "Trying message...");
			
			System.out.println("18) furkan sended a message to yetgin\n");
			account.get(0).SendMessage(account.get(9), "You must study to your midterms..!!");
			
			System.out.println("19) (username: furkan) is logging out from the account\n");
			account.get(0).Logout();
			
			System.out.println("20) (username: gizem) is logging into the account\n");
			account.get(1).Login(account, 10);
			
			System.out.println("21) gizem shared a post\n");
			account.get(1).SharePost("This homework is exhausting...");
			
			System.out.println("22) gizem followed tugba\n");
			account.get(1).FollowPerson(account.get(3));
			
			System.out.println("23) gizem followed furkan\n");
			account.get(1).FollowPerson(account.get(0));
			
			System.out.println("24) gizem followed fevzi\n");
			account.get(1).FollowPerson(account.get(5));
			
			System.out.println("25) gizem followed sena\n");
			account.get(1).FollowPerson(account.get(8));
			
			System.out.println("26) gizem followed ahmet\n");
			account.get(1).FollowPerson(account.get(4));
			
			System.out.println("27) gizem followed yetgin\n");
			account.get(1).FollowPerson(account.get(9));
			
			System.out.println("28) gizem shared another post\n");
			account.get(1).SharePost("I am so tired to teach new information to students...");
			
			System.out.println("29) gizem sended a message to furkan\n");
			account.get(1).SendMessage(account.get(0), "Congratulations.. This homework is so nice...");
			
			System.out.println("30) gizem sended a message to tugba\n");
			account.get(1).SendMessage(account.get(3), "Could you come to my room");
			
			System.out.println("31) (username: gizem) is logging out from the account\n");
			account.get(1).Logout();
			
			System.out.println("32) (username: fatih) is logging into the account\n");
			account.get(2).Login(account, 10);
			
			System.out.println("33) fatih followed furkan\n");
			account.get(2).FollowPerson(account.get(0));
			
			System.out.println("34) fatih followed yetgin\n");
			account.get(2).FollowPerson(account.get(9));
			
			System.out.println("35) fatih followed gizem\n");
			account.get(2).FollowPerson(account.get(1));
			
			System.out.println("36) fatih viewed profile of furkan\n");
			account.get(2).ViewProfile(account.get(0));
			
			System.out.println("37) fatih tried to like post of furkan\n");
			account.get(2).LikePost(account.get(0), 0);
			
			System.out.println("38) fatih viewed posts of furkan\n");
			account.get(2).ViewingPosts(account.get(0));
			
			System.out.println("39) fatih like post of furkan\n");
			account.get(2).LikePost(account.get(0), 0);
			
			System.out.println("40) fatih viewed interactions of furkan's posts\n");
			account.get(2).ViewingPostInteractions(account.get(0), account, 10);
			
			System.out.println("41) yetgin tried to logging into the account\n");
			account.get(9).Login(account, 10);
			
            System.out.println("42) fatih unfollowed furkan\n");
            account.get(2).UnfollowPerson(account.get(0));
			
			System.out.println("43) fatih viewed profile of furkan\n");
			account.get(2).ViewProfile(account.get(0));
			
			System.out.println("44) fatih tried to unlike post of furkan\n");
			account.get(2).UnlikePost(account.get(0), 0);
			
			System.out.println("45) fatih viewed posts of furkan\n");
			account.get(2).ViewingPosts(account.get(0));
			
			System.out.println("46) fatih unlike post of furkan\n");
			account.get(2).UnlikePost(account.get(0), 0);
			
			System.out.println("47) fatih viewed interactions of furkan's posts\n");
			account.get(2).ViewingPostInteractions(account.get(0), account, 10);
			
			System.out.println("48) fatih liked post of furkan again\n");
			account.get(2).LikePost(account.get(0), 0);
			
			System.out.println("49) fatih viewed interactions of furkan's posts\n");
			account.get(2).ViewingPostInteractions(account.get(0), account, 10);
			
			System.out.println("50) fatih made a comment to post of furkan\n");
			account.get(2).CommentPost(account.get(0), 0, "Sorry, I just wanted to see if i could undo the like after i liked it :)");
			
			System.out.println("51) fatih viewed interactions of furkan's posts\n");
			account.get(2).ViewingPostInteractions(account.get(0), account, 10);
			
			System.out.println("52) (username: fatih) is logging out from the account\n");
			account.get(2).Logout();
			
			System.out.println("53) (username: tugba) is logging into the account\n");
			account.get(3).Login(account, 10);
			
			System.out.println("54) tugba followed furkan\n");
			account.get(3).FollowPerson(account.get(0));
			
			System.out.println("55) tugba followed gamze\n");
			account.get(3).FollowPerson(account.get(6));
			
			System.out.println("56) tugba followed faruk\n");
			account.get(3).FollowPerson(account.get(7));
			
			System.out.println("57) tugba followed gizem\n");
			account.get(3).FollowPerson(account.get(1));
			
			System.out.println("58) tugba followed yetgin\n");
			account.get(3).FollowPerson(account.get(9));
			
			System.out.println("59) tugba sent a message to furkan\n");
			account.get(3).SendMessage(account.get(0), "Heyy, I am okay :)");
			
			System.out.println("60) tugba viewed profile of furkan\n");
			account.get(3).ViewProfile(account.get(0));
			
			System.out.println("61) tugba viewed posts of furkan\n");
			account.get(3).ViewingPosts(account.get(0));
			
			System.out.println("62) tugba liked post of furkan\n");
			account.get(3).LikePost(account.get(0), 0);
			
			System.out.println("63) tugba made a comment to post of furkan\n");
			account.get(3).CommentPost(account.get(0), 0, "Yepp, weather is really good..");
		
			System.out.println("64) tugba viewed interactions of furkan's posts\n");
			account.get(3).ViewingPostInteractions(account.get(0), account, 10);
			
			System.out.println("65) tugba showed your own past moves\n");
			account.get(3).ActionHistory();
			
			System.out.println("66) (username: tugba) is logging out from the account\n");
			account.get(3).Logout();
			
			System.out.println("67) (username: ahmet) is logging into the account\n");
			account.get(4).Login(account, 10);
			
			System.out.println("68) ahmet followed furkan\n");
			account.get(4).FollowPerson(account.get(0));
			
			System.out.println("69) ahmet followed yetgin\n");
			account.get(4).FollowPerson(account.get(9));
			
			System.out.println("70) ahmet followed fatih\n");
			account.get(4).FollowPerson(account.get(2));
			
			System.out.println("71) ahmet followed gizem\n");
			account.get(4).FollowPerson(account.get(1));
			
			System.out.println("72) ahmet viewed profile of gizem\n");
			account.get(4).ViewProfile(account.get(1));
			
			System.out.println("73) ahmet viewed posts of gizem\n");
			account.get(4).ViewingPosts(account.get(1));
			
			System.out.println("74) ahmet liked post of gizem\n");
			account.get(4).LikePost(account.get(1), 0);
			
			System.out.println("75) ahmet liked post of gizem\n");
			account.get(4).LikePost(account.get(1), 1);
			
			System.out.println("76) ahmet viewed interactions of gizem's posts\n");
			account.get(4).ViewingPostInteractions(account.get(1), account, 10);
			
			System.out.println("77) ahmet commented to post of gizem\n");
			account.get(4).CommentPost(account.get(1), 0, "Yeah, really it is..");
			
			System.out.println("78) ahmet viewed interactions of gizem's posts\n");
			account.get(4).ViewingPostInteractions(account.get(1), account, 10);
			
			System.out.println("79) ahmet uncommented from post of gizem\n");
			account.get(4).UncommentPost(account.get(1), 0);
			
			System.out.println("80) ahmet viewed interactions of gizem's posts\n");
			account.get(4).ViewingPostInteractions(account.get(1), account, 10);
			
			System.out.println("81) ahmet showed your own past moves\n");
			account.get(4).ActionHistory();
			
			System.out.println("82) ahmet tried to unfollow faruk\n");
			account.get(4).UnfollowPerson(account.get(7));
			
			System.out.println("\n83) (username: ahmet) is logging out from the account\n");
			account.get(4).Logout();
			
			System.out.println("84) (username: fevzi) is logging into the account\n");
			account.get(5).Login(account, 10);
			
			System.out.println("85) fevzi followed furkan\n");
			account.get(5).FollowPerson(account.get(0));
			
			System.out.println("86) fevzi followed gizem\n");
			account.get(5).FollowPerson(account.get(1));
			
			System.out.println("87) fevzi followed gamze\n");
			account.get(5).FollowPerson(account.get(6));
			
			System.out.println("88) fevzi followed sena\n");
			account.get(5).FollowPerson(account.get(8));
			
			System.out.println("89) fevzi followed yetgin\n");
			account.get(5).FollowPerson(account.get(9));
			
			System.out.println("90) fevzi shared a post\n");
			account.get(5).SharePost("I like football");
			
			System.out.println("91) fevzi shared a post\n");
			account.get(5).SharePost("I do not like basketball");
			
			System.out.println("92) fevzi blocked ahmet\n");
			account.get(5).BlockUsers(account.get(4));
			
			System.out.println("93) fevzi tried to send a message to ahmet\n");
			account.get(5).SendMessage(account.get(4), "I blocked you");
			
			System.out.println("94) fevzi unblocked ahmet\n");
			account.get(5).UnblockUsers(account.get(4));
			
			System.out.println("95) fevzi tried to send a message to ahmet\n");
			account.get(5).SendMessage(account.get(4), "I blocked you");
			
			System.out.println("96) fevzi followed ahmet\n");
			account.get(5).FollowPerson(account.get(4));
			
			System.out.println("97) fevzi sent a message to ahmet\n");
			account.get(5).SendMessage(account.get(4), "I blocked you but I never blocks anymore...");
			
			System.out.println("98) fevzi viewed profile of ahmet\n");
			account.get(5).ViewProfile(account.get(4));
			
			System.out.println("99) fevzi viewed posts of ahmet\n");
			account.get(5).ViewingPosts(account.get(4));
			
			System.out.println("100) Check inbox and outbox for fevzi\n");
			account.get(5).CheckingInbox();
		    account.get(5).CheckingOutbox();
			
			System.out.println("101) (username: fevzi) is logging out from the account\n");
			account.get(5).Logout();
			
			System.out.println("102) (username: gamze) is logging into the account\n");
			account.get(6).Login(account, 10);
			
			System.out.println("103) gamze followed furkan\n");
			account.get(6).FollowPerson(account.get(0));
			
			System.out.println("104) gamze followed tugba\n");
			account.get(6).FollowPerson(account.get(3));
			
			System.out.println("105) gamze followed yetgin\n");
			account.get(6).FollowPerson(account.get(9));
			
			System.out.println("106) gamze viewed profile of furkan\n");
			account.get(6).ViewProfile(account.get(0));
			
			System.out.println("107) gamze unfollowed furkan\n");
			account.get(6).UnfollowPerson(account.get(0));
			
			System.out.println("108) gamze viewed profile of furkan");
			account.get(6).ViewProfile(account.get(0));
			
			System.out.println("********************************************************************************************************");
			System.out.println("Here two people were deleted from the list of followers of furkan and the result was processed correctly");
			System.out.println("********************************************************************************************************\n");
			
			System.out.println("109) gamze viewed post of furkan\n");
			account.get(6).ViewingPosts(account.get(0));
			
			System.out.println("110) gamze viewed interactions of furkan's posts\n");
			account.get(6).ViewingPostInteractions(account.get(0), account, 10);
			
			System.out.println("111) gamze liked a post of furkan\n");
			account.get(6).LikePost(account.get(0), 0);
			
			System.out.println("112) gamze viewed interactions of furkan's posts\n");
			account.get(6).ViewingPostInteractions(account.get(0), account, 10);
			
			System.out.println("113) (username: gamze) is logging out from the account\n");
			account.get(6).Logout();
			
			System.out.println("114) (username: faruk) is logging into the account\n");
			account.get(7).Login(account, 10);
			
			System.out.println("115) faruk followed furkan\n");
			account.get(7).FollowPerson(account.get(0));
			
			System.out.println("116) faruk followed fevzi\n");
			account.get(7).FollowPerson(account.get(5));
			
			System.out.println("117) faruk followed yetgin\n");
			account.get(7).FollowPerson(account.get(9));
			
			System.out.println("118) faruk viewed profile of faruk\n");
			account.get(7).ViewProfile(account.get(7));
			
			System.out.println("119) faruk sent a message to furkan\n");
			account.get(7).SendMessage(account.get(0), "Hii, I miss you");
			
			System.out.println("120) faruk shared a post\n");
			account.get(7).SharePost("Besiktas is the biggest club in Turkey");
			
			System.out.println("121) faruk showed your own past moves\n");
			account.get(7).ActionHistory();
			
			System.out.println("122) faruk sent a message to yetgin\n");
			account.get(7).SendMessage(account.get(9), "Heyy, where are you??");
			
			System.out.println("123) (username: faruk) is logging out from the account\n");
			account.get(7).Logout();
			
			System.out.println("124) (username: sena) is logging into the account\n");
			account.get(8).Login(account, 10);
			
			System.out.println("125) sena followed furkan\n");
			account.get(8).FollowPerson(account.get(0));
			
			System.out.println("126) sena followed fatih\n");
			account.get(8).FollowPerson(account.get(2));
			
			System.out.println("127) sena followed yetgin\n");
			account.get(8).FollowPerson(account.get(9));
			
			System.out.println("128) sena followed gizem\n");
			account.get(8).FollowPerson(account.get(1));
			
			System.out.println("129) sena sent a message to yetgin\n");
			account.get(8).SendMessage(account.get(9), "I went to cinema yesterday..");
			
			System.out.println("130) sena sent a message to yetgin\n");
			account.get(8).SendMessage(account.get(9), "What about you??");
			
			System.out.println("131) sena blocked furkan\n");
			account.get(8).BlockUsers(account.get(0));
			
			System.out.println("132) (username: sena) is logging out from the account\n");
			account.get(8).Logout();
			
			System.out.println("133) (username: yetgin) is logging into the account\n");
			account.get(9).Login(account, 10);
			
			System.out.println("134) yetgin followed furkan\n");
			account.get(9).FollowPerson(account.get(0));
			
			System.out.println("135) yetgin followed fatih\n");
			account.get(9).FollowPerson(account.get(2));
			
			System.out.println("136) yetgin followed gizem\n");
			account.get(9).FollowPerson(account.get(1));
			
			System.out.println("137) yetgin followed sena\n");
			account.get(9).FollowPerson(account.get(8));
			
			System.out.println("138) yetgin sent a message to furkan\n");
			account.get(9).SendMessage(account.get(0), "Shall we go to the beach in midnight..");
			
			System.out.println("139) Check inbox and outbox for yetgin\n");
			account.get(9).CheckingInbox();
			account.get(9).CheckingOutbox();
			
			System.out.println("140) View inbox and outbox for yetgin\n");
			account.get(9).ViewingInbox(account, 10);
			account.get(9).ViewingOutbox(account, 10);
			
			System.out.println("141) yetgin showed your own past moves\n");
			account.get(9).ActionHistory();
			
			System.out.println("142) yetgin viewed profile of furkan\n");
			account.get(9).ViewProfile(account.get(0));
			
			System.out.println("143) (username: yetgin) is logging out from the account\n");
			account.get(9).Logout();
		}
}
