
public class CircularQueue {
   int front;
    int rear;
    int capicity;
    int cur_size;
    int a[];
    public CircularQueue(int cap) {
        front = 0;
        rear = -1;
        capicity = cap;
        cur_size = 0;
        a = new int[capicity];
    }
    int size()
    {
        return cur_size;
    }
    boolean is_full()
    {
        return cur_size >= capicity;
    }
    boolean is_empty()
    {
        return cur_size == 0;
    }
    void insert(int x)
    {
        if(!is_full())
        {
            rear =  ( front + cur_size - 1 ) % capicity;
            rear =  ( rear + 1 )  % capicity;
            a[rear] = x;
            cur_size++;
        }
        else
            System.out.println("insertion not possible,Queue is full...");
    }
    void delete()
    {
        if(!is_empty())
        {
            front = (front + 1) % capicity;
            cur_size--;
        }
        else
            System.out.println("deletion not possible...");
            
    }
    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);
        cq.delete();
        cq.insert(10);
        cq.insert(20);
        cq.insert(30);
        System.out.println("front : "+cq.front + " rear : "+cq.rear + " current size : "+cq.size());
        
        
        cq.delete();
        System.out.println("front : "+cq.front + " rear : "+cq.rear + " current size : "+cq.size());
        
        
        cq.insert(40);
        cq.insert(50);
        System.out.println("front : "+cq.front + " rear : "+cq.rear + " current size : "+cq.size());
        
        
        cq.insert(60);//circulate
        System.out.println("front : "+cq.front + " rear : "+cq.rear + " current size : "+cq.size());
    } 
}
