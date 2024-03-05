package org.example.semaphoreproducerconsumer;

import java.util.logging.Logger;

public class Producer implements Runnable {

    private final static Logger logger = Logger.getLogger(Producer.class.getName());
    private TaskQueue queue;

    public Producer(TaskQueue queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            try {
                queue.offer(new Task(i));
            } catch (InterruptedException swallow) {
                logger.info("Interrupted");
            }
        }
    }
}
