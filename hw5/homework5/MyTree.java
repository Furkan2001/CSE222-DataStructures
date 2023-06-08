/**
*
*@author Ahmet Furkan Ekinci - 200104004063
*
*/

package homework5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;


/**
 *
 *This is my tree class.
 *
 */
public class MyTree 
{
	private DefaultMutableTreeNode root;
	private JFrame frame;
	
	 // Constructor method for creating a new MyTree object
	/**
	 * 
	 * constructor method that creates a new MyTree object. 
	 * it initializes a JFrame and reads data from a file into a 2D array.
	 * it then creates a new root node with the label "Root" and loops through the 2D array to create new nodes for each item. 
	 * it finally creates a JTree object from the root node and displays it in a new JFrame.
	 * 
	 * @throws FileNotFoundException if the file specified in the code is not found
	 */
	public MyTree() throws FileNotFoundException
	{
		 // Initialize the JFrame and read data from file into a 2D array
		this.frame = new JFrame();
		String [][] array;
		int temp;
		
		array = new String[1][1];
		array = readFromFile(array);
		
		 // Create a new root node with the label "Root"
		this.root = new DefaultMutableTreeNode("Root");
		DefaultMutableTreeNode dummy;

		// Loop through the 2D array and create new nodes for each item
        for (int i = 0; i < array.length; i++) 
        {
            DefaultMutableTreeNode parent = root;
            for (int j = 0; j < array[0].length; j++) 
            {
            	temp = 0;
            	if (array[i][j] != null && j == 0)
            	{
            		// Traverse existing nodes until we find the parent node for this item
            		dummy = root;
            		while (findNodeIndex(dummy, array[i][temp]) != -1)
            		{
            			int index = findNodeIndex(dummy, array[i][temp]);
            			dummy = (DefaultMutableTreeNode) dummy.getChildAt(index);
            			temp++;
            		}
            		if (temp != 0)
            		{
            			// If a parent node exists, add this node as its child
            			j = temp;
            			DefaultMutableTreeNode node = new DefaultMutableTreeNode(array[i][j]);
            			dummy.add(node);
            			parent = node;
            		}
            		else
            		{
            			 // If no parent node exists, add this node as a child of the root node
            			DefaultMutableTreeNode node = new DefaultMutableTreeNode(array[i][j]);
    	                parent.add(node);
    	                parent = node;
            		}
            	}
            	else if (array[i][j] != null)
            	{
            		// If this is not the first item in a row, create a new child node for it
            		DefaultMutableTreeNode node = new DefaultMutableTreeNode(array[i][j]);
	                parent.add(node);
	                parent = node;
            	}
            }
        }
        // Create a JTree object from the root node and display it in a new JFrame
        JTree jtree=new JTree(root);  
		frame.add(jtree);
		frame.setSize(300,600);  
		frame.setVisible(true); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	 // A helper method for reading data from a file into a 2D array
	/**
	 * 
	 * a helper method for reading data from a file into a 2D array.
	 * 
	 * @param array is a 2D array of String
	 * @return 2D array of String
	 * @throws FileNotFoundException if the file specified in the code is not found
	 */
	private String[][] readFromFile(String[][] array) throws FileNotFoundException
	{
		int row,column;
		
		row = 1;
		column = 1;
		
		File file = new File("tree.txt");	
        Scanner scanner = new Scanner(file);
        
        int i = 0; 

        while (scanner.hasNextLine()) 
        { 
        	if (!(i < row))
        	{
        		row++;
        		String [][] dummy = new String[row][column];
        		for (int k = 0; k < row - 1; k++)
        		{
        			for (int z = 0; z < column; z++)
        			{
        				dummy[k][z] = array[k][z];
        			}
        		}
        		array = dummy;
        	}
	        String line = scanner.nextLine();
	        String[] words = line.split(";"); 
	        
	        if (column < words.length)
	        {
	        	String [][] dummy = new String[row][words.length];
	        	for (int k = 0; k < row; k++)
        		{
        			for (int z = 0; z < column; z++)
        			{
        				dummy[k][z] = array[k][z];
        			}
        		}
	        	column = words.length;
	        	array = dummy;
	        }
	        for (int j = 0; j < words.length; j++) 
	        {
	        	array[i][j] = words[j]; // kelimeyi iki boyutlu diziye kaydediyoruz
	        }
	        i++;
        }
        scanner.close();
        return array;
	}
    
	/**
	 * This is a search method for tree.
	 * 
	 * @param str is a String we will look for in the tree.
	 */
    public void breadthFirstSearch(String str) 
    {
        Queue<DefaultMutableTreeNode> queue = new LinkedList<>();
        queue.add(root);
        int flag;
        int counter;
        
        counter = 1;
        flag = 0;
        while (!queue.isEmpty()) 
        {
            DefaultMutableTreeNode node = queue.poll();
            System.out.print("STEP " + counter + " -> " + node.getUserObject());
            if(node.getUserObject().equals(str))
            {
            	System.out.print(" (FOUND!!)");
            	flag++;
            	break;
            }
            System.out.println("");
            int childCount = node.getChildCount();
            for (int i = 0; i < childCount; i++) 
            {
                DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) node.getChildAt(i);
                queue.add(childNode);
            }
            counter++;
        }
        if (flag == 0)
        {
        	System.out.println("");
        	System.out.println("Not found!!!");
        }
    }
    
