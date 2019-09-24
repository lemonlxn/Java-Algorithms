package LinkedList;


public class LinkListDummy<E>{
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

    private Node dummyhead; // 在索引为0前的一个节点
    private int size;

    public LinkListDummy(){
        dummyhead = new Node(null,null); // 虚拟节点，不赋任何值
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



    // 在链表index位置插入元素(从0开始)
    // 链表中不常用，通常使用链表都不使用索引概念，此处仅作练习使用

    public void add(int index,E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("需 index>= 0 且 index <= size");


        Node prev = dummyhead; // 从dummyhead开始，向后挪动到 index 前一个节点处

        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node node = new Node(e); // next 为null
        node.next = prev.next;
        prev.next = node;

        // 上面三行，可书写为
        // prev.next = new Node(e,prev.next);

        size++;

    }

    // 在链表头部添加元素
    public void addFirst(E e){
        add(0,e);

    }

    // 在链表尾部添加元素
    public void addLast(E e){
        add(size,e);

    }

    // 获得链表的第index(从0开始)个位置的元素
    // 在链表中不是一个常用的操作，仅练习用

    public E get(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("需 index>= 0 且 index < size");

        // 从0开始遍历，遍历到index处
        Node cur = dummyhead.next;

        for (int i = 0 ; i < index ; i ++)
            cur = cur.next;
        return cur.e;

    }

    // 获取链表第一个元素
    public E getFirst(){
        return get(0);
    }

    // 获取链表最后一个元素
    public E getLast(){
        return get(size - 1);
    }

    // 修改第index位置第元素
    // 在链表中不是一个常用的操作，仅练习用

    public void set(int index,E e){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("需 index>= 0 且 index < size");

        Node cur = dummyhead.next;

        for (int i = 0 ; i < index ; i ++)
            cur = cur.next;
        cur.e = e;
    }

    // 查找链表中是否含有某元素
    public boolean contains(E e){

        for (Node cur = dummyhead.next ; cur != null;cur = cur.next){
            if (cur.e.equals(e))
                return true;
        }

        return false;

    }

    // 链表删除操作
    // 仅做练习
    public E remove(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("需 index>= 0 且 index < size");

        Node prev = dummyhead;

        for (int i = 0 ; i < index ; i ++)
            prev = prev.next;

        // indexNode 为index节点
        Node indexNode = prev.next;
        prev.next = indexNode.next; // 让index 前一个节点，绕过index节点，直接指向 index下一个节点

        indexNode.next = null;      // 彻底与当前链表脱离关系
        size --;

        return indexNode.e;
    }

    // 删除头节点
    public E removeFirst(){
        return remove(0);
    }

    // 删除尾节点
    public E removeLast(){
        return remove(size - 1);
    }



    public String toString(){
        StringBuilder str = new StringBuilder();

        Node cur = dummyhead.next;

        while (cur != null){
            str.append(cur.e + "-->"); // 写成 cur + "-->" 也是可以，Node类的 toString 返回的是 cur.e
            cur = cur.next;
        }

        // 上面代码，另外一种写法如下

//        for (Node cur = dummyhead.next;cur != null ; cur = cur.next)
//            str.append(cur.e + "-->");

        str.append("NULL");


        return str.toString();
    }


}