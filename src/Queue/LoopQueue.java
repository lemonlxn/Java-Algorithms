package Queue;


// 由于需要浪费一个空间，所以开辟空间的时候，capacity = capacity + 1

public class LoopQueue<E> implements Queue<E> {

    private E[] data;        // 不复用动态数组，从底层写起
    private int front,tail;  // 分别指向 队首与队末(待添加元素) 索引
    private int size;        // 记录队列元素个数

    public LoopQueue(int capacity){
        // 对于循环队列，需要浪费一个空间，则 开辟 capacity空间大小 比用户传来的 capacity空间大小 要多一个
        data = (E[])new Object[capacity + 1];

        // 初始化成员变量
        front= 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length - 1; // capacity + 1 - 1，原capacity空间大小
    }



    @Override
    public void enqueue(E e) {
        // 入队之前，判断队列是否满了
        // 当 (tail + 1) % data.length == front的时候，队列满了

        if ((tail + 1) % data.length == front)
            resize(getCapacity() * 2);

        // 在tail处添加元素
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;

    }

    private void resize(int newcapacity){
        E[] newData = (E[])new Object[newcapacity + 1]; // 需要浪费一个空间
        /*
           将data数据，从front开始，依次添加到newData中
           newData[0] --> data[front]
           newData[1] --> data[front+1] 有 front 个偏移量
           由于这是一个循环队列，可能存在 i + front > data.length
           所以需要修改为 (i + front) % data.length
         */


        for (int i = 0; i < size ; i ++){
            newData[i] = data[(i+front) % data.length];
        }

        data = newData;

        front = 0 ;  // 扩容或缩容后 front 指向队首
        tail = size; // 扩容或缩容后 tail = size


    }

    @Override
    public E dequeue() {

        // 在移除队首数据前，先判断队列是否为空
        if (isEmpty())
            throw new IllegalArgumentException("队列为空");

        E res = data[front];
        data[front] = null; // 移除队首元素后，该值为null

        front = (front + 1) % data.length;
        size --;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);

        return res;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("队列为空");

        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail; // 相等的时候，意味着队列为空
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("Queue: size = %d , capacity = %d \n", size, getCapacity()));
        str.append("LoopQueue:front [");

//        for (int i = front ; i != tail; i = (i + 1) % data.length){
//            str.append(data[i]);
//            if ((i + 1) % data.length != tail)
//                str.append(",");
//        }

        for (int i = 0 ; i < size ; i ++){
            str.append(data[(i + front) % data.length]);

            if (i != size - 1)
                str.append(",");
        }

        str.append("] tail");


        return str.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<Integer>();


        for (int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }

    }
}
