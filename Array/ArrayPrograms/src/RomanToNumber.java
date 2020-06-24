import java.util.*;
import java.lang.*;
import java.io.*;
class RomanToNumber
 {
	public static void main (String[] args)
	 {
	    Scanner sc = new Scanner(System.in);
	    int T= sc.nextInt();
            //d={'I':1,'V':5,'X':10,'L':50,'C':100,'D':500,'M':1000}
            HashMap<Character,Integer>hm = new HashMap<Character,Integer>();
            hm.put('I', 1);
            hm.put('V', 5);
            hm.put('X', 10);
            hm.put('L', 50);
            hm.put('C', 100);
            hm.put('D', 500);
            hm.put('M', 1000);
	    for(int t = 0; t < T; t++)
	    {
	        String str = sc.nextLine();
	        char ch[] = str.toCharArray();
                int count = 0;
                for(int i = 0; i < str.length(); i++)
                {
                    count += hm.get(ch[i]);
                }
                System.out.println(count);
	    }
	 }
}