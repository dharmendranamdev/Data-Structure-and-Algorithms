
public class LCSRecursion {
    
    //you can start from right side of string as well,
    //but here i will start from end
    static int lcs(String str1, String str2, int m, int n)
    {
        if(m == 0 || n == 0)
            return 0;
        if(str1.charAt(m-1) == str2.charAt(n-1))
            return 1 + lcs(str1, str2, m-1, n-1);
        else
            return Integer.max(lcs(str1, str2, m - 1, n),lcs(str1, str2, m, n - 1));
    } 
    public static void main(String[] args) {
        String str1 = "GEEKSFORGEEKS"; 
        String str2 = "SKEEGROFSKEEG"; 
        int m = str1.length();
        int n = str2.length();
        System.out.println("(Recursion)Longest common substring length : "+lcs(str1,str2,m,n));
    }
    
}
