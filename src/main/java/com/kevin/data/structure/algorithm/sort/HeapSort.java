package com.kevin.data.structure.algorithm.sort;

import java.util.Arrays;

/**
 *  堆排序 1、建堆 2、排序
 *
 * @author kevin
 * @date 2021/2/21 22:21
 * @since 1.0.0
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] array = new int[]{12, 34, -34, 454, 657, 33, 89, 67, 68, 99, -23, 34};
        System.out.println("排序前：" + Arrays.toString(array));
        heapSort(array);
        System.out.println("排序后：" + Arrays.toString(array));
    }

    /**
     *  堆排序
     *
     * @param array 带排序的数组
     */
    public static void heapSort(int[] array) {
        if (array.length <= 1) {
            return;
        }

        // 1、建堆
        buildHeap(array);

        // 2、排序
        int k = array.length - 1;
        while (k > 0) {
            // 将堆顶元素（最大）与最后一个元素进行交换
            swap(array, 0, k);
            // 将剩余元素重新堆化，堆顶元素变成最大元素
            heapify(array, --k, 0);
        }
    }

    /**
     * 交换数组中 两个下标位置的值
     * @param array 待排序数组
     * @param i 需要交换的下标 1
     * @param k 需要交换的下标 2
     */
    public static void swap(int[] array, int i, int k) {
        int tmp = array[i];
        array[i] = array[k];
        array[k] = tmp;
    }

    /**
     * 堆化操作
     *
     * @param array 需要排序的数组
     * @param i
     * @param i1
     */
    private static void heapify(int[] array, int n, int i) {
        while (true) {
            // 记录最大位置
            int maxPos = i;

            int leftChild = i * 2 + 1;
            // 与左子节点（leftChild）比较，获取最大值位置
            if (leftChild <= n && array[i] < array[leftChild]) {
                maxPos = leftChild;
            }

            // 与右子节点进行比较，获取最大值的位置
            int rightChild = i * 2 + 2;
            if (rightChild <= n && array[maxPos] < array[rightChild]) {
                maxPos = rightChild;
            }

            // 如果上面左子和右子节点都比自己小则结束
            if (maxPos == i) {
                break;
            }

            // 与子节点交换位置
            swap(array, i, maxPos);

            // 交换完子节点后，继续往下找
            i = maxPos;
        }
    }

    /**
     * 建堆
     * @param array 待排序的数组
     */
    private static void buildHeap(int[] array) {
        // i的起始位置为： (array.length - 1) / 2， 是最后一个叶子节点的父节点
        // 也就是最后一个非叶子节点，依次堆化直到根节点
        for (int i = (array.length - 1) / 2; i >= 0; i--) {
            heapify(array, array.length - 1, i);
        }
    }

}
