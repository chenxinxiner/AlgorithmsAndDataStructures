package algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author ：chenxin
 * @date ：Created in 2020/4/14 8:51
 */
public class Quick {

    public static void sort(Comparable[] b) {
        sort(b, 0, b.length - 1);
    }

    private static void sort(Comparable[] b, int begin, int end) {
        if (end <= begin) {
            return;
        }
        int j = partition(b, begin, end);
        sort(b, begin, j);
        sort(b, j + 1, end);
    }

    private static int partition(Comparable[] b, int begin, int end) {
        int i = begin, j = end + 1;
        Comparable v = b[begin];
        while (true) {
            while (b[++i].compareTo(v) < 0) {
                if (i == end) {
                    break;
                }
            }
            while (b[--j].compareTo(v) >= 0) {
                if (j == begin) {
                    break;
                }
            }
            if (i > j) {
                break;
            }
            Comparable temp = b[i];
            b[i] = b[j];
            b[j] = temp;
        }

        Comparable temp = b[j];
        b[j] = b[begin];
        b[begin] = temp;
        return j;
    }


    public static void main(String[] args) {
        Integer[] test = {6, 1, 2, 3, 1, 6, 123, 545, 65, 7, 234, 6, 56, 56, 472, 4, 72, 7, 246, 72, 7, 2467, 2456, 724, 67, 24, 7, 5, 7, 9, 8};
        Quick.sort(test);
        System.out.println(Arrays.toString(test));
    }
}
