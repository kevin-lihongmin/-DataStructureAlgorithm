package com.kevin.data.structure.algorithm.algorithm.binary;

/**
 *  “近似”二分查找
 *  1、第一个X值出现的位置
 *  2、最后一个X值出现的位置
 *  3、第一个大于等于X值的位置
 *  4、最后一个小于等于X值的位置
 *
 * @author kevin
 * @date 2021/3/4 17:49
 * @since 1.0.0
 */
public class NearlyBinarySearch {


    public static void main(String[] args) {
        /*
            第一个 5 出现的下标位置为：3
            最后一个 5 出现的下标位置为：6
            第一个大于等于5 出现的下标位置为：3
            最后一个小于等于5 出现的下标位置为：6
        */
        int[] arr = new int[]{1, 2, 3, 5, 5, 5, 5, 7, 8, 9};
        int firstIndex = firstValueIndex(arr, 5);
        System.out.println("第一个 5 出现的下标位置为：" + firstIndex);

        int lastIndex = lastValueIndex(arr, 5);
        System.out.println("最后一个 5 出现的下标位置为：" + lastIndex);

        int firstGtEIndex = firstGtOrEquals(arr, 5);
        System.out.println("第一个大于等于5 出现的下标位置为：" + firstGtEIndex);

        int lastLtEIndex = lastLtOrEquals(arr, 5);
        System.out.println("最后一个小于等于5 出现的下标位置为：" + lastLtEIndex);
    }

    /**
     * 查询第一个X出现的位置
     * @param array 待查询的有序数组
     * @param value 需要查询的值
     * @return 第一个等值的下标
     */
    public static int firstValueIndex(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            if (array[middle] == value) {
                // 第一个位置，那么当前下标是0 或者 前面一个值等于value就是第一个出现的位置
                if (middle == 0 || array[middle - 1] != value) {
                    return middle;
                } else {
                    // 否则需要去前面的空间判断
                    high = middle - 1;
                }
            } else if (array[middle] < value) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return -1;
    }

    /**
     *  查询最后一个X出现的位置下标
     * @param arr 待查询的有序数组
     * @param value 待查询的值
     * @return 等值的最后一个元素的下标
     */
    public static int lastValueIndex(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            if (arr[middle] == value) {
                // 如果当前已经是数组的最后一位（也防止后面判断时+1的下标越界），或者下一个值不等于该值
                if (middle == arr.length - 1 || arr[middle + 1] != value) {
                    return middle;
                } else {
                    // 去后面找
                    low = middle + 1;
                }
            } else if (arr[middle] < value) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return -1;
    }

    /**
     *  查询第一个大于等于X值的下标位置
     * @param arr 待查询的有序数组
     * @param value 待查询的值
     * @return 第一个大于等于下下标出现的位置
     */
    public static int firstGtOrEquals(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            if (arr[middle] >= value) {
                // 当前以及是数组头部或者前一个不是该值，说明当前就是等于该值的第一个
                if (middle == 0 || arr[middle - 1] != value) {
                    return middle;
                } else {
                    // 否则前面还有等于该值的，去前面空间找
                    high = middle - 1;
                }
            } else {
                // 否则中间值比要查找的值小，去更大的空间找
                low = middle + 1;
            }
        }
        return -1;
    }

    /**
     *  查询最后一个小于等于X的下标位置
     * @param arr 待查询的有序数组
     * @param value 待查询的值
     * @return 最后一个小于等于值的下标位置
     */
    public static int lastLtOrEquals(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            if (arr[middle] <= value) {
                // 如果当前已经是最好一个元素，或者后面一个下标位的值不能于该值，那么现在就是最后一个等值位置
                if (middle == arr.length - 1 || arr[middle + 1] != value) {
                    return middle;
                } else {
                    // 否则 arr[middle + 1] == value,后面还有等值, 调大最小值
                    low = middle + 1;
                }
            } else {
                // 否则，中间值大于了待查询的值，需要去低空间查找
                high = middle - 1;
            }
        }
        return -1;
    }

}
