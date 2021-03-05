package com.kevin.data.structure.algorithm.algorithm.binary;

import java.util.Arrays;
import java.util.Random;

/**
 *  最基本的二分查找算法
 *
 *  2¹ = 2 => O(log1) = 2
 *  二分查找的前提是利用的数组的随机访问时间复杂度是O(1)，也就是说有序链表本身的二分查找时间复杂度不能达到O(logN)
 *
 * @author kevin
 * @date 2021/3/4 10:35
 * @since 1.0.0
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[100];
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            arr[i] = random.nextInt(1000);
        }
        // 调用Java的 TimSort排序
        Arrays.sort(arr);

        int index = binarySearch(arr, 50);
        System.out.println("元素50 出现的下标位置为：" + index);
    }

    /**
    * 基本的二分查找
    * @param array 待查找的有序数组
    * @param value 待查找的值
    * @return 查找值对应的下标
    */
    public static int binarySearch(int[] array, int value) {
    int low = 0;
    int high = array.length - 1;
    while (low <= high) {
        int middle = low + ((high - low) >> 1);
        if (array[middle] == value) {
            return middle;
            // 升序，当前中间值比待查询的值小，则在后半段，将最小值重置；
            // 降序数组则把判断是小于变成大于
        } else if (array[middle] < value) {
            low = middle + 1;
        } else {
            high = middle - 1;
        }
    }
    return -1;
    }

    /**
     * 递归实现基本的二分查找
     * @param array 待查找的有序数组
     * @param value 待查找的值
     * @return 查找值对应的下标
     */
    public static int recursionBinarySearch(int[] array, int value) {
        return binarySearchInternally(array, 0, array.length, value);
    }

    private static int binarySearchInternally(int[] array, int low, int high, int value) {
        if (low > high) {
            return -1;
        }

        int middle = low + ((high - low) >> 1);
        if (array[middle] == value) {
            return middle;
        } else if (array[middle] < value) {
            return binarySearchInternally(array, middle + 1, high, value);
        } else {
            return binarySearchInternally(array, low, middle - 1, value);
        }
    }

}
