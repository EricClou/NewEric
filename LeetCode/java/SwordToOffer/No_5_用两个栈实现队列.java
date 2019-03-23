package SwordToOffer;


import java.util.Stack;

//用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。


/**
 * 栈和队列的区别：
 * 栈是FILO，先进后出的类型
 * 队列是FIFO，先进先出的类型
 */
public class No_5_用两个栈实现队列 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }
    /**
     * 用栈模拟队列就可以放两个栈，用一个栈入栈，然后出栈是将其全部放入另一个栈
     * 所有的出栈操作由另一个栈完成，FILO再倒一遍就是FIFO
     * @return
     */
    public int pop() {
        //首先要看stack2里面倒干净了没有，没倒干净先倒干净
        if (!stack2.isEmpty()) return stack2.pop();
        while (!stack1.isEmpty()) stack2.push(stack1.pop());
        return stack2.pop();
    }
}
