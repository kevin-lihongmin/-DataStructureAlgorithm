package com.kevin.data.structure.algorithm.sort;

/**
 *  归并排序 使用了分治的思想分而治之
 *  归并排序同快排一样是时间复杂度为 O(N*logN) 只是相同情况下一般会选择快速排序
 *
 *
 * @author kevin
 * @date 2021/2/20 16:47
 * @since 1.0.0
 */
public class MergeSort {

    public static void main(String[] args) {

    }

    public static void mergeSort(int[] array) {
        int length = array.length;
        mergeSortInternally(array, 0, length - 1);
    }

    private static void mergeSortInternally(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int part = left + (right - left) / 2;
        mergeSortInternally(array, left, part);
        mergeSortInternally(array, part + 1, right);

        // 将分开排序的范围进行合并
        merge(array, left, part, right);
    }

    private static void merge(int[] array, int left, int part, int right) {
        int i = left;
        int j = part + 1;
        int k = 0;
        int[] tmp = new int[right - left + 1];
    }

}
