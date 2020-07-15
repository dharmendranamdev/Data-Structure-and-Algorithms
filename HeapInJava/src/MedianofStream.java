import java.util.*;

//Left container(MaxHeap)
//Right container(MinHeap)
//Note : both container will contains either same no of elements or left container may contains 1 extra element of right container
//if total processed number till now is odd : top of left containter(Maxheap)
//if total processed number till now is even : [ top of left(Maxheap) + top of right(MinHeap) ]  / 2


//Time complexity : o ( n * log(n) ) 

public class MedianofStream {

    static void Median(int a[])
    {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); //left container
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();  //right container
        
        maxHeap.add(a[0]);
        System.out.print(a[0]+ "   ");
        
        for(int i = 1; i < a.length; i++)
        {
            int cur_element = a[i];
            if(maxHeap.size() > minHeap.size()) //only one elment greater
            {
                if(maxHeap.peek() > cur_element) //because left container(maxHeap) already filled 1 element more
                {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(cur_element);
                    
                }
                else  //insert this elment into minheap(right container) so that both got same size
                {
                    minHeap.add(cur_element);
                }
                System.out.print((double)(maxHeap.peek() + minHeap.peek()) / 2 + "   ");
            }
            else  //size is same
            {
                if(maxHeap.peek() < cur_element) //cur elment is greter than top of left(maxheap) so
                {                              //we can't put extra elment in right(minheap) container
                                               //so remove top of right container and put int into left container
                                               //than add cur elment into right(minHeap) container
                    maxHeap.add(minHeap.poll());
                    minHeap.add(cur_element);
                }
                else
                {
                    maxHeap.add(cur_element);
                }
                System.out.print(maxHeap.peek()+"   ");
            }
        }
        
    }
    public static void main(String[] args) {
        int a[] = {12,15,10,5,8,7,16};
        Median(a);
    }
}
