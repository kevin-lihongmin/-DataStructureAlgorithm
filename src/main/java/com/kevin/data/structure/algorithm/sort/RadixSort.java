package com.kevin.data.structure.algorithm.sort;

import java.util.Arrays;

/**
 *  基数排序
 *
 * @author kevin
 * @date 2021/2/22 16:37
 * @since 1.0.0
 */
public class RadixSort {

    public static void main(String[] args) {
        // 使用电话号码模拟
        long[] array = new long[]{13811125683L, 13856569891L, 15856985695L, 17769699897L,
            18965659692L, 15984653263L, 19965654254L, 13454879652L
        };

        System.out.println("排序前：" + Arrays.toString(array));
        radixSort(array);
        System.out.println("排序后：" + Arrays.toString(array));
    }

    /**
     * 基数排序
     * @param array 待排序数组
     */
    public static void radixSort(long[] array) {
        if (array.length < 2) {
            return;
        }

        long maxValue = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }

        // 从个位开始，对数组array按 指数进行排序： 1，10， 100，1000
        for (int exp = 1; maxValue / exp > 0; exp *= 10) {
            // 对每位上进行排序
            countingSort(array, exp);
        }
    }

    /**
     * 对每一位上进行排序
     * @param array 待排序数组
     * @param exp 除数，也就觉得了是排哪个位
     */
    public static void countingSort(long[] array, int exp) {
        if (array.length < 2) {
            return;
        }

        // 计算每个元素的个数
        int[] count = new int[10];
        for (int i = 0; i < array.length; i++) {
            // 比如电话号码是 13800000000 / 100000000 就是比较百位， 取余就是为了放入计数叠加器
            count[(int)((array[i] / exp) % 10)]++;
        }

        // 计算排序后的位置, 叠加计算出后面的位置下标，具体可以参见计数排序的注释
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i - 1] + count[i];
        }

        // 申请临时数组
        long[] tmp = new long[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            tmp[count[(int)((array[i] / exp) % 10)] - 1] = array[i];
            count[(int)((array[i] / exp) % 10)]--;
        }

        // 重置排序后的结果
        for (int i = 0; i < array.length; i++) {
            array[i] = tmp[i];
        }
    }
}
