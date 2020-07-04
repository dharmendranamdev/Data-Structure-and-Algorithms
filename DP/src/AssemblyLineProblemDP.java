
public class AssemblyLineProblemDP {
    static int entry[];
    static int exit[];
    static int STATION = 4; // each line only 4 station
    static int scost[][];
    static int tcost[][];   
    static int scheduling()
    {
       int f0[] = new int[STATION];
       int f1[] = new int[STATION];
       
       f0[0] = entry[0] + scost[0][0]; //entry cost of 0th line + line 0 and station 0
       f1[0] = entry[1] + scost[1][0];//entry cost of 1th line  + line 1 and station 0
       
       for(int j = 1; j < STATION; j++)
       {
           f0[j] = Integer.min(f0[j-1]+scost[0][j],    f1[j-1]+tcost[1][j]+scost[0][j]);
           
           f1[j] = Integer.min(f1[j-1]+scost[1][j],   f0[j-1]+tcost[0][j] +scost[1][j]);
           
       }
       return Integer.min(f0[STATION - 1] + exit[0] ,  f1[STATION - 1] + exit[1]);
    }
    public static void main(String[] args) {
        entry = new int[]{10,12}; //entry cost of line 0 and line 1
        exit = new int[]{18,7}; //exit cost of line 0 and line 1
        
        
        //we are having costs of 4 stations for each line (line 0 and line 1)
        scost = new int[][]{
                             {4,5,3,2},
                             {2,10,1,4}
                            };
        
        tcost = new int[][]{
                             {0,7,4,5},
                             {0,9,2,8}
                           };
        
        System.out.println("Minimum Cost for assembling a car is : "+ scheduling());
                
    }
    
}
