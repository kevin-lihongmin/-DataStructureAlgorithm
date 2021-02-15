package com.kevin.DataStructureAlgorithm.application;

import com.google.common.collect.Maps;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *  使用 {@link Stack} FILO 的特性处理括号类匹配验证
 *
 *  1、使用Map作为括号存储，那么查询的时间复杂度接近 O(1), 并且代码比较优雅
 *  2、右括号则存储为map的key，右括号在则压栈，否则判栈是否为空，或者从栈中取出字符判断是否不相等
 *  3、是否字符匹配是否相同是，使用equals
 *
 * @author kevin
 * @date 2021/2/9 22:48
 * @since 1.0.0
 */
public class StackForBrackets {


    private static Map<Character, Character> CHAR_MAP = null;

    static {
        HashMap<Character, Character> tempForGc = Maps.newHashMap();
        tempForGc.put(']', '[');
        tempForGc.put('}', '{');
        tempForGc.put(')', '(');
        CHAR_MAP = Collections.unmodifiableMap(tempForGc);
    }

    public static void main(String[] args) {
        String str = "{[][]()}{{{}}}}";
        System.out.println(StackForBrackets.isValid(str));
    }

    public static Boolean isValid(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (!CHAR_MAP.containsKey(c)) {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty() || c.equals(stack.pop())) {
                return false;
            }
        }
        return stack.isEmpty();
    }

}
