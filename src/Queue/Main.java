package Queue;

import java.util.Random;


public class Main {
    public static double testQueue(Queue<Integer> q , int opCount){
       long start_time = System.nanoTime();
       Random random = new Random();

       for (int i = 0 ; i < opCount ; i ++)
           q.enqueue(random.nextInt(Integer.MAX_VALUE));
       for (int i = 0 ; i < opCount ; i ++)
           q.dequeue();

       long end_time = System.nanoTime();
       return (end_time - start_time) / 1000000000.0;
    }



    public static void main(String[] args) {
        int opCount = 200000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<Integer>();
        double time1 = testQueue(arrayQueue,opCount);

        LoopQueue<Integer> loopQueue = new LoopQueue<Integer>();
        double time2 = testQueue(loopQueue,opCount);

        // 使用循环队列的方式，比使用数组队列的方式，快了几百倍
        System.out.println(time1);
        System.out.println(time2);


    }
}
