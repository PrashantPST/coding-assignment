package intuit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

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
    public static void main(String[] args) {

    }

    public List<Node> removeNodes(Node root, int[] nodesToBeRemoved) {
        List<Node> subtreesRoots = new ArrayList<>();
        if (root == null) {
            return subtreesRoots;
        }
        subtreesRoots.add(root);
        if (nodesToBeRemoved.length == 0) {
            return subtreesRoots;
        }
        Set<Integer> toDelete = new HashSet<>();
        for (int nodeId : nodesToBeRemoved) {
            toDelete.add(nodeId);
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (toDelete.contains(node.id)) {
                subtreesRoots.remove(node);
                if (node.left != null) {
                    subtreesRoots.add(node.left);
                }
                if (node.right != null) {
                    subtreesRoots.add(node.right);
                }
            }
            if (node.left != null) {
                queue.offer(node.left);
                if (toDelete.contains(node.left.id)) {
                    node.left = null;
                }
            }
            if (node.right != null) {
                queue.offer(node.right);
                if (toDelete.contains(node.right.id)) {
                    node.right = null;
                }
            }
        }
        return subtreesRoots;
    }
}
