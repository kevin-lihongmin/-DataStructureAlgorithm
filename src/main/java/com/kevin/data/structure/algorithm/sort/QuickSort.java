package com.kevin.data.structure.algorithm.sort;

import java.util.Arrays;

/**
 *  快速排序也叫快排， 也是时间复杂度为 O(N*logN)
 *  与归并排序相同的时间复杂度，也使用了归并的思想 但是不同之处是需要先找到一个区分点， 再进行递归
 *  快排是使用最广泛的排序方式，比如mysql 中需要排序时（order by， group by的第一步也是排序）
 *
 * @author kevin
 * @date 2021/2/20 16:03
 * @since 1.0.0
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{12, 34, -34, 454, 657, 33, 89, 67, 68, 99, -23, 34};
        System.out.println("排序前：" + Arrays.toString(array));
        quickSort(array);
        System.out.println("排序后：" + Arrays.toString(array));
    }

    public static void quickSort(int[] array) {
        int n = array.length;
        quickSortInternally(array, 0, n - 1);
    }


    public static void quickSortInternally(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int part = partition(array, left, right);
        quickSortInternally(array, left, part - 1);
        quickSortInternally(array, part + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        // 获取区分点的值
        int pivot = array[right];
        // 用i记录区分点值pivot，最后真正应该去的下标位置
        int i = left;
        // 从范围内，左到右遍历
        for (int j = left; j < right; j++) {
            if (array[j] < pivot) {
                // 说明当前只就该在自己位置上老实呆着，将i的值叠加继续下一个判断
                if (i == j) {
                    i++;
                } else {
                    int tmp = array[i];
                    array[i++] = array[j];
                    array[j] = tmp;
                }
            }
        }
        //
        int tmp = array[i];
        array[i] = array[right];
        array[right] = tmp;

//        System.out.println("i = " + i);
        return i;
    }

}
