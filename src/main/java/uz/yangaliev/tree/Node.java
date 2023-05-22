package uz.yangaliev.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Node {

    public Node parent;
    Node left;
    Node right;

    public Node() {

    }

    public Node(Node left, Node right) {
        this.left = left;
        this.right = right;

        if (left != null)
            left.parent = this;
        if (right != null)
            right.parent = this;
    }

    public static int depth(Node node) {
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
}
