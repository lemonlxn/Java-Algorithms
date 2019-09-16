package Queue;

public interface Queue<E> {
    void enqueue(E e); // 队末入队
    E dequeue();       // 队首出队
    E getFront();      // 查看队首元素
    int getSize();     // 查看队列元素个数
    boolean isEmpty(); // 判断队列是否为空


}
