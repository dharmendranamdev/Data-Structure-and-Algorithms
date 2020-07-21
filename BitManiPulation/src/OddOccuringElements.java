

//Find the Number Occurring Odd Number of Times
//I: a = {1, 2, 3, 2, 3, 1, 3}
//O: 3

//I: arr = {5, 7, 2, 7, 5, 2, 5}
//O: 5

// x^x = 0
// x^0 = x
// x^y = y^x

public class OddOccuringElements {
    static int oddOccuringElement(int a[])
    {
        int res = a[0];
        for(int i = 1; i < a.length; i++)
            res = res ^ a[i];
        return res;
    }
    public static void main(String[] args) {
        int a[] = new int[]{1,2,5,2,5,1,5};
        
        System.out.println("Odd occuring element is : "+oddOccuringElement(a));
    }
}
