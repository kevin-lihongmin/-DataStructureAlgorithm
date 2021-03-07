package com.kevin.data.structure.algorithm.algorithm.heap;

import com.kevin.data.structure.algorithm.sort.HeapSort;

import java.util.Arrays;

/**
 *  堆实现，非线程安全
 *
 * @author kevin
 * @date 2021/3/7 16:01
 * @since 1.0.0
 */
public class Heap {

    public static void main(String[] args) {
        Heap heap = new Heap(6);

        int[] arr = {6, 5, 1, 3, 4,};
        for (int i = 0; i < arr.length; i++) {
            heap.insert(arr[i]);
        }
        System.out.println(Arrays.toString(heap.arr));
        heap.insert(2);
        System.out.println(Arrays.toString(heap.arr));
        // [0, 6, 5, 1, 3, 4, 0]
        // [0, 6, 5, 2, 3, 4, 1]
    }

    /** 用数组存储堆元素 */
    public int[] arr;
    /** 堆的最大值，即数组的长度，当前不考虑扩容问题 */
    private int maxLength;
    /** 当前堆已经存储的个数 */
    private int currentLength;

    public boolean insert(int value) {
        if (currentLength >= maxLength) {
            return false;
        }
        // 先赋值到空闲数组的最后一位，此时一定满足完全二叉树
        ++currentLength;
        arr[currentLength] = value;
        int index = currentLength;
        // 判断还没有到堆顶下标为1， 并且当前值大于 index/2 为父节点的值
        while(index/2 > 0 && arr[index] > arr[index / 2]) {
            // 交换元素
            HeapSort.swap(arr, index, index/2);
            // 下标缩小一半，继续
            index = index / 2;
        }
        return true;
    }


    public Boolean removeMax() {
        if (currentLength == 0) {
            return false;
        }
        // 将最后一个叶子节点放到堆顶位置，计数器减1
        arr[1] = arr[currentLength];
        --currentLength;
        heapify(arr, currentLength, 1);
        return true;
    }

    private void heapify(int[] a, int currentLength, int i) { // 自上往下堆化
        while (true) {
            // 从堆顶1，开始往下堆化， maxPos记录要替换的节点
            int maxPos = i;
            // 左子下标在数组有值范围内判断， 如果当前节点值小于左子节点
            if (i*2 <= currentLength && a[i] < a[i*2]) {
                maxPos = i*2;
            }
            // 右子下标在数组有值的范围内判断，如果上面的父节点或者左子节点的最大值 比右子节点小
            if (i*2+1 <= currentLength && a[maxPos] < a[i*2+1]) {
                maxPos = i*2+1;
            }
            // 上面两个判断都没进，即父节点大于左右子节点，停止
            if (maxPos == i) {
                break;
            }
            // 将父节点与左子或右子替换
            HeapSort.swap(arr, i, maxPos);
            // 将堆化的指针指向刚替换过的左子或右子，看看其下面是否还需要替换
            i = maxPos;
        }
    }

    public Heap(int capacity) {
        // 留出下标为0的位置
        this.arr = new int[capacity + 1];
        maxLength = capacity;
        this.currentLength = 0;
    }

}
