package collection.base;

/**
 * 堆栈链表实现
 *
 * @Description
 * @Author chenxin
 * @Date 2019/9/16 22:09
 * @Version 1.0
 **/
public class StackLink<Item> {

    private Node firstNode = new Node();

    private int size = 0;

    private class Node {
        Item item;
        Node next;
    }

    /**
     *
      *@Description 
      *@Params [item]
      *@Return void
      *@Author chenxin
      *@Date 2019-9-20 16:44
      *@Version 1.0
      **/
    public void push(Item item) {
        
        if (size == 0) {
            firstNode.item = item;
            size++;
            return;
        }
        Node nodeNext = firstNode;
        firstNode = new Node();
        firstNode.item = item;
        firstNode.next = nodeNext;
        size++;
    }

    public Item pop() {
        if (size == 0) {
            return null;
        }
        Item returnItem = firstNode.item;
        firstNode = firstNode.next;
        size--;
        return returnItem;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
