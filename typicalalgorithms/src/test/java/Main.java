/*
 * Copyright (c) 2018.
 *
 * Create by StevenWash (huaxin)
 */

import sun.jvm.hotspot.utilities.BitMap;

import javax.print.attribute.HashPrintServiceAttributeSet;
import java.nio.Buffer;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description:
 * kk
 *
 * @author huaxin
 * @create 2018/03/21 18:00
 */
public class Main {

    public static void main(String[] args) {
//        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
//
//        Consumer consumer = new Consumer(queue);
//        Producer producer = new Producer(queue);
//
//        producer.start();
//        consumer.start();

        BitSet set = new BitSet();
        set.set(1,true);
        set.set(5,true);

        for(int i=0;i<set.size();i++){

            boolean b = set.get(i);


                System.out.println(b);



        }
    }
}


class Consumer extends Thread {
    private ArrayBlockingQueue<Integer> queue;
    public Consumer(ArrayBlockingQueue<Integer> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        while(true) {
            try {
                Integer i = queue.take();
                System.out.println("消费者从队列取出元素:" + i);
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread {
    private ArrayBlockingQueue<Integer> queue;
    public Producer(ArrayBlockingQueue<Integer> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                queue.put(i);
                System.out.println("生产者向队列插入元素:" + i);
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
