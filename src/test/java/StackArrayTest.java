import collection.base.StackArray;
import org.junit.jupiter.api.Test;

class StackArrayTest {

    @Test
    void test() throws Exception {
        StackArray<String> stringStackArray = new StackArray<String>();
        stringStackArray.push("sss");
        System.out.printf(String.valueOf(stringStackArray.size()));
        System.out.printf(stringStackArray.pop());
    }

}