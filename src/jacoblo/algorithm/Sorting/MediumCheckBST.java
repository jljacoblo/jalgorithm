/*
 * Medium
 * 
 * https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/problem
 * 
 * Trees: Is This a Binary Search Tree?
 * 
 * For the purposes of this challenge, we define a binary search tree to be a binary tree with the following ordering properties:
The  value of every node in a node's left subtree is less than the data value of that node.
The  value of every node in a node's right subtree is greater than the data value of that node.
Given the root node of a binary tree, can you determine if it's also a binary search tree?
Complete the function in your editor below, which has  parameter: a pointer to the root of a binary tree. It must return a boolean denoting whether or not the binary tree is a binary search tree. You may have to write one or more helper functions to complete this challenge.
Note: We do not consider a binary tree to be a binary search tree if it contains duplicate values.
Input Format
You are not responsible for reading any input from stdin. Hidden code stubs will assemble a binary tree and pass its root node to your function as an argument.
Constraints

Output Format
You are not responsible for printing any output to stdout. Your function must return true if the tree is a binary search tree; otherwise, it must return false. Hidden code stubs will print this result as a Yes or No answer on a new line.
Sample Input
tree
Sample Output
Yes
Explanation
The tree in the diagram satisfies the ordering property for a Binary Search Tree, so we print Yes.

 */
package jacoblo.algorithm.Sorting;

public class MediumCheckBST {
  
  public static void main(String[] args) {
    Node n1 = new Node(1,null,null);
    Node n3 = new Node(2,null,null);
    Node n2 = new Node(2, n1, n3);
    
    Node n7 = new Node(7,null,null);
    Node n10 = new Node(10,null,null);
    Node n8 = new Node(8, n7, n10);
    
    Node n6 = new Node(6, n2, n8);
    
    MediumCheckBST e = new MediumCheckBST();
    Result result = e.checkBSTHelper(n6);
    System.out.println(result.isBST);
  }
  /* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

  The Node class is defined as follows:
  */
  private static class Node {
    int data;
    Node left;
    Node right;
    
    public Node(int d, Node l, Node r) {
      data = d;
      left = l;
      right = r;
    }
 }
  
  private static class Result {
    boolean isBST;
    int minValueInBST;
    int maxValueInBST;
    
    Result(boolean isBST, int minValue, int maxValue) {
      this.isBST = isBST;
      this.minValueInBST = minValue;
      this.maxValueInBST = maxValue;
    }
  }
  
  public boolean checkBST(Node root) {
    return checkBSTHelper(root).isBST;
  }
  
  private Result checkBSTHelper(Node node) {
    if ( node == null ) return new Result(false, Integer.MIN_VALUE, Integer.MAX_VALUE);
    
    Result rLeft = checkBSTHelper(node.left);
    Result rRight = checkBSTHelper(node.right);
    
    if ( rLeft.isBST && rLeft.maxValueInBST >= node.data ||
        rRight.isBST && rRight.minValueInBST <= node.data ||
        node.left != null && !rLeft.isBST || node.right != null && !rRight.isBST ) {
      return new Result(false, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    int newMinValue = ( node.left == null ? node.data : rLeft.minValueInBST );
    int newMaxValue = ( node.right == null ? node.data : rRight.maxValueInBST );
    return new Result ( true, newMinValue, newMaxValue );
  }
  
}
