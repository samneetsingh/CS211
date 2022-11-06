// Class SearchTree stores and prints a binary search tree of
// objects of type E.  E must implement the Comparable<E>
// interface.  from Reges and Stepp, Building Java Programs
//
// modified by W.P. Iverson, to not allow duplicates added
// added toString()
// Bellevue College, January 2021

/*
 * Samneet Singh
 * March 8th, 2021
 * CS 211 w/ Mr. Iverson
 * Assignment 17
 * Purpose: To write methods for the SearchTree class
 */

public class SearchTree<E extends Comparable<E>> {
    private SearchTreeNode<E> overallRoot; // root of overall tree

    // post: constructs an empty search tree
    public SearchTree() {
        overallRoot = null;
    }
    
    // WRITE ADDITIONAL METHODS HERE:

    // returns true if the binary tree is full
    public boolean isFull() {
        return isFull(overallRoot);
    }

    // create the helper method for isFull
    private boolean isFull(SearchTreeNode node) {
        // check if parent is null because then its true
        if (node == null) {
            return true;
        }
        // check if the tree has any more values stored
        if(node.left != null && node.right == null) {
            return false;
        }
        if(node.left == null && node.right != null) {
            return false;
        }
        // recursive case
        return isFull(node.right) && isFull(node.left);
    }

    // create the equals method to check if the trees are equal
    public boolean equals(SearchTreeNode<E> firstTree, SearchTreeNode<E> secondTree) {
        // check for basic false cases
        if(firstTree == null && secondTree != null) {
            return false;
        }
        if(firstTree != null && secondTree == null) {
            return false;
        }
        // check for empty node cases
        if(firstTree == null && secondTree == null) {
            return true;
        }
        return equals(firstTree.left, secondTree.left) && equals(firstTree.right, secondTree.right) && firstTree.data.compareTo(secondTree.data) == 0;

    }

    // create the setter method
    public void removeLeaves() {
        overallRoot = removeLeaves(overallRoot);
    }

    // create helper for removeLeaves method
    private SearchTreeNode<E> removeLeaves(SearchTreeNode<E> tree) {
        // check for base null case
        if(tree == null) {
            return null;
        }
        //  check for basic null cases
        if(tree.left == null && tree.right == null) {
            return null;
        }
        // create recursive cases
        tree.right = removeLeaves(tree.right);
        tree.left = removeLeaves(tree.left);
        return tree;
    }

    public void remove(E value) {
        overallRoot = remove(overallRoot, value);
    }

    private SearchTreeNode<E> remove(SearchTreeNode<E> root, E value) {
        if(root == null) {
            return null;
        } else if(root.data.compareTo(value) == 1) {
            root.left = remove(root.left, value);
        } else if(root.data.compareTo(value) == -1) {
            root.right = remove(root.right, value);
        } else {
            if(root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            } else {
                root.data = getMin(root.right);
                root.right = remove(root.right, root.data);
            }
        }
        return root;
    }

    private E getMin(SearchTreeNode<E> root) {
        if(root.left == null){
            return root.right.data;
        }
        if(root.right == null) {
            return root.left.data;
        } else {
            return root.left.data;
        }
    }
    // post: value added to tree so as to preserve binary search tree
    public void add(E value) {
        overallRoot = add(overallRoot, value);
    }

    // post: value added to tree so as to preserve binary search tree
    private SearchTreeNode<E> add(SearchTreeNode<E> root, E value) {
        if (root == null) {
            root = new SearchTreeNode<E>(value);
        } else if (root.data.compareTo(value) > 0) {
            root.left = add(root.left, value);
        } else if (root.data.compareTo(value) < 0) {
            root.right = add(root.right, value);
        }
        return root;
    }

    // post: returns true if tree contains value, returns false otherwise
    public boolean contains(E value) {
        return contains(overallRoot, value);
    }   

    // post: returns true if given tree contains value, returns false otherwise
    private boolean contains(SearchTreeNode<E> root, E value) {
        if (root == null) {
            return false;
        } else {
            int compare = value.compareTo(root.data);
            if (compare == 0) {
                return true;
            } else if (compare < 0) {
                return contains(root.left, value);
            } else {   // compare > 0
                return contains(root.right, value);
            }
        }
    }

    // post: prints the data of the tree, one per line
    public void print() {
        printInorder(overallRoot);
    }

    // post: prints the data of the tree using an inorder traversal
    private void printInorder(SearchTreeNode<E> root) {
        if (root != null) {
            printInorder(root.left);
            System.out.println(root.data);
            printInorder(root.right);
        }
    }
    
    // toString() added by W.P. Iverson for simple console testing
    // since String is immutable, I've used StringBuilder
    public String toString() {
    	StringBuilder s = new StringBuilder();
    	toString(overallRoot, 0, s);
    	return s.toString();
    }
    
    // similar reverse in order traversal of tree as print sideways
    private void toString(SearchTreeNode<E> root, int level, StringBuilder s) {
        if (root != null) {
            toString(root.right, level + 1, s);
            String temp = new String(); // different for each node
            for (int i = 0; i < level; i++) {
            	temp += "    ";
            }
            s.append(temp + root.data + "\n"); // uses same String in recursions
            toString(root.left, level + 1, s);
        }
    }

    
    
    // a private inner Class for the search tree nodes
    // there is no use for such nodes outside of the SearchTree Class
    // so a private inner Class is appropriate in this case...
    private static class SearchTreeNode<E> {
        public E data;                   // data stored in this node
        public SearchTreeNode<E> left;   // left subtree
        public SearchTreeNode<E> right;  // right subtree

        // post: constructs a leaf node with given data
        public SearchTreeNode(E data) {
            this(data, null, null);
        }

        // post: constructs a node with the given data and links
        public SearchTreeNode(E data, SearchTreeNode<E> left,
                              SearchTreeNode<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
