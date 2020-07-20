public class MultInverse {
    
    static  int multInverse(int a, int m)
    {
        a = a % m;
        for(int i = 1; i < m; i++)
        {
            if((i * a ) % m == 1)
                return i;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        
        int a = 10, m = 17;
        System.out.println("MultInverse :"+multInverse(a, m));
        a = 3;
        m =11;
        System.out.println("MultInverse : "+multInverse(a,m));
    }
}
