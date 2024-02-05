
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
    
    public static void calculateNextGneration(Board b, Board nextB)
    {
        
    }
    
    public static void main(String[] args)
    {
        Board board = new Board(ROWS, COLS);
        initializeBOARD(board);
        displayBoard(board);
    }
    
    
    
    
}
