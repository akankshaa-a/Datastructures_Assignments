package trees;

/*
 * Program to perform the following operations on Binary Search Tree:
 * 	1. Insertion
 * 		a. Recursive
 * 		b. Iterative
 * 	2. Search
 * 		a. Recursive
 * 		b. Iterative
 * 	3. Deletion
 * 		a. Of a leaf node (No children)
 * 		b. Of a node with only one child
 * 		c. Of a node with two children
 */
public class BST {

	//Recursive Function to insert node into the BST:
	static Node insertRec(Node node, int ele)
	{
		if(node == null)
		{
			Node newnode = new Node(ele);
			node = newnode;
			return node;
		}
		if(ele<node.data)
		{
			node.left = insertRec(node.left,ele);
		}
		else if(ele>node.data)
		{
			node.right = insertRec(node.right,ele);
		}
		return node;
	}
	
	//Iterative function to insert a node into the BST
	static Node insertIter(Node root, int ele)
	{
		Node newNode = new Node(ele);
		
		if(root==null)
		{
			root = newNode;
			return root;
		}
		Node p = root;
		
		while(p!=null)
		{
			if(ele<p.data)
			{
				if(p.left!=null)
					p = p.left;
				else
				{
					p.left = newNode;
					break;
				}
			}
			else
			{
				if(p.right!=null)
					p = p.right;
				else
				{
					p.right = newNode;
					break;
				}
			}
		}
		
		return root;
	}
	
	//Recursive function to search for a node in a BST
	static Node searchRec(Node node, int ele)
	{
		if(node==null || node.data == ele)
			return node;
		if(ele<node.data)
			return searchRec(node.left,ele);
		else 
			return searchRec(node.right,ele);
	}
	
	//Iterative function to search for node in BST:
	static Node searchIter(Node root, int ele)
	{
		Node p = root;
		while(p!=null)
		{
			if(p==null || p.data == ele)
				break;
			else if(ele<p.data)
				p = p.left;
			else
				p = p.right;
		}
		return p;
	}
	
	//Function to delete a particular node:
	static void deleteNode(Node root, int ele)
	{
		//Code to find the parent of the node to be deleted:
		Node p = root;
		Node delNode = root;
		while(p!=null)
		{
			if(ele<p.data)
			{
				if(p.left!=null && p.left.data==ele)
				{
					delNode = p.left;
					break;
				}
				else
					p = p.left;
			}
			else if(ele>p.data)
			{
				if(p.right!=null && p.right.data == ele)
				{
					delNode = p.right;
					break;
				}
				else
					p = p.right;
			}
			else
			{
				delNode = p;
				break;
			}
		}	
		
		if(delNode.data!=ele)
		{
			System.out.println("Data not found in BST!");
			return;
		}
				
		//Deleting a node with no children:
		if(delNode.left == null && delNode.right == null)
		{
			if(p.left == delNode)
				p.left = null;
			else
				p.right = null;
			return;
		}
		
		//Deleting a node having both left and right child
		else if(delNode.left != null && delNode.right != null)
		{
			//Finding in order predecessor:
			Node inord_pre = delNode;
			
			inord_pre = inord_pre.left;
			while(inord_pre.right!=null)
			{
				inord_pre = inord_pre.right;
			}
			
				//System.out.println("Inord pre:"+inord_pre.data);
			
			//Copy in order predecessor data to the node
			delNode.data = inord_pre.data;

			//Edge case:
			if(inord_pre == delNode.left)
					delNode.left = inord_pre.left;
			else
				//Recursively call the function to delete the actual in order predecessor node 
				deleteNode(delNode.left,inord_pre.data);
		}
		
		//Deleting a node having only one child:
		else 
		{
			Node replaceNode = delNode.left!=null? delNode.left :delNode.right;
			if(p.left==delNode)
				p.left = replaceNode;
			else if(p.right == delNode)
				p.right = replaceNode;			
			return;
		}
		
	}
		
		
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//Creation of the tree:
		Node root = null;
		
		//Insertion - recursive
		root = insertRec(root,60);
		root = insertRec(root,30);
		root = insertRec(root,80);
		root = insertRec(root,40);
		root = insertRec(root,20);
		root = insertRec(root,70);
		
		//Insertion - Iterative
		root = insertIter(root,90);
		root = insertIter(root,10);
		root = insertIter(root,50);
		root = insertIter(root,100);
		root = insertIter(root,25);
		root = insertIter(root,35);
		root = insertIter(root,65);
		root = insertIter(root,75);
		root = insertIter(root,85);
		root = insertIter(root,105);
		root = insertIter(root,115);
		root = insertIter(root,103);
		root = insertIter(root,22);
		root = insertIter(root,12);

		//Displaying the tree:
		LevelOrder lo = new LevelOrder();
		lo.levelOrder(root);
		
		//Searching for an element recursively:
		int ele = 70;
		Node find = searchRec(root,ele);
		if(find == null)
			System.out.println(ele+" not in BST.");
		else
			System.out.println(ele+" found in the BST.");
		
		//Searching for an element Iteratively:
		ele = 90;
		find = searchIter(root,ele);
		if(find == null)
			System.out.println(ele+" not in BST.");
		else
			System.out.println(ele+" found in the BST.");
		
		//Deleting a node that is in the BST:
		deleteNode(root,30);
		
		//Displaying the tree after deleting the node
		lo.levelOrder(root);
	}

}
