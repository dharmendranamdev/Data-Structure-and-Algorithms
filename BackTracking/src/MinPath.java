import com.sun.java.swing.plaf.motif.MotifSplitPaneDivider;
import java.util.*;
public class MinPath
{
    //static int sol[][] = new int[5][5];
    //static int count = 0;
    static boolean isValidPlace(int r, int c, int maze[][], int x, int y) {      
        if(x >= 0 && x < r && y >= 0 && y < c && maze[x][y] == 1)
               return true;
        return false;
    }
    static int rec(int maze[][], int r, int c, int x, int y, int count)
    {
      
        if(x == r - 1 && y == c - 1 && maze[x][y] == 1)
        {
            //sol[x][y] = 1;
            return count;
        }
        if(isValidPlace(r,c,maze,x, y) == true)
        {   count++;
            //sol[x][y] = 1; 
            int x1 = rec(maze, r, c, x+1, y,count);
            int x2 = rec(maze, r, c, x, y+1,count);
            return Math.min(x1, x2);
        }  
        return Integer.MAX_VALUE;
    }
    public static void main(String[] args) {
        int maze[][] = { {1,1,1,0,0,0},
                         {1,0,1,0,0,0},
                         {1,0,1,1,1,0},
                         {1,0,0,0,1,1},
                         {1,1,0,0,0,1},
                         {0,1,1,1,0,1}
                       };
        //you are only allowed to go down or right
        int x = rec(maze,6,6,0,0,0);
        
        
        System.out.println("Min Length og Path : "+x);
        
        
        
        
        maze = new int[][]{ {1,1,1,0,0},
                            {1,0,1,0,0},
                            {1,0,1,1,1},
                            {1,0,0,0,1},
                            {1,1,1,0,1},
                       };
        //you are only allowed to go down or right
        x = rec(maze,5,5,0,0,0);
        
        
        System.out.println("Min Length og Path : "+x);
    }
}
