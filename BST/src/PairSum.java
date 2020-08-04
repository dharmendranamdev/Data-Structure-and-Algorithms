//check whether 2 elements which sum is given sum or not !
import java.util.HashSet;
public class PairSum {
    //PreOrder Traversal
    static void inorder(Node root)
    {
        if(root != null)
        {
            inorder(root.left);
            System.out.print(root.key+" ");
            inorder(root.right);
        }
    }
    static boolean inorderPairSum(Node root, HashSet<Integer> hs, int sum)
    {
        if(root == null)
            return false;
        else
        {
            if(inorderPairSum(root.left, hs, sum) == true)
                return true;
            if(hs.contains(sum - root.key))
                return true;
            if(inorderPairSum(root.right, hs, sum) == true)
                return true;
            hs.add(root.key);
            return false;
        }       
    }
    //Insertion
    static Node insertion(Node root, int data)
    {
       if(root == null){
           root = new Node(data);
           return root;
       }
       else
       {
           if(root.key > data)
             root.left = insertion(root.left, data);
           else
             root.right = insertion(root.right, data);
       }
       return root;
    }
    public static void main(String[] args) {
         Node root = null;
        root = insertion(root,10);
        root = insertion(root, 15);
        root = insertion(root, 5);
        root = insertion(root, 8);
        root = insertion(root, 1);
        root = insertion(root, 9);
        root = insertion(root, 6);
        root = insertion(root, 12);
        root = insertion(root, 20);
        root = insertion(root, 16);
        
        
        //System.out.println(root.key + " " + root.left.key + "   "+root.right.key);
        //System.out.println(root.key);
        System.out.println("Elements are : ");
        inorder(root);
        System.out.println();
        
        int sum = 14;
        HashSet<Integer> hs = new HashSet<Integer>();
        System.out.println(sum + " sum exist : "+inorderPairSum(root, hs, sum));
        
    }
}
