package ArrayStack_;

public interface Stack<E> {
    // 栈的基本方法
    int getsize();
    boolean isEmpty();

    void push(E e);
    E pop();
    E peek();

}
