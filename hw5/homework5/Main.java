/**
*
*@author Ahmet Furkan Ekinci - 200104004063
*
*/

package homework5;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This is the main class to run the homework5 application.
 * it creates a tree, performs BFS, DFS, post-order traversal,
 * and move operation on the tree based on user input.
 * it also displays a JFrame that can be closed by user input.
 */

public class Main {

    /**
     * Default constructor for creating Main objects without parameters.
     */
    public Main(){}
    /**
     *The main method of the program.
     *
     *@param args is a String[] parameter.
     *
     *@throws FileNotFoundException If the file specified in the code is not found
     */
	public static void main(String[] args) throws FileNotFoundException
	{
		MyTree my = new MyTree();
		String input,dest;
		
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter any string to close the JFrame: ");
        scanner.nextLine();

        my.visible();

    	System.out.println("");
    	System.out.println("");
    	System.out.println("--------------------------------------------------------------");
        System.out.print("Please Enter a String for bfs: ");
        input = scanner.nextLine();
		
		my.breadthFirstSearch(input);
		
		
		System.out.println("");
    	System.out.println("");
    	System.out.println("--------------------------------------------------------------");
        System.out.print("Please Enter a String for dfs: ");
        input = scanner.nextLine();
		
		my.depthFirstSearch(input);
		
		
		System.out.println("");
    	System.out.println("");
    	System.out.println("--------------------------------------------------------------");
        System.out.print("Please Enter a String for post order traversal: ");
        input = scanner.nextLine();
		
		my.postOrderTraversal(input);
		
		
		System.out.println("");
    	System.out.println("");
    	System.out.println("--------------------------------------------------------------");
        System.out.print("Please Enter a String for source with comma(','): ");
        input = scanner.nextLine();
        System.out.print("Please Enter a String for destination: ");
        dest = scanner.nextLine();
		
		my.move(input, dest);
        
		scanner.close();
	}
}
