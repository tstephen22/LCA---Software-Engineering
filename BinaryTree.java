//Node class - Integer node 
class Node
{
    int data;
    Node left, right;
 
    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}
 
public class BinaryTree
{
	private Node LCA; 
	private int n1Len = 0; 
	private int n2Len = 0; 
	private int lcaLen = 0; 
    // Root of the Binary Tree
    Node root;
    static boolean present1 = false, present2 = false;
 
    /*
     * findLCA(Node node, int n1, int n2) - finds the LCA of two integer nodes n1 and n2
     * - Returns LCA if both are present and null otherwise 
     */
    private Node findLCA(Node node, int n1, int n2, int lcaLength)
    {
        if (node == null)
            return null;
         
        //Store result in temp, in case of key match so that we can search for other key also.
        Node temp=null;
 
        //If n1 / n2 is the root, return the root 
        if (node.data == n1)
        {
            present1 = true;
            temp = node;
            n1Len = lcaLength; 
        }
        if (node.data == n2)
        {
            present2 = true;
            temp = node;
            n2Len = lcaLength; 
        }
 
        // Look for keys in left and right subtrees
        Node leftLCA = findLCA(node.left, n1, n2, lcaLength+1);
        Node rightLCA = findLCA(node.right, n1, n2, lcaLength+1);
 
        if (temp != null)
            return temp;
 
        //If leftLCA & rightLCA return Non-Null, node is the LCA
        if (leftLCA != null && rightLCA != null) {
           if(LCA == null) {//If LCA is not found yet, set LCA to newly found LCA 
        	   LCA = node; 
        	   lcaLen = n1Len + n2Len; 
           } else { //If another LCA is found, compare lengths of the two LCAs and assign to the lower of the 2
        	   if(lcaLen > (n1Len+n2Len)) {
        		   LCA = node; 
        		   lcaLen = n1Len+n2Len; 
        	   }
           }
           return node; 
        }
        // Otherwise check if left subtree or right subtree is LCA
        return (leftLCA != null) ? leftLCA : rightLCA;
    }
 
    // Finds lca of n1 and n2 under the subtree rooted with 'node'
    Node findLCA(int n1, int n2)
    {
        // Initialize n1 and n2 as not present
        present1 = false;
        present2 = false;
 
        // Find lca 
        Node lca = findLCA(root, n1, n2, 0);
 
        // Return LCA only if both n1 and n2 are present in tree
        Node returnedLCA = LCA;
        LCA = null; 
        if (present1 && present2) return returnedLCA; else return null;
        // Else return NULL
    }
}
