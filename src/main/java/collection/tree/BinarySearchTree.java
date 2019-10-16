package collection.tree;

import javax.security.auth.kerberos.KerberosTicket;

/**
 * 二叉查找树
 *
 * @author Administrator
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    /**
     * 根节点
     */
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node leftNode, rightNode;
        /**
         * 节点计数器（包含自己）
         */
        private int n;

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            this.n = n;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.n;
        }
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }


    private Node put(Node node, Key key, Value value) {

        if (node == null) {
            return new Node(key, value, 1);
        }
        int tmp = key.compareTo(node.key);
        if (tmp > 0) {
            node.rightNode = put(node.rightNode, key, value);
        } else if (tmp < 0) {
            node.leftNode = put(node.leftNode, key, value);
        } else {
            node.value = value;
        }
        node.n = size(node.leftNode) + size(node.rightNode) + 1;
        return node;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int tmp = key.compareTo(node.key);
        if (tmp > 0) {
            return get(node.rightNode, key);
        } else if (tmp < 0) {
            return get(node.leftNode, key);
        } else {
            return node.value;
        }
    }

    public Key min() {
        return min(root);
    }

    private Key min(Node root) {
        if (root.leftNode == null) {
            return root.key;
        }else{
            return min(root.leftNode);
        }
    }
    public Key max() {
        return max(root);
    }

    private Key max(Node root) {
        if (root.rightNode == null) {
            return root.key;
        }else{
            return min(root.rightNode);
        }
    }
}
