package Arrays;

public class Array {
    private int[] data;  //data.length 数组长度
    private int size;    // 元素个数


    // 构造函数，接收用户传来的容量
    public Array(int capacity){
        data = new int[capacity];
        size = 0;       // 元素个数默认为0
    }

    // 构造函数，默认容量为10
    public Array(){
        this(10);
    }

    // 获取数组容量
    public int getCapacity(){
        return data.length;
    }

    // 获取数字中的元素个数
    public int getSize(){
        return size;
    }

    // 返回数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 在index位置处，插入一个元素
    // 需考虑的条件如下：
    // 1.索引不能小于0，或索引不能大于size
    // 2.size == data.length，暂定需要2倍扩容
    public void add(int index,int e){

        if (index < 0 || index > size)
            throw new IllegalArgumentException("索引需 >= 0，或索引需 <= size");

        // 添加元素前，看看是否需要扩容
        if (size == data.length)
            resize(data.length * 2);

        // index 后，所有数据向后挪一位

        for (int i = size - 1; i >= index;i--)
            data[i+1] = data[i];

        data[index] = e;
        size ++;

    }

    // 在所有元素前，添加元素
    public void addFirst(int e){
        add(0,e);
    }

    // 在所有元素后，添加元素
    public void addLast(int e){
        add(size,e);
    }

    // 获取索引位置的元素
    public int get(int index){
        if (index < 0 || index >=size )
            throw new IllegalArgumentException("索引需>=0，或 索引 < size");

        return data[index];
    }

    // 获取索引为0的元素
    public int getFirst(){
        return get(0);
    }

    public int getLast(){
        return get(size -1);
    }


    // 修改索引位置的值
    public void set(int index,int e){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("索引需>=0，或 索引 < size");

        data[index] = e ;
    }

    // 查找数组中是否含有元素e
    public boolean contains(int e){
        for (int i = 0 ; i < size ; i ++){
            if (data[i] == e)
                    return true;
        }
        return false;
    }


    // 查找数组中元素对应的索引，若找不到则返回 -1
    public int find(int e){
        for (int i = 0 ; i < size ; i ++){
            if (data[i] == e)
                return i;
        }

        return -1;
    }

    // 从数组中删除 index索引 所在的元素，并返回该删除元素
    // data.length / 2 != 0  (缩容过程，元素个数至少>1)
    public int remove(int index){
        if (index < 0 || index >=size)
            throw new IllegalArgumentException("索引需 >=0，或 索引 < size");

        int result = data[index];

        for (int i = index ; i < size - 1 ; i ++)
            data[i] = data[i + 1];

        size --;

        // 删除元素之后，再考虑缩容
        if (size == data.length / 4 && data.length / 2 != 0 )
            resize(data.length / 2);

        return result;

    }

    // 删除第一个元素，并返回第一个元素
    public int removeFirst(){
        return remove(0);
    }

    // 删除最后一个元素，并返回最后一个元素
    public int removeLast(){
        return remove(size-1);
    }

    // 从数组中删除元素e
    public void removeElement(int e){
        int index = find(e);

        if (index != -1)
            remove(index);
        else
            System.out.println("该元素不存在");
    }



    // 创建一个新数组，将数组元素，逐一添加到新数组中
    // 最后让原数组，指向新数组
    public void resize (int newCapacity){

        int[] newData = new int[newCapacity];

        for (int i = 0 ; i < size ; i ++){
            newData[i] = data[i];
        }

        data = newData;

    }



    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();

        str.append(String.format("数组.Array:size = %d , capacity = %d \n",size,data.length));
        str.append("[");

        for (int i = 0; i < size ; i ++){
            str.append(data[i]);

            if (i != size - 1)
                str.append(",");
        }

        str.append("]");
        return str.toString();
    }



}
