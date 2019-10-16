package collection.tree;

import org.junit.jupiter.api.Test;

class BSTTest {

    @Test
    void put() {
        BinarySearchTree<String, String> stringIntegerBST = new BinarySearchTree<String, String>();
        stringIntegerBST.put("h","h");
        stringIntegerBST.put("a","a");
        stringIntegerBST.put("c","asdasda");
        stringIntegerBST.put("f","qweq");
        stringIntegerBST.put("e","e");
        stringIntegerBST.put("j","j");
        stringIntegerBST.put("d","d");
        stringIntegerBST.put("K","K");
        stringIntegerBST.put("m","m");
        System.out.println(stringIntegerBST.size()+" "+stringIntegerBST.get("c"));
    }

    @Test
    void get() {
    }
}