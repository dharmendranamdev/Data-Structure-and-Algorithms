import java.util.*;
public class ActivitySelectionProblem {
    
    static class Task{
        public int startTime;
        public int finishTime;
        public Task(int x, int y) {
            startTime = x;
            finishTime = y;
        }
        
    }
    static class Comp implements Comparator<Task>
    {
        public int compare(Task o1, Task o2) {
            if(o1.finishTime > o2.finishTime )
                return 1;
            return -1;
        }
        
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of task (Meeting) : ");
        int n = sc.nextInt();
        Task t[] = new Task[n];
        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter start time and finish Time of "+ i + " th Task : ");
            int s = sc.nextInt();
            int f = sc.nextInt();
            t[i] = new Task(s, f);
        }
        //sorting the Task according to their finish time
        Arrays.sort(t, new Comp());
        
        //Sorted..
        /*
        for(int i = 0; i < n; i++)
        {
            //System.out.println("Enter start time and finish Time of "+ i + " th Task : ");
            System.out.println("stat time : "+t[i].startTime+ " finishTime "+t[i].finishTime);
        }
        */
        int count = 1;
        int finish_time_previous_Task = t[0].finishTime;
        
        System.out.println("Following Activity/Task/Meeting are selected....");
        System.out.print("0 ");
        for(int i = 1; i < n; i++)
        {
            //start time of cur task is greter or equal to finish time of previous task , we can take one more task or meeting
            if(finish_time_previous_Task <= t[i].startTime)
            {
                count++;
                finish_time_previous_Task = t[i].finishTime;
                System.out.print(i + " ");
            }
           
        }
        System.out.println();
        System.out.println("Maximum no of task(Meeting) that can be done : "+count);
        
    }
}
