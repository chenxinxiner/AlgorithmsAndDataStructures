package unit;

import java.util.Random;

/**
 * 数组相关测试工具类
 *
 * @author ：chenxin
 * @date ：Created in 2019-9-27 17:29
 * @description：数组相关测试工具类
 * @modified By：
 * @version: 1.0$
 */
public class ArrayTestUnit {

    /**
     * 生成随机数组成的数组
     * @param length 数组长度
     * @param min 数组中值得最小值
     * @param max 数组中值得最大值
     * @return
     */
    public static int[] generateAnArray(int length,int min,int max) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = new Random().nextInt(max-min)+min;
        }
        return array;
    }
}
