//find maximum and minimum of 2 number without using any loop or condition
public class Max_Min {
    
    static int max(int a, int b){
        return ((a + b) + Math.abs(a - b) ) / 2 ;
    }
    static int min(int a, int b){
        return ((a + b) - Math.abs(a - b) ) / 2 ;
    }
    public static void main(String[] args) {
        System.out.println("Max : "+max(13,56));
        System.out.println("Max : "+max(13,-10));
        System.out.println("Max : "+max(0, 14));
        System.out.println("Max : "+max(-67,0));
        
        System.out.println("Min : "+min(13,56));
        System.out.println("Min : "+min(13,-10));
        System.out.println("Min : "+min(0, 14));
        System.out.println("Min : "+min(-67,0));
        
    }
}
