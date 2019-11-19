package trees;

/*
 * Program to print all the paths
 * from root to leaf in a binary tree
 */
public class RootToLeafPaths {
	
	static void printPaths(Node node,int[] path,int count)
	{

		if(node==null)
			return;
		else
		{
			
			path[++count] = node.data;	//Adding the current node to the path
			
			//If the node is a leaf, we print the path
			if(node.left==null && node.right==null)
			{
				int i;
				
				for(i=0;i<count;i++)
					System.out.print(path[i]+"--->");
				System.out.print(path[i]+"\n");
			}
			
			//Post order traversal of the tree:
			printPaths(node.left,path,count);
			printPaths(node.right,path,count);
		}
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
		root.left.left.left = new Node(12);
		
		int path[] = new int[100];
		
		printPaths(root,path,-1);
	}

}
