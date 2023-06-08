import java.io.IOException;
import java.util.List;

public class TestCases implements Runnable 
{

    private  String FileName;
    private int X_SIZE;
    private int Y_SIZE;

    public TestCases(String FileName, int X_SIZE, int Y_SIZE) 
    {
        this.FileName = FileName;
        this.X_SIZE = X_SIZE;
    	this.Y_SIZE = Y_SIZE;
    }
    
    public void test() throws IOException 
    {
    	System.out.println("\n\n*******************\nMap is " + this.FileName + " with X_SIZE " + this.X_SIZE + " and Y_SIZE " + this.Y_SIZE + "\n********************\n");
    	
    	int txtNumber = 0;
    	
    	for (int i = 0; i < FileName.length(); i++) {
    	    char c = FileName.charAt(i);
    	    if (Character.isDigit(c)) 
    	    {
    	    	txtNumber *= 10;
    	    	txtNumber += c - 48;
    	    }
    	}
    	
    	String str = FileName.substring(0, FileName.length() - 4);
    	
    	
    	CSE222Map map = new CSE222Map(FileName, X_SIZE);
		//map.printMap();  //1
		//map.printBegin();  //2
		//map.printEnd();  //3
		
		CSE222Graph graph = new CSE222Graph(map, X_SIZE);
		//graph.printGraph();  //4
		
		int [] start = graph.getStartVertex();
		int [] end	 = graph.getEndVertex();
		int startIndex = ((start[0] * X_SIZE) + start[1]);
		int endIndex = ((end[0] * X_SIZE) + end[1]);
		
		List<Integer> path = graph.findBfsPath(startIndex, endIndex);
		
		if (path != null) 
		{
            System.out.println("\n\nBFS Path from " + start[0] + " " + start[1] + " to " + end[0] + " " + end[1]);
            for (int i = 0; i < path.size(); i++)
            {
            	graph.printTxt(str + "BFS_path.txt", path);
            }
            System.out.println("The distance between the starting point and the end point is " + (path.size()-1));
        } 
		else 
        {
            System.out.println("No path found from " + start[0] + " " + start[1] + " to " + end[0] + " " + end[1]);
            System.exit(0);
        }
		
		map.setBfsDijkstraPath(graph.getBfsPath());
    	map.drawLine(txtNumber, str);
		
		
		path = graph.findDijkstraPath(startIndex, endIndex);
		
		if (path != null) 
		{
            System.out.println("\n\nDijkstra Path from " + start[0] + " " + start[1] + " to " + end[0] + " " + end[1]);
            for (int i = 0; i < path.size(); i++)
            {
            	graph.printTxt2(str + "Dijkstra_path.txt", path);
            }
            System.out.println("The distance between the starting point and the end point is " + (path.size()-1));
        } 
		else 
        {
            System.out.println("\n\nNo path found from " + start[0] + " " + start[1] + " to " + end[0] + " " + end[1]);
            System.exit(0);
        }
		
		map.setBfsDijkstraPath(graph.getDijkstraPath());
		map.drawLine2(txtNumber, str);
	

    }

    @Override
    public void run() 
    {
			try 
			{
				test();
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
}

