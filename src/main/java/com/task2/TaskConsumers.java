package com.task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class TaskConsumers {

    private final BlockingQueue<String> queue;
    private final ExecutorService threadPool;
    private final Integer numberOfConsumers;

    public TaskConsumers(BlockingQueue<String> queue) {
        this(queue, 10);
    }

    public TaskConsumers(BlockingQueue<String> queue, Integer numberOfConsumers) {
        this.queue = queue;
        this.threadPool = Executors.newFixedThreadPool(numberOfConsumers);
        this.numberOfConsumers = numberOfConsumers;
    }

    public void startConsuming() {
        IntStream.range(0, numberOfConsumers).forEach(i -> {
            threadPool.execute(new TaskConsumer(queue));
        });
    }

    public void stopConsuming() {
        threadPool.shutdown();
    }

}
