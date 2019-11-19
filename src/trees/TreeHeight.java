package trees;

//Program to find the height of a tree
public class TreeHeight {
	
	//Recursive Function to find the height of a tree:
	static int treeHeight(Node node)
	{
		if(node!=null)	//Height of the subtree = max of heights of left and right subtree+1
		{
			//Finding the heights of the left and right subtrees;
			int left = treeHeight(node.left);
			int right = treeHeight(node.right);
			
			return 1+(left>right?left:right);
		}
		else
			return 0;
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
		int height = treeHeight(root);
		
		//Displaying the no. of nodes deleted:
		System.out.println("Height of the tree: "+(height-1));
	}
}
