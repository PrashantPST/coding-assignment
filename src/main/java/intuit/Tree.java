package intuit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/*
Given a binary tree with unique integer values.
Return the vector of roots of subtrees formed after
removing the given node.
Node {
    int id;
    Node left;
    Node right;
};
Vector<Integer> removeNode(Node root, int nodeToBeRemoved)
 */
public class Tree {

    private static Node createTree() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        n6.left = n7;

        return n1;
    }

    public static void main(String[] args) {

        int[] nodesToBeRemovedCase1 = {1};
        int[] nodesToBeRemovedCase2 = {2};
        int[] nodesToBeRemovedCase3 = {1, 2};

        // Check iterative solution
        System.out.println(removeNodesIterativeSolution(createTree(), nodesToBeRemovedCase1).stream()
                                                                                            .map(node -> node.id)
                                                                                            .collect(Collectors.toList()));
        System.out.println(removeNodesIterativeSolution(createTree(), nodesToBeRemovedCase2).stream()
                                                                                            .map(node -> node.id)
                                                                                            .collect(Collectors.toList()));
        System.out.println(removeNodesIterativeSolution(createTree(), nodesToBeRemovedCase3).stream()
                                                                                            .map(node -> node.id)
                                                                                            .collect(Collectors.toList()));

        // check recursive solution
        System.out.println(removeNodesRecursiveSolution(createTree(), nodesToBeRemovedCase1).stream()
                                                                                            .map(node -> node.id)
                                                                                            .collect(Collectors.toList()));
        System.out.println(removeNodesRecursiveSolution(createTree(), nodesToBeRemovedCase2).stream()
                                                                                            .map(node -> node.id)
                                                                                            .collect(Collectors.toList()));
        System.out.println(removeNodesRecursiveSolution(createTree(), nodesToBeRemovedCase3).stream()
                                                                                            .map(node -> node.id)
                                                                                            .collect(Collectors.toList()));
    }

    // iterative solution
    public static List<Node> removeNodesIterativeSolution(Node root, int[] nodesToBeRemoved) {
        List<Node> subtreesRoots = new ArrayList<>();

        // Basic edge/sanity checks
        if (root == null) {
            return subtreesRoots;
        }
        subtreesRoots.add(root);
        if (nodesToBeRemoved.length == 0) {
            return subtreesRoots;
        }

        // get all nodes to be removed in a set
        Set<Integer> nodeIdToBeRemoved = new HashSet<>();
        for (int nodeId : nodesToBeRemoved) {
            nodeIdToBeRemoved.add(nodeId);
        }

        // do BFS traversal over entire tree (using a queue)
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            // If current explored node is one of the nodes to be deleted, then we need to exclude/remove from answer list
            if (nodeIdToBeRemoved.contains(currentNode.id)) {
                subtreesRoots.remove(currentNode);
                if (currentNode.left != null) {
                    subtreesRoots.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    subtreesRoots.add(currentNode.right);
                }
            }

            // add left child for exploring if its not null
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
                if (nodeIdToBeRemoved.contains(currentNode.left.id)) {
                    currentNode.left = null;
                }
            }

            // add right child for exploring if its not null
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
                if (nodeIdToBeRemoved.contains(currentNode.right.id)) {
                    currentNode.right = null;
                }
            }
        }
        return subtreesRoots;
    }

    // recursive solution
    public static List<Node> removeNodesRecursiveSolution(Node root, int[] nodesToBeRemoved) {
        Set<Integer> nodeIdToBeRemoved = new HashSet<>();
        for (int nodeId : nodesToBeRemoved) {
            nodeIdToBeRemoved.add(nodeId);
        }
        List<Node> subtreesRoots = new ArrayList<>();
        if (root == null) {
            return subtreesRoots;
        }
        if (postOrderTraverse(root, nodeIdToBeRemoved, subtreesRoots) != null) {
            subtreesRoots.add(root);
        }
        return subtreesRoots;
    }

    private static Node postOrderTraverse(Node root, Set<Integer> nodeIdToBeRemoved, List<Node> subtreesRoots) {
        if (root == null) {
            return null;
        }
        root.left = postOrderTraverse(root.left, nodeIdToBeRemoved, subtreesRoots);
        root.right = postOrderTraverse(root.right, nodeIdToBeRemoved, subtreesRoots);
        if (nodeIdToBeRemoved.contains(root.id)) {
            if (root.left != null) {
                subtreesRoots.add(root.left);
            }
            if (root.right != null) {
                subtreesRoots.add(root.right);
            }
            return null;
        }
        return root;
    }
}
