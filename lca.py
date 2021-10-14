
class Node:
 
    # Constructor to create a new node
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None
 
def findNodes(root, n1, n2, present):
    if root is None:
        return None
 
    #If root is n1 / n2, return root 
    if root.key == n1 :
        present[0] = True
        return root
 
    if root.key == n2:
        present[1] = True
        return root
 
    # Look for keys in left and right subtree
    leftLCA = findNodes(root.left, n1, n2, present)
    rightLCA = findNodes(root.right, n1, n2, present)
 
    # If both non-null, root is LCA
    if leftLCA and rightLCA:
        return root
 
    # Otherwise check if left subtree or right subtree is LCA
    return leftLCA if leftLCA is not None else rightLCA
 
 
def find(root, k):
    if root is None:
        return False
     
    # If key is present at root, or if left subtree or right
    # subtree , return true
    if (root.key == k or find(root.left, k) or
        find(root.right, k)):
        return True
     
    # Else return false
    return False
 
def findLCA(root, n1, n2):
    present = [False, False]
    # Find LCA of n1 and n2 
    lca = findNodes(root, n1, n2, present)
 
    # Returns LCA only if both n1 and n2 are present in tree
    if (present[0] and present[1] or present[0] and find(lca, n2) or present[1] and
        find(lca, n1)):
        return lca
 
    return None


