import java.util.Scanner;
/**
 * Write a description of class Life here.
 *
 * 
 */
public class Life
{
    Scanner input = new Scanner (System.in);
    public static String yolo;
    public static int r;
    public static int c;
    public static int generation;
    public static int ROWS;
    public static int COLS;
    public static final int TIME_DELAY=1000;
    private static void generationCount() {
        generation++;
        System.out.println("generation:" + generation);
    }

    private static void Rowinput() {
        boolean Row = true;
        while (Row == true) {
            System.out.println ("How many Rows? (Less than 30)");

            Scanner input = new Scanner (System.in);
            try {
                ROWS = input.nextInt();
                if (ROWS > 30) 
                {
                    System.out.println("Too many Rows");
                } 
                else 
                {
                    Row = false;
                }
            } catch (Exception e) 
            {
                System.out.println("Invalid");
            }
            input.close();
        } 
    }

    private static void Columninput() {
        boolean Cols = true;
        while (Cols == true) {
            System.out.println ("How many Columns?(Less than 110)");

            Scanner input = new Scanner (System.in);
            try {
                COLS = input.nextInt();
                if (COLS > 110) 
                {
                    System.out.println("Too many Columns");
                } 
                else 
                {
                    Cols = false;
                }
            } catch (Exception e) {
                System.out.println("Invalid");
            }
            input.close();
        }
    }
    private static void ClearBOARD(Board b)
    {
        for (int r = 0; r < ROWS; r++)
        {
            for (int c = 0; c <COLS; c++)
            {
                b.set(r,c,0);
            }
        }
    }

    private static void RandomBOARD(Board b)
    {
        for (int r = 0; r < ROWS; r++)
        {
            for(int c = 0; c < COLS; c++)
            {
                int randVal = (int) (Math.random() * 3);
                if (randVal == 0)
                {
                    b.set(r,c,1);
                }
            }
        } 
    }

    private static void initializeBOARD(Board b) {
        System.out.println("Where do you want your pieces - type 9009 for col and row if you are done");
        Scanner input = new Scanner (System.in);
        boolean random = true;
        while (random == true) {
            System.out.println("Randomize? - input yes/no");
            yolo = input.next();
            if (yolo.equals("yes")) {
                ClearBOARD(b);
                RandomBOARD(b);
                displayBoard(b);
            } else if (yolo.equals("no")) {
                random = false;
            } else {
                System.out.println("bruh (type 9009 after this input)");
            }
        }
        boolean done = true;
        while (done == true) {
            boolean doneRow = true;
            while (doneRow == true) {
                try {
                    System.out.println("Row?(including 0)");
                    r = input.nextInt();
                    doneRow = false;
                } catch (Exception e) {
                    System.out.println("Invalid");
                    input.next(); //Consume the invalid input
                }
            }
            boolean doneCol = true;
            while (doneCol == true) {
                try {
                    System.out.println("Column?(including 0)");
                    c = input.nextInt();
                    doneCol = false;
                } catch (Exception e) {
                    System.out.println("Invalid");
                    input.next();
                }
            }
            if (r == 9009 || c == 9009) {
                done = false;
            }
            if (done == true) {
                b.set(r,c,1);
                displayBoard(b);
            }
        }
    }

    private static void displayBoard(Board board)
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

    private static void calculateNextGeneration(Board b, Board nextB)
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
                else if (b.get(r,c) == 1 && neighborCount < 4)
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

    private static int countNeighbors(int row, int col, Board b)
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
    private static void aliveANDdead(Board b)
    {
        int alive = 0;
        int dead = 0;
        for (int r = 0; r < ROWS; r++)
        {
            for (int c = 0; c < COLS; c++)
            {
                if (b.get(r,c) == 1) {
                    alive++;
                } 
                else if (b.get(r,c) == 0)
                {
                    dead++;
                }
            }
        }
        System.out.print("Alive:" + alive);
        System.out.println(" Dead:" + dead);
    }

    private static void transferNextToCurrent(Board board, Board nextB)
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
        Rowinput();
        Columninput();

        Board board = new Board(ROWS, COLS);
        Board nextBoard = new Board(ROWS, COLS);
        initializeBOARD(board);
        for (int i = 0; i < 300; i++)
        {
            clearConsole();
            System.out.println(" ");
            displayBoard(board);
            generationCount();
            aliveANDdead(board);
            slow(TIME_DELAY);
            calculateNextGeneration(board, nextBoard);
            clearConsole();
            transferNextToCurrent(board, nextBoard);
        }
    }
}
