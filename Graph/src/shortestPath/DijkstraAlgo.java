
package shortestPath;



import java.util.*;
import java.lang.*;

class Vertex { 
    public int v; 
    public int cost; 
       
    public Vertex(int x, int y) { 
        v = x;
        cost = y;
    } 
}
class VertexComparator implements Comparator<Vertex>{ 
			
	public int compare(Vertex s1, Vertex s2) { 
		if (s1.cost > s2.cost) 
		    return 1; 
	        else if (s1.cost < s2.cost) 
		    return -1; 
		return 0; 
	} 
} 

public class DijkstraAlgo {
    
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
    static void addEdge(int a[][], int u, int v, int cost){
        a[u][v] = cost;
    }
    static void Dijkstra(int a[][], int V, int s)
    {
        Vertex obj[] = new Vertex[V];
        int dist[] = new int[V];
        int path[] = new int[V];
        for(int v = 0; v < V; v++)
        {
            dist[v] = -1;
            path[v] = -1;//no parent till now
        }
        PriorityQueue<Vertex> q = new PriorityQueue<>(5, new VertexComparator());
        q.add(new Vertex(s, 0));
        //q.add(s);//insertion in Queue
        dist[s] = 0;
        while (!q.isEmpty()) {
            //deletion in Queue
            Vertex extract = q.poll();
            int u = extract.v;
            //int cost = obj.cost;
            //check u's neighbour ----> nbr = neighbour of u
            for(int nbr = 0; nbr < V; nbr++)
            {
                if(a[u][nbr] != 0) //all adjacent of u
                {
                    int d = dist[u] + a[u][nbr];
                    if(dist[nbr] == -1) //node not visited yet
                    {
                        dist[nbr] = d;
                        path[nbr] = u;
                        //insert neighbour in Queue with priority d
                        obj[nbr] = new Vertex(nbr, d);
                        q.add(obj[nbr]);
                    }
                    if(dist[nbr] > d) //if node is allready visited then check
                    {
                        dist[nbr] = d;
                        path[nbr] = u;
                        //update priority of vertex u from something to d
                        q.remove(obj[nbr]);
                        obj[nbr].v = nbr;
                        obj[nbr].cost = d;
                        q.add(obj[nbr]);
                    }
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
            System.out.println("Enter u and v and cost :");
            int u = sc.nextInt();
            int v = sc.nextInt();
            int cost = sc.nextInt();
            addEdge(adjMat,u,v,cost);
        }
        //printing adjacency matrix
        printmat(adjMat, vertices);
        
        //BFS Algo for path filndind in unweighted directed graph
        System.out.println("Enter source vertex b/w 0 to "+ (vertices - 1));
        int sourceVertex = sc.nextInt();
        if(sourceVertex < vertices && sourceVertex >= 0)
             Dijkstra(adjMat, vertices,sourceVertex);
        else
            System.out.println("Invalid Source vertex....");
        
    }
}
