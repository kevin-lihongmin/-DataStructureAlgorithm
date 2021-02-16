package com.kevin.data.structure.algorithm.practice;

import java.util.Stack;

/**
 *  1、LeetCode-232 用栈实现队列
 *
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