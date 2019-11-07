import collection.base.StackLink;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Stack;

class StackLinkTest {
    @Test
    public void test() {
        /*StackLink<Integer> stackLink = new StackLink();

        stackLink.push(1);
        stackLink.push(2);
        stackLink.push(3);
        stackLink.push(4);
        stackLink.push(5);

        System.out.println(stackLink.pop());
        System.out.println(stackLink.pop());
        System.out.println(stackLink.pop());
        System.out.println(stackLink.pop());
        System.out.println(stackLink.pop());
        System.out.println(stackLink.pop());
        System.out.println(stackLink.pop());*/

        Stack<String> stack = new Stack();
        stack.push("ss");
        stack.push("123");
        stack.push("43");

        int[] a = new int[2];

        Iterator iterator = stack.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }

}