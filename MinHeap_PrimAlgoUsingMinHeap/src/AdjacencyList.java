import java.util.*;
public class AdjacencyList {
    Node head;
    static class Node{
          int data;
          Node next;
          
          Node(int d)
          {
              data = d;
          }
    }
    public static AdjacencyList insert(AdjacencyList list,int key)
    {
        Node new_node = new Node(key);
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
    public static void printList(AdjacencyList list)
    {
        Node last = list.head;
        while(last != null)
        {
            System.out.print(last.data+"->");
            last = last.next;
        }
    }
    public static void main(String args[])
    {/*
        AdjacencyList list = new AdjacencyList();
        list = insert(list,1);
        list = insert(list,2);
        list = insert(list,3);
        list = insert(list,4);
        list = insert(list,5);
        list = insert(list,6);
        printList(list);
        
        */
        
        Scanner sc = new Scanner(System.in);
        System.out.println("How many Nodes we are having:");
        int n = sc.nextInt();
        
        AdjacencyList list[] = new AdjacencyList[n];
        
        for(int i = 0; i < n; i++)
        {
            list[i] = new AdjacencyList();
            System.out.println("How many Edges Come out from this vertex "+i);
            int edges = sc.nextInt();
            for(int j = 1; j <= edges; j++)
            {
                System.out.println("Enter Dest. vertex : ");
                int dest = sc.nextInt();
                list[i] = insert(list[i] , dest);
            }
        }
        
        //print
        for(int i = 0; i < n; i++)
        {
            System.out.print(i+"->");
            printList(list[i]);
            System.out.println();
        }   
    }
}
