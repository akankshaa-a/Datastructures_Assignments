package trees;

/*
 * Program to find the no. of nodes
 * in a binary tree 
 */
public class TreeSize {
	
	//Recursive Function to find the total no. of nodes:
	static int treeSize(Node node)
	{
		if(node!=null)	//Size of the tree = 1 + sum of heights of left and right subtrees 
			return 1 + treeSize(node.left) + treeSize(node.right);
		else
			return 0;	//No nodes in the tree
	}
	
	public static void main(String args[])
	{
		//Filling the tree: Level 0
		Node root = new Node(1);
		
		//Level 1:
		root.left = new Node(2);
		root.right = new Node(3);
		
		//Level 2:
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		//Level 3:
		root.left.left.left = new Node(8);
		root.right.right.right = new Node(9);
		
		//Level 4:
		root.right.right.right.left = new Node(10);
		
		//Deleting all Nodes:
		int size = treeSize(root);
		
		//Displaying the height:
		System.out.println("Size of the tree: "+size);
	}
}
