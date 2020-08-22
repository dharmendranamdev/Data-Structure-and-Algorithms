
public class Queue1 {
    int front;
    int rear;
    int capicity;
    int cur_size;
    int a[];
    public Queue1(int cap) {
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
            a[++rear] = x;
            cur_size++;
        }
        else
            System.out.println("insertion not possible,Queue is full...");
    }
    void delete()
    {
        if(!is_empty())
        {
            front++;
            cur_size--;
        }
        else
            System.out.println("deletion not possible...");
            
    }
    public static void main(String[] args) {
        Queue1 queue = new Queue1(5);
        queue.delete();
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        System.out.println("front : "+queue.front + " rear : "+queue.rear + " current size : "+queue.size());
        
        
        queue.delete();
        System.out.println("front : "+queue.front + " rear : "+queue.rear + " current size : "+queue.size());
        
        
        queue.insert(40);
        queue.insert(50);
        System.out.println("front : "+queue.front + " rear : "+queue.rear + " current size : "+queue.size());
        
        
        //queue.insert(60);//even queue is not full, it goes array out of bound,we use circular queue to avoid this problem
        System.out.println("front : "+queue.front + " rear : "+queue.rear + " current size : "+queue.size());
    }
}
