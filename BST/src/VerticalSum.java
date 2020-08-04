//check whether 2 elements which sum is given sum or not !
import java.util.Map;
import java.util.TreeMap;
public class VerticalSum {
    //InOrder Traversal
    static void inorder(Node root)
    {
        if(root != null)
        {
            inorder(root.left);
            System.out.print(root.key+" ");
            inorder(root.right);
        }
    }
    //follow the inorder traversal
    static void verticalSum(Node root, TreeMap<Integer, Integer> map, int hd)
    {
          if(root != null)
          {
              verticalSum(root.left, map, hd-1);  //left
              
              int x = (map.get(hd) == null) ? 0 : map.get(hd);
              map.put(hd, x + root.key);
           
              verticalSum(root.right, map, hd+1);//right
          }
    }
    static void vertSum(Node root)
    {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        verticalSum(root, map, 0);
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            
            System.out.println("key : "+key + " value : "+value);
          
            
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
        
        
        vertSum(root);
        
        
    }
}
