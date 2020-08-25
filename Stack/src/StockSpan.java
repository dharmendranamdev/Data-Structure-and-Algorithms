import java.util.*;
//Stock Span Problem : 
public class StockSpan {
    //Naive Approach: O(n^2)
    static void calSpanNaive(int price[], int n)
    {
        System.out.print("1 ");
        for(int i = 1; i < n; i++)
        {
            int j = i - 1;
            int sp = 1;
            while(j >= 0 && price[j] <= price[i])
            {
                sp += 1;
                j--;
            }
            System.out.print(sp+" ");
        }
    }
    //efficient Solution using Stack : O(n)
    //1) if cur_element is smaller than top element of stack then ,push it into the stack
    //2)Other wise,pop elements from the stack untill the bigger elment appears at the top
    static void calSpan_usingStack(int price[], int n)
    {
        Stack<Integer> stack = new Stack<>();//used for storing index
        stack.push(0);
        System.out.print("1 ");
        
        for(int i = 1; i < n; i++)
        {
            
            //2)if cur element is greter than or equal to top elements, 
            //then pop elements from the stack untill the bigger elment appears at the top.
            while(stack.isEmpty() == false && price[i] >= price[stack.peek()])
            {
                stack.pop();
            }
            //if cur elment is greter than all elements of stack than just  assign i + 1, otherwise curindex - top index
            int p = (stack.isEmpty())? (i + 1):(i - stack.peek());
            
            System.out.print(p + " ");
            
            //1) if cur_element is smaller than top element of stack then ,push it into the stack
            stack.push(i);
        }
    }
    public static void main(String[] args) {
        
        int price[] = {10,4,5,90,120,80};
        int n = price.length;
        
        calSpanNaive(price,n);
        System.out.println("");
        calSpan_usingStack(price,n);
        
        
        System.out.println("\n");
        price = new int[]{1, 30, 40, 50, 90, 100};
        calSpanNaive(price,n);
        System.out.println("");
        calSpan_usingStack(price,n);
        
        
        System.out.println("\n");
        price = new int[]{100 , 90, 50 , 40 ,30, 1};
        calSpanNaive(price,n);
        System.out.println("");
        calSpan_usingStack(price,n);
    }
}
