package com.task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerProblemInterviewTask {

    public static final BlockingQueue<String> GLOBAL_QUEUE = new LinkedBlockingQueue<>();
    private static final Integer MAXIMUM_QUEUE_SIZE = 10;

    public static void main(String[] args) {
        TaskProducers producers = new TaskProducers(GLOBAL_QUEUE, MAXIMUM_QUEUE_SIZE, 2);
        producers.startProducing();

        TaskConsumers consumers = new TaskConsumers(GLOBAL_QUEUE, 4);
        consumers.startConsuming();
    }

}

