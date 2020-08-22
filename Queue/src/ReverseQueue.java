import java.util.*;
public class ReverseQueue {
    
    //Iterative : O(n)
    static void reverse(Queue<Integer> queue)
    {
        Stack<Integer> stack = new Stack<>();
        //remove from queue and insert into stack
        while(!queue.isEmpty())
        {
            stack.push(queue.poll());
        }
        //remove from stack and insert into queue
        while(!stack.isEmpty())
        {
            queue.offer(stack.pop());
        }
    }
    //Recursive Approach
    static void reverse_rec(Queue<Integer> queue)
    {
        if(queue.isEmpty())
            return;
        int x = queue.poll();
        reverse_rec(queue);
        queue.offer(x);
    }
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);
        
        //Iteration
        System.out.println("Initial queue :"+queue);
        reverse(queue);
        System.out.println(" Reverse Queue : "+queue);
        
        
        //recursion
        System.out.println("Initial queue :"+queue);
        reverse_rec(queue);
        System.out.println(" Reverse Queue : "+queue);
    }
}
