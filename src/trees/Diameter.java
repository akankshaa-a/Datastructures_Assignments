package trees;

/*
 * Program to get the diameter of a tree
 */
public class Diameter {
	//function to get the maximum of 2 values:
	static int max(int a,int b)
	{
		return a>b?a:b;
	}
	
	//recursive function to get the height of a node
	static int getHeight(Node node)
	{
		if(node==null)
			return 0;
		else
			return 1+max(getHeight(node.left),getHeight(node.right));
	}
	
	//recursive function to get the diameter
	static int getDiameter(Node node, int max)
	{
		if(node==null)
			return 0;
		else
		{
			int dia = 1 + getHeight(node.left) + getHeight(node.right);
			return dia>max? dia: max;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		root.left.left.left = new Node(12);
		root.right.left.right = new Node(6);
		
		//Level 4:
		root.right.left.right.left = new Node(16);
		
		System.out.println("Diameter of the tree: "+getDiameter(root,0));
		
	}

}
