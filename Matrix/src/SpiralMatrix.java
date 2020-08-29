
public class SpiralMatrix {
    static void print(int a[][], int r, int c)
    {
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
    }
    static void PrintSpiral(int a[][], int row, int col)
    {
        int row1 = 0,row2 = row;
        int col1 = 0,col2 = col;
        while(row1 < row2 && col1 < col2)
        {
            for(int i = col1; i < col2; i++)
                System.out.print(a[row1][i]+" ");
            row1++;
            for(int i = row1; i < row2; i++)
                System.out.print(a[i][col2 - 1]+" ");
            col2--;
            if(row1 < row2){
                for(int i = col2 - 1; i >= col1; i--)
                System.out.print(a[row2-1][i]+" ");
                row2--;
            }
            if(col1 < col2)
            {
                for(int i = row2 - 1; i >= row1; i--)
                System.out.print(a[i][col1]+" ");
                col1++;
            }
        }
    }
    public static void main(String[] args) {
        int a[][] = {{1,2,3,4},{4,5,6,7},{7,8,9,9},{1,2,3,4}};
        int row = 4;
        int col = 4;
        print(a,row,col);
        System.out.println("Printing Matrix in Spiral Form..");
        PrintSpiral(a,row,col);
        System.out.println("");
        
        a = new int[][]{ {1,2,3,4}, {4,5,6,7}, {7,8,9,9} };
        row = 3;
        col = 4;
        System.out.println("");
        print(a,row,col);
        System.out.println("Printing Matrix in Spiral Form..");
        PrintSpiral(a,row,col);
    }
}
