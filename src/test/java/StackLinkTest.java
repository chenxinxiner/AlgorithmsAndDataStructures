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
    }@Test
    public void test2() {
        System.out.println(trailingZeroes(17));
    }
    public int trailingZeroes(int n) {
        int a = 1;
        while (n !=0){
            a=a*n;
            n--;
        }
        return a;
    }

    public int multiply(int min,int max){
        if((min+1) == max){
            return min*max;
        }else if(min == max){
            return max;
        }else{
            int mid = (min+max)/2;
            return multiply(min,mid)*multiply(mid+1,max);
        }

    }
}