package com.kevin.data.structure.algorithm.practice;

import java.util.LinkedList;

/**
 *  滑动窗口最大值
 *  1、维护一个窗口大小的大顶堆 时间复杂度是 O（N*logK）
 *  2、使用双关队列，即Dqueue两边都可以进和出 时间复杂度为 O（N）
 *
 *
 * @author kevin
 * @date 2021/2/16 20:36
 * @since 1.0.0
 */
public class SlidingWindowMaximum239 {

    public int[] byHeap() {

        return null;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        return null;
    }

    public int[] byDqueue(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        LinkedList<Integer> dqueue = new LinkedList();
        int[] result = new int[nums.length - k];
        for (int i = 0; i < nums.length; i++) {

        }
        return result;
    }

    public static void main(String[] args) {

    }

}
