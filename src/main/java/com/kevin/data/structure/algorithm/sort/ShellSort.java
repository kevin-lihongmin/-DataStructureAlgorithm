package com.kevin.data.structure.algorithm.sort;

/**
 *  希尔排序
 *
 *  针对逆序度比较高的情况，一般的插入排序需要将最小元素移动的下标为0的位置，单个的时间复杂度近似 O(N) 所以希尔排序能快速的将逆序度非常高调整为近似顺序
 *
 *  比如： [8, 9, 1, 7, 2, 3, 5, 4, 6, 0] 这样的数组需要从小到大排列， 一般的插入排序，时间复杂度就是 O(N)
 *  第一次外层循环：
 *      初始增量 gap = length / 2 = 5 , 那么整个数组将被分到5个组中， (8,3) (9,5) (1,4) (7,6) (2,0) 再进行比较交换
 *      当前状态为： [3, 1, 0, 9, 7, 5, 6, 8, 4, 2]
 *
 *  第二次外层循环：
 *      缩小增量 gap = 5 / 2 = 2, 那么 将分成两个组 (3, 1, 0, 9, 7) (5, 6, 8, 4, 2) 再进行比较交换
 *      当前的状态为： [3, 5, 1, 6, 0, 8, 4, 9, 2, 7]
 *  第三次外层循环：
 *      继续缩小增量： gap = 2 / 2 = 1, 那么整个被分成一个组 (3, 5, 1, 6, 0, 8, 4, 9, 2, 7)
 *
 *
 * @author kevin
 * @date 2021/2/22 10:40
 * @since 1.0.0
 */
public class ShellSort {

    /**
     * 希尔排序 针对有序序列在插入时采用交换法
     * @param arr 待排序数组
     */
    public static void sort(int[] arr) {
        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                while (j - gap >= 0 && arr[j] < arr[j-gap]) {
                    // 插入排序采用交换法
                    swap(arr, j,j - gap);
                    j -= gap;
                }
            }
        }
    }

    /**
     *  希尔排序 针对有序序列在插入时采用移动法
     * @param arr 待排序数组
     */
    public static void sort2(int[] arr) {
        // 增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while(j - gap >= 0 && temp < arr[j - gap]) {
                        // 移动法
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     *  交换数组元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }

}
