import java.util.*;
public class MatrixMultiplication {
    static Scanner sc = new Scanner(System.in);
    static void assignElements(int a[][], int row, int col)
    {
        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++)
                a[i][j] = sc.nextInt();
    }
    static void print(int a[][], int r, int c)
    {
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
    }
    static void multiplication(int a[][], int b[][], int c[][], int m, int n, int p)
    {
        for(int i = 0; i < m; i++){
            for(int j = 0; j < p; j++){
                for(int k = 0; k < n; k++)
                {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
    }
    public static void main(String[] args)
    {
    
        System.out.println("Enter 'A' Matrix Dimensions : ");
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println("Enter 'B' Matrix Dimensions : ");
        int n1 = sc.nextInt();
        int p = sc.nextInt();
        if(n == n1)
        {
            int a[][] = new int[m][n];
            int b[][] =  new int[n][p];
            int c[][] = new int[m][p];
            
            //enter elements in both array a and b
            assignElements(a,m,n);
            assignElements(b,n,p);
            //print the array
            System.out.println("Matrix A");
            print(a, m, n);
            System.out.println("Matrix B");
            print(b, n, p);
            //print(c, m, p);
            //main operation
            multiplication(a,b,c,m,n,p);
            //print output
            System.out.println("Multiplication Result ");
            print(c,m,p);
        }
        else
            System.out.println("\nNot Possible...\n");
        
    }
}
