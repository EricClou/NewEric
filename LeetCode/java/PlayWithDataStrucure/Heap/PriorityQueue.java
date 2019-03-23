package PlayWithDataStrucure.Heap;


/**
 * 优先队列是一种分轻重缓急的队列，每次出队的都是队内的最大值。
 * @param <E>
 */
public class PriorityQueue<E extends Comparable <E>> implements Queue <E> {

    private MaxHeap <E> maxHeap;

    public PriorityQueue () {
        maxHeap = new MaxHeap <>();
    }

    @Override
    public int getSize () {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty () {
        return maxHeap.isEmpty();
    }

    @Override
    public E getFront () {
        return maxHeap.findMax();
    }

    @Override
    public void enqueue ( E e ) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue () {
        return maxHeap.extractMax();
    }
}
