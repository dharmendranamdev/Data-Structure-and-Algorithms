import java.util.*;
public class PrimUsingMinHeap {
    static class HeapNode
    {
        int node;
        int key;
    }
    static class Result
    {
        int parent;
        int weight;
    }
    static class UniEdge
    {
        int source;
        int destination;
        int weight;
        public UniEdge(int x, int y, int z) {
            source = x;
            destination = y;
            weight = z;
        }
    }
    static class Graph 
    {
        int vertices;
        //for storing the Edge Object
        LinkedList<UniEdge>[] list;

        Graph(int vertices) 
        {
            this.vertices = vertices;
            list = new LinkedList[vertices];
            //initialize adjacency lists for all the vertices
            for (int i = 0; i <vertices ; i++) {
                list[i] = new LinkedList<>();
            }
        }

        public void assignEdge(int s, int d, int wt) {
            //Creating a edge using UniEdge class object
            UniEdge edge = new UniEdge(s, d, wt);
            //put this edge into linkedlist
            list[s].addFirst(edge);//adFirst lib func : which add the edge at first
            
            //vice - versa:if graph is undirected
            edge = new UniEdge(d, s, wt);
            list[d].addFirst(edge); 
        }

        public void primMST()
        {
            //--------------Heap Initialization-------------------------
            boolean[] inHeap = new boolean[vertices];
            Result[] result = new Result[vertices];
            int [] key = new int[vertices];
            HeapNode [] heapNodes = new HeapNode[vertices];
            for (int i = 0; i <vertices ; i++)
            {
                heapNodes[i] = new HeapNode();
                heapNodes[i].node = i;
                heapNodes[i].key = Integer.MAX_VALUE;
                result[i] = new Result();
                result[i].parent = -1;
                inHeap[i] = true;
                key[i] = Integer.MAX_VALUE;
            }

            heapNodes[0].key = 0;
            
            //--------------Heap Insertion---------
            MinHeap minHeap = new MinHeap(vertices);
            //add all the vertices to priority queue
            for (int i = 0; i < vertices ; i++) {
                minHeap.insert(heapNodes[i]);
            }

            
            while(!minHeap.isEmpty())
            {
                //extract the minimum node
                HeapNode extractNode = minHeap.extractMin();
                int v = extractNode.node;
                inHeap[v] = false;
                //getting all the adjacent vertices of v
                LinkedList<UniEdge> mylist = list[v];
                for (int i = 0; i < mylist.size() ; i++) 
                {
                    UniEdge edge = mylist.get(i);//it contains null  when there is no edge b/w i and v
                    if(inHeap[edge.destination])
                    {
                        int dest = edge.destination;//adjacent vertex
                        int newKey = edge.weight;
                        if(key[dest]>newKey) {
                            decreaseKey(minHeap, newKey, dest);
                            result[dest].parent = v;
                            result[dest].weight = newKey;
                            key[dest] = newKey;
                        }
                    }
                }
            }
            printMST(result);
        }

        public void decreaseKey(MinHeap minHeap, int newKey, int vertex)
        {
            int index = minHeap.indexes[vertex];
            HeapNode node = minHeap.myHeap[index];
            node.key= newKey;
            minHeap.checkParents(index);
        }

        public void printMST(Result[] result)
        {
            int sum = 0;
            System.out.println("Distace Table of Minimum Spanning Tree: ");
            System.out.println("vertex no |  weight  |  parent");
            System.out.println("''''''''''''''''''''''''''''''''");
            for (int i = 1; i <vertices ; i++) {
                System.out.println(i + "        |   " +  result[i].weight + "     | "+ result[i].parent);
                sum += result[i].weight;
            }
            System.out.println("''''''''''''''''''''''''''''''''");
            System.out.println("Sum of all the minimum esges: " + sum);
        }
    }
    public static void main(String[] args) 
    {
            int no_of_vertices = 6;
            Graph g1 = new Graph(no_of_vertices);
            g1.assignEdge(0, 1, 4);
            g1.assignEdge(0, 2, 3);
            g1.assignEdge(1, 2, 1);
            g1.assignEdge(1, 3, 2);
            g1.assignEdge(2, 3, 4);
            g1.assignEdge(3, 4, 2);
            g1.assignEdge(4, 5, 6);
            g1.primMST();
    }
    static class MinHeap
    {
         int capacity;
         int currentSize;
         HeapNode[] myHeap;
         int [] indexes; //will be used to decrease the key
         
         public boolean isEmpty() {
            return currentSize == 0;
        }

        public int getheapSize(){
            return currentSize;
        }
        public MinHeap(int capacity)
        {
            this.capacity = capacity;
            myHeap = new HeapNode[capacity + 1];
            indexes = new int[capacity];
            myHeap[0] = new HeapNode();
            myHeap[0].key = Integer.MIN_VALUE;
            myHeap[0].node = -1;
            currentSize = 0;
        }

        public void display()
        {
            for (int i = 0; i <=currentSize; i++) {
                System.out.println(" " + myHeap[i].node + "   key   " + myHeap[i].key);
            }
        }
        
        public void swap(int a, int b) {
            HeapNode temp = myHeap[a];
            myHeap[a] = myHeap[b];
            myHeap[b] = temp;
        }
        public void insert(HeapNode x) 
        {
            currentSize++;
            int index = currentSize;
            myHeap[index] = x;
            indexes[x.node] = index;
            checkParents(index);
        }
        
        public void checkParents(int pos)
        {
            int parentIndex = pos/2;
            int i = pos;
            while (i > 0 && myHeap[parentIndex].key > myHeap[i].key)
            {
                HeapNode Curnode = myHeap[i];
                HeapNode itsparentNode = myHeap[parentIndex];
                indexes[Curnode.node] = parentIndex;
                indexes[itsparentNode.node] = i;
                swap(i,parentIndex);
                i = parentIndex;
                parentIndex = parentIndex/2;
            }
        }
        public HeapNode extractMin()
        {
            HeapNode min = myHeap[1];
            HeapNode lastNode = myHeap[currentSize];
            indexes[lastNode.node] = 1;
            myHeap[1] = lastNode;
            myHeap[currentSize] = null;
            MinHeapify(1);
            currentSize--;
            return min;
        }

        public void MinHeapify(int index) {
            int smallest = index;
            int lc = 2 * index;
            int rc = 2 * index + 1;
            if (lc < getheapSize() && myHeap[smallest].key > myHeap[lc].key) {
                smallest = lc;
            }
            if (rc < getheapSize() && myHeap[smallest].key > myHeap[rc].key) {
                smallest = rc;
            }
            if (smallest != index) {
                HeapNode smallestNode = myHeap[smallest];
                HeapNode kNode = myHeap[index];
                indexes[smallestNode.node] = index;
                indexes[kNode.node] = smallest;
                swap(index, smallest);
                MinHeapify(smallest);
            }
        }
    }
}