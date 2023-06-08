/**
*
*@author Ahmet Furkan Ekinci - 200104004063
*
*/

package LDLinkedList;

import java.util.AbstractList;
import java.util.List;

/**
 *  LDLinkedList implementation of the List interface.
 *
 * @param <E> the type of elements held in this list
 */
public class LDLinkedList<E> extends AbstractList<E> implements List<E> {

	private Node<E> head;  // This variable is object of node class..
	private int size;  // This variable size of head..
	private int countLazyDeleted; // This variable holds the number of node objects that should be deleted but it is not deleted..
	
	/**
    *
    *This is a no parameter constructor.
    *
    */
	public LDLinkedList()
	{
		head = null;
		size = 0;
		countLazyDeleted = 0;
	}
	
	/**
    *
    *This is a one parameter constructor.
    *
    *@param node is a object of Node class
    *
    */
	public LDLinkedList(Node<E> node)
	{
		head = node;  
		size = 0;
		countLazyDeleted = 0; 
		Node<E> temp = new Node<>(head.data, head.next);
		while (temp != null)
		{
			size++;
			temp = temp.next;
		}
	}
	
	
	
	//***************************************************************************************
	
    /**
     * A node in a LDLinkedList.
     *
     * @param <E> the type of element held in this node
     */
	public static class Node <E> 
	{   //We declare Node<E> to be static because there is no need for its methods to access the data fields of its parent class(LDLinkedList<E>).
		private Node<E> next;
		private E data;
		private boolean isMarked;
		
		/**
	    *
	    *This is a one parameter constructor.
	    *
	    *@param dataItem is a object of E
	    *
	    */
		public Node(E dataItem) 
		{
	        this.data = dataItem;
	        this.next = null; 
	        this.isMarked = false;
	    }
		
		/**
	    *
	    *This is a two parameter constructor.
	    *
	    *@param dataItem is a object of E
	    *@param nodeRef is object  of Node
	    *
	    */
		public Node(E dataItem, Node<E> nodeRef) 
		{
	        this.data = dataItem;
	        this.next = nodeRef;
	        this.isMarked = false;
	    }
		
		/**
		 *This method returns object of E and the purpose of this method is to return the value of the node object
		 *
		 * @return an object of E
		 */
		public E getData()
		{
			return (this.data);
		}
		
		/**
		 * This method equals the object it takes as a parameter with its own object
		 * 
		 * @param data is an object of E
		 * 
		 */
		public void setData(E data)
		{
			this.data = data;
		}
		
		/**
		 * This method determines the value of the next variable inside the Node class.
		 * 
		 * @param next is a object of Node
		 */
		public void setNext(Node<E> next)
		{
			this.next = next;
		}
		
		/**
		 * This method returns object of Node class
		 *
		 * @return object of Node class
		 */
		public Node<E> getNext()
		{
			return (this.next);
		}
		
		/**
		 * This method returns boolean value
		 * 
		 * @return an boolean value
		 */
		public boolean getIsMarked()
		{
			return (this.isMarked);
		}
		
		/**
		 * This method sets the b parameter to the value of the isMarked variable
		 * 
		 * @param b is a boolean value
		 */
		public void setIsMarked(boolean b)
		{
			this.isMarked = b;
		}
	}
	
	//***************************************************************************************
	
	
	/**
	 * This method returns object of Node but also this method controls if isMarked variable is true or false
	 * 
	 * @param index is value of integer
	 * @return an object of Node
	 */
	public Node<E> getNode(int index) 
	{
        Node<E> node = head;
        int nodeIndex = 0;
        while (node != null)
        {
        	if (node.getIsMarked() == false)
        	{
        		if (index == nodeIndex)
        		{
        			return node;
        		}
        		nodeIndex++;
        	}
        	node = node.getNext();
        }
        return null;
    }
	
	/**
	 * This method remove element of Node object
	 */
	public void LazyRemove()
	{
		Node<E> current = head;
		Node<E> previous = null;
		while (current != null)
		{
			if (current.getIsMarked() == true) // if getIsMarked is false then this method should not remove
			{
				if (previous == null)
				{
					head = head.getNext();
				}
				else
				{
					previous.setNext(current.getNext());
				}
				this.size--;
				this.countLazyDeleted--;
			}
			else // Because if current is marked then it must be deleted..And we ignore that node..
			{
				previous = current;
			}
			current = current.getNext();
		}
	}
	
	/**
	 * This method remove element which in index
	 * 
	 * @param index is an integer
	 * @return an object of E
	 * 
	 */
	@Override
	public E remove(int index)
	{
		if (index < 0 || index >= this.size()) 
        {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
		this.countLazyDeleted++;
		int i = 0;
		Node<E> current = head;
		while (i < index)
		{
			if (current.getIsMarked() == true)
			{
				current = current.getNext();
			}
			current = current.getNext();
			i++;
		}
		current.setIsMarked(true);
		if (countLazyDeleted == 2)
		{
			this.LazyRemove();
		}
		return null;
	}
	
	/**
	 * This method sets new value to node 
	 * 
	 * @param index is a integer
	 * @param newValue is an object of E
	 * @return an object of E
	 * 
	 */
	@Override
	public E set(int index, E newValue) 
	{
        if (index < 0 || index >= this.size()) 
        {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        E result = node.data;
        node.setData(newValue);
        return result;
	}
	
	/**
	 * This method adds an element to an object of Node
	 * 
	 * @param item is an object of E
	 * @return a boolean value
	 * 
	 */
	@Override
	public boolean add(E item) 
	{
		Node<E> node;
		if (size == 0)
		{
			head = new Node<E>(item);
		}
		else
		{
			node = head;
			while (node.getNext() != null)
			{
				node = node.getNext();
			}
			node.setNext(new Node<E>(item));
		}
		this.size++;
        return true;
    }
	
	/**
	 * This method returns an object of value
	 * 
	 * @param index is an value of integer
	 * @return is an object of E
	 * 
	 */
	@Override
	public E get(int index) 
	{
		if (index < 0 || index >= this.size()) 
        {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        return node.data;
	}

	/**
	 * This method returns an integer value
	 * 
	 * @return an integer value
	 * 
	 */
	@Override
	public int size() 
	{
		return (size - countLazyDeleted);
	}
}
