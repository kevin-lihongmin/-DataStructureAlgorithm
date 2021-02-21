package com.kevin.data.structure.algorithm.sort;

import com.alibaba.fastjson.JSON;

/**
 *  冒泡排序
 *
 *  就是每次比较相邻的两个元素，如果不符合顺序则进行交换，直到某次没有交换过任何数据说明已经有序
 *  最好时间复杂的是本身就有序，那么也需要便利一遍即 O(n)
 *  最坏时间复杂的就是两层循环每次都跑完，那么时间复杂度就是 O(N²)
 *
 * @author kevin
 * @date 2021/2/21 23:28
 * @since 1.0.0
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = new int[]{12, 34, -34, 454, 657, 33, 89, 67, 68, 99, -23, 34};
        System.out.println("排序前：" + JSON.toJSONString(array));
        bubbleSort(array);
        System.out.println("排序后：" + JSON.toJSONString(array));
    }

    /**
     * 冒泡排序
     * @param array 待排序的数组
     */
    public static void bubbleSort(int[] array) {
        if (array.length < 2) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            boolean isChanged = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    isChanged = true;
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
            // 如果上一轮没有进行任何的数据交换，则说明已经有序直接退出
            if (isChanged == false) {
                break;
            }
        }
    }

    /**
     * 冒泡排序的改进方案
     *
     * 每次记录最后一次进行位置交换的点，作为下次比较的边界，节省了该部分的比较操作
     *
     * @param array 待排序的数组
     */
    public static void bubbleSortOptimization(int[] array) {
        if (array.length < 2) {
            return;
        }

        // 记录最后一次交换的点
        int lastChangePoint = 0;
        // 记录无序数组的边界，每次比较到该处即可，后面已经是有序的
        int sortBoeder = array.length - 1;

        for (int i = 0; i < array.length - 1; i++) {
            boolean isChanged = false;
            for (int j = 0; j < array.length - sortBoeder; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    lastChangePoint = j;
                    isChanged = true;
                }
            }
            sortBoeder = lastChangePoint;
            // 如果上一轮没有进行任何的数据交换，则说明已经有序直接退出
            if (isChanged == false) {
                break;
            }
        }

    }

    /**
     * 交换数组中 两个下标位置的值
     * @param array 待排序数组
     * @param i 需要交换的下标 1
     * @param k 需要交换的下标 2
     */
    private static void swap(int[] array, int i, int k) {
        int tmp = array[i];
        array[i] = array[k];
        array[k] = tmp;
    }
}
