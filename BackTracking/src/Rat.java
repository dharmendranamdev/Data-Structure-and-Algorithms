import java.util.*;
public class Rat
{
    static int sol[][] = new int[5][5];
    static boolean isValidPlace(int r, int c, int maze[][], int x, int y) {      
        if(x >= 0 && x < r && y >= 0 && y < c && maze[x][y] == 1)
               return true;
        return false;
    }
    static int rec(int maze[][], int r, int c, int x, int y)
    {
        
        if(x == r - 1 && y == c - 1 && maze[x][y] == 1)
        {
            sol[x][y] = 1;
            return 1;
        }
        if(isValidPlace(r,c,maze,x, y) == true)
        {    
            sol[x][y] = 1; 
            if (rec(maze, r, c, x+1, y) == 1)       
                return 1;
            if (rec(maze, r, c, x, y+1) == 1)        
                return 1;
            sol[x][y] = 0;        
            return 0;
        }  
        return 0;
    }
    public static void main(String[] args) {
        int maze[][] = { {1,0,0,0,0},
                         {1,1,0,1,0},
                         {1,0,0,1,0},
                         {1,1,1,1,0},
                         {0,0,0,1,1}
                       };
        //you are only allowed to go down or right
        int x = rec(maze,5,5,0,0);
        
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }
}
