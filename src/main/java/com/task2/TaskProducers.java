package com.task2;

import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * Creates thread pool of N producers, producing certain task, can use queue of any kind
 * Producers can produce tasks up to certain threshold, which is passed in constructor
 * After threshold limit is exceeded, periodically polls queue to check if it's half full(poll interval is param)
 * given queue is half full, then starts producing again
 * //TODO passing task to do as lambda
 */
public class TaskProducers {

    private static final Integer pollingIntervalWhenWaiting = 100;
    private final Queue<String> queue;
    private final Integer maximumQueueSize;
    private final Integer numberOfProducers;
    private final ExecutorService threadPool;

    public TaskProducers(Queue<String> queue) {
        this(queue, 10, 2);
    }

    public TaskProducers(Queue<String> queue, Integer maximumQueueSize, Integer numberOfProducers) {
        this.queue = queue;
        this.maximumQueueSize = maximumQueueSize;
        this.numberOfProducers = numberOfProducers;
        this.threadPool = Executors.newFixedThreadPool(numberOfProducers);
    }

    public void startProducing() {
        IntStream.range(0, numberOfProducers).forEach(i -> {
            threadPool.execute(new TaskProducer(queue, maximumQueueSize, pollingIntervalWhenWaiting));
        });
    }

    public void stopProducing() {
        threadPool.shutdown();
    }

}
