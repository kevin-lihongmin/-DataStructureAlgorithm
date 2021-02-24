package com.kevin.data.structure.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 *  插入排序
 *
 *  插入排序是经常使用的排序算法，其优于冒泡排序， 而选择排序本身是非稳定排序所以使用场景更少
 *
 *  插入排序在数据交换时更加的复杂，所以同样为 O(N²)的时间复杂度，但是插入排序的性能优于冒泡排序
 *
 *  做一个十万的数组，相同的机器配置，执行 {@link InsertionSort#insertionSortVsBubbleSort()} ，执行结果为：
 *  arrayByInsertion length = 100000 排序花费时间为：765
 *  arrayByBubble length = 100000 排序花费时间为：14366
 *
 *
 * @author kevin
 * @date 2021/2/21 23:53
 * @since 1.0.0
 */
public class InsertionSort {

    public static void insertionSortVsBubbleSort() {
        int[] arrayByInsertion = new int[100000];
        int[] arrayByBubble = new int[100000];
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            int value = random.nextInt();
            arrayByInsertion[i] = value;
            arrayByBubble[i] = value;
        }

        long start = System.currentTimeMillis();
        insertionSort(arrayByInsertion);
        long end = System.currentTimeMillis();
        long insertionTime = end - start;
        BubbleSort.bubbleSort(arrayByBubble);
        long end2 = System.currentTimeMillis();
        long bubbleTime = end2 - end;

        System.out.println("arrayByInsertion length = " + arrayByInsertion.length + " 排序花费时间为：" + insertionTime);
        System.out.println("arrayByBubble length = " + arrayByBubble.length + " 排序花费时间为：" + bubbleTime);

    }

    public static void main(String[] args) {
        insertionSortVsBubbleSort();
        /*int[] array = new int[]{12, 34, -34, 454, 657, 33, 89, 67, 68, 99, -23, 34};
        System.out.println("排序前：" + Arrays.toString(array));
        insertionSort(array);
        System.out.println("排序后：" + Arrays.toString(array));*/
    }

/**
 * 插入排序
 * @param array 待排序的数组
 */
public static void insertionSort(int[] array) {
    if (array.length < 2) {
        return;
    }

    for (int i = 0; i < array.length; i ++) {
        int value = array[i];
        int j = i - 1;

        for ( ; j >= 0; j--) {
            if (array[j] > value) {
                array[j + 1] = array[j];
            } else {
                break;
            }
        }
        array[j + 1] = value;
    }
}


}
