import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackArrayTest {

    @Test
    void test() {
        StackArray<String> stringStackArray = new StackArray<String>();
        stringStackArray.push("sss");
        System.out.printf(String.valueOf(stringStackArray.size()));
        System.out.printf(stringStackArray.pop());
    }

}