package 剑指offer;

/**
 * 题目：用两个栈实现一个队列。队列的声明如下：请实现它的两个函数appendTail和deleteHead，分别完成在队列
 * 尾部插入节点和在队列头部删除节点的功能。
 */

import java.util.Stack;

public class No_8用两个栈实现队列 {

    Stack <Integer> stack1 = new Stack <Integer>();
    Stack <Integer> stack2 = new Stack <Integer>();

    public void appendTail ( int e ) {
        stack1.push(e);

    }

    public int deleteHead () {
        if (!stack2.isEmpty()) return stack2.pop();
        while (!stack1.empty()) stack2.push(stack1.pop());
        return stack2.pop();

    }

}



