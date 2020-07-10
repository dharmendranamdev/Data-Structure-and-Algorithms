import java.util.*;
public class PrimAlgo {
    Node head;
    static class Node{
          int data;
          int weight;
          Node next;
          
          Node(int d)
          {
              data = d;
          }
    }
    public static PrimAlgo insert(PrimAlgo list,int key,int cost)
    {
        Node new_node = new Node(key);
        new_node.weight = cost;
        new_node.next = null;
        
        if(list.head == null)
        {
            list.head = new_node;
        }
        else
        {
            Node last = list.head;
            while(last.next != null)
            {
                last = last.next;
            }
            last.next = new_node;
            
        }
        return list;
        
    }
    public static void printList(PrimAlgo list)
    {
        Node last = list.head;
        while(last != null)
        {
            System.out.print(last.data + "|" + last.weight +"->");
            last = last.next;
        }
    }
    public static void prim(PrimAlgo list[], int n, int s)
    {
        PriorityQueue<Num> pQueue = new PriorityQueue<Num>(n,new Num());
        //objects of Num class
        Num obj[] = new Num[n];
        
        int v,w;
        pQueue.add(new Num(s,0));
        //Distance table
        int Distance[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            Distance[i] = -1;
        }
        int path[] = new int[n];
    
        Distance[s] = 0;
        while(!pQueue.isEmpty())
        {
            v = pQueue.poll().node;
            System.out.println("v:"+v);
            Node temp = list[v].head;
            while(temp != null)
            {
                w = temp.data;
                int wt = temp.weight;
                int d = Distance[v] + wt;
                //System.out.println("neighbour : "+ w +" weight" + w + "New distance " + d);
                if(Distance[w] == -1)
                {
                     
                    Distance[w] = wt;
                    //Insert w in the priority queue with priroity d
                    obj[w] = new Num(w,d);
                    pQueue.add(obj[w]);
                    path[w] = v;
                }
                if(Distance[w] > d)
                {
                    Distance[w] = wt;
                    //update priority of vertex w to be d
                    pQueue.remove(obj[w]);
                    obj[w].node = w;
                    obj[w].cost = d;
                    pQueue.add(obj[w]);
                    path[w] = v;
                }
                System.out.println("done");
                temp = temp.next;
            }
        }
        pQueue.clear();
        //System.out.println("vertex no | Distance | path" );
        for(int i = 0; i < n; i++)
        {
            System.out.println(i + " | " + Distance[i] + " | " + path[i]);
        }
    }
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("How many Nodes we are having:");
        int n = sc.nextInt();
        
        PrimAlgo list[] = new PrimAlgo[n];
        
        for(int i = 0; i < n; i++)
        {
            list[i] = new PrimAlgo();
            System.out.println("How many Edges Come out from this vertex "+i);
            int edges = sc.nextInt();
            for(int j = 1; j <= edges; j++)
            {
                System.out.println("Enter Dest. vertex : ");
                int dest = sc.nextInt();
                System.out.println("Enter Cost to reach Dest "+dest);
                int cost = sc.nextInt();
                list[i] = insert(list[i] , dest,cost);
            }
        }
        
        //print
        for(int i = 0; i < n; i++)
        {
            System.out.print(i+"->");
            printList(list[i]);
            System.out.println();
        }
        int s = 0;
        prim(list,n,s);
        
    }
}
class Num implements Comparator<Num> {
            public int node;
            public int cost;
            public Num(){}
            public Num(int a,int b)
            {
                this.node = a;
                this.cost = b;
            }
            public int getNode()
            {
                return node;
            }
            public int getCost()
            {
                return cost;
            }
            public int compare(Num node1, Num node2) 
            { 
                if (node1.cost < node2.cost) 
                    return -1; 
                if (node1.cost > node2.cost) 
                    return 1; 
                return 0; 
            }
            
            
}