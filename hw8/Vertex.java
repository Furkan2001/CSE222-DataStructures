import java.util.ArrayList;

public class Vertex 
{
	private int size;
	private int number;
	private int x;
	private int y;
	ArrayList<Edge> edges;
	
	public Vertex(int number, int x, int y, int[][] map, int size)
	{
		this.size = size;
		this.number = number;
		this.x = x;
		this.y = y;
		edges = new ArrayList<Edge>();
		
		if (x != 0 && y != 0 && x != (size-1) && y != (size-1))
		{
			if (map[x-1][y-1] == 0)
			{
				edges.add(new Edge(x-1, y-1));
			}
			if (map[x-1][y] == 0)
			{
				edges.add(new Edge(x-1, y));
			}
			if (map[x-1][y+1] == 0)
			{
				edges.add(new Edge(x-1, y+1));
			}
			if (map[x][y-1] == 0)
			{
				edges.add(new Edge(x, y-1));
			}
			if (map[x][y+1] == 0)
			{
				edges.add(new Edge(x, y+1));
			}
			if (map[x+1][y-1] == 0)
			{
				edges.add(new Edge(x+1, y-1));
			}
			if (map[x+1][y] == 0)
			{
				edges.add(new Edge(x+1, y));
			}
			if (map[x+1][y+1] == 0)
			{
				edges.add(new Edge(x+1, y+1));
			}
		}
		else if (x != 0 && y != 0 && x != (size-1))
		{
			if (map[x-1][y-1] == 0)
			{
				edges.add(new Edge(x-1, y-1));
			}
			if (map[x-1][y] == 0)
			{
				edges.add(new Edge(x-1, y));
			}
			if (map[x][y-1] == 0)
			{
				edges.add(new Edge(x, y-1));
			}
			if (map[x+1][y-1] == 0)
			{
				edges.add(new Edge(x+1, y-1));
			}
			if (map[x+1][y] == 0)
			{
				edges.add(new Edge(x+1, y));
			}
		}
		else if (x != 0 && y != 0 && y != (size-1))
		{
			if (map[x-1][y-1] == 0)
			{
				edges.add(new Edge(x-1, y-1));
			}
			if (map[x-1][y] == 0)
			{
				edges.add(new Edge(x-1, y));
			}
			if (map[x-1][y+1] == 0)
			{
				edges.add(new Edge(x-1, y+1));
			}
			if (map[x][y-1] == 0)
			{
				edges.add(new Edge(x, y-1));
			}
			if (map[x][y+1] == 0)
			{
				edges.add(new Edge(x, y+1));
			}
		}
		else if (x != 0 && x != (size-1) && y != (size-1))
		{
			if (map[x-1][y] == 0)
			{
				edges.add(new Edge(x-1, y));
			}
			if (map[x-1][y+1] == 0)
			{
				edges.add(new Edge(x-1, y+1));
			}
			if (map[x][y+1] == 0)
			{
				edges.add(new Edge(x, y+1));
			}
			if (map[x+1][y] == 0)
			{
				edges.add(new Edge(x+1, y));
			}
			if (map[x+1][y+1] == 0)
			{
				edges.add(new Edge(x+1, y+1));
			}
		}
		else if (y != 0 && x != (size-1) && y != (size-1))
		{
			if (map[x][y-1] == 0)
			{
				edges.add(new Edge(x, y-1));
			}
			if (map[x][y+1] == 0)
			{
				edges.add(new Edge(x, y+1));
			}
			if (map[x+1][y-1] == 0)
			{
				edges.add(new Edge(x+1, y-1));
			}
			if (map[x+1][y] == 0)
			{
				edges.add(new Edge(x+1, y));
			}
			if (map[x+1][y+1] == 0)
			{
				edges.add(new Edge(x+1, y+1));
			}
		}
		else if (x != 0 && y != 0)
		{
			if (map[x-1][y-1] == 0)
			{
				edges.add(new Edge(x-1, y-1));
			}
			if (map[x-1][y] == 0)
			{
				edges.add(new Edge(x-1, y));
			}
			if (map[x][y-1] == 0)
			{
				edges.add(new Edge(x, y-1));
			}
		}
		else if (x != 0 && y != (size-1))
		{
			if (map[x-1][y] == 0)
			{
				edges.add(new Edge(x-1, y));
			}
			if (map[x-1][y+1] == 0)
			{
				edges.add(new Edge(x-1, y+1));
			}
			if (map[x][y+1] == 0)
			{
				edges.add(new Edge(x, y+1));
			}
		}
		else if (x != (size-1) && y != (size-1))
		{
			if (map[x][y+1] == 0)
			{
				edges.add(new Edge(x, y+1));
			}
			if (map[x+1][y] == 0)
			{
				edges.add(new Edge(x+1, y));
			}
			if (map[x+1][y+1] == 0)
			{
				edges.add(new Edge(x+1, y+1));
			}
		}
		else if (y != 0 && x != (size-1))
		{
			if (map[x][y-1] == 0)
			{
				edges.add(new Edge(x, y-1));
			}
			if (map[x+1][y-1] == 0)
			{
				edges.add(new Edge(x+1, y-1));
			}
			if (map[x+1][y] == 0)
			{
				edges.add(new Edge(x+1, y));
			}
		}
	}
	
	public boolean findEdge(int x, int y)
	{
		for (int i = 0; i < edges.size(); i++)
		{
			if (edges.get(i).getX() == x && edges.get(i).getY() == y)
			{
				return true;
			}
		}
		return false;
	}
	
	public void printIndex()
	{
		System.out.print(x + " " + y);
	}
	
	public void printEdges()
	{
		for (int i = 0; i < edges.size(); i++)
		{
			edges.get(i).printIndex();
		}
	}
	
	public int getResult() // bir boyutlu array için bulunduğu konum... Graph ın dijkstra methodunda kullanıcam...
	{
		return ((x * size) + y);
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getNumber()
	{
		return number;
	}
	
	public ArrayList<Edge> getEdges()
	{
		return edges;
	}
}
