/**
*
*@author Ahmet Furkan Ekinci - 200104004063
*
*/

package homework;


/**
 * 
 *  The InsertionSort class represents a insertion sort algorithm applied to a MyMap object.
 *  it sorts the MyMap object based on the size of the values associated with its keys.
 *
 */
public class InsertionSort 
{
	private MyMap originalMap;
	private MyMap sortedMap;
	private String[] aux; //it is a string that holds the key part of the originalMap variable once in succession.
	
	 /**
     * Constructs an InsertionSort object with the given map.
     *
     * @param map the map to be sorted
     */
	public InsertionSort(MyMap map)
    {
		this.originalMap = map;
        this.sortedMap = new MyMap(map);
        this.aux = originalMap.stringOfMapForOthers(); 
    }
	
	 /**
     * Sorts the map using the insertion sort algorithm.
     * Updates the sorted map and prints the auxiliary array.
     */
	public void sort() 
    {
		insertionSort();
    	updateSortedMap();
    	printAux();
    }
	
	/**
	 * Sorts the map using the insertion sort algorithm.
	 * This algorithm iterates over the array of keys and inserts each key into its correct position in the sorted part of the array.
	 * It compares the size of the values associated with the keys to determine the correct position.
	 * After sorting, it updates the sorted map and prints the auxiliary array.
	 */
	private void insertionSort()
	{
		String temp;
		
		for (int i = 1; i < originalMap.getMapSize(); i++)
		{
			temp = aux[i];
			int j = i - 1;
			
			while (j >= 0 && originalMap.getMap().get(aux[j]).getSize() > originalMap.getMap().get(temp).getSize())
			{
				aux[j + 1] = aux[j];
				j--;
			}
			aux[j + 1] = temp;
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
