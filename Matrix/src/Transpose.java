import java.util.*;
public class Transpose {
    static void print(int a[][], int r, int c)
    {
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
    }
    static void transpose(int a[][], int row, int col)
    {
        for(int i = 0; i < row; i++)
        {
            for(int j = i + 1; j < col; j++)
            {
                //System.out.println("a i ,j : "+a[i][j] + " a j i : "+a[j][i]);
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
                //System.out.println("a i ,j : "+a[i][j] + " a j i : "+a[j][i]);
            }
        }
    }
    public static void main(String[] args) {
        int a[][] = {{1,2,3},{4,5,6},{7,8,9}};
        int row = 3;
        int col = 3;
         print(a,row,col);
        transpose(a,row,col);
        System.out.println("\nTranspose");
        print(a,row,col);
    }
}
