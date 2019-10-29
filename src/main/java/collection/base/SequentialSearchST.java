package collection.base;

/**
 * 基于无序链表的符号表
 *
 * @author ：chenxin
 * @date ：Created in 2019-10-29 15:43
 * @description：基于无序链表的符号表
 * @modified By：
 * @version: $1.0
 */
public class SequentialSearchST<Key ,Value> {

    private Node first;

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public void put(Key key,Value value) {


        // put(key,value,first);
    }
/*
    private void put(Key key,Value value,Node node) {
        if (node == null) {
            first = new Node(key, value, null);
            return;
        }
        if (node.key.equals(key)) {
            node.value = value;
            return;
        }
        if (node.next == null) {
            node.next = new Node(key,value,null);
        }else {
            put(key, value, node.next);
        }
    }*/

}
