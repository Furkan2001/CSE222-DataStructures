import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class CSE222Graph 
{
	private int   size;
	private int[] startVertex;
	private int[] endVertex;
	private ArrayList<Vertex> vertex;
	private List<Integer> bfsPath;
	private List<Integer> dijkstraPath;
	
	public CSE222Graph(CSE222Map realMap, int size)
	{
		this.size = size;
		int count = 0;
		int[][] map = realMap.getMap();
		startVertex = new int[2];
		endVertex = new int[2];
		bfsPath 		= new ArrayList<>();
		dijkstraPath	= new ArrayList<>();
		startVertex = realMap.getIndexBeginning();
		endVertex	= realMap.getIndekEnd();
		vertex = new ArrayList<Vertex>();
		
		for (int i = 0; i < map.length; i++)
		{
			for (int j = 0; j < map[i].length; j++)
			{
				if (map[i][j] == 0)
				{
					vertex.add(new Vertex(count,i,j,map,size));
					count++;
				}
			}
		}
	}
	
	public void printGraph()
	{
		for (int i = 0; i < vertex.size(); i++)
		{
			System.out.print("Coordinate of " + i + ". vertex is ");
			vertex.get(i).printIndex();
			System.out.println("\t\tWith this vertex, the coordinates of the vertexes that have the edge are given;");
			vertex.get(i).printEdges();
			System.out.println();
			System.out.println();
		}
	}
	
	 // BFS algoritması ile başlangıç düğümünden hedef düğüme giden yolu bulma
    public List<Integer> findBfsPath(int start, int target) 
    {
        boolean[] visited = new boolean[size * size];
        Vertex[] parent = new Vertex[size * size];

        Queue<Vertex> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(findNumberOfVertex(start));

        while (!queue.isEmpty()) //queue boş olana kadar döngüyü dönder
        {
            Vertex currentVertex = queue.poll();

            ArrayList<Edge> neighbors = currentVertex.getEdges();

            for (int i = 0; i < neighbors.size(); i++) // tüm okmşuları kontrol et
            {
                if (!visited[(neighbors.get(i).getX()*size) + neighbors.get(i).getY()]) 
                {
                    visited[(neighbors.get(i).getX() * size) + neighbors.get(i).getY()] = true;
                    parent[(neighbors.get(i).getX() * size) + neighbors.get(i).getY()] = currentVertex;
                    queue.add(findNumberOfVertex((neighbors.get(i).getX() * size) + neighbors.get(i).getY()));

                    // Hedef düğüme ulaşıldıysa, yolunuzu döndürebilirsiniz
                    if (((neighbors.get(i).getX() * size) + neighbors.get(i).getY()) == target) 
                    {
                        return constructPath(parent, start, target);
                    }
                }
            }
        }
        // Hedef düğüme ulaşılamadı
        return null;
    }
    
    public List<Integer> findDijkstraPath(int start, int target) 
    {
    	int [][] arr = new int[size][size];  // distance
    	int [][] helpForPath = new int[size][size];   // parent
    	boolean [][] control = new boolean[size][size];   // boolean kontrol dizisi
    	int value = 0;   // döngüde bir sonraki en kısa uzaklığa sahip distance indexini seçmek için oluşturdum.
    	
    	for (int i = 0; i < arr.length; i++)  // arr değişkenini doldurdum.
    	{
    		for (int j = 0; j < arr[i].length; j++)
    		{
    			if ((i * size) + j != start) // arraydeki tüm indekslere sonsuz integer değeri atadım
    			{
    				arr[i][j] = Integer.MAX_VALUE;
    			}
    			else  // başlangıç index e uzaklık hali hazırda 0 olduğu için direk 0 ı verdim
    			{
    				arr[i][j] = 0;
    			}
    		}
    	}
  
    	for (int i = 0; i < control.length; i++)  // control değişkenini doldurdum
    	{
    		for (int j = 0; j < control[i].length; j++)
    		{
    			control[i][j] = false;
    		}
    	}

    	for (int i = 0; i < vertex.size(); i++) // başlangıç indexini buldum..
    	{
    		if (start == (vertex.get(i).getX() * size) + vertex.get(i).getY())
    		{
    			value = i;
    			break;
    		}
    	}
    	int min = Integer.MAX_VALUE;
    	do // Start of Do-While loop...
    	{
    		ArrayList<Edge> edges = vertex.get(value).getEdges();
    		control[vertex.get(value).getX()][vertex.get(value).getY()] = true;

    		for (int i = 0; i < edges.size(); i++) // belirli bir vertexe göre daha yakın bir yol bulunduysa o yol güncellenir
    		{
    			if (arr[edges.get(i).getX()][edges.get(i).getY()] > arr[vertex.get(value).getX()][vertex.get(value).getY()])
    			{
    				arr[edges.get(i).getX()][edges.get(i).getY()] = arr[vertex.get(value).getX()][vertex.get(value).getY()] + 1;
    				helpForPath[edges.get(i).getX()][edges.get(i).getY()] = ((vertex.get(value).getX() * size) + vertex.get(value).getY());
    			}
    		}
    	
    		min = Integer.MAX_VALUE;
    		boolean flag = false;
    		for (int i = 0; i < vertex.size(); i++) // bir sonraki döngüde hangi vertexe göre kontrol yapılacağını bulan döngü
    		{
    			if (min > arr[vertex.get(i).getX()][vertex.get(i).getY()] && control[vertex.get(i).getX()][vertex.get(i).getY()] == false && ((vertex.get(i).getX() * size) + vertex.get(i).getY()) != start && arr[vertex.get(i).getX()][vertex.get(i).getY()] != Integer.MAX_VALUE)
    			{
    				flag = true;
    				value = i;
    				min = arr[vertex.get(i).getX()][vertex.get(i).getY()];
    			}
    		}
    		if (flag == false)
    		{
    			break;
    		}

    		if (arr[vertex.get(value).getX()][vertex.get(value).getY()] == 0)
    		{
    			value = Integer.MAX_VALUE;
    		}
    		
    	}	while(min != Integer.MAX_VALUE);   // End of While loop...
    	
    	if (arr[target / size][target % size] == Integer.MAX_VALUE)
    	{
    		 // Hedef düğüme ulaşılamadı
    		return null;
    	}
    	
    	int temp = -1;
    	while (target != start)
    	{
    		dijkstraPath.add(target);
    		temp = helpForPath[target / size][target % size];
    		target = temp;
    	}
    	dijkstraPath.add(target);
    	Collections.reverse(dijkstraPath);
    	
    	return dijkstraPath;
    }

   
	
    // BFS algoritmasının sonucunda bulunan yolu oluşturma
    public List<Integer> constructPath(Vertex[] parent, int start, int target) 
    {
        List<Integer> path = new ArrayList<>();
        int vertex = target;
        while (vertex != start) 
        {
            path.add(vertex);
            vertex = ((parent[vertex].getX() * size) + parent[vertex].getY());
        }
        path.add(start);
        Collections.reverse(path);
        return path;
    }
	
    public Vertex findNumberOfVertex(int number)
    {
    	for (int i = 0; i < vertex.size(); i++)
    	{
    		if (vertex.get(i).getX() == (number / size) && vertex.get(i).getY() == (number % size))
    		{
    			return vertex.get(i);
    		}
    	}
    	return null; // there is no vertex in this coordinate...
    }
    
    public void printTxt(String txt, List<Integer> path) throws IOException
    {
    	bfsPath = path;
    	File outputFile = new File(txt);
    	FileWriter writer = new FileWriter(outputFile);
    	for (int i = 0; i < path.size(); i++)
    	{
    		 writer.write(path.get(i)/size + " " + path.get(i)%size + "\n");
    	}
    	writer.close();
    }
    
    public void printTxt2(String txt, List<Integer> path) throws IOException
    {
    	dijkstraPath = path;
    	File outputFile = new File(txt);
    	FileWriter writer = new FileWriter(outputFile);
    	for (int i = 0; i < path.size(); i++)
    	{
    		 writer.write(path.get(i)/size + " " + path.get(i)%size + "\n");
    	}
    	writer.close();
    }
    
    public List<Integer> getBfsPath()
    {
    	return bfsPath;
    }
    
    public List<Integer> getDijkstraPath()
    {
    	return dijkstraPath;
    }
    
	public int[] getStartVertex()
	{
		return startVertex;
	}
	
	public int[] getEndVertex()
	{
		return endVertex;
	}
}
