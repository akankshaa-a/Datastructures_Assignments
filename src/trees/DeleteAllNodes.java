package trees;

/*
 * Program to delete all the nodes of a binary tree
 */
public class DeleteAllNodes {
	
	//Static variable to count the number of nodes deleted:
	static int count = 0;
	
	//Function to delete all the nodes of a Binary Tree
	static Node DeleteAllNodes(Node node)
	{
		if(node!=null)
		{
			if(node.left!=null)
				node.left = DeleteAllNodes(node.left);
			if(node.right!=null)
				node.right = DeleteAllNodes(node.right);
		}
		
		count++;
		return null;
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
		
		//Deleting all Nodes:
		root = DeleteAllNodes(root);
		
		//Displaying the no. of nodes deleted:
		System.out.println("No. of nodes deleted: "+count);
	}
}
