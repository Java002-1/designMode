package com.biuder.flyweght;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 享元模式
 */
public class FlyWeightTest {
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(3,4,TreeFactory.getTreeNode("1","2"));
        TreeNode treeNode2 = new TreeNode(3,4,TreeFactory.getTreeNode("1","2"));
    }
}


class TreeFactory{
    private static final Map<String,Tree> map = new ConcurrentHashMap<>();
    public static Tree getTreeNode(String name,String data){
        if(map.containsKey(name)){
            return map.get(name);
        }
        Tree treeNode = new Tree(name,data);
        map.put(name,treeNode);
        return treeNode;
    }
}
class TreeNode{
    private int x;
    private int y;
    private Tree tree;

    public TreeNode(int x, int y, Tree tree) {
        this.x = x;
        this.y = y;
        this.tree = tree;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }
}


class Tree{
    private final String name;
    private final String data;

    public Tree(String name, String data) {
        System.out.println("创建Tree对象");
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }
}