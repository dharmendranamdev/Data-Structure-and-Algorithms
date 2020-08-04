
public class Ceil {
    //PreOrder Traversal
    static void preorder(Node root)
    {
        if(root != null)
        {
            System.out.print(root.key+" ");
            preorder(root.left);
            preorder(root.right);
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
    //Ceiling : we need to find ceiling of x  , ceiling of x >= x
    //Time complexity : O(h)  and SC : O(1)
    static Node ceil(Node root, int x)  //ceil value >= x
    {
        Node res = null;
        while(root != null)
        {
            if(root.key == x) //key == x, just return that Node
                return root;
            else if(root.key < x ) //if key < x, means root.key will never be a ceiling of x, bcz ceiling is >= x
                root = root.right;
            else  //root.key < x , so this might be a ceiling
            {
                res = root;
                root = root.left;
            }
        }
        return res;
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
        
       
        System.out.println("Elements are : ");
        preorder(root);
        System.out.println();
        
        
        System.out.println("floor of 17 : "+ceil(root, 17).key);
        System.out.println("floor of 4 : "+ceil(root, 4).key);
        System.out.println("floor of 7 : "+ceil(root, 7).key);
        System.out.println("floor of 10 : "+ceil(root, 10).key);        
        System.out.println("floor of 15 : "+ceil(root, 15).key);
        
        
     
    }
}
