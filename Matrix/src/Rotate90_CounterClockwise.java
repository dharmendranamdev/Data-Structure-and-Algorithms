//Anticlock wise or counter clock wise : 90 Degree
public class Rotate90_CounterClockwise {
    static void print(int a[][], int r, int c)
    {
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
    }
    //Do the transpose of a matrix
   //Swap 1st row with last row, 2nd row with 2nd last row ,...and so on.....
    static  void rotate(int a[][], int row, int col)
    {
        //transpose the matrix
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
        //Swap last row with fist row, and 2nd row with 2nd last row and son on
        for(int i = 0; i < row / 2; i++)
        {
            for(int j = 0; j < col; j++)
            {
                //Swap(A[i][j], A[row-1-i][j])
                int temp = a[i][j];
                a[i][j] = a[row-1-i][j];
                a[row-1-i][j] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int a[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int row = 4;
        int col = 4;
        print(a,row,col);
        System.out.println("Rotate 90 Degree Anti clockwise...");
        rotate(a,row,col);
        print(a, row, col);
        System.out.println("");
        
        a = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        row = 3;
        col = 3;
        print(a,row,col);
        System.out.println("Rotate 90 Degree Anti clockwise...");
        rotate(a,row,col);
        print(a, row, col);
        System.out.println("");
    }
}
