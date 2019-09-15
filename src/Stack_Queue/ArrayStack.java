package Stack_Queue;

import Arrays.ArrayE;

public class ArrayStack<E> implements Stack<E>{
    private ArrayE<E> array;

    public ArrayStack(int capacity){
        array = new ArrayE<>(capacity);
    }

    public ArrayStack(){
        array = new ArrayE<>();
    }

    @Override
    public int getsize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    public int getCapacity(){
        return array.getCapacity();
    }


    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Stack:[");

        for (int i = 0 ; i < array.getSize(); i ++){
            str.append(array.get(i));

            if (i != array.getSize() - 1)
                str.append(",");
            str.append("] top");
        }

        return str.toString();
    }
}
