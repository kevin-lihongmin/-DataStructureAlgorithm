package com.kevin.data.structure.algorithm.lru;

import java.util.LinkedHashMap;

/**
 *  基于数组实现 LRU 缓存策略
 *
 * @author kevin
 * @date 2021/2/24 15:00
 * @since 1.0.0
 */
public class ArrayLur {

    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);



        System.out.println(map);
        Integer integer = map.get(1);
    }

}
