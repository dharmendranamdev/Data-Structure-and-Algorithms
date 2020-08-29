//Clock wise : 90 Degree
public class Rotate90_Clockwise {
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
   //Swap 1st col with last col, 2nd col with 2nd last col ,...and so on.....
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
        //Swap last col with fist col, and 2nd col with 2nd last col and so on.......
        for(int j = 0; j < col / 2; j++)
        {
            for(int i = 0; i < row; i++)
            {
                //Swap(A[i][j], A[i][col-1-j])
                int temp = a[i][j];
                a[i][j] = a[i][col-1-j];
                a[i][col-1-j] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int a[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int row = 4;
        int col = 4;
        print(a,row,col);
        System.out.println("Rotate 90 Degree clockwise...");
        rotate(a,row,col);
        print(a, row, col);
        System.out.println("");
        
        a = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        row = 3;
        col = 3;
        print(a,row,col);
        System.out.println("Rotate 90 Degree clockwise...");
        rotate(a,row,col);
        print(a, row, col);
        System.out.println("");
    }
}
