import java.util.*;
public class QueueinJava {
    public static void main(String[] args) {
        //Queue is a interface and ArrayDeque & LinkedList is a class 
        //Queue <Integer> q = new LinkedList<Integer>();  //  LinkedList implementation of queue
        Queue <Integer> q = new ArrayDeque<>();          //   Array Implementation of array
        q.offer(1);
        q.offer(2);
        q.offer(3);
        System.out.println(q.peek());
        System.out.println(q.poll());
        System.out.println(q.peek());
        System.out.println(q);
    }
}
