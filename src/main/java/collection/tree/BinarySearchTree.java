package collection.tree;

import javax.security.auth.kerberos.KerberosTicket;
import java.util.LinkedList;
import java.util.Queue;

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
        return min(root).key;
    }

    private Node min(Node root) {
        if (root.leftNode == null) {
            return root;
        } else {
            return min(root.leftNode);
        }
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node root) {
        if (root.rightNode == null) {
            return root;
        } else {
            return max(root.rightNode);
        }
    }

    /**
     * 向下取整（小于等于key的最大键）
     *
     * @Description
     * @Params [key]
     * @Return Key
     * @Author chenxin
     * @Date 2019-10-18 10:56
     * @Version 1.0
     **/
    public Key floor(Key key) {
        return floor(root, key);
    }

    private Key floor(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return floor(node.leftNode, key);
        } else if (cmp > 0) {
            Key floorKey = floor(node.rightNode, key);
            if (floorKey != null) {
                return floorKey;
            } else {
                return node.key;
            }
        } else {
            return node.key;
        }
    }

    /**
     * 向下取整（大于等于key的最小键）
     *
     * @Description
     * @Params [key]
     * @Return Key
     * @Author chenxin
     * @Date 2019-10-18 11:26
     * @Version 1.0
     **/
    public Key ceiling(Key key) {
        return ceiling(root, key);
    }

    private Key ceiling(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp > 0) {
            return ceiling(node.rightNode, key);
        } else if (cmp < 0) {
            Key ceilingKey = ceiling(node.leftNode, key);
            if (ceilingKey != null) {
                return ceilingKey;
            } else {
                return node.key;
            }
        } else {
            return node.key;
        }
    }

    /**
     * 给定位置，返回对应位置的键
     *
     * @Description
     * @Params [k]
     * @Return Key
     * @Author chenxin
     * @Date 2019-10-18 15:03
     * @Version 1.0
     **/
    public Key select(int k) throws Exception {
        if (k < 0 || k > this.size()) {
            throw new Exception("范围溢出");
        }
        return select(root, k);
    }

    private Key select(Node node, int k) {
        int rank = node.n - size(node.rightNode);
        if (k < rank) {
            return select(node.leftNode, k);
        } else if (k > rank) {
            return select(node.rightNode, k - rank);
        } else {
            return node.key;
        }
    }

    /**
     * 给定键，返回在BST中排名
     *
     * @Description
     * @Params [key]
     * @Return int
     * @Author chenxin
     * @Date 2019-10-18 15:47
     * @Version 1.0
     * rnak(node) = size(left)+node的前面的
     **/
    public int rank(Key key) {
        return rank(root, key, 1);
    }

    private int rank(Node node, Key key, int k) {
        if (node == null) {
            return -1;
        }
        int cmp = key.compareTo(node.key);
        if (cmp > 0) {
            return rank(node.rightNode, key, k + size(node.leftNode) + 1);
        } else if (cmp < 0) {
            return rank(node.leftNode, key, k);
        } else {
            return k + size(node.leftNode);
        }
    }

    /**
     * 删除最小键
     *
     * @Description
     * @Params []
     * @Return void
     * @Author chenxin
     * @Date 2019-10-18 16:37
     * @Version 1.0
     **/
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node == null) {
            return null;
        }
        if (node.leftNode != null) {
            node.leftNode = deleteMin(node.leftNode);
            node.n = size(node.leftNode) + size(node.rightNode) + 1;
            return node;
        } else {
            return node.rightNode;
        }
    }

    /**
     * 删除最大键
     *
     * @Description
     * @Params []
     * @Return void
     * @Author chenxin
     * @Date 2019-10-21 10:35
     * @Version 1.0
     **/
    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node node) {
        if (node == null) {
            return null;
        }
        if (node.rightNode != null) {
            node.rightNode = deleteMax(node.rightNode);
            node.n = size(node.leftNode) + size(node.rightNode) + 1;
            return node;
        } else {
            return node.leftNode;
        }
    }

    /**
     * 删除指定建
      *@Description
      *@Params [key]
      *@Return void
      *@Author chenxin
      *@Date 2019/10/21 21:54
      *@Version 1.0
      **/
    public void delete(Key key) {
        root = delete(root, key);
    }

    public Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int tmp = key.compareTo(node.key);
        if (tmp > 0) {
            node.rightNode = delete(node.rightNode, key);
        } else if (tmp < 0) {
            node.leftNode = delete(node.leftNode, key);
        } else {
            if (node.leftNode != null && node.rightNode != null) {
                Node n = node;
                node = min(node);
                node.rightNode = deleteMin(node.rightNode);
                node.leftNode = n.leftNode;
            } else if (node.leftNode == null) {
                return node.leftNode;
            } else if (node.rightNode == null) {
                return node.rightNode;
            }
        }
        node.n = size(node.leftNode) + size(node.rightNode) + 1;
        return node;
    }

    /**
     * 返回所有键的迭代器
      *@Description
      *@Params []
      *@Return java.lang.Iterable<Key>
      *@Author chenxin
      *@Date 2019-10-22 17:01
      *@Version 1.0
      **/
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    /**
     * 返回指定范围键的迭代器
      *@Description
      *@Params [min, max]
      *@Return java.lang.Iterable<Key>
      *@Author chenxin
      *@Date 2019-10-22 17:00
      *@Version 1.0
      **/
    public Iterable<Key> keys(Key min, Key max) {
        Queue<Key> keys = new LinkedList<Key>();
        keys(keys,root,min,max);
        return keys;
    }

    public void keys(Queue keys,Node node,Key min,Key max) {
        if (node == null) {
            return;
        }
        if (node.key.compareTo(min) <0) {
            keys(keys, node.rightNode, min, max);
        } else if (node.key.compareTo(min) >= 0 && node.key.compareTo(max) <= 0) {
            //中序遍历的思想
            keys(keys, node.leftNode, min, max);
            keys.add(node.key);
            keys(keys, node.rightNode, min, max);
        } else if(node.key.compareTo(max) > 0) {
            keys(keys, node.leftNode, min, max);
        }
    }

}
