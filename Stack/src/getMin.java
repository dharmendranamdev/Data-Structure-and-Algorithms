import java.util.*;
class GetMin{
    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> AuxStack = new Stack<>();
    
    
    void push(int x)
    {
        //initial, excute only 1 time
        if(mainStack.isEmpty())
        {
            mainStack.push(x);
            AuxStack.push(x);
        }
        else
            mainStack.push(x);
        
        //if x is smaller or equal then current of AuxStack, then insert x into Aux Stack
        if(mainStack.peek() <= AuxStack.peek())
            AuxStack.push(x);
    }
    
    int pop()
    {
        if(mainStack.peek() == AuxStack.peek())
            AuxStack.pop();
        int x = mainStack.peek();
        mainStack.pop();
        
        return x;
    }
    
    int getminimum()
    {
        return AuxStack.peek();
    }
    public static void main(String[] args) {
        GetMin s = new GetMin();
        
        s.push(5);
        s.push(10);
        s.push(20);
        System.out.println("get minimum : "+s.getminimum());
        
        s.push(2);
        s.push(6);
        s.push(4);
        System.out.println("get minimum : "+s.getminimum());
        
        s.pop();
        s.pop();
        System.out.println("get minimum : "+s.getminimum());
        
        s.push(2);
        s.pop();
        s.push(1);
        System.out.println("get minimum : "+s.getminimum());
        
        s.pop();
        s.pop();
        
        System.out.println("get minimum : "+s.getminimum());
    }
}
