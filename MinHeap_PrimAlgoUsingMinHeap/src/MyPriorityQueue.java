 
import java.util.*; 

class MyPriorityQueue {
    
        
	public static void main(String args[]) 
	{ 
                int n = 10;
		// Creating empty priority queue 
		PriorityQueue<Number> pQueue = new PriorityQueue<Number>(10,new Number());
                
                Number object[] = new Number[n];
                
                object[0] = new Number(1,21);
                object[1] = new Number(16,-2);
                object[2] = new Number(100,2);
                object[3] = new Number(12,200);
                object[4] = new Number(10,442);
                object[5] = new Number(-1,2);
		// Adding items to the pQueue using add()
                
		for(int i = 0; i < 6; i++)
                {
                    pQueue.add(object[i]);
                }
                
                 pQueue.remove(object[1]);
                 object[1].a = 2000;
                 object[1].b = 90;
                 pQueue.add(object[1]);
                   
                /*
                Iterator<Number> itr = pQueue.iterator<>() ;
                while(itr.hasNext() ) {
                      System.out.print(itr.next().getA() + " -> " + itr.next().getB()) ;
                System.out.println();
                */
                
                while (!pQueue.isEmpty()) { 
		   System.out.println(pQueue.poll().getA()); 
                }
                System.out.println();
                
                System.out.println(pQueue);
		
	} 
} 
class Number implements Comparator<Number> {
            public int a;
            public int b;
            public Number(){}
            public Number(int a,int b)
            {
                this.a = a;
                this.b = b;
            }
            public int getA()
            {
                return a;
            }
            public int getB()
            {
                return b;
            }
            public int compare(Number node1, Number node2) 
            { 
                if (node1.b < node2.b) 
                    return -1; 
                if (node1.b > node2.b) 
                    return 1; 
                return 0; 
            }
            
            
}