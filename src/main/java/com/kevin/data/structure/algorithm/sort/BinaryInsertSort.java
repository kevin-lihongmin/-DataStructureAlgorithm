package com.kevin.data.structure.algorithm.sort;

import java.util.Arrays;

/**
 *  二分插入排序
 *
 *  直接插入排序就每次轮训将前N个元素变成有序，N+1个元素插入已经有序的子数组中，我们忽略了一个重要的特性就是子数组本身已经【有序】
 *  我们还是使用遍历遍历子数组的方式，其最好时间复杂度为O(1),最坏时间复杂度为O(N),平均时间复杂为O(N)
 *  查询有序数组，我们可以使用二分查询的方式，将次过程的时间复杂度从O(N)降低为O(logN),在乘以N轮那么此过程的时间复杂度就是O(N*logN)
 *
 * @author kevin
 * @date 2021/3/2 14:45
 * @since 1.0.0
 */
public class BinaryInsertSort {

    public static void main(String[] args) {
        int[] array = new int[]{12, 34, -34, 454, 657, 33, 89, 67, 68, 99, -23, 34};
        System.out.println("排序前：" + Arrays.toString(array));
        binaryInsertSort(array);
        System.out.println("排序后：" + Arrays.toString(array));
    }

    /**
     * 二分插入排序
     * @param array 待排序的数组
     */
    public static void binaryInsertSort(int[] array) {
        if (array.length < 2) {
            return;
        }
        // 记录当轮的值
        int value = 0;
        int low = 0, high = 0, middle = 0;
        for (int i = 1; i < array.length; i++) {
            low = 0;
            value = array[i];
            high = i - 1;
            while (low <= high) {
                middle = (high + low) >> 1;
                if (value < array[middle]) {
                    // 插入点为低半区，否则插入点在高半区
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
            }

            // 已经用临时变量value记录了需要挪动的位置值，此时从后往前将插入点后面所有元素往后挪动一位
            for (int j = i - 1; j >= low; j--) {
                array[j+ 1] = array[j];
            }
            //都往后挪动完了，再插入准确位置
            array[low] = value;
        }
    }
}
