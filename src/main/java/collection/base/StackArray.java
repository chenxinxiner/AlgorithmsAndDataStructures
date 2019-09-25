package collection.base;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 堆栈数组实现
  *@Description
  *@Author chenxin
  *@Date 2019/9/16 21:12
  *@Version 1.0
  **/
public class StackArray<Item> implements Iterable<Item>{

    private Object[] objects = new Object[10];

    private int size = 0;

    public StackArray() {

    }

    public void push(Item item) {
        objects[size] =item;
        size++;
    }

    public Item pop() throws Exception {
        if (size == 0) {
            throw new Exception();
        }
        Item lastItem = (Item) objects[size-1];
        objects[size-1] = null;
        size--;
        return lastItem;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public int size() {
        return size;
    }

    public Iterator<Item> iterator() {
        return null;
    }
}
