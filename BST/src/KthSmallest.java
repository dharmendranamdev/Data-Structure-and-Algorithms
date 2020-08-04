//Time complexity: O(h) where h is height of tree.



class DataNode{
    int key;
    DataNode left,right;
    int lcount;
    public DataNode(int data){
        left = right = null;
        key  = data;
        lcount = 0;
    }
}
public class KthSmallest {
    //PreOrder Traversal
    static void inorder(DataNode root)
    {
        if(root != null)
        {
            
            inorder(root.left);
            System.out.print(root.key+" ");
            inorder(root.right);
        }
    }
    //KthSmallestNode
    static DataNode kthSmallest(DataNode root, int k)
    {
        if(root == null)
            return null;
        if(root.lcount + 1 == k)
            return root;
        else if(root.lcount + 1 > k)
            return kthSmallest(root.left, k);
        return kthSmallest(root.right,  k - (root.lcount + 1) );
        
        
    }
    //Insertion
    static DataNode insertion(DataNode root, int data)
    {
       if(root == null){
           root = new DataNode(data);
           return root;
       }
       else
       {
           if(root.key > data)
           {
             root.left = insertion(root.left, data);
             root.lcount++;
           }
           else
             root.right = insertion(root.right, data);
       }
       return root;
    }
    public static void main(String[] args) {
        /*
                                     10
                                  /     \
                                 5      15
                               /  \    /   \
                              1    8  12   20
                                  /\        /
                                 6  9      16
       */
        DataNode root = null;
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
        
        
        System.out.println("Elements are : ");
        inorder(root);
        System.out.println();
        
        int k = 8;
        DataNode dumy = kthSmallest(root, k);
        if(dumy != null)
            System.out.println(k+" th smallest node : "+dumy.key);
        
        k = 4;
        dumy = kthSmallest(root, k);
        if(dumy != null)
            System.out.println(k+" th smallest node : "+dumy.key);
        
        
        k = 15;
        dumy = kthSmallest(root, k);
        if(dumy != null)
            System.out.println(k+" th smallest node : "+dumy.key);
        else
            System.out.println("Smallest Item not Exist..");
    }
}
