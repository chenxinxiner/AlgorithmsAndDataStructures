import collection.base.StackLink;
import org.junit.jupiter.api.Test;

class StackLinkTest {
    @Test
    public void test() {
        StackLink<Integer> stackLink = new StackLink();

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
        System.out.println(stackLink.pop());
    }

}