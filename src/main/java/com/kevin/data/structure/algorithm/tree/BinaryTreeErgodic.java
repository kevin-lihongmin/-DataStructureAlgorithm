package com.kevin.data.structure.algorithm.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 *  二叉树的遍历
 *          A
 *         / \
 *       B     C
 *     /  \   / \
 *    D    E  F  G
 *    前序遍历打印： A -> B -> C -> D -> E -> F -> G
 *    中序遍历打印： D -> B -> E -> A -> F -> C -> G
 *    后序遍历打印： D -> E -> B -> F -> G -> C -> A
 *
 * @author kevin
 * @date 2021/3/5 16:35
 * @since 1.0.0
 */
public class BinaryTreeErgodic {

    public static void main(String[] args) {
        Node dNode = new Node("D");
        Node eNode = new Node("E");
        Node fNode = new Node("F");
        Node gNode = new Node("G");

        Node bNode = new Node("B", dNode, eNode);
        Node cNode = new Node("C", fNode, gNode);

        Node root = new Node("A", bNode, cNode);

        // 二叉树前序遍历结果为：A B D E C F G
        // 二叉树中序遍历结果为：D B E A F C G
        // 二叉树后序遍历结果为：D E B F G C A
        System.out.print("二叉树前序遍历结果为：");
        preOrder(root);
        System.out.println(" ");
        System.out.print("二叉树中序遍历结果为：");
        inOrder(root);
        System.out.println(" ");
        System.out.print("二叉树后序遍历结果为：");
        postOrder(root);
    }





    /**
     * 前序遍历打印二叉树，前序遍历顺序为：跟（自己）、左、右
     * @param root 二叉树根节点
     */
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        if (root.left != null) {
            preOrder(root.left);
        }
        if (root.right != null) {
            preOrder(root.right);
        }
    }

    /**
     * 中序遍历打印二叉树，顺序为：左、根（自己）、右
     * @param root 二叉树根节点
     */
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inOrder(root.left);
        }
        System.out.print(root.data + " ");
        if (root.right != null) {
            inOrder(root.right);
        }
    }

    /**
     *  后序遍历打印二叉树，顺序为：左、右、根（自己）
     * @param root 二叉树的根节点
     */
    private static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            postOrder(root.left);
        }
        if (root.right != null) {
            postOrder(root.right);
        }
        System.out.print(root.data + " ");
    }
    
    

    /**
     * 二叉树结构
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Node {
        /** 存储节点的数据 */
        private String data;
        /** 左子节点 */
        private Node left;
        /** 右子节点 */
        private Node right;

        public Node(String data) {
            this.data = data;
        }
    }

}
