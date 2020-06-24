import java.util.*;
import java.lang.*;
import java.io.*;
class FindGivenSum
 {
	public static void main (String[] args)
	 {
	   Scanner sc = new Scanner(System.in);
	   int T = sc.nextInt();
	   
	   for(int t = 1; t <= T; t++)
	   {
	      int n = sc.nextInt();
	      
	      int given_sum = sc.nextInt();
	      
	      int a[] = new int[n];
	      
	      for(int i = 0; i < n; i++)
	      {
	          a[i] = sc.nextInt();
	      }
	      
	      int start = 0;
	      int cur_sum = a[0];
	      System.out.println(given_sum);
	      for(int i = 1; i <= n; i++)
	      {
	          if(cur_sum > given_sum && start < i - 1)
	          {
	              cur_sum = cur_sum -  a[start];
	              start++;
	          }
	          if(cur_sum == given_sum)
	          {
	              start++;
	              int p = i;
	              System.out.print(start + " " + p +"\n");
	              break;
	          }
	          if(i < n)
	             cur_sum = cur_sum +  a[i];
	          //System.out.println(cur_sum);
	          if(i == n)
	             System.out.println("-1");
	      }
	     
	   }
	 }
}