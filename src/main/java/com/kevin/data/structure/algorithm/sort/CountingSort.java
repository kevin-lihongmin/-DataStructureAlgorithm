package com.kevin.data.structure.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 *  计数排序
 *  计算排序可以理解是特殊的桶排序，对数据的要求更苛刻
 *  数据要求：数据的范围根据密集，并且范围尽可能的小，比如下面模拟数据十万的数据出现在100的范围内，
 *           那么计数【桶缩小到1，当前也不用再执行快排了】的平均出现次数是1000.
 *
 * @author kevin
 * @date 2021/2/22 15:25
 * @since 1.0.0
 */
public class CountingSort {

    public static void main(String[] args) {
        // 创建模拟数据，十万的数据，区间在100 之内， 很可能某个数都出现多次【平均每个位置出现1000次】，所以是计数排序
        int[] array = new int[100000];
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            array[i] = random.nextInt(100);
        }

        System.out.println("排序前：" + Arrays.toString(array));
        countingSort(array);
        System.out.println("排序后：" + Arrays.toString(array));
    }

    /**
     *  计数排序
     * @param array 待排序数组
     */
    public static void countingSort(int[] array) {
        if (array.length < 2) {
            return;
        }

        // 确认待查询的数据的范围
        int maxValue = array[0];
        for (int i = 0; i < array.length; i++) {
            if (maxValue < array[i]) {
                maxValue = array[i];
            }
        }

        // 申请一个最大数的数组空间,并且初始化计数全是0
        int[] count = new int[maxValue + 1];
        for (int i = 0; i < maxValue; i++) {
            count[i] = 0;
        }

        // 计算每个元素出现的次数
        for (int i = 0; i < array.length; i++) {
            // array[i]的值本身就是count的下标 每次++
            count[array[i]]++;
        }

        // 依次累加，这个很关键，主要用于处理后续的拷贝数据的下标位置
        for (int i = 1; i <= maxValue; i++) {
            // 0和1加的值给1 1和2加的值给2【1的值本身就是前面加后的结果】 最后count[maxValue]的值就是所有之和
            count[i] = count[i - 1] + count[i];
        }

        // 申请临时数组存储排序后的结果
        int[] tmp = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            // array[最大下标]就是获取原数组中的值，count[原数组中的值]就获取到大概位置上的个数
            // 比如第一次的下标为 99999 的原始数据为45， 那么就是获取所有值中1-45的个数 46230 为 index
            int index = count[array[i]] - 1;
            // 将原数组中的值赋值给 tmp[46230]
            tmp[index] = array[i];
            // 那么当前应该把 下标为45的统计个数给减去1
            // 下次再获取到值为45时， tmp下标就为 56230 - 1 了，排到了该值的前一位，所以是稳定排序
            count[array[i]]--;
        }

        // 将结果拷贝到原数组
        for (int i = 0; i < array.length; i++) {
            array[i] = tmp[i];
        }
    }

}
