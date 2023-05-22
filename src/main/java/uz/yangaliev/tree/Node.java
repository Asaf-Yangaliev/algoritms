package uz.yangaliev.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Node {

    Node left;
    Node right;

    public Node() {

    }

    public Node(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    public static int iterativeDepth(Node node) {
        if (node == null)
            throw new IllegalArgumentException("Node must not be null");
        Stack<Node> stack = new Stack<>();
        stack.add(node);
        int currentDepth = 1;
        int maxDepth = 1;
        Map<Node, Integer> map = new HashMap<>();
        map.put(node, 1);
        while (stack.size() != 0) {
            if (currentDepth > maxDepth)
                maxDepth = currentDepth;
            Node currentNode = stack.pop();
            if (currentNode.left != null || currentNode.right != null) {
                currentDepth++;
                if (currentNode.left != null) {
                    stack.add(currentNode.left);
                    map.put(currentNode.left, currentDepth);
                }
                if (currentNode.right != null) {
                    stack.add(currentNode.right);
                    map.put(currentNode.right, currentDepth);
                }
            } else {
                map.remove(currentNode);
                if (stack.size() != 0)
                    currentDepth = map.get(stack.peek());
            }
        }
        return maxDepth;
    }

    public static int recursiveDepth(Node node) {
        if (node == null)
            throw new IllegalArgumentException("Node must not be null");
        int leftDepth = 0;
        if (node.left != null)
            leftDepth = recursiveDepth(node.left);
        int rightDepth = 0;
        if (node.right != null)
            rightDepth = recursiveDepth(node.right
            );
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
