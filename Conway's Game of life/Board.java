
/**
 * Write a description of class Board here.
 *
 * @author (Rohan Huynh)
 * @version (2/1/24)
 */
public class Board
{
    
    int[][] grid;
    
    /**
     * Constructor for objects of class Board
     */
    public Board(int rows, int cols)
    {
        // initialise instance variables
        grid = new int[rows][cols];
    }
    
    public int get(int row, int col) 
    {
        return grid[row][col];
    }
    
    public void set(int row, int col, int value)
    {
        grid[row][col] = value;
    }
    
    public int getRows()
    {
        return grid.length;
    }
    
    public int getCols()
    {
        return grid[0].length;
    }
    
    public String toString()
    {
        String result = "";
        for (int r = 0; r < getRows(); r++)
        {
            for(int c = 0; c < getCols(); c++)
            {
                result += grid[r][c];
            }
            result += "\n";
        } 
        return result;
    }
}
