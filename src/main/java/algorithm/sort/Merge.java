package algorithm.sort;

import sun.security.util.Length;

import java.util.Arrays;
import java.util.SortedMap;

/**
 * 自顶向下的归并排序
 *
 * @author ：chenxin
 * @date ：Created in 2020/4/14 8:15
 */
public class Merge {

    private static Comparable[] aux;

    public static void sort(Comparable[] b) {
        int l = b.length;
        aux = new Comparable[l];
        sort(b, 0, l - 1);
    }

    public static void sort(Comparable[] b, int begin, int end) {
        if (end <= begin) {
            return;
        }
        int mid = begin + (end - begin) / 2;
        sort(b, begin, mid);
        sort(b, mid + 1, end);
        merge(b, begin, mid, end);
    }

    private static void merge(Comparable[] b, int begin, int mid, int end) {
        int i = begin, j = mid + 1;
        System.arraycopy(b, begin, aux, begin, end - begin + 1);
        for (int k = begin; k <= end; k++) {
            if (i > mid) {
                b[k] = aux[j++];
            } else if (j > end) {
                b[k] = aux[i++];
            } else if (aux[i].compareTo(aux[j]) < 0) {
                b[k] = aux[i++];
            } else {
                b[k] = aux[j++];
            }
        }
    }

    public static void main(String[] args) {
        Integer[] test = {6, 1, 2, 3, 1, 6, 123, 545, 65, 7, 234, 6, 56, 56, 472, 4, 72, 7, 246, 72, 7, 2467, 2456, 724, 67, 24, 7, 5, 7, 9, 8};
        Merge.sort(test);
        System.out.println(Arrays.toString(test));
    }
}
