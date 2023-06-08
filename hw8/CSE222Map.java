import java.awt.Color;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class CSE222Map
{
	private int 	size;
	private int[]  	indexBeginning;
	private int[]  	indexEnd;
	private int[][] map;
	private int[][] dummyMap;
	private List<Integer> bfsDijkstraPath;
	
	public CSE222Map(String inputFile, int size) throws IOException 
	{
		this.size = size;
		indexBeginning  =	new int[2];
		indexEnd		= 	new int[2];
		map 			= 	new int[size][size];
		dummyMap		= 	new int[size][size];
		bfsDijkstraPath = new ArrayList<>();
		readDataFromFile(inputFile);
		replaceNumbersInMap();
		if (map[indexBeginning[0]][indexBeginning[1]] != 0 || map[indexEnd[0]][indexEnd[1]] != 0)
		{
			System.out.println("There is no 0 in that indexes!!!");
			System.exit(0);
		}
	}
	
	// Verileri dosyadan okuyan metod
	public void readDataFromFile(String fileName) throws FileNotFoundException
	{
        ArrayList<int[]> dataList = new ArrayList<>();

        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        // Başlangıç indekslerini oku
        String temp = scanner.nextLine();
        for (int i = 0; i < temp.length(); i++) { // sayı olmayan bir karakter girildiğinde hata döndüreceğim..
            char c = temp.charAt(i);
            if ((!Character.isDigit(c)) && c != ',') {
            	System.out.println("There is an character except numbers and comma!!!");
            	System.exit(0); // Sayı olmayan bir karakter bulundu
            }
        }
        String[] tempValue = temp.split(",");
        indexBeginning[0] = Integer.parseInt(tempValue[0].trim());
        indexBeginning[1] = Integer.parseInt(tempValue[1].trim());
        
        if (!(indexBeginning[0] >= 0 && indexBeginning[0] <= size-1 && indexBeginning[1] >= 0 && indexBeginning[1] <= size-1))
        {
        	System.out.println("Beginning indexes is false. Because they can not be bigger than 499 or smaller than 0!!!");
        	System.exit(0);
        }
            
        // Bitiş indekslerini oku
        String tempEnd = scanner.nextLine();
        for (int i = 0; i < tempEnd.length(); i++) {  // sayı olmayan bir karakter girildiğinde hata döndüreceğim..
            char c = tempEnd.charAt(i);
            if ((!Character.isDigit(c)) && c != ',') {
            	System.out.println("There is an character except numbers and comma!!!");
            	System.exit(0); // Sayı olmayan bir karakter bulundu
            }
        }
        String[] tempEndValue = tempEnd.split(",");
        indexEnd[0] = Integer.parseInt(tempEndValue[0].trim());
        indexEnd[1] = Integer.parseInt(tempEndValue[1].trim());
        
        if (!(indexEnd[0] >= 0 && indexEnd[0] <= size-1 && indexEnd[1] >= 0 && indexEnd[1] <= size-1))
        {
        	System.out.println("End indexes is false. Because they can not be bigger than 499 or smaller than 0!!!");
        	System.exit(0);
        }
         
        // Haritayı oku
        while (scanner.hasNextLine()) 
        {
        	String line = scanner.nextLine();
        	String[] values = line.split(",");

        	int[] row = new int[values.length];
        	for (int i = 0; i < values.length; i++) 
        	{
        		row[i] = Integer.parseInt(values[i].trim());
        	}

            dataList.add(row);
        }
        scanner.close();

        for (int i = 0; i < dataList.size(); i++) 
        {
            map[i] = dataList.get(i);
        }
    }
	
	// Haritadaki -1 değerlerini 1 olarak değiştiren metod
	public void replaceNumbersInMap()
	{   
		for (int i = 0; i < map.length; i++)
		{
			for (int j = 0; j < map[i].length; j++)
			{
				if (map[i][j] == -1)
				{
					map[i][j] = 1;
				}
			}
		}
	}
	
	// Haritayı çizen metod (BFS için)
	public void drawLine(int z, String str)
	{
		int width = 1000;
		int height = 1000;
		if (size > 500)
		{
			width *= 2;
			height *= 2;
			
		}
		int cellWidth = width / map[0].length;
		int cellHeight = height / map.length;
		
		boolean flag = false;
	    for (int i = 0; i < map.length; i++)
	    {
	       	for (int j = 0; j < map[i].length; j++)
	       	{
	       		flag = false;
	       		for (int x = 0; x < bfsDijkstraPath.size(); x++)
        		{
	       			if (bfsDijkstraPath.get(x) == ((i * size) + j))
	        		{
	        			dummyMap[i][j] = 2; 
	       				flag = true;
	       				break;
	       			}
	       		}
	       		if (flag == false)
	       		{
	       			dummyMap[i][j] = map[i][j];
	       		}
        	}
	    }
		
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        for (int i = 0; i < dummyMap.length; i++) 
        {
            for (int j = 0; j < dummyMap[i].length; j++) 
            {
                int x = j * cellWidth;
                int y = i * cellHeight;
                
                if (dummyMap[i][j] == 1) 
                {
                    g2d.setColor(Color.WHITE);
                } 
                else if (dummyMap[i][j] == 2)
                {
                	g2d.setColor(Color.green);
                }
                else 
                {
                    g2d.setColor(Color.BLACK);
                }

                g2d.fillRect(x, y, cellWidth, cellHeight);
                g2d.setColor(Color.BLACK);
                g2d.drawRect(x, y, cellWidth, cellHeight);
            }
        }

        g2d.dispose();

        try 
        {
        	if (z != 0)
        	{
        		ImageIO.write(image, "PNG", new File("mapBfs" + z + ".png"));
            	System.out.println("Dosya başarıyla kaydedildi: " + "mapBfs" + z + ".png");
        	}
        	else
        	{
        		ImageIO.write(image, "PNG", new File("mapBfs_" + str + ".png"));
            	System.out.println("Dosya başarıyla kaydedildi: " + "mapBfs_" + str + ".png");
        	}
        } 
        catch (IOException e) 
        {
            System.out.println("Dosya kaydedilirken bir hata oluştu: " + e.getMessage());
        }
	}
	
	// Haritayı çizen metod (Dijkstra için)
	public void drawLine2(int z, String str)
	{
		int width = 1000;
		int height = 1000;
		if (size > 500)
		{
			width *= 2;
			height *= 2;
			
		}
		
		int cellWidth = width / map[0].length;
		int cellHeight = height / map.length;
		
		boolean flag = false;
	    for (int i = 0; i < map.length; i++)
	    {
	       	for (int j = 0; j < map[i].length; j++)
	       	{
	       		flag = false;
	       		for (int x = 0; x < bfsDijkstraPath.size(); x++)
        		{
	       			if (bfsDijkstraPath.get(x) == ((i * size) + j))
	        		{
	        			dummyMap[i][j] = 2; 
	       				flag = true;
	       				break;
	       			}
	       		}
	       		if (flag == false)
	       		{
	       			dummyMap[i][j] = map[i][j];
	       		}
        	}
	    }
		
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        for (int i = 0; i < dummyMap.length; i++) 
        {
            for (int j = 0; j < dummyMap[i].length; j++) 
            {
                int x = j * cellWidth;
                int y = i * cellHeight;

                if (dummyMap[i][j] == 1) 
                {
                    g2d.setColor(Color.WHITE);
                } 
                else if (dummyMap[i][j] == 2)
                {
                	g2d.setColor(Color.green);
                }
                else 
                {
                    g2d.setColor(Color.BLACK);
                }

                g2d.fillRect(x, y, cellWidth, cellHeight);
                g2d.setColor(Color.BLACK);
                g2d.drawRect(x, y, cellWidth, cellHeight);
            }
        }

        g2d.dispose();

        try 
        {
        	if (z != 0)
        	{
	            ImageIO.write(image, "PNG", new File("mapDijkstra" + z + ".png"));
	            System.out.println("Dosya başarıyla kaydedildi: " + "mapDijkstra" + z + ".png");
        	}
        	else
        	{
        		 ImageIO.write(image, "PNG", new File("mapDijkstra_" + str + ".png"));
 	            System.out.println("Dosya başarıyla kaydedildi: " + "mapDijkstra_" + str + ".png");
        	}
        } 
        catch (IOException e) 
        {
            System.out.println("Dosya kaydedilirken bir hata oluştu: " + e.getMessage());
        }
	}

	public void printMap()
	{
		for (int i = 0; i < map.length; i++)
		{
			for (int j = 0; j < map[i].length; j++)
			{
				System.out.print(map[i][j]);
			}
			System.out.print("\n");
		}
	}
	
	public void setBfsDijkstraPath(List<Integer> path)
	{
		bfsDijkstraPath = path;
	}
	
	public void printBegin()
	{
		System.out.println(indexBeginning[0] + "," + indexBeginning[1]);
	}
	
	public void printEnd()
	{
		System.out.println(indexEnd[0] + "," + indexEnd[1]);
	}
	
	public int[][] getMap()
	{
		return map;
	}
	
	public int[] getIndexBeginning()
	{
		return indexBeginning;
	}
	
	public int[] getIndekEnd()
	{
		return indexEnd;
	}
}
