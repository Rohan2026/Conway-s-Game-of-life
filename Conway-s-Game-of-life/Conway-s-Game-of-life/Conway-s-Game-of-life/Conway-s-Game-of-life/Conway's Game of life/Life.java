import java.util.Scanner;
/**
 * Write a description of class Life here.
 *
 * @author (Rohan Huynh)
 * @version (2/2/24)
 */
public class Life
{
    static int row;
    public static final int ROWS = 50;
    public static final int COLS = 150;
    public static final int TIME_DELAY=5250;
    public static void sizeinput() {
        System.out.println ("How many Rows?");
        
        Scanner input = new Scanner (System.in);
    }
    
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
                else if (b.get(r,c) == 1 && neighborCount < 4) //first statement already dealt with if it was underpopulation
                {
                    nextB.set(r, c, 1);
                }
                else if (b.get(r,c) == 1 && neighborCount > 3)
                {
                    nextB.set(r, c, 0);
                }
                else if (b.get(r, c) == 0 && neighborCount == 3 || neighborCount ==6)
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
                if (r >= 0 && r < ROWS && 
                    c >= 0 && c < COLS && 
                    !(r == row && c == col) && 
                    b.get(r,c) == 1)
                {
                    count ++;
                }
            }
        }
        return count;
    }
    
    public static void transferNextToCurrent(Board board, Board nextB)
    {
        for (int r = 0; r < ROWS; r++)
        {
            for (int c = 0; c < COLS; c++)
            {
               board.set(r,c, nextB.get(r,c)); 
            }
        }
    }
    
    private static void clearConsole()
    {
        System.out.print("");
        System.out.flush();
    }
    
    private static void slow(int TIME_DELAY)
    {
        try
        {
            Thread.sleep(TIME_DELAY);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
    
    public static void main(String[] args)
    {
        sizeinput();
        
        Board board = new Board(ROWS, COLS);
        Board nextBoard = new Board(ROWS, COLS);
        initializeBOARD(board);
        //for (int i = 0; i < 300; i++)
        //{
        //    clearConsole();
        //    displayBoard(board);
         //   slow(TIME_DELAY);
           // calculateNextGeneration(board, nextBoard);
            //clearConsole();
           // transferNextToCurrent(board, nextBoard);
        }
    }
//}
