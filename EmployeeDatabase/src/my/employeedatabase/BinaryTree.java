/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.employeedatabase;
import java.util.ArrayList;

/**
 *
 * @author 589073
 */

public class BinaryTree {

    // Attributes
    private EmployeeInfo root;
    private int numInTree;

    // Constructors
    public BinaryTree() { // Constructs a tree with the inputed EmployeeInfo as the first node
        root = null;
        numInTree = 0;
    }

    // Methods
    public int getNumInTree() { // Returns the number of nodes in the tree (in case you wanted to know)
        return numInTree;
    }

    public EmployeeInfo getRoot() { // Returns the first node
        return root;
    }

    public void addToTree(EmployeeInfo cN, EmployeeInfo sI) { // Compares the inputed EmployeeInfo with the current node 
        if (root == null) { // If the tree is somehow empty, sets the inputed EmployeeInfo as the first node
            root = sI;
            numInTree++; // Increases the count of entries in the tree
        } else {
            if (sI.getEmployeeNumber() < cN.getEmployeeNumber()) { // If inputed studentNumber is less than current node, set current node as left
                if (cN.getLeft() == null) {
                    cN.setLeft(sI); // If left is empty, sets left as the inputed EmployeeInfo
                    numInTree++; // Increases the count of entries in the tree
                } else {
                    addToTree(cN.getLeft(), sI); // If left is not empty, moves current node to left
                }
            } else if (sI.getEmployeeNumber() > cN.getEmployeeNumber()) { // If inputed studentNumber is more than current node, set current node as right
                if (cN.getRight() == null) {
                    cN.setRight(sI); // If right is empty, sets right as the inputed EmployeeInfo
                    numInTree++; // Increases the count of entries in the tree
                } else {
                    addToTree(cN.getRight(), sI); // If right is not empty, moves current node to right
                }
            }
        }
    }

    public EmployeeInfo preorder(EmployeeInfo cN) { // Reads the tree in a pre-order traversal
        if (cN == null) {
            System.out.println("Error: specified node is empty"); // If the first node specified by the user is empty, returns null
            return null;
        }

        System.out.println(cN.getEmployeeNumber() + " " + cN.getFirstName());  // Prints the node before any comparisons
        EmployeeInfo nextNode = cN; // Sets a temp variable as the current node

        if (cN.getLeft() != null) {
            nextNode = cN.getLeft();
            preorder(nextNode); // If left node isn't empty, moves current node to left
        }

        if (cN.getRight() != null) {
            nextNode = cN.getRight();
            preorder(nextNode); // If right node isn't empty, moves current node to right
        }

        return nextNode; // Exits the instance of the function
    }

    public EmployeeInfo postorder(EmployeeInfo cN) { // Reads the tree in a post-order traversal
        if (cN == null) {
            System.out.println("Error: specified node is empty"); // If the first node specified by the user is empty, returns null
            return null;
        }

        EmployeeInfo nextNode = cN; // Sets a temp variable as the current node

        if (cN.getLeft() != null) {
            nextNode = cN.getLeft();
            postorder(nextNode); // If left node isn't empty, moves current node to left
        }

        if (cN.getRight() != null) {
            nextNode = cN.getRight();
            postorder(nextNode); // If right node isn't empty, moves current node to right
        }

        System.out.println(cN.getEmployeeNumber() + " " + cN.getFirstName()); // Prints the node after all nodes to the left and right have already been printed

        return nextNode;
    }

    public EmployeeInfo inorder(EmployeeInfo cN, ArrayList<EmployeeInfo> eL) { // Reads the tree in an in-order traversal
        if (cN == null) {
            System.out.println("Error: specified node is empty"); // If the first node specified by the user is empty, returns null
            return null;
        }

        EmployeeInfo nextNode = cN; // Sets a temp variable as the current node

        if (cN.getLeft() != null) {
            nextNode = cN.getLeft();
            inorder(nextNode, eL); // If the left node isn't empty, moves current node to left
            eL.add(cN);
            System.out.println(cN.getEmployeeNumber() + " " + cN.getFirstName());  // Once the left branch has been read, prints the current node
        }

        if (cN.getRight() != null) {
            if (cN.getLeft() == null) {
                eL.add(cN);
                System.out.println(cN.getEmployeeNumber() + " " + cN.getFirstName()); // Prints the current node if it hasn't been printed already
            }
            nextNode = cN.getRight();
            inorder(nextNode, eL); // If the right node isn't empty, moves current node to right

        }

        if (cN.getLeft() == null && cN.getRight() == null) {
            eL.add(cN);
            System.out.println(cN.getEmployeeNumber() + " " + cN.getFirstName());  // If both nodes happen to be null, prints the current node (since it hasn't been printed yet)
        }

        return nextNode;
    }
}
