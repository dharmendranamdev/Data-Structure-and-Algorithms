//source GFG:
//disjoint set data structure which maintains collection of disjoint sets 
//and each set is represented by its representative which is one of its members.
import java.util.*;
import java.lang.*;
class DisjointSet{
    int N;
    int parent[];
    DisjointSet(int n)
    {
        parent = new int[n];
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
    //It will return the representative of the set where i is present(fall)
    int find(int i)
    {
        //i should be between 0.....N-1
        if(!(i >= 0 && i < N))
            return -1;
        //if i is parent of itself it means i is the representative of set
        if(parent[i] == i)
            return i;
        else //else i is not the representative of his set. So we recursively call Find on its parent
            return find(parent[i]);
    }
    void union(int i, int j)
    {
        //find the representative of both i and j
        int i_rep = find(i);
        int j_rep = find(j);
        if(i_rep == j_rep) //if they are equal it means both belongs to same set
            return;
        // Make the parent of i’s representative
        // be j’s  representative effectively 
        // moving all of i’s set into j’s set)
        parent[i_rep] = j_rep;
    }
}
public class DisjointSetOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many Disjoint sets you want : ");
        int n = sc.nextInt();
 
        DisjointSet ds = new DisjointSet(n);
        ds.showSets();
        
        ds.union(0, 2);
        ds.union(1, 3);
        ds.union(3, 4);
        ds.union(4, 5);
        ds.showSets();
        
    }
}
