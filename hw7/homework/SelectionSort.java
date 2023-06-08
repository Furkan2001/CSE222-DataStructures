/**
*
*@author Ahmet Furkan Ekinci - 200104004063
*
*/

package homework;

/**
 * 
 *  The SelectionSort class represents a selection sort algorithm applied to a MyMap object.
 * It sorts the MyMap object based on the size of the values associated with its keys.
 *
 */
public class SelectionSort 
{
	private MyMap originalMap;
	private MyMap sortedMap;
	private String[] aux; //it is a string that holds the key part of the originalMap variable once in succession.
	
	/**
     * Constructs a SelectionSort object with the given map.
     *
     * @param map the map to be sorted
     */
	public SelectionSort(MyMap map)
    {
		this.originalMap = map;
        this.sortedMap = new MyMap(map);
        this.aux = originalMap.stringOfMapForOthers(); 
    }
	
	 /**
     * Sorts the map using the selection sort algorithm.
     * Updates the sorted map and prints the auxiliary array.
     */
	public void sort() 
    {
    	selectionSort();
    	updateSortedMap();
    	printAux();
    }
	
	/**
	 * Sorts aux array depends on count with selection sort.
	 */
	private void selectionSort()
	{
		int min; // i used this variable to hold the index of the smallest element in the array..
		String temp = new String();
		
		for (int i = 0; i < originalMap.getMapSize() - 1; i++) // (originalMap.getMapSize() - 1) => the reason why i use this piece of code is when sorting up to the last index the last index is automatically sorted so there is no need to check this..
		{
			min = i;
			for (int j = i + 1; j < originalMap.getMapSize(); j++)
			{
				if (originalMap.getMap().get(aux[min]).getSize() > originalMap.getMap().get(aux[j]).getSize())
				{
					min = j;
				}
			}
			temp = aux[min];
			aux[min] = aux[i];
			aux[i] = temp;
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
