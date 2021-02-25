package com.kevin.data.structure.algorithm.practice.heap;

import java.util.PriorityQueue;

/**
 *  流数据中的第K大元素
 *
 *  1、每次给元素进行排序，可以考虑使用快排，那么时间复杂的也是 K*logK
 *  2、创建一个长度为K的小顶堆（java的{@link PriorityQueue} 使用的是严格的斐波那契堆，性能非常的高
 *    第k大的元素永远在堆顶） 那么时间复杂都为 log2K
 *
 * @author kevin
 * @date 2021/2/15 22:50
 * @since 1.0.0
 */
public class KthLargest703 {

    public static void main(String[] args) {
        int[] init = new int[]{4, 5, 8, 2};
        KthLargest703 kthLargest = new KthLargest703(3, init);
        System.out.println("return 4 --> " + kthLargest.add(3));   // return 4
        System.out.println("return 5 --> " + kthLargest.add(5));   // return 5
        System.out.println("return 5 --> " + kthLargest.add(10));  // return 5
        System.out.println("return 8 --> " + kthLargest.add(9));  // return 8
        System.out.println("return 8 --> " + kthLargest.add(4));   // return 8
    }

    private PriorityQueue<Integer> priorityQueue;

    private int k;

    public KthLargest703(int k, int[] numArray) {
        this.k = k;
        priorityQueue = new PriorityQueue<>(k);
        for (int num : numArray) {
            add(num);
        }
    }

    public int add(int val) {
        if (priorityQueue.size() < k) {
            priorityQueue.offer(val);
        } else if (priorityQueue.peek() < val) {
            // 新添加的值比栈顶元素大，则移除该小顶堆的top，再添加新的元素
            priorityQueue.poll();
            priorityQueue.offer(val);
        }
        return priorityQueue.peek();
    }

}
