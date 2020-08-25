import java.util.*;

public class TwoStack {
    
    int top1,top2;
    int size1,size2;
    int a[];
    int total_capicity;

    public TwoStack(int capicity) {
        total_capicity =capicity;
        a = new int[capicity];
        top1 = -1;
        top2 = capicity;
        size1 = 0;
        size2 = 0;
    }
    void push1(int x)
    {
        if(top1 < top2 - 1)
        {
            size1++;
            a[++top1] = x;
        }
        else
            System.out.println("Element can't be inserted in stack 1..");
    }
    void push2(int x)
    {
        if(top1 < top2 - 1)
        {
            size2++;
            a[--top2] = x;
        }
        else
            System.out.println("Element can't be inserted in stack 2..");
    }
    int pop1(){
        if(top1 > -1)
        {
            size1--;
            return a[top1--];
            
        }
        else
        {
            System.out.println("can't popped from stack 1........");
            return -1;
        }
    }
    int pop2(){
        if(top2 < total_capicity)
        {
            size2--;
            return a[top2++];
        }
        else
        {
            System.out.println("can't popped from stack 2........");
            return -1;
        }
    }
    public static void main(String[] args) {
        TwoStack s = new TwoStack(7);
        s.push1(10);
        s.push1(20);
        
        s.push2(30);
        s.push2(40);
        
        s.push1(50);
        s.push1(60);
        
        s.push2(70);
        s.push2(80);
        
        System.out.println("top1 : "+s.top1 + "  top2 : "+s.top2);
        System.out.println("(left stack)---->           <----(Right Stack)");
        for(int i = 0; i < 7; i++)
        {
            System.out.print(s.a[i] + "\t");
        }
        
        
        
        s.pop1();
        s.pop2();
        s.push1(100);
        s.push2(200);
        System.out.println("\n\ntop1 : "+s.top1 + "  top2 : "+s.top2);
        System.out.println("(left stack)---->           <----(Right Stack)");
        for(int i = 0; i < 7; i++)
        {
            System.out.print(s.a[i] + "\t");
        }
    }
}
