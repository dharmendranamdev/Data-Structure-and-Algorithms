//Given a number n, print first n number(in increasing order) such that all these numbers have digits in set {5, 6}
//inp : 4
//out : 5 , 6, 55, 56
import java.util.*;

public class GenerateNumbers {
    
    //O(n)
    static void generate(int n)
    {
        Queue<String> queue = new LinkedList<>();
        queue.offer("5");
        queue.offer("6");
        for(int i = 0; i < n; i++)
        {
            String str = queue.poll();
            System.out.print(str + " ");
            queue.offer(str + "5");
            queue.offer(str + "6");
        }
    }
    public static void main(String[] args) {
        generate(4);
        System.out.println("\n");
        generate(10);
    }
}
