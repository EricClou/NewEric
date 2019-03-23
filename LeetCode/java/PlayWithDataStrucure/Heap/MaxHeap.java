package PlayWithDataStrucure.Heap;

public class MaxHeap<E extends Comparable <E>> {

    private Array <E> data;

    public MaxHeap ( int capacity ) {
        data = new Array <>(capacity);
    }

    public MaxHeap () {
        data = new Array <>();
    }

    public MaxHeap ( E[] arr ) {
        data = new Array <>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--)
            siftDown(i);
    }

    // 返回堆中的元素个数
    public int size () {
        return data.getSize();
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty () {
        return data.isEmpty();
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent ( int index ) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index - 1) / 2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild ( int index ) {
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild ( int index ) {
        return index * 2 + 2;
    }

    // 向堆中添加元素
    public void add ( E e ) {
        data.addLast(e);

        //在堆的末尾添加元素后，把这个元素向上升序到合适位置（之所以添加到末尾是因为这个堆实际上还是由顺序表来实现的
        siftUp(data.getSize() - 1);
    }


    //向上调整
    private void siftUp ( int k ) {

        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    // 看堆中的最大元素,大顶堆的最大元素就在顶
    public E findMax () {
        if (data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return data.get(0);
    }

    // 取出堆中最大元素
    public E extractMax () {

        E ret = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();

        //取出最大元素后，原本堆中最后一个元素放在堆顶，然后在调整其位置
        siftDown(0);

        return ret;
    }


    //调整序列k的节点在整个堆中的位置
    private void siftDown ( int k ) {

        //该节点不是叶子节点，有调整的余地
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k); // 在此轮循环中,data[k]和data[j]交换位置
            if (j + 1 < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0)   //右子节点也在堆中且右子节点比左子节点大
                j++;
            // data[j] 是 leftChild 和 rightChild 中的最大值

            if (data.get(k).compareTo(data.get(j)) >= 0)        //父节点大于子节点，不需要进行调整
                break;

            data.swap(k, j);                  //父节点小于子节点中的较大的那个，进行交换
            k = j;
        }
    }

    // 取出堆中的最大元素，并且替换成元素e
    public E replace ( E e ) {

        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }
}
