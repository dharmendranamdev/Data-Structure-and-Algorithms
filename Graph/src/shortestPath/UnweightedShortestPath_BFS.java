package shortestPath;

import java.util.*;
import java.lang.*;

public class UnweightedShortestPath_BFS {
    
    static void printA(int a[], int n){
        for(int j = 0; j < n; j++){
            System.out.print(a[j] + " ");
        }
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
    static void addEdge(int a[][], int u, int v){
        a[u][v] = 1;
    }
    static void BFS(int a[][], int V, int s)
    {
        int dist[] = new int[V];
        int path[] = new int[V];
        for(int v = 0; v < V; v++)
        {
            dist[v] = -1;
            path[v] = -1;//no parent till now
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(s);//insertion in Queue
        dist[s] = 0;
        while (!q.isEmpty()) {
            //deletion in Queue
            int u = q.remove();
            //check u's neighbour ----> nbr = neighbour of u
            for(int nbr = 0; nbr < V; nbr++)
            {
                if(a[u][nbr] == 1 && dist[nbr] == -1)//color[nbr] == 'W' , means neighbour not visited yet
                {
                    dist[nbr] = dist[u] + 1;
                    path[nbr] = u;
                    q.add(nbr);
                }
            }
        }
       
        System.out.println("distance from source To each vertex.....\n");
        printA(dist, V);
        System.out.println("path or parent of each vertex....\n");
        printA(path, V);
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
        
        //BFS Algo for path filndind in unweighted directed graph
        System.out.println("Enter source vertex b/w 0 to "+ (vertices - 1));
        int sourceVertex = sc.nextInt();
        if(sourceVertex < vertices && sourceVertex >= 0)
             BFS(adjMat, vertices,sourceVertex);
        else
            System.out.println("Invalid Source vertex....");
        
    }
}
