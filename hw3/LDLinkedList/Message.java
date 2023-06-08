/**
*
*@author Ahmet Furkan Ekinci - 200104004063
*
*/

package LDLinkedList;

/**
*
* This class is Message class.
*
*/

public class Message 
{
	private int		messageId;
	private int		senderId;
	private int		receiverId;
	private String	content;
	
   /**
    *This is a four parameter constructor.
    *
    *@param idMessage is a ID for Message class.
    *@param idSender is variable that hold id of person who send the message.
    *@param idReceiver is variable that hold id of person who receive the message.
    *@param content is a object of String. It holds a content of message.
    *
    */
	public Message(int idMessage, int idSender, int idReceiver, String content)
	{
		this.messageId = idMessage;
		this.senderId = idSender;
		this.receiverId = idReceiver;
		this.content = content;
	}
	
   /**
    *
    *This method is overriden. This method provide to return a string for printing. This method is ovirriden from Object class.
    *
    *@return This method return String for printing Message in somewhere else.
    *
    */
	@Override
	public String toString()
	{
		return ("Message ID: " + messageId + "\n" + "Message: " + content);
	}
	
   /**
    *
    *This method returns a integer value for id of message.
    *
    *@return This method returns a integer value. The value include id of message.
    *
    */
	public int GetMessageId()
	{
		return (this.messageId);
	}
	
   /**
    *
    *This method returns a integer value for id of sender person.
    *
    *@return This method returns a integer value. The value include id of sender person.
    *
    */
	public int GetSenderId()
	{
		return (this.senderId);
	}
	
   /**
    *
    *This method returns a integer value for id of receiver person.
    *
    *@return This method returns a integer value. The value include id of receiver person.
    *
    */
	public int GetReceiverId()
	{
		return (this.receiverId);
	}
}


