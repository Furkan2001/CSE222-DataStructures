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
        String temp = "'Hush, hush!' whispered the rushing wind. tant kart fanh trn fssdw fskke rutuht bfjbj fvj fpemb khkg hlh hg bbty py bk ejj qio";
        MyMap myMap = new MyMap(temp);
        System.out.println("Original String:\t" + temp);
        System.out.println("");
        System.out.println("Preprocessed String:    " + myMap.getStr());
        System.out.println("\n\nThe original (unsorted) map:");
        myMap.printMap();
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("\nThe merge sorted map:");
        MergeSort Sort0 = new MergeSort(myMap);
        Sort0.sort();
        Sort0.printSortedMap();
        
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("\nThe selection sorted map:");
        SelectionSort Sort1 = new SelectionSort(myMap);
        Sort1.sort();
        Sort1.printSortedMap();
        
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("\nThe insertion sorted map:");
        InsertionSort Sort2 = new InsertionSort(myMap);
        Sort2.sort();
        Sort2.printSortedMap();
        
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("\nThe bubble sorted map:");
        BubbleSort Sort3 = new BubbleSort(myMap);
        Sort3.sort();
        Sort3.printSortedMap();
        
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("\nThe quick sorted map:");
        QuickSort Sort4 = new QuickSort(myMap);
        Sort4.sort();
        Sort4.printSortedMap();
        
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\n\n\n");
        
        long[] startTime = new long[15];
        long[] endTime = new long[15];
        long[] totalTime = new long[15];
		String[] str = new String[15];
        
        str[2] = "abc cbc ctt ttt";
        str[1] = "acb cbc ctt ttt";
        str[0] = "ttc cbc ttt acb";

        myMap = new MyMap(str[0]);
        System.out.println("str[0]: Original String:\t" + str[0]);
        System.out.println("");
        System.out.println("Preprocessed String:    " + myMap.getStr());
        System.out.println("\n\nThe original (unsorted) map:");
        myMap.printMap();
		System.out.println("\nThe merge sorted map:");
		MergeSort Sort = new MergeSort(myMap);
        startTime[0] = System.nanoTime();
		Sort.sort();
        endTime[0] = System.nanoTime();
        totalTime[0] = endTime[0] - startTime[0];
		Sort.printSortedMap();
        System.out.println("Time: " + totalTime[0] + " ns");
        
        System.out.println("\n*************************************");
        
        myMap = new MyMap(str[1]);
        System.out.println("\n\nstr[1]: Original String:\t" + str[1]);
        System.out.println("");
        System.out.println("Preprocessed String:    " + myMap.getStr());
        System.out.println("\n\nThe original (unsorted) map:");
        myMap.printMap();
        System.out.println("\nThe merge sorted map:");
        Sort = new MergeSort(myMap);
        startTime[1] = System.nanoTime();
        Sort.sort();
        endTime[1] = System.nanoTime();
        totalTime[1] = endTime[1] - startTime[1];
        Sort.printSortedMap();
        System.out.println("Time: " + totalTime[1] + " ns");
        
        System.out.println("\n*************************************");
        
        myMap = new MyMap(str[2]);
        System.out.println("\n\nstr[2]: Original String:\t" + str[2]);
        System.out.println("");
        System.out.println("Preprocessed String:    " + myMap.getStr());
        System.out.println("\n\nThe original (unsorted) map:");
        myMap.printMap();
        System.out.println("\nThe merge sorted map:");
        Sort = new MergeSort(myMap);
        startTime[2] = System.nanoTime();
        Sort.sort();
        endTime[2] = System.nanoTime();
        totalTime[2] = endTime[2] - startTime[2];
        Sort.printSortedMap();
        System.out.println("Time: " + totalTime[2] + " ns");
        
		System.out.println("-----------------------------------------------------------------------------");
        
        str[5] = "abc cbc ctt ttt";
        str[4] = "acb cbc ctt ttt";
        str[3] = "ttc cbc ttt acb";
        
        myMap = new MyMap(str[3]);
        System.out.println("\n\nstr[3]: Original String:\t" + str[3]);
        System.out.println("");
        System.out.println("Preprocessed String:    " + myMap.getStr());
        System.out.println("\n\nThe original (unsorted) map:");
        myMap.printMap();
		System.out.println("\nThe selection sorted map:");
		SelectionSort selection = new SelectionSort(myMap);
        startTime[3] = System.nanoTime();
		selection.sort();
        endTime[3] = System.nanoTime();
        totalTime[3] = endTime[3] - startTime[3];
		selection.printSortedMap();
        System.out.println("Time: " + totalTime[3] + " ns");
        
        System.out.println("\n*************************************");
        
        myMap = new MyMap(str[4]);
        System.out.println("\n\nstr[4]: Original String:\t" + str[4]);
        System.out.println("");
        System.out.println("Preprocessed String:    " + myMap.getStr());
        System.out.println("\n\nThe original (unsorted) map:");
        myMap.printMap();
        System.out.println("\nThe selection sorted map:");
        selection = new SelectionSort(myMap);
        startTime[4] = System.nanoTime();
        selection.sort();
        endTime[4] = System.nanoTime();
        totalTime[4] = endTime[4] - startTime[4];
        selection.printSortedMap();
        System.out.println("Time: " + totalTime[4] + " ns");
        
        System.out.println("\n*************************************");
        
        myMap = new MyMap(str[5]);
        System.out.println("\n\nstr[5]: Original String:\t" + str[5]);
        System.out.println("");
        System.out.println("Preprocessed String:    " + myMap.getStr());
        System.out.println("\n\nThe original (unsorted) map:");
        myMap.printMap();
        System.out.println("\nThe selection sorted map:");
        selection = new SelectionSort(myMap);
        startTime[5] = System.nanoTime();
        selection.sort();
        endTime[5] = System.nanoTime();
        totalTime[5] = endTime[5] - startTime[5];
        selection.printSortedMap();
        System.out.println("Time: " + totalTime[5] + " ns");
        
		System.out.println("-----------------------------------------------------------------------------");
        str[8] = "abc cbc ctt ttt";
        str[7] = "acb cbc ctt ttt";
        str[6] = "ttc cbc ttt acb";
        
        myMap = new MyMap(str[6]);
        System.out.println("\n\nstr[6]: Original String:\t" + str[6]);
        System.out.println("");
        System.out.println("Preprocessed String:    " + myMap.getStr());
        System.out.println("\n\nThe original (unsorted) map:");
        myMap.printMap();
		System.out.println("\nThe insertion sorted map:");
		InsertionSort insertion = new InsertionSort(myMap);
        startTime[6] = System.nanoTime();
		insertion.sort();
        endTime[6] = System.nanoTime();
        totalTime[6] = endTime[6] - startTime[6];
		insertion.printSortedMap();
        System.out.println("Time: " + totalTime[6] + " ns");
        
        System.out.println("\n*************************************");
        
        myMap = new MyMap(str[7]);
        System.out.println("\n\nstr[7]: Original String:\t" + str[7]);
        System.out.println("");
        System.out.println("Preprocessed String:    " + myMap.getStr());
        System.out.println("\n\nThe original (unsorted) map:");
        myMap.printMap();
        System.out.println("\nThe insertion sorted map:");
        insertion = new InsertionSort(myMap);
        startTime[7] = System.nanoTime();
        insertion.sort();
        endTime[7] = System.nanoTime();
        totalTime[7] = endTime[7] - startTime[7];
        insertion.printSortedMap();
        System.out.println("Time: " + totalTime[7] + " ns");
        
        System.out.println("\n*************************************");
        
        myMap = new MyMap(str[8]);
        System.out.println("\n\nstr[8]: Original String:\t" + str[8]);
        System.out.println("");
        System.out.println("Preprocessed String:    " + myMap.getStr());
        System.out.println("\n\nThe original (unsorted) map:");
        myMap.printMap();
        System.out.println("\nThe insertion sorted map:");
        insertion = new InsertionSort(myMap);
        startTime[8] = System.nanoTime();
        insertion.sort();
        endTime[8] = System.nanoTime();
        totalTime[8] = endTime[8] - startTime[8];
        insertion.printSortedMap();
        System.out.println("Time: " + totalTime[8] + " ns");
        
		System.out.println("-----------------------------------------------------------------------------");
        str[11] = "abc cbc ctt ttt";
        str[10] = "acb cbc ctt ttt";
        str[9] = "ttc cbc ttt acb";
        
        myMap = new MyMap(str[9]);
        System.out.println("\n\nstr[9]: Original String:\t" + str[9]);
        System.out.println("");
        System.out.println("Preprocessed String:    " + myMap.getStr());
        System.out.println("\n\nThe original (unsorted) map:");
        myMap.printMap();
		System.out.println("\nThe bubble sorted map:");
		BubbleSort bubble = new BubbleSort(myMap);
        startTime[9] = System.nanoTime();
		bubble.sort();
        endTime[9] = System.nanoTime();
        totalTime[9] = endTime[9] - startTime[9];
		bubble.printSortedMap();
        System.out.println("Time: " + totalTime[9] + " ns");
        
        System.out.println("\n*************************************");
        
        myMap = new MyMap(str[10]);
        System.out.println("\n\nstr[10]: Original String:\t" + str[10]);
        System.out.println("");
        System.out.println("Preprocessed String:    " + myMap.getStr());
        System.out.println("\n\nThe original (unsorted) map:");
        myMap.printMap();
        System.out.println("\nThe bubble sorted map:");
        bubble = new BubbleSort(myMap);
        startTime[10] = System.nanoTime();
        bubble.sort();
        endTime[10] = System.nanoTime();
        totalTime[10] = endTime[10] - startTime[10];
        bubble.printSortedMap();
        System.out.println("Time: " + totalTime[10] + " ns");
        
        System.out.println("\n*************************************");
        
        myMap = new MyMap(str[11]);
        System.out.println("\n\nstr[11]: Original String:\t" + str[11]);
        System.out.println("");
        System.out.println("Preprocessed String:    " + myMap.getStr());
        System.out.println("\n\nThe original (unsorted) map:");
        myMap.printMap();
        System.out.println("\nThe bubble sorted map:");
        bubble = new BubbleSort(myMap);
        startTime[11] = System.nanoTime();
        bubble.sort();
        endTime[11] = System.nanoTime();
        totalTime[11] = endTime[11] - startTime[11];
        bubble.printSortedMap();
        System.out.println("Time: " + totalTime[11] + " ns");
        
		System.out.println("-----------------------------------------------------------------------------");
        str[14] = "abc cbc ctt ttt";
        str[13] = "acb cbc ctt ttt";
        str[12] = "ttc cbc ttt acb";
        
        myMap = new MyMap(str[12]);
        System.out.println("\n\nstr[12]: Original String:\t" + str[12]);
        System.out.println("");
        System.out.println("Preprocessed String:    " + myMap.getStr());
        System.out.println("\n\nThe original (unsorted) map:");
        myMap.printMap();
		System.out.println("\nThe quick sorted map:");
		QuickSort quick = new QuickSort(myMap);
        startTime[12] = System.nanoTime();
		quick.sort();
        endTime[12] = System.nanoTime();
        totalTime[12] = endTime[12] - startTime[12];
		quick.printSortedMap();
        System.out.println("Time: " + totalTime[12] + " ns");
        
        System.out.println("\n*************************************");
        
        myMap = new MyMap(str[13]);
        System.out.println("\n\nstr[13]: Original String:\t" + str[13]);
        System.out.println("");
        System.out.println("Preprocessed String:    " + myMap.getStr());
        System.out.println("\n\nThe original (unsorted) map:");
        myMap.printMap();
        System.out.println("\nThe quick sorted map:");
        quick = new QuickSort(myMap);
        startTime[13] = System.nanoTime();
        quick.sort();
        endTime[13] = System.nanoTime();
        totalTime[13] = endTime[13] - startTime[13];
        quick.printSortedMap();
        System.out.println("Time: " + totalTime[13] + " ns");
        
        System.out.println("\n*************************************");
        
        myMap = new MyMap(str[14]);
        System.out.println("\n\nstr[14]: Original String:\t" + str[14]);
        System.out.println("");
        System.out.println("Preprocessed String:    " + myMap.getStr());
        System.out.println("\n\nThe original (unsorted) map:");
        myMap.printMap();
        System.out.println("\nThe quick sorted map:");
        quick = new QuickSort(myMap);
        startTime[14] = System.nanoTime();
        quick.sort();
        endTime[14] = System.nanoTime();
        totalTime[14] = endTime[14] - startTime[14];
        quick.printSortedMap();
        System.out.println("Time: " + totalTime[14] + " ns");
	}
}
