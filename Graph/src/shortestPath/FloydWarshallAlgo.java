
package shortestPath;

public class FloydWarshallAlgo {
    static int INF = 999999;
    
    public static void FloydWarshall(int graph[][], int V)
    {
        int dist[][] = new int[V][V];
        
        for(int i = 0; i < V; i++) 
	    for(int j = 0; j < V; j++) 
		 dist[i][j] = graph[i][j]; 
        
        for(int i = 0; i < V; i++)
        {
            for(int j = 0; j < V; j++)
            {
                for(int k = 0; k < V; k++)
                {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        
        for(int i = 0; i < V; i++){ 
	    for(int j = 0; j < V; j++) 
            {
                if(dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            } 
            System.out.println();
        }
        
    }
    public static void main(String[] args) {
        int graph[][] = {  {0,   5  , INF, 10}, 
			   {INF, 0  , 3, INF}, 
		           {INF, INF, 0, 1}, 
			   {INF, INF, INF, 0} 
			};
        
        int vertices = 4;
        FloydWarshall(graph, vertices);
    }
}
