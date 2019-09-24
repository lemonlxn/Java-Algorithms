package LinkedList;

import ArrayStack_.Stack;

public class LinkListStack <E> implements Stack<E> {
    private LinkListDummy<E> list;

    public LinkListStack(){
        list = new LinkListDummy<>();
    }

    @Override
    public int getsize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Stack:top ");
        str.append(list);
        return str.toString();
    }
}
