
package minimumSpanningTreeAlgo;


import java.util.*;
import java.lang.*;

/*
        
1. Sort all the edges in non-decreasing order of their weight.
2. Pick the smallest edge. Check if it forms a cycle with the spanning tree formed so far. 
   If cycle is not formed, include this edge. Else, discard it.
3. Repeat step#2 until there are (V-1) edges in the spanning tree

*/
class DisjointSetOp{
    static class Edges{
        int source;
        int dest;
        int cost;
    }
    int N;
    int parent[];
    int rank[];
    DisjointSetOp(int n)
    {
        parent = new int[n];
        rank = new int[n];
        N = n;
        makeSet();
    }
    void makeSet()
    {
        for(int i = 0; i < N; i++){
            parent[i] = i;
        }
    }
    void showSets()
    {
        System.out.println();
        for(int i = 0; i < N; i++){
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i = 0; i < N; i++){
            System.out.print(parent[i] + " ");
        }
    }
    //Note that the implementation of union() and find() is naive and takes O(n) time in worst case. 
    //These methods can be improved to O(Logn) using Union by Rank or Height.
    
    int find(int i)
    {
        //i should be between 0.....N-1
        if(!(i >= 0 && i < N))
            return -1;
        //if i is parent of itself it means i is the representative of set
        if(parent[i] == i)
            return i;
        else //else i is not the representative of his set. So we recursively call Find on its parent
            return parent[i] = find(parent[i]);
    }
    void union(int i, int j)
    {
        //find the representative of both i and j
        int i_rep = find(i);
        int j_rep = find(j);
        if(i_rep == j_rep) //if they are equal it means both belongs to same set
            return;
        //get the rank of i's Tree(Set)
        int irank = rank[i_rep];
        //get the rank of j's Tree(Set)
        int jrank = rank[j_rep];
        
        if(irank < jrank)
            parent[i_rep] = j_rep;
        else if(irank > jrank)
            parent[j_rep] = i_rep;
        else //if both rank are same,then move i under j(which goes where it doesn't matter)
        {
            parent[i_rep] = j_rep;
            rank[j_rep]++;
        }
    }
    boolean isCycle(Edges e[], int no_of_edges)
    {
        //Note that the implementation of union() and find() is naive and takes O(n) time in worst case. 
        //These methods can be improved to O(Logn) using Union by Rank or Height.
        for(int i = 0; i < no_of_edges; i++)
        {
            int s = e[i].source;
            int d = e[i].dest;
            if(find(s) == find(d)) //if both vertices(source, Dest) belongs to same set means there is cycle
                return true;
            //otherwise ,take union
            union(s, d);
        }
        return false;
    }
    void Krushkal(ArrayList<DisjointSetOp.Edges> e, int no_of_edges, int V)
    {
        Edges result[] = new Edges[V-1];//No of Edges Should be V-1
        for(int j = 0; j < V-1; j++)
            result[j] = new Edges();
        
        
        int k = 0;
        int i= 0;
        while(k < V - 1)
        {
            if(i >= no_of_edges)
                break;
            // Step 2: Pick the smallest edge. And increment  
            // the index for next iteration
            Edges edge = e.get(i++);
            int s = edge.source;
            int d = edge.dest;
            //int weight = edge.cost;
            
            int x = find(s); 
            int y = find(d);
            
            //x and y not same , it means they belongs to different set,so no cycle...
            //Hence Unite them
            if(x != y)
            {
                
                result[k++] = edge;
                union(s, d);
            } 
            
        }
        for(i = 0; i < V-1; i++)
        {
            System.out.println(result[i].source + " " + result[i].dest +" "+ result[i].cost);
        }
        
    }
}
public class KrushkalAlgo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = 4;
        int no_of_edges = 5;
        
         /* Weighted graph 
                 10 
            0--------1 
            |  \     | 
           6|   5\   |15 
            |      \ | 
            2--------3 
                4       */
        DisjointSetOp.Edges e[] = new DisjointSetOp.Edges[no_of_edges];
        ArrayList<DisjointSetOp.Edges> list_of_edges = new ArrayList<>();
        for(int i = 0; i < no_of_edges; i++)
        {
            e[i] = new DisjointSetOp.Edges();
            list_of_edges.add(e[i]);
        }
        e[0].source = 0;
        e[0].dest = 1;
        e[0].cost = 10;
        
        e[1].source = 0;
        e[1].dest = 2;
        e[1].cost =  6;
        
        
        e[2].source = 0;
        e[2].dest = 3;
        e[2].cost = 5;
        
        e[3].source = 1;
        e[3].dest = 3;
        e[3].cost = 15;
        
        e[4].source = 2;
        e[4].dest = 3;
        e[4].cost = 4;
        
        //Step 1: sort the edges
        Collections.sort(list_of_edges, new ForSorting());
        
        DisjointSetOp ds = new DisjointSetOp(vertices);
        
        ds.Krushkal(list_of_edges, no_of_edges, vertices);
        /*
        for(int i = 0; i < list_of_edges.size(); i++)
        {
            System.out.println(list_of_edges.get(i).source + " " + list_of_edges.get(i).dest + " " + list_of_edges.get(i).cost);
        }
        */
        
        
        ///ds.showSets();
        /*
        if(ds.isCycle(e, no_of_edges))
            System.out.println("There is cycle in Graph..");
        else
            System.out.println("Not Cycle......");
        */
    }
}
class ForSorting implements Comparator<DisjointSetOp.Edges>
{
    public int compare(DisjointSetOp.Edges e1, DisjointSetOp.Edges e2) {
          if(e1.cost < e2.cost)
              return -1;
          if(e1.cost > e2.cost)
              return 1;
          return 0;
    }
    
}

