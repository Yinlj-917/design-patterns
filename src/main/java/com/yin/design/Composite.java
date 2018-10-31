package com.yin.design;

import lombok.Data;

import java.util.Enumeration;
import java.util.Vector;

/**
 *  结构型模式 - 组合模式
 *
 * @author lijian.yin@foxmail.com
 * @date 2018/10/27
 */
public class Composite {
    public static void main(String[] args) {
        Tree tree = new Tree("A");
        TreeNode nodeB = new TreeNode("B");
        TreeNode nodeC = new TreeNode("C");

        nodeB.add(nodeC);
        tree.root.add(nodeB);
        System.out.println("build the tree finished!");
    }
}
class Tree {
    TreeNode root = null;

    public Tree(String name) {
        root = new TreeNode(name);
    }
}

@Data
class TreeNode {

    private String name;
    private TreeNode parent;
    private Vector<TreeNode> children = new Vector<TreeNode>();

    public TreeNode(String name){
        this.name = name;
    }

    public void add(TreeNode node){
        children.add(node);
    }

    public void remove(TreeNode node){
        children.remove(node);
    }

    public Enumeration<TreeNode> getChildren(){
        return children.elements();
    }
}