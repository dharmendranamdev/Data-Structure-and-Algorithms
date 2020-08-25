import java.util.*;
//Just Like an Stack Span Problem and Previous Greater

public class NextGreater {
    //naive : O(n^2)
    static void naive(int a[], int n)
    {
        System.out.print("-1 ");
        for (int i =  n - 2; i >= 0 ; i--) {
            int j;
            for(j = i + 1; j < n; j++)
            {
                if(a[j] > a[i]){
                    System.out.print(a[j] + " ");
                    break;
                }
            }
            if(j == n)
                System.out.print("-1 ");
        }
    }
    //Efficient Approch : O(N)
    //see : Stock Spam Problem, In which we keep track to index of maximum value,
    //here we instead maintaining the index ,we just maintain maximum value
    
    static void prevGreater_usingStack(int a[], int n)
    {
        Stack<Integer> stack = new Stack<>();//used for storing index
        stack.push(a[n-1]);
        System.out.print("-1 ");
        
        for(int i = n - 2 ; i >= 0 ; i--)
        {
            
            //2)if cur element is greter than or equal to top elements, 
            //then pop elements from the stack untill the bigger elment appears at the top.
            while(stack.isEmpty() == false && a[i] > stack.peek())
            {
                stack.pop();
            }
            //if cur elment is greter than all elements of stack(or its previous) than just assign -1, otherwise top element of stack
            int p = (stack.isEmpty())? -1 : stack.peek();
            
            System.out.print(p + " ");
            
            //1) if cur_element is smaller than top element of stack then ,push it into the stack
            stack.push(a[i]);
        }
    }
    public static void main(String[] args) {
        
        int a[] = {5,15,10,8,6,12,9,18};
        int n = a.length;
        System.out.println("\nRead in Reverse Order or you can store in ArrayList");
        naive(a,n);
        System.out.println("");
        prevGreater_usingStack(a, n);
        
        System.out.println("");
        a = new int[]{1,3,4,6};
        n = a.length;
           System.out.println("\nRead in Reverse Order or you can store in ArrayList");
        naive(a,n);
        System.out.println("");
        prevGreater_usingStack(a, n);
        
        System.out.println("");
        a = new int[]{10 ,6, 4, 2};
        n = a.length;
           System.out.println("\nRead in Reverse Order or you can store in ArrayList");
        naive(a,n);
        System.out.println("");
        prevGreater_usingStack(a, n);
        
    }
}
