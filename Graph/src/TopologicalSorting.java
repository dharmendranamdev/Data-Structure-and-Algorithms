import java.util.*;
//Topological sort ....
//v1,v2,v3,v4...vn  is a topological sort if and only if there is edge vi to vj ...not vj to vi ( i < j)
// how to find:
//sort the vertex in decreasing order of finish time.
public class TopologicalSorting {
    
    static int time = 0;
    static int start[];
    static int finish[];
    static char color[];
    static int parent[];
    static int topologicalSort[]; 
    
    static void printA(int a[], int n){
        for(int j = 0; j < n; j++)
            System.out.print(a[j] + " ");
        System.out.println();
    }
    static void printmat(int a[][], int v)
    {
        for(int i = 0; i < v; i++)
        {
            for(int j = 0; j < v; j++)
            {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static void addEdge(int a[][], int u, int v)
    {
        a[u][v] = 1;//Directed Graph
        //a[v][u] = 1;
    }
    public static void insertionsort(int a[],int vertices)
    {
       topologicalSort = new int[vertices];
       for(int i = 0; i < vertices; i++)
           topologicalSort[i] = i;
       for(int i = 1; i < vertices; i++)
       {
           int j = i;
           while(j > 0 && a[j] > a[j-1])
           {
               int temp = topologicalSort[j];
               topologicalSort[j] = topologicalSort[j-1];
               topologicalSort[j-1] = temp;
               
               temp = a[j];
               a[j] = a[j-1];
               a[j-1] =  temp;
               j--;
           }
       }
       //Topological sort----->
       System.out.println("Topological Sort....\n");
       for(int i = 0; i < vertices; i++)
       {
           System.out.print(topologicalSort[i] + " ");
       }
       System.out.println();
    }
    public static void TopologicalSort(int finishTime[],int vertices)
    {
       //vertices in decreasing order of finish time = topological sort
       insertionsort(finishTime,vertices);
    }
    static void DFS_Visit(int a[][], int V, int u)
    {
        time++;
        start[u] = time;
        color[u] = 'G';
        for(int nbr = 0; nbr < V; nbr++)
        {
            if(a[u][nbr] == 1 && color[nbr] == 'W')
            {
                parent[nbr] = u;
                DFS_Visit(a, V, nbr);
            }
        }
        color[u] = 'B';
        time++;
        finish[u] = time;
    }
    static void DFS(int a[][], int V)
    {
        parent = new int[V];
        color = new char[V];
        start = new int[V];
        finish = new int[V];
        for(int v = 0; v < V; v++)
        {
            parent[v] = -1;
            color[v] = 'W';
        }
        //bcz we can have connected components
        for(int u = 0; u < V; u++)
        {
            if(color[u] == 'W')
                DFS_Visit(a, V, u);
        }
        
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
     
        System.out.println("Enter no of vertices and edges :");
        int vertices = sc.nextInt();
        int no_of_edges = sc.nextInt();
        
        
        int adjMat[][] = new int[vertices][vertices];
        
        for(int i = 1; i <= no_of_edges; i++)
        {
            System.out.println("Enter u and v:");
            int u = sc.nextInt();
            int v = sc.nextInt();
            addEdge(adjMat,u,v);
        }
        //printing adjacency matrix
        printmat(adjMat, vertices);
      
        DFS(adjMat, vertices);
        
        System.out.println("start time.....");
        printA(start, vertices);
        
        System.out.println("finish time.....");
        printA(finish, vertices);
  
        System.out.println("parent.....");
        printA(parent, vertices);
        
        //Topological sort...........
        TopologicalSort(finish,vertices);
        
       
    }
}
