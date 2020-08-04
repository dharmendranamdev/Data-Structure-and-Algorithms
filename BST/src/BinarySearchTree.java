
class Node{
    int key;
    Node left,right;
    public Node(int data){
        left = right = null;
        key  = data;
    }
}
public class BinarySearchTree {
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
    //Searching
    static Node search(Node root, int keyElement)
    {
        if(root == null || root.key == keyElement)
            return root;
        if(root.key > keyElement)
            return search(root.left , keyElement);
        else
            return search(root.right , keyElement);
    }
    static int minValueofRightSubTree(Node temp)
    {
        if(temp.left == null)
            return temp.key;
        return minValueofRightSubTree(temp.left);
    }
    static Node Deletion(Node root, int data)
    {
        if(root == null)
            return null;
        if(root.key > data)
            root.left =  Deletion(root.left, data);
        else if(root.key < data)
            root.right =  Deletion(root.right, data);
        else
        {
             //No children 
            if(root.left == null && root.right == null)
                return null;
            
            //If only one children is their
            if(root.left == null)
                return root.right;
            if(root.right == null)
                return root.left;
            
            //If Both children or complete tree is their
            //Getting the smallest value of right sub tree
            root.key = minValueofRightSubTree(root.right);
            
            //Now Delete smallest value node
            root.right = Deletion(root.right, root.key);         
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
        preorder(root);
        System.out.println();
        
        if(search(root, 15) != null)
            System.out.println("Element is present");
        else
            System.out.println("Not Present");
        
        if(search(root, 8) != null)
            System.out.println("Element is present");
        else
            System.out.println("Not Present");
        
        
        /*
                                     10
                                  /     \
                                 5      15
                               /  \    /   \
                              1   8    12   20
                                  /\        /
                                 6  9      16
        //With only one child(left child 16)
        root = Deletion(root, 20);
        System.out.println();
        preorder(root);
        
        //left node
        root = Deletion(root, 12);
        System.out.println();
        preorder(root);
        
        //Left node
        root = Deletion(root, 16);
        System.out.println();
        preorder(root);
        */
        
        //Both children or BST
        root = Deletion(root, 10);
        System.out.println();
        preorder(root);
        
    }
}
