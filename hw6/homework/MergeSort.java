/**
*
*@author Ahmet Furkan Ekinci - 200104004063
*
*/

package homework;

/**
 * The mergeSort class represents a merge sort algorithm applied to a MyMap object.
 * It sorts the MyMap object based on the size of the values associated with its keys.
 */
public class MergeSort
{
    private MyMap originalMap;
    private MyMap sortedMap;
    private String[] aux; //it is a string that holds the key part of the originalMap variable twice in succession. like 2 String array...
    
    /**
     * Constructs a mergeSort object with the specified MyMap object.
     *
     * @param map the MyMap object to be sorted
     */
    public MergeSort(MyMap map)
    {
        this.originalMap = map;
        this.sortedMap = new MyMap(map);
        this.aux = originalMap.stringOfMapForMerge();
    }
    
    /**
     * Sorts the MyMap object using the merge sort algorithm.
     * Prints the sorted array.
     */
    public void sort() 
    {
    	mergeSort(0, originalMap.getMapSize() - 1);
    	updateSortedMap();
    	printAux();
    }
    
    /**
     * Applies the merge sort algorithm to the specified range of the auxiliary array.
     *
     * @param left the left index of the range
     * @param right the right index of the range
     */
    private void mergeSort(int left, int right)
    {
        if (left < right) 
        {
            int mid = left + (right - left) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }
    
    /**
     * Merges two subarrays of the auxiliary array.
     *
     * @param low the lowest index of the subarray(actualy there is no any subarray but we act like we have)
     * @param mid the highest index of the subarray(actualy there is no any subarray but we act like we have)
     * @param high the highest index of the subarray(actualy there is no any subarray but we act like we have)
     */
    private void merge(int low, int mid, int high)
    {
        // mid - low + 1 => I thought I have a String array with length from index 0 to this number..
        // high - mid => I thought I have a String array with length from index mid - low + 1 to this number..
    	
    	int number1 = mid - low + 1;
    	int number2 = high - mid;

        for (int i = 0; i < number1; ++i)
        {
            aux[i] = aux[originalMap.getMapSize() + low + i];
        }
        for (int j = 0; j < number2; ++j)
        {
            aux[number1 + j] = aux[originalMap.getMapSize() + mid + 1 + j];
        }
 
        int i;
        int j;
        int k;
        
        i = 0;
        j = 0;
        k = low;
        while (i < number1 && j < number2) 
        {
            if (originalMap.getMap().get(aux[i]).getSize() <= originalMap.getMap().get(aux[mid - low + 1 + j]).getSize()) 
            {
            	aux[originalMap.getMapSize() + k] = aux[i];
                i++;
            }
            else 
            {
            	aux[originalMap.getMapSize() + k] = aux[number1 + j];
                j++;
            }
            k++;
        }
        while (i < number1) 
        {
        	aux[originalMap.getMapSize() + k] = aux[i];
            i++;
            k++;
        }
        while (j < number2) 
        {
            aux[originalMap.getMapSize() + k] = aux[number1 + j];
            j++;
            k++;
        }
    }
    
    /**
     * Updates the sorted map based on the sorted auxiliary array.
     */
    private void updateSortedMap() 
    {
    	for (int i = 0; i < originalMap.getMapSize(); i++)
    	{
    		sortedMap.getMap().put(aux[originalMap.getMapSize() + i], originalMap.getMap().get(aux[originalMap.getMapSize() + i]));
    	}
    }
    
    /**
     * Prints the auxiliary array.
     */
    private void printAux()
    {
    	System.out.print("\naux: {");
    	for (int i = originalMap.getMapSize(); i < 2 * originalMap.getMapSize(); i++) 
    	{
    	    System.out.print(aux[i] + " ");
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
