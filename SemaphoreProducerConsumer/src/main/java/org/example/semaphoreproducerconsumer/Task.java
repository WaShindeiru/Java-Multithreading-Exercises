package org.example.semaphoreproducerconsumer;

public class Task {
    private int number;
    private String name;

    public Task(int number) {
        this(number, "example");
    }

    public Task(int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Task: " + number + ", name: " + name + "\n";
    }
}