    /**
	 * This is a another search method for tree.
	 * 
	 * @param str is a String we will look for in the tree.
	 */
    public void depthFirstSearch(String str) 
    {
        Stack<DefaultMutableTreeNode> stack = new Stack<>();
        stack.push(root);
        int flag;
        int counter;

        flag = 0;
        counter = 1;
        while (!stack.isEmpty()) 
        {
            DefaultMutableTreeNode node = stack.pop();
            System.out.print("STEP " + counter + " -> " + node.getUserObject());
            if(node.getUserObject().equals(str))
            {
            	System.out.print(" (FOUND!!)");
            	flag++;
            	break;
            }
            System.out.println("");
            int numChildren = node.getChildCount();
            for (int i = 0; i < numChildren; i++) 
            {
                DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) node.getChildAt(i);
                stack.push(childNode);
            }
            counter++;
        }
        if (flag == 0)
        {
        	System.out.println("");
        	System.out.println("Not found!!!");
        }
    }
    
    /**
	 * This is a another search method for tree.
	 * 
	 * @param str is a String we will look for in the tree.
	 */
    public void postOrderTraversal(String str)
    {
    	Stack<DefaultMutableTreeNode> stack = new Stack<>();
    	Stack<DefaultMutableTreeNode> realStack = new Stack<>();
        stack.push(root);
        int flag;
        int counter;

        flag = 0;
        counter = 1;
        while (!stack.isEmpty()) 
        {
            DefaultMutableTreeNode node = stack.pop();
            realStack.push(node);
            
            int numChildren = node.getChildCount();
            for (int i = 0; i < numChildren; i++) 
            {
                DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) node.getChildAt(i);
                stack.push(childNode);
            }
        }
        while (!realStack.isEmpty())
        {
        	DefaultMutableTreeNode realNode = realStack.pop();
        	System.out.print("STEP " + counter + " -> " + realNode.getUserObject());
        	if(realNode.getUserObject().equals(str))
            {
            	System.out.print(" (FOUND!!)");
            	flag++;
            	break;
            }
        	System.out.println("");
        	counter++;
        }
        if (flag == 0)
        {
        	System.out.println("");
        	System.out.println("Not found!!!");
        }
    }
    
    /**
     * This method takes 2 parameters. First one is source and second one is destination.
     * if there is a sequence of nodes in the tree, such as the path specified in the source, 
     * it sends it to destination and deletes the source part from the tree.
     * 
     * @param str is a String includes source path
     * @param dest is a String includes destination
     */
    public void move(String str, String dest)
    {
    	String[] words = str.split(","); 
    	if (words[0] == dest)
    	{
    		System.out.println("Source and destination are same...");
    		return;
    	}
     	DefaultMutableTreeNode realNode;
     	int control = 0;
     	
     	realNode = root;
        // I controlled whether words is in tree or not.
     	for (int i = 0; i < words.length; i++)
     	{
     		if (findNodeIndex(realNode, words[i]) == -1)
     		{
     			System.out.print("Cannot move ");
     			for (int j = 0; j < words.length; j++)
     			{
     				if (control != 0)
     				{
     					System.out.print("->");
     				}
     				System.out.print(words[j]);
     				control++;
     			}
     			System.out.println(" because it doesn't exist in the tree.");
     			return;
     		}
     		realNode = (DefaultMutableTreeNode) realNode.getChildAt(findNodeIndex(realNode, words[i]));
     	}
     	// I removed str path from tree(root).
     	remove(str);
     	words[0] = dest;
     	control = 0;
     	realNode = root;
     	for (int i = 0; i < words.length; i++)
     	{
     		if (findNodeIndex(realNode, words[i]) == -1)
     		{
     			control++;
     			break;
     		}
     		realNode = (DefaultMutableTreeNode) realNode.getChildAt(findNodeIndex(realNode, words[i]));
     	}
        //If all elements along the path are in the tree, this if structure is provided.
     	if (control == 0)
     	{
     		String[] temp = str.split(",");
     		System.out.print("Moved ");
 			for (int j = 0; j < temp.length; j++)
 			{
 				if (j != 0)
 				{
 					System.out.print("->");
 				}
 				System.out.print(temp[j]);
 			}
 			System.out.println(" to " + dest);
 			for (int j = 0; j < words.length; j++)
 			{
 				if (j != 0)
 				{
 					System.out.print("->");
 				}
 				System.out.print(words[j]);
 			}
 			System.out.println(" has been overwritten.");
     	}
        //If all elements along the path are not in the tree, this else structure is provided.Add in here...
     	else
     	{
     		DefaultMutableTreeNode parent = root;
     		DefaultMutableTreeNode dummy;
     		for (int j = 0; j < words.length; j++) 
             {
             	control = 0;
             	if (j == 0)
             	{
             		dummy = root;
             		while (findNodeIndex(dummy, words[control]) != -1)
             		{
             			int index = findNodeIndex(dummy, words[control]);
             			dummy = (DefaultMutableTreeNode) dummy.getChildAt(index);
             			control++;
             		}
             		if (control != 0)
             		{
             			j = control;
             			DefaultMutableTreeNode node = new DefaultMutableTreeNode(words[j]);
             			dummy.add(node);
             			parent = node;
             		}
             		else
             		{
             			DefaultMutableTreeNode node = new DefaultMutableTreeNode(words[j]);
     	                parent.add(node);
     	                parent = node;
             		}
             	}
             	else if (words[j] != null)
             	{
             		DefaultMutableTreeNode node = new DefaultMutableTreeNode(words[j]);
 	                parent.add(node);
 	                parent = node;
             	}
             }
    	}
    	JTree jtree=new JTree(root);  
    	frame = new JFrame();
		frame.add(jtree);
		frame.setSize(300,600);  
		frame.setVisible(true); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
	 * It is used to delete the path given as a parameter from the tree.
	 * 
	 * @param str is a String includes path.
	 */
    public void remove(String str)
    {
    	String[] words = str.split(","); 
    	DefaultMutableTreeNode realNode;
    	int control = 0;
    	
    	realNode = root;
    	realNode = (DefaultMutableTreeNode) realNode.getChildAt(findNodeIndex(realNode, words[0]));
    	
    	for (int i = 1; i < words.length; i++)
    	{
    		if (realNode.getChildCount() > 1)
    		{
    			control++;
    			break;
    		}
    		realNode = (DefaultMutableTreeNode) realNode.getChildAt(findNodeIndex(realNode, words[i]));
    	}
    	realNode = root;
        // If it has children then i go to the last node of the source string and delete this node.
    	if (control > 0)
    	{
    		for (int i = 0; i < words.length - 1; i++)
        	{
        		realNode = (DefaultMutableTreeNode) realNode.getChildAt(findNodeIndex(realNode, words[i]));
        	}
    		realNode.remove(findNodeIndex(realNode, words[words.length-1]));
    	}
        // If any node in the source string has no children then I delete the string at the beginning of the source string and they are all deleted.
    	else
    	{
    		realNode.remove(findNodeIndex(realNode, words[0]));
    	}
    }
    
    /**
     * Checks if the given node has children with the same string as name and if not returns -1.
     * 
     * @param node is a DefaultMutableTreeNode.
     * @param name is a String we will look for in the tree.
     * @return integer value includes index
     */
    private int findNodeIndex(DefaultMutableTreeNode node, String name) 
    {
        for (int i = 0; i < node.getChildCount(); i++) 
        {
            if (node.getChildAt(i).toString().equals(name)) 
            {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Makes JFrame type frame invisible...
     */
    public void visible()
    {
    	frame.setVisible(false);
    }
}
