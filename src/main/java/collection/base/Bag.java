package collection.base;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * 背包数据结构
 * 不支持删除、帮助用例搜集元素并迭代遍历所有收集到的元素 迭代的顺序不确定，与用例无关
 * @Description
 * @Author chenxin
 * @Date 2019/11/6 21:37
 * @Version 1.0
 **/
public class Bag<Item> implements Iterable<Item> {


    private Node firstNode = new Node();

    private int size = 0;

    private class Node {
        Item item;
        Node next;
    }

    public void add(Item item) {
        Node oldFirstNode = firstNode;
        firstNode = new Node();
        firstNode.item = item;
        firstNode.next = oldFirstNode;
        size++;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = firstNode;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
