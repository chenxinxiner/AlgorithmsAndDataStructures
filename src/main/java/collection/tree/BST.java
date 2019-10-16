package collection.tree;

import javax.security.auth.kerberos.KerberosTicket;

public class BST<Key extends Comparable<Key>,Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node leftNode,rightNode;
        private int n;
        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            this.n = n;
        }
    }
/*
    public int size() {

    }*/

    public void put(Key key,Value value) {
        root =put(root,key,value);
    }

    private Node put(Node node, Key key, Value value) {
        /*int cmp = node.key.compareTo(key);
        if (cmp > 0) {
            put(node.rightNode,key,value);
        } else if (cmp < 0) {
            put(node.leftNode, key, value);
        } else {
            node.value = value;
        }*/

        if (node == null) {
            return new Node(key,value,1);
        }
        int cmp = node.key.compareTo(key);
        if (cmp > 0) {
            node.rightNode = put(node.rightNode,key,value);
        } else if (cmp < 0) {
            node.leftNode = put(node.leftNode, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    public Value get(Key key) {
        return get(root,key);
    }
    private Value get(Node node ,Key key) {
        if (node == null) {
            return null;
        }
        if (node.key.compareTo(key) < 0) {
            return get(node.leftNode,key);
        } else if (node.key.compareTo(key) > 0) {
            return get(node.rightNode, key);
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

}
