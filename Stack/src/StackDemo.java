import java.util.*;
public class StackDemo {
    public static void main(String[] args) {
        //in Java, We can use Stack Class or ArrayDeque(also for Queue)
        //Stack<Integer> s = new Stack<>();
                           //or
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        System.out.println("stack : "+stack);
        System.out.println("Top : "+stack.peek());
        
        while(stack.isEmpty() != true)
        {
            System.out.println(stack.poll()+" ");
        }
    }
}
