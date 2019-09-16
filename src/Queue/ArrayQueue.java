package Queue;

import Arrays.ArrayE;

public class ArrayQueue<E> implements Queue<E> {
    private ArrayE<E> array;

    public ArrayQueue(int capacity){
        array = new ArrayE<>(capacity);
    }

    public ArrayQueue(){
        array = new ArrayE<>();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Queue:front [");

        for (int i = 0 ; i < array.getSize(); i++){
            str.append(array.get(i));
            if (i != array.getSize() -1)
                str.append(",");
        }

        str.append("] tail");


        return str.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<Integer>();

        for (int i = 0 ; i < 10 ; i ++){
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);

            if (i % 3 == 2){
                arrayQueue.dequeue();
                System.out.println(arrayQueue);
            }


        }



    }
}
