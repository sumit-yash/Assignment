package com.yash.collectionDemo.Question10;

class Node {
	int data;
    public Node left;
    public Node right;
    Node(int data)
    {
        this.data = data;
        left = right = null;
    }
}

public class BinaryClassDemo {

	public static Node insert(Node root, int data)
    {
        if (root == null)
            return new Node(data);
        if (data < root.data)
            root.left = insert(root.left, data);
        if (data > root.data)
            root.right = insert(root.right, data);
        return root;
    }
 
    public static void inOrder(Node root)
    {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

}
