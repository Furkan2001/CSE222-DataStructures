/**
*
*@author Ahmet Furkan Ekinci - 200104004063
*
*/

package homework;

/**
 * 
 *  The QuickSort class represents a quick sort algorithm applied to a MyMap object.
 *  It sorts the MyMap object based on the size of the values associated with its keys.
 *
 */
public class QuickSort 
{
	private MyMap originalMap;
	private MyMap sortedMap;
	private String[] aux; //it is a string that holds the key part of the originalMap variable once in succession.
	
	 /**
     * Constructs an QuickSort object with the given map.
     *
     * @param map the map to be sorted
     */
	public QuickSort(MyMap map)
    {
		this.originalMap = map;
        this.sortedMap = new MyMap(map);
        this.aux = originalMap.stringOfMapForOthers(); 
    }
	
	 /**
     * Sorts the map using the quick sort algorithm.
     * Updates the sorted map and prints the auxiliary array.
     */
	public void sort()
	{
		quickSort(0, originalMap.getMapSize() - 1);
		updateSortedMap();
		printAux();
	}
	
	/**
	 * Sorts the specified range of the map using the quick sort algorithm.
	 * The range to be sorted is from the 'begin' index to the 'end' index, inclusive.
	 *
	 * @param begin the starting index of the range to be sorted
	 * @param end   the ending index of the range to be sorted
	 */
	private void quickSort(int begin, int end)
	{
		if (begin >= end)
		{
			return;
		}
		int temp = quick(begin, end);
		quickSort(begin, temp - 1);
		quickSort(temp + 1, end);
	}
	
	/**
	 * Performs the partitioning step of the quick sort algorithm.
	 * It selects a pivot element and rearranges the elements in the range
	 * such that all elements smaller than the pivot are on the left side,
	 * and all elements greater than the pivot are on the right side.
	 *
	 * @param begin the starting index of the range
	 * @param end   the ending index of the range
	 * @return the index of the pivot element after partitioning
	 */
	private int quick(int begin, int end)
	{
		int pivot = originalMap.getMap().get(aux[end]).getSize();
		int i = begin - 1;
		
		for (int j = begin; j <= end - 1; j++)
		{
			if (originalMap.getMap().get(aux[j]).getSize() < pivot)
			{
				i++;
				String temp = aux[i];
				aux[i] = aux[j];
				aux[j] = temp;
			}
		}
		i++;
		String temp = aux[i];
		aux[i] = aux[end];
		aux[end] = temp;
		
		return i;
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
