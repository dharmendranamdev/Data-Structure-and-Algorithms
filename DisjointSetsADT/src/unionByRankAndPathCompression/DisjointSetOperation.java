package unionByRankAndPathCompression;
//source GFG:
//disjoint set data structure which maintains collection of disjoint sets 
//and each set is represented by its representative which is one of its members.
import java.util.*;
import java.lang.*;
class DisjointSet{
    int N;
    int parent[];
    int rank[];
    DisjointSet(int n)
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
        System.out.print("Elements : ");
        for(int i = 0; i < N; i++){
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("Parents : ");
        for(int i = 0; i < N; i++){
            System.out.print(parent[i] + " ");
        }
        System.out.println("\n------------------------");
    }
    //It will return the representative of the set where i is present(fall)
    int find(int i) //path compression: It speeds up the data structure by compressing the height of the trees.
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
}
public class DisjointSetOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many Disjoint sets you want : ");
        int n = sc.nextInt();
 
        DisjointSet ds = new DisjointSet(n);
        System.out.println("Making the set.....\n");
        ds.showSets();
        
        ds.union(0, 2);
        ds.union(1, 3);
        ds.union(3, 4);
        ds.union(4, 5);
        System.out.println("After 3 union operation.....\n");
        ds.showSets();
        
        if(ds.find(1) == ds.find(2))
            System.out.println("Both Elements Belongs to the same set(TREE)...");
        else
            System.out.println("Both Elements doesn't belongs to the same set(TREE)...");
        
        if(ds.find(1) == ds.find(4))
            System.out.println("Both Elements Belongs to the same set(TREE)...");
        else
            System.out.println("Both Elements doesn't belongs to the same set(TREE)...");
    }
}
