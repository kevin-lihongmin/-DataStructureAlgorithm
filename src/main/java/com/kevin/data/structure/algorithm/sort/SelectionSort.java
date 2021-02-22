package com.kevin.data.structure.algorithm.sort;

import com.alibaba.fastjson.JSON;

/**
 *  选择排序
 *
 * @author kevin
 * @date 2021/2/22 11:18
 * @since 1.0.0
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] array = new int[]{12, 34, -34, 454, 657, 33, 89, 67, 68, 99, -23, 34};
        System.out.println("排序前：" + JSON.toJSONString(array));
        selectionSort(array);
        System.out.println("排序后：" + JSON.toJSONString(array));
    }

    /**
     * 选择排序，a表示数组，n表示数组大小
     * @param a 待排序数组
     */
    public static void selectionSort(int[] a) {
        int n = a.length;
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n - 1; ++i) {
            // 查找最小值
            int minIndex = i;
            for (int j = i + 1; j < n; ++j) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }

            // 交换
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }

}