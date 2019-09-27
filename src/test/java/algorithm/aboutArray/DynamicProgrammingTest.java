package algorithm.aboutArray;

import org.junit.jupiter.api.Test;
import unit.ArrayTestUnit;

import static org.junit.jupiter.api.Assertions.*;

class DynamicProgrammingTest {

    @Test
    void maxSubArray() {
        int[] array = ArrayTestUnit.generateAnArray(10000000,-500,500);

        long bei = System.currentTimeMillis();
        System.out.println(DynamicProgramming.maxSubArrayDyPg(array));
        long end = System.currentTimeMillis();
        System.out.println("动态规划用时："+(end-bei));
        System.out.println(DynamicProgramming.maxSubArrayMerger(array));
        System.out.println("归并用时："+(System.currentTimeMillis()-end));
    }
}