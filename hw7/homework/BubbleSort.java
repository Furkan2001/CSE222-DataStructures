/**
*
*@author Ahmet Furkan Ekinci - 200104004063
*
*/

package homework;

/**
 * 
 *  The BubbleSort class represents a bubble sort algorithm applied to a MyMap object.
 *  It sorts the MyMap object based on the size of the values associated with its keys.
 *
 */
public class BubbleSort 
{
	private MyMap originalMap;
	private MyMap sortedMap;
	private String[] aux; //it is a string that holds the key part of the originalMap variable once in succession.
	
	 /**
     * Constructs an BubbleSort object with the given map.
     *
     * @param map the map to be sorted
     */
	public BubbleSort(MyMap map)
    {
		this.originalMap = map;
        this.sortedMap = new MyMap(map);
        this.aux = originalMap.stringOfMapForOthers(); 
    }
	
	 /**
     * Sorts the map using the bubble sort algorithm.
     * Updates the sorted map and prints the auxiliary array.
     */
	public void sort() 
    {
		bubbleSort();
    	updateSortedMap();
    	printAux();
    }
	
	/**
	 * Sorts the map using the bubble sort algorithm.
	 * This algorithm repeatedly compares adjacent elements and swaps them if they are in the wrong order.
	 * It compares the size of the values associated with the keys to determine the order.
	 * After sorting, the sorted map is not updated, but the auxiliary array is modified.
	 */
	private void bubbleSort()
	{
		String temp;
        boolean sorted;
		
        
		for (int i = 0; i < (originalMap.getMapSize() - 1); i++)
		{
            sorted = false;
			for (int j = 0; j < originalMap.getMapSize() - 1 - i; j++)
			{
				if (originalMap.getMap().get(aux[j]).getSize() > originalMap.getMap().get(aux[j + 1]).getSize())
				{
					temp = aux[j];
					aux[j] = aux[j + 1];
					aux[j + 1] = temp;
                    sorted = true;
				}
			}
            if (sorted == false)
            {
                return;
            }
		}
	}
	
	/**
     * Updates the sorted map based on the sorted auxiliary array.
     */
	private void updateSortedMap() 
    {
    	for (int i = 0; i < originalMap.getMapSize(); i++)
    	{
    		sortedMap.getMap().put(aux[i], originalMap.getMap().get(aux[i]));
    	}
    }
	
	/**
     * Prints the auxiliary array.
     */
	private void printAux()
    {
		System.out.print("\naux: {");
    	for (String element : aux) 
    	{
    	    System.out.print(element + " ");
    	}
    	System.out.println("}\n"); // skip to the bottom line
    }
	
	/**
     * Prints the sorted map.
     */
	public void printSortedMap() 
    {
        sortedMap.printMap();
    }
}
