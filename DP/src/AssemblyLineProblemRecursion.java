
public class AssemblyLineProblemRecursion {
    
    
    static int entry[];
    static int exit[];
    static int STATION = 4; // each line only 4 station
    static int scost[][];
    static int tcost[][];
    static int scheduling()
    {
        int op1 = entry[0] + startManuFacturing(0,0);  //line 0 and cur station 0
        int op2 = entry[1] + startManuFacturing(1,0); //line 1 and cur tation 0
        return Integer.min(op1, op2);
    }
    static int startManuFacturing(int line, int currentStation)
    {
        if(currentStation == STATION - 1)
            return scost[line][currentStation] + exit[line];
        
        int op1 = startManuFacturing(line, currentStation + 1);
        int op2 = tcost[line][currentStation + 1] + startManuFacturing(1-line, currentStation+1);
        
        return Integer.min(op1, op2) + scost[line][currentStation];
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
