package com.kevin.data.structure.algorithm.structure.graph;

/**
 * 邻接矩阵表示图
 * 邻接矩阵法表示图只适应于数据量比较小，并且不是稀疏图（Sparse Matrix）的情况，否则会浪费大量的空间，相比较邻接表的图查询效率高，是空间换时间的思想
 * 如果查询第一个顶点和第三个顶点是否有关系： relation[1][3] > 0 ?
 *
 *  {@link #data} 表示图的顶点; {@link #relation} 表示图的边; relation[0]中大于0的个数 表示第一个顶点的度
 *
 * @author kevin
 * @date 2021/3/9 13:31
 * @since 1.0.0
 */
public class AdjacencyMatrixGraph {
    /** 图的顶点 */
    private String[] data;
    /** 图的边 */
    private int[][] relation;
}
