package com.kevin.data.structure.algorithm.practice.stack;

import java.util.Stack;

/**
 *  LeetCode-232 用栈实现队列
 *
 *  1、使用两个栈（比如叫A、B）
 *  2、队列是否为空方法：判断两个栈是否都为空
 *  3、入队方法：将元素依次压入栈A
 *  4、出队列方法：判断如果栈B为空，则将栈A中的元素全部出栈并压入栈B；否则直接从栈B出栈一个元素
 *  5、查看方法：处理逻辑与出队方法相同，只是最后返回的是 B栈的peek方法
 *
 * @author kevin
 * @date 2021/2/15 19:53
 * @since 1.0.0
 */
public class StackToQueue232 {

    private static Stack<Integer> input = null;

    private static Stack<Integer> output = null;

    /** Initialize your data structure here. */
    public StackToQueue232() {
        input = new Stack<Integer>();
        output = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        input.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (output.empty()) {
            while (!input.empty()) {
                output.push(input.pop());
            }
        }
        return output.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (output.empty()) {
            while (!input.empty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return input.empty() && output.empty();
    }
}