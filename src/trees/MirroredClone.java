package trees;

/*
 * Program to create a clone of binary tree
 * which is a mirror image of the tree
 */
public class MirroredClone {
	
	//Function to create a mirror image of the tree:
	static Node cloneMirror(Node node)
	{	
		Node copynode;
		
		if(node == null)
			return null;
		else
		{
			copynode = new Node(node.data);
			
			//Interchanging the left and right subtrees:
			if(node.left!=null) copynode.right = cloneMirror(node.left);
			if(node.right!=null) copynode.left = cloneMirror(node.right);
			
		}
		return copynode;
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
		
		//Calling the cloning function:
		Node cloneRoot = cloneMirror(root);

		LevelOrder lo = new LevelOrder();	//Instantiating the level order class
		
		System.out.println("Original:");
		lo.levelOrder(root);	//Displaying the original tree
		
		System.out.println("Cloned:");
		lo.levelOrder(cloneRoot);	//Displayin the cloned tree

	}

}
