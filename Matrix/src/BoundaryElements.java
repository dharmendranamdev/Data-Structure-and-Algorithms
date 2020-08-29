
public class BoundaryElements {
    static void print(int a[][], int r, int c)
    {
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
    }
    static void PrintBoundaryElements(int a[][], int row, int col)
    {
        for(int i = 0; i < col; i++)
            System.out.print(a[0][i] +" ");
        for(int i = 1; i < row; i++)
            System.out.print(a[i][col - 1] +" ");
        for(int i = col - 2; i >= 0; i--)
            System.out.print(a[row-1][i] +" ");
        for(int i = row - 2; i >= 1; i--)
            System.out.print(a[i][0] +" ");
    }
    public static void main(String[] args) {
         int a[][] = {{1,2,3,4},{4,5,6,7},{7,8,9,9}};
        int row = 3;
        int col = 4;
        print(a,row,col);
        PrintBoundaryElements(a,row,col);
    }
}
