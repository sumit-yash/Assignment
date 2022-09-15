package com.yash.collectionDemo.Question10;

public class Demo {

	public static void main(String[] args) {
		 int arr[] = { 1, 2, 3, 2, 5, 4, 4 };
		 
	        int n = arr.length;
	 
	        Node root = null;
	        for (int i = 0; i < n; i++)
	        {
	            root = BinaryClassDemo.insert(root,arr[i]);
	        }
	 
	        BinaryClassDemo.inOrder(root);
	    }
	}
