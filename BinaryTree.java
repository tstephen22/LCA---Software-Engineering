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
    // Root of the Binary Tree
    Node root;
    static boolean present1 = false, present2 = false;
 
    /*
     * findLCA(Node node, int n1, int n2) - finds the LCA of two integer nodes n1 and n2
     * - Returns LCA if both are present and null otherwise 
     */
    private Node findLCA(Node node, int n1, int n2)
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
        }
        if (node.data == n2)
        {
            present2 = true;
            temp = node;
        }
 
        // Look for keys in left and right subtrees
        Node leftLCA = findLCA(node.left, n1, n2);
        Node rightLCA = findLCA(node.right, n1, n2);
 
        if (temp != null)
            return temp;
 
        //If leftLCA & rightLCA return Non-Null, node is the LCA
        if (leftLCA != null && rightLCA != null)
            return node;
 
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
        Node lca = findLCA(root, n1, n2);
 
        // Return LCA only if both n1 and n2 are present in tree
        if (present1 && present2) return lca; else return null;
        // Else return NULL
    }
}
