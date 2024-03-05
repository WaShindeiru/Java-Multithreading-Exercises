package org.example.semaphoreproducerconsumer;

import java.util.ArrayList;
import java.util.List;

public class SemaphoreProducerConsumerApplication {

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 10;
        TaskQueue taskQueue = new TaskQueue(threadCount);

        List<Thread> threads = new ArrayList<>();
        threads.add(new Thread(new Producer(taskQueue)));

        for(int i=0; i<threadCount; i++) {
            threads.add(new Thread(new Consumer(taskQueue)));
        }

        for(var thread: threads) {
            thread.start();
        }
    }

}
