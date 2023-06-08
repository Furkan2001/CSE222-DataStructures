/**
*
*@author Ahmet Furkan Ekinci - 200104004063
*
*/

package homework;

/**
*
*The Main class contains the main method to execute the sorting algorithms on a given string.
*
*/
public class Main 
{
	
		/**
	    * Default constructor for creating Main objects without parameters.
	    */
	  	public Main(){}
	
	/**
	*
	*The main entry point of the program.
	*
	*@param args the command-line arguments
	*
	*/
	public static void main(String[] args)
	{
		String str = "'Hush, hush!' whispered the rushing wind. tant kart fanh trn fssdw fskke rutuht bfjbj fvj fpemb khkg hlh hg bbty py bk ejj qio";
		MyMap myMap = new MyMap(str);
		System.out.println("Original String:\t" + str);
		System.out.println("");
		System.out.println("Preprocessed String:    " + myMap.getStr());
		System.out.println("\n\nThe original (unsorted) map:");
		myMap.printMap();
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("\nThe merge sorted map:");
		MergeSort Sort = new MergeSort(myMap);
		Sort.sort();
		Sort.printSortedMap();
	}
}
