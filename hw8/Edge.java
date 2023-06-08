public class Edge 
{
	private int x;
	private int y;
	
	public Edge(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void printIndex()
	{
		System.out.println(x + " " + y);
	}
}
