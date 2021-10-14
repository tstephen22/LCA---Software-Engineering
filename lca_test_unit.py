from lca import *
import unittest

class TestLCA(unittest.TestCase):
    def test_lca(self):
        root = Node(1)
        root.left = Node(2)
        root.right = Node(3)
        root.left.left = Node(4)
        root.left.right = Node(5)
        root.right.left = Node(6)
        root.right.right = Node(7)
        #Test for LCA = 2 for nodes 4,5 
        self.assertAlmostEqual(findLCA(root, 4,5).key, 2)
        #Test for non-existent LCA between 4, 10 in param 2
        self.assertAlmostEqual(findLCA(root, 4, 10), None)
        #Test for non-existent LCA between 10, 2 in param 1
        self.assertAlmostEqual(findLCA(root, 10, 2), None)
        #Test for root = LCA
        self.assertAlmostEqual(findLCA(root, 7, 4), root)
        #Test on null
        self.assertAlmostEqual(findLCA(root, None, None), None)