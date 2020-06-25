//Detect Cycle in Undirected Graph Using Disjoint Set


import java.util.*;
import java.lang.*;
class DisjointSetOp{
    static class Edges{
        int source;
        int dest;
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
}
public class DetectCycle1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = 4;
        int no_of_edges = 4;
        
        //Given Undirected Graph
        //     0-------1
        //     |       |
        //     |       |
         //    2-------3 
        
        DisjointSetOp.Edges e[] = new DisjointSetOp.Edges[no_of_edges];
        for(int i = 0; i < no_of_edges; i++)
        {
            e[i] = new DisjointSetOp.Edges();
        }
        e[0].source = 0;
        e[0].dest = 1;
        
        e[1].source = 1;
        e[1].dest = 3;
        
        e[2].source = 3;
        e[2].dest = 2;
        
        
        e[3].source = 0;
        e[3].dest = 2;
        
        DisjointSetOp ds = new DisjointSetOp(vertices);
        ///ds.showSets();
        
        if(ds.isCycle(e, no_of_edges))
            System.out.println("There is cycle in Graph..");
        else
            System.out.println("Not Cycle......");
    }
}

