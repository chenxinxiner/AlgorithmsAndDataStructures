package collection.tree;

import sun.applet.Main;

/**
 * 红黑树
 *
 * @author ：chenxin
 * @date ：Created in 2019-10-25 9:28
 * @description：红黑树
 * @modified By：
 * @version: 1.0$
 */
public class RedBlackTree<Key extends Comparable, Value> {
    /**
     * 根节点
     */
    private Node root;

    private final static boolean RED = true;
    private final static boolean BLACK = false;

    /**
     * 左旋转
     *
     * @Description
     * @Params [x]
     * @Return collection.tree.RedBlackTree<Key, Value>.Node
     * @Author chenxin
     * @Date 2019-10-25 10:28
     * @Version 1.0
     **/
    private Node rotateLeft(Node h) {
        Node x = h.rightNode;
        h.rightNode = x.leftNode;
        x.leftNode = h;
        x.color = h.color;
        h.color = RED;
        x.n = h.n;
        h.n = size(x.leftNode) + size(x.rightNode) + 1;
        return x;
    }

    /**
     * 右旋转
     *
     * @Description
     * @Params [x]
     * @Return collection.tree.RedBlackTree<Key, Value>.Node
     * @Author chenxin
     * @Date 2019-10-25 10:29
     * @Version 1.0
     **/
    private Node rotateRight(Node h) {
        Node x = h.leftNode;
        h.leftNode = x.rightNode;
        x.rightNode = h;
        x.color = h.color;
        h.color = RED;
        x.n = h.n;
        h.n = size(x.leftNode) + size(x.rightNode) + 1;
        return x;
    }

    /**
     * 判断指向改节点的连接是否为红色
     *
     * @Description
     * @Params [x]
     * @Return boolean
     * @Author chenxin
     * @Date 2019-10-25 14:39
     * @Version 1.0
     **/
    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    /**
     * 将节点的子链接都变为黑色，同时将连接节点的连接变为红色
     *
     * @Description
     * @Params [h]
     * @Return void
     * @Author chenxin
     * @Date 2019-10-25 14:38
     * @Version 1.0
     **/
    private void flipColors(Node h) {
        h.color = RED;
        h.leftNode.color = BLACK;
        h.rightNode.color = BLACK;
    }

    private class Node {
        Key key;
        Value value;
        Node leftNode, rightNode;
        int n;
        //由其父节点指向它的链接的颜色
        boolean color;

        Node(Key key, Value value, int n, boolean color) {
            this.key = key;
            this.value = value;
            this.n = n;
            this.color = color;
        }
    }

    /**
     * 返回红黑树的节点个数
     *
     * @Description
     * @Params []
     * @Return int
     * @Author chenxin
     * @Date 2019-10-25 15:21
     * @Version 1.0
     **/
    public int size() {
        return size(root);
    }

    /**
     * 指定节点的节点个数（包含本身）
     *
     * @Description
     * @Params [node]
     * @Return int
     * @Author chenxin
     * @Date 2019-10-25 15:22
     * @Version 1.0
     **/
    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.n;
        }
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value value) {
        if (h == null) {
            return new Node(key, value, 1, RED);
        }
        int cmp = key.compareTo(h.key);
        if (cmp > 0) {
            h.rightNode = put(h.rightNode, key, value);
        } else if (cmp < 0) {
            h.leftNode = put(h.leftNode, key, value);
        } else {
            h.value = value;
        }
        if (isRed(h.rightNode) && !isRed(h.leftNode)) {
            h = rotateLeft(h);
        }
        if (isRed(h.rightNode) && isRed(h.leftNode)) {
            flipColors(h);
        }
        if (isRed(h.leftNode) && isRed(h.leftNode.leftNode)) {
            h = rotateRight(h);
        }
        h.n = size(h.leftNode)+size(h.rightNode)+1;
        return h;
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

    public static void main(String[] args) {
    }
}
