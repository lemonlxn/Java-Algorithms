package LinkedList;


public class LinkList<E>{
    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;       // 当前Node存储的数据
            this.next = next; // 指向下一个Node对象
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }

    }

    private Node head;
    private int size;

    public LinkList(){
        head = null; // 初始化数据为null
        size = 0;
    }

    // 获取链表中的元素个数
    public int getSize(){
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 在链表头部添加元素
    public void addFirst(E e){
        Node node = new Node(e); // 创建新节点，并传入元素e
        node.next = head;        // 让node的next，指向head
        head = node;             // 最后更新head，让head指向node，使node成为头节点

        // 上述三行代码这么写也可以
        // 解释为：创建一个新的Node，赋值为e，让Node的next指向head，最后更新head指向，让该Node成为头节点
        // head = new Node(e,head);

        size ++;

    }

    // 在链表index位置插入元素(从0开始)
    // 链表中不常用，通常使用链表都不使用索引概念，此处仅作练习使用

    public void add(int index,E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("需 index>= 0 且 index < size");

        if (index == 0)
            addFirst(e);
        else {
            Node prev = head; // 从head开始，向后挪动到 index 前一个节点处

                for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }

            Node node = new Node(e);
            node.next = prev.next;
            prev.next = node;

            size++;
        }


    }

}