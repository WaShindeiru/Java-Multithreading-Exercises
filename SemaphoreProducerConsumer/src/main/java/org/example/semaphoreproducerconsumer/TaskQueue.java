package org.example.semaphoreproducerconsumer;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class TaskQueue {

    private int capacity;
    public Semaphore empty;
    public Semaphore full;
    public ReentrantLock lock;
    public Queue<Task> tasks;

    public boolean isEmpty() {
        return tasks.isEmpty();
    }


    public TaskQueue(int capacity) {
        this.capacity = capacity;
        empty = new Semaphore(0);
        full = new Semaphore(capacity);
        lock = new ReentrantLock();
        tasks = new ArrayDeque<>();
    }

    public void offer(Task task) throws InterruptedException {
        full.acquire();
        lock.lock();
        tasks.offer(task);
        System.out.println("Added new Task: " + task.toString());
        System.out.println("Full: " + full.availablePermits() + " Empty: " + (empty.availablePermits() + 1));
        empty.release();
        lock.unlock();
    }

    public Task poll() throws InterruptedException {
        Task task;
        empty.acquire();
        lock.lock();
        task = tasks.poll();
        System.out.println("Consumed a task " + task.toString());
        System.out.println("Full: " + (full.availablePermits() + 1) + " Empty: " + empty.availablePermits());
        full.release();
        lock.unlock();

        return task;
    }
}
