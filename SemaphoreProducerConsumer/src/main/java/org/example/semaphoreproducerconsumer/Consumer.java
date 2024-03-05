package org.example.semaphoreproducerconsumer;

import java.util.logging.Logger;

public class Consumer implements Runnable {

    private final static Logger logger = java.util.logging.Logger.getLogger(Consumer.class.getName());
    private TaskQueue queue;

    public Consumer(TaskQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while(!queue.isEmpty()) {
                Thread.sleep(500);
                var temp = queue.poll();
            }
        } catch (InterruptedException e) {
            logger.info("Consumer interrupted!");
        }
    }
}
