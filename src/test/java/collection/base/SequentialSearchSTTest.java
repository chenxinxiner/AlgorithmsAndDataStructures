package collection.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SequentialSearchSTTest {

    @Test
    void put() {
        SequentialSearchST<Integer,String> sequentialSearchST = new SequentialSearchST();
        sequentialSearchST.put(123,"1");
        sequentialSearchST.put(12,"2");
        sequentialSearchST.put(12,"3");
        sequentialSearchST.put(34,"4");
        sequentialSearchST.put(25,"5");
        sequentialSearchST.put(76,"6");
        sequentialSearchST.put(90,"7");
    }
}