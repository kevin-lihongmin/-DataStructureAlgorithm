package com.kevin.data.structure.algorithm.sort;

import com.alibaba.fastjson.JSON;

/**
 *  归并排序 使用了分治的思想分而治之
 *  归并排序同快排一样是时间复杂度为 O(N*logN) 只是相同情况下一般会选择快速排序
 *
 *  归并排序的思想就是每次讲数组长度的分成两份，递归 一直到不可再分， 最后执行排序； 每次递归的最后一步是将排好序的元素拷贝到临时空间中
 *  而临时空间每次都是复用的所以空间复杂度是O(N)
 *
 *
 *
 *
 * @author kevin
 * @date 2021/2/20 16:47
 * @since 1.0.0
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = new int[]{12, 34, -34, 454, 657, 33, 89, 67, 68, 99, -23, 34};
        System.out.println("排序前：" + JSON.toJSONString(array));
        mergeSort(array);
        System.out.println("排序后：" + JSON.toJSONString(array));
    }

    public static void mergeSort(int[] array) {
        int length = array.length;
        mergeSortInternally(array, 0, length - 1);
    }

    private static void mergeSortInternally(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int part = left + (right - left)/2;
        mergeSortInternally(array, left, part);
        mergeSortInternally(array, part + 1, right);

        // 将分开排序的范围进行合并
//        merge(array, left, part, right);
        mergeBySentry(array, left, part, right);
    }

    private static void merge(int[] array, int left, int part, int right) {
        int i = left;
        int j = part + 1;
        int k = 0;
        int[] tmp = new int[right - left + 1];
        while (i <= part && j <= right) {
            if (array[i] <= array[j]) {
                tmp[k++] = array[i++];
            } else {
                tmp[k++] = array[j++];
            }
        }

        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = part;
        if (j <= right) {
            start = j;
            end = right;
        }

        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            tmp[k++] = array[start++];
        }

        // 将数据拷贝回原数组
        for (i = 0; i <= right - left; ++i) {
            array[left + i] = tmp[i];
        }
    }

    /**
     *  使用哨兵方式进行合并
     * @param array 需要排序的数组
     * @param left 左边下标
     * @param part 区分点
     * @param right 右边下标
     */
    public static void mergeBySentry(int[] array, int left, int part, int right) {
        int[] leftArray = new int[part - left + 2];
        int[] rightArray = new int[right - part + 1];

        for (int i = 0; i <= part - left; i++) {
            leftArray[i] = array[left + i];
        }
        leftArray[part - left + 1] = Integer.MAX_VALUE;

        for (int i = 0; i < right - part; i++) {
            rightArray[i] = array[part + 1 + i];
        }
        rightArray[right - part] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int k = left;

        while (k <= right) {
            // 当左边数组到达哨兵时，i不再继续增加，直到右边数组取完剩余值
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }
    }

}
