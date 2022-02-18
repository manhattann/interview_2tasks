package com.task2;

import java.util.Queue;

public class TaskProducer extends Thread {

    public static final Object lock1 = new Object();

    private final Integer pollingIntervalWhenWaiting;
    private final Queue<String> queue;
    private final Integer producingLimit;

    TaskProducer(Queue<String> queue, Integer producingLimit, Integer pollingIntervalWhenWaiting) {
        this.queue = queue;
        this.producingLimit = producingLimit;
        this.pollingIntervalWhenWaiting = pollingIntervalWhenWaiting;
    }

    public boolean addTask() {
        synchronized (lock1) {
            if (queue.size() < producingLimit) {
                String newTask = StringFormulaUtils.generateTask();
                queue.add(newTask);
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public void run() {
        boolean isAlive = true;
        while (isAlive) {
            try {
                boolean couldAddTask = addTask();
                if (!couldAddTask) {
                    pollForFreeQueue();
                }

            } catch (Exception e) {
                isAlive = false;
            }
        }

    }

    private void pollForFreeQueue() throws InterruptedException {
        boolean isAlive = true;
        while (isAlive) {
            if (queue.size() <= (producingLimit / 2)) {
                isAlive = false;
            }
            Thread.sleep(pollingIntervalWhenWaiting);
        }
    }

}
