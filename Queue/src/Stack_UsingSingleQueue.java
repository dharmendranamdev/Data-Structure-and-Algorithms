import java.util.*;
/*
// x is the element to be pushed and s is stack
  1) Let size of q be s. 
  1) Enqueue x to q
  2) One by one Dequeue s items from queue and enqueue them.
  
// Removes an item from stack
  1) Dequeue an item from q


*/
public class Stack_UsingSingleQueue {
    int cur_size;
    public Stack_UsingSingleQueue() {
        cur_size = 0;
    }
    Queue<Integer> q = new ArrayDeque<>();
    void insert(int x)
    {   
        int Queuesize = q.size();
        
        
        //insert x in Queue q and increment cur_size
        q.offer(x);
        cur_size++;
        
        
        // Pop (or Dequeue) all previous 
        // elements and put them after current 
        // element 
        for(int i = 0; i < Queuesize; i++)
        {
            //System.out.println(q);
            q.offer(q.poll());
        }
    }
    int delete()
    {
        if(q.isEmpty())
            return -1;
        cur_size--;
        return q.poll();
    }
    
    public static void main(String[] args) {
        Stack_UsingSingleQueue stack = new Stack_UsingSingleQueue();
        stack.insert(10);
        stack.insert(20);
        stack.insert(30);
        System.out.println("cur size : "+stack.cur_size);
        System.out.println("stack : "+ stack.q);
        System.out.println("Deletion/popping : "+ stack.delete());
        System.out.println("stack : "+stack.q);
        
    }
}
