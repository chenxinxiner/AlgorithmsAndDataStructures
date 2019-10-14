package collection.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {

    @Test
    void put() {
        BST<String, Integer> stringIntegerBST = new BST<String, Integer>();
        stringIntegerBST.put("b",1);
        stringIntegerBST.put("a",2);
        stringIntegerBST.put("c",3);
        stringIntegerBST.put("f",4);
        System.out.printf(String.valueOf(stringIntegerBST.get("c")));
        System.out.printf(String.valueOf(stringIntegerBST.get("f")));
    }

    @Test
    void get() {
    }
}