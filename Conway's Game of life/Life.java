
/**
 * Write a description of class Life here.
 *
 * @author (Rohan Huynh)
 * @version (2/2/24)
 */
public class Life
{
    public static final int ROWS = 20;
    public static final int COLS = 80;
    public static final int TIME_DELAY=500;
    
    public static void initializeBOARD(Board b)
    {
        for (int r = 0; r < ROWS; r++)
        {
            for(int c = 0; c < COLS; c++)
            {
                int randVal = (int) (Math.random() * 3); // random number 0, 1, 2
                if (randVal == 0)
                {
                    b.set(r,c,1);
                }
            }
        } 
    }
    
    public static void displayBoard(Board board)
    {
        for (int r = 0; r < ROWS; r++)
        {
            for(int c= 0; c < COLS; c++)
            {
                if (board.get(r,c) == 0)
                {
                    System.out.print(".");
                }
                else if (board.get(r,c) == 1)
                {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }
    
    public static void calculateNextGeneration(Board b, Board nextB)
    {
        for (int r = 0; r  < ROWS; r++)
        {
            for (int c = 0; c< COLS; c++)
            {
                int neighborCount = countNeighbors(r, c, b);
                if (b.get(r,c) == 1 && neighborCount < 2)
                {
                    nextB.set(r, c, 0);
                }
                else if (b.get(r,c) == 1 && neighborCount <= 3) //first statement already dealt with if it was underpopulation
                {
                    nextB.set(r, c, 1);
                }
                else if (b.get(r,c) == 1 && neighborCount > 3)
                {
                    nextB.set(r, c, 0);
                }
                else if (b.get(r, c) == 0 && neighborCount == 3)
                {
                    nextB.set(r, c, 1);
                }
                else
                {
                    nextB.set(r, c, 0);
                }
            }
        }
    }
    
    public static int countNeighbors(int row, int col, Board b)
    {
        int count = 0;
        for (int r = row - 1; r <= row + 1; r++)
        {
            for (int c = col -1; c <= col +1; c++)
            {
                if (r >= 0 && r <= ROWS && 
                    c >= 0 && c <= COLS && 
                    !(r == row && c == col) && 
                    b.get(r,c) == 1)
                {
                    count ++;
                }
            }
        }
        return count;
    }
    
    public static void transferNextToCurrent(Board board, Board nextBoard)
    {
        
    }
    
    public static void main(String[] args)
    {
        Board board = new Board(ROWS, COLS);
        initializeBOARD(board);
        displayBoard(board);
        System.out.println(countNeighbors(0, 0, board));
    }
    
    
    
    
}
