package trees;

/*
 * Program to find the Least Common Ancestor 
 * of 2 nodes in a Binary tree
 */
public class LCA {
	
	//Function to check if the Node is present in the tree
	static boolean isPresent(Node node,int d)
	{
		if(node==null)
			return false;
		if(node.data == d)	//Node is found
			return true;
		else 	//Check if node is in the left or right subtree
			return (isPresent(node.left,d) || isPresent(node.right,d));
	}
	
	//Function to check for LCA if both nodes are present in tree:
	static void checkForLCA(Node root, int d1, int d2) throws Exception
	{
		if(isPresent(root,d1) && isPresent(root,d2))
			System.out.println("The LCA of "+d1+" and "+d2+" is: "+getLCA(root, d1, d2).data);
		
		else
		{
			if(!isPresent(root,d1))
				System.out.println("Node "+d1+" not in tree");
			if(!isPresent(root,d2))
				System.out.println("Node "+d2+" not in tree");
			System.out.println("Cannot get LCA!");
		}
	}
	
	//Helper function to get the Least Common Ancestor
	static Node getLCA(Node node, int d1, int d2)
	{
		
		if(node==null || node.data==d1 || node.data==d2)
			return node;
		
		Node leftlca = getLCA(node.left,d1,d2);
		Node rightlca = getLCA(node.right,d1,d2);
		
		if(leftlca!=null && rightlca!=null)
			return node;	//for LCA both leftlca and rightlca will be not null
		
		return leftlca!=null?leftlca:rightlca;
	}
	
	public static void main(String[] args) throws Exception{
		
		//Creating tree: Level 0
		Node root = new Node(8);
		
		//Level 1:
		root.left = new Node(3);
		root.right = new Node(4);
				
		//Level 2:
		root.left.left = new Node(5);
		root.left.right = new Node(7);
		root.right.left = new Node(9);
		root.right.right = new Node(11);
		
		//Level 3:
		root.left.left.left = new Node(51);
		root.left.left.right = new Node(52);
		
		root.left.right.left = new Node(71);
		root.left.right.right = new Node(72);
				
		root.right.left.left = new Node(91);
		root.right.left.right = new Node(92);
				
		root.right.right.left = new Node(111);
		root.right.right.right = new Node(112);
					
		//Level 4:
		root.right.left.right.left = new Node(16);
		
		//Printing the tree:
		LevelOrder lo = new LevelOrder();
		lo.levelOrder(root);
		
		int d1 = 11;
		int d2 = 9;
				
		//Calling the LCA function:
		checkForLCA(root,d1,d2);
		
	}

}
