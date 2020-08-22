import java.util.*;
public class ImplementationStack {
    int cur_size;
    
    public ImplementationStack() {
        cur_size = 0;
    }
    
    Queue<Integer> q1 = new ArrayDeque<>();
    Queue<Integer> q2 = new ArrayDeque<>();
    
    //1) Enqueue/inseration/push operation costly
    
    void pushing(int x)
    {
        cur_size++;
        //addding the element into q2
        q2.offer(x);
        //delete all the elements from q1 and insert them into q2
        while(q1.isEmpty() == false)
        {
            q2.offer(q1.poll());
        }
        //swap the queues to each other
        Queue temp = q1;
        q1 = q2;
        q2 = temp;
    }
    int popping()
    {
        if(q1.isEmpty())
            return -1;
        cur_size--;
        return q1.poll();
    }
    
    //2) Dequeue / Deletion / Popping operation Costly
    
    int dequeue()
    {
        if(q1.isEmpty())
            return -1;
        
        //pop all elments of q1 untill 1 element left
        while(q1.size() != 1)
        {
            q2.add(q1.poll());
        }
        //popping last element of q1
        int element = q1.poll();
        cur_size--;
        
        //swap the queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        
        //return deleted element
        return element;
    }
    void enqueue(int x)
    {
        q1.offer(x);
        cur_size++;
    }
    
    public static void main(String[] args) {
        ImplementationStack stack = new ImplementationStack();
        
        //Insertion Costly
        stack.pushing(10);
        stack.pushing(20);
        stack.pushing(30);
        System.out.println("cur size : "+ stack.cur_size);
        System.out.println("stack : "+stack.q1);
        System.out.println("deletion : "+stack.popping());
        System.out.println("stack : "+stack.q1);
        
        
        
        //Deletion costly
        System.out.println("\n");
        ImplementationStack s1 = new ImplementationStack();
        s1.enqueue(10);
        s1.enqueue(20);
        s1.enqueue(30);
        System.out.println("cur size : "+ s1.cur_size);
        System.out.println("stack : "+s1.q1);
        System.out.println("deletion : "+s1.dequeue());
        System.out.println("stack : "+s1.q1);
        
    }
}
