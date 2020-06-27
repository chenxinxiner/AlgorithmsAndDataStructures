package algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author ：chenxin
 * @date ：Created in 2020/4/14 7:53
 */
public class Insert {

    public static void sort(Comparable[] a) {
        int l = a.length;
        for (int i = 1; i < l; i++) {
            for (int j = i; j > 0 && (a[j].compareTo(a[j - 1]) < 0); j--) {
                Comparable temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] test = {6, 1, 2, 3, 1, 6, 7, 5, 7, 9, 8};
        Insert.sort(test);
        System.out.println(Arrays.toString(test));
    }

}
