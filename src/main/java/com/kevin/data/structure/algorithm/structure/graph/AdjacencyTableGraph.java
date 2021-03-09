package com.kevin.data.structure.algorithm.structure.graph;

import java.util.LinkedList;

/**
 *  邻接表方式的无向图
 *  邻接表存储比较节省空间，只是查询两个节点是否有边时，需要查询链表，时间复杂度较低，是时间换空间的思想
 *  只是当数据量比较大是，只能用邻接表存储， 如果链表过长导致查询性能下降，可以选择读写性能都比较高的数据结构
 *  即链表可以更换为 跳表、红黑树（或其他的平衡二叉查找树）等
 *
 * @author kevin
 * @date 2021/3/9 13:41
 * @since 1.0.0
 */
public class AdjacencyTableGraph {
    /** 记录顶点的个数 */
    private int vertex;
    /** 邻接表 */
    private LinkedList<Integer>[] data;

    public AdjacencyTableGraph(int vertex) {
        this.vertex = vertex;
        data = new LinkedList[vertex];
        for (int i = 0; i < data.length; i++) {
            data[i] = new LinkedList<>();
        }
    }

    /** 无向图存储一个边，要存储两个地方 */
    public void addEdge(int start, int end) {
        data[start].add(end);
        data[end].add(start);
    }
}
