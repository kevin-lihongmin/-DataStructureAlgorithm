package com.kevin.data.structure.algorithm.practice.queue;

/**
 *  环形队列
 *
 *  1、head、tail 指针出队和入队操作
 *  2、判断队列满的条件是 (tail + 1) % n == head ; 判断队空的判断条件是 head == tail;
 *  3、这种情况下回浪费一个数组元素空间
 *  4、写的关键：存取都是先根据当前的指针作为下标存取数据，在将下标赋值给 下标 + 1，此时可能已经下标越界，取余则回到数组头部，非常巧妙
 *    （此处，判断下标使用： head = head + 1 == n ? 0 : head; 也是可以的，好理解但是不巧妙）
 *
 * @author kevin
 * @date 2021/2/25 16:41
 * @since 1.0.0
 */
public class CircularQueue<T> {

    /** 队列数据 */
    private final Object[] data;
    /** 队列的长度 */
    private final int queueLength;
    /** 队头的位置 */
    private int head;
    /** 队尾的位置 */
    private int tail;

    public static void main(String[] args) {
        // 取出元素1
        // 存储第四个元素返回false,因为不空一个位置的话，没有条件判断队空队满
        CircularQueue<Integer> circularQueue = new CircularQueue<>(4);
        // head = 0, tail = 0;

        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        Integer dequeue = circularQueue.dequeue();
        System.out.println("取出元素" + dequeue);
        circularQueue.enqueue(3);
        circularQueue.enqueue(4);
        Boolean enqueue = circularQueue.enqueue(5);
        System.out.println("存储第四个元素返回" + enqueue + ",因为不空一个位置的话，没有条件判断队空队满");
    }

    public CircularQueue(int queueLength) {
        data = new Object[queueLength];
        this.queueLength = queueLength;
    }

    public Boolean enqueue(T t) {
        if ((tail + 1) % queueLength == head) {
            return false;
        }

        data[tail] = t;
//        tail = (tail + 1) % queueLength;
        tail = tail + 1 == queueLength ? 0 : tail + 1;

        return true;
    }

    public T dequeue() {
        if (head == tail) {
            return null;
        }

        T result = (T)data[head];
//        head = (head + 1) % queueLength;
        head = head + 1 == queueLength ? 0 : head + 1;

        return result;
    }

}
