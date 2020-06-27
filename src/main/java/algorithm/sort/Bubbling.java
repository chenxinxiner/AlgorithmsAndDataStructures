package algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author ：chenxin
 * @date ：Created in 2020/4/14 8:02
 */
public class Bubbling {

    public static void sort(Comparable[] b) {
        int l = b.length;
        for (int i = l - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (b[i].compareTo(b[j]) < 0) {
                    Comparable temp = b[i];
                    b[i] = b[j];
                    b[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] test = {6, 1, 2, 3, 1, 6, 7, 5, 7, 9, 8};
        Bubbling.sort(test);
        System.out.println(Arrays.toString(test));
    }
}
