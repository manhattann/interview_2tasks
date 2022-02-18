package com.task2;

import java.util.concurrent.BlockingQueue;

/**
 * Creates thread pool of N consumers, polling queue, must use blocking queue to work properly
 * //TODO passing task to consume as lambda
 */
public class TaskConsumer extends Thread {

    private final BlockingQueue<String> queue;

    TaskConsumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        boolean isAlive = true;
        while (isAlive) {
            try {
                String taskToProcess = queue.poll();
                if (taskToProcess != null) {
                    // TODO process task somehow
                    double formulaResult = StringFormulaUtils.solveFormula(taskToProcess);
                    System.out.println("Result of task: " + taskToProcess + " = " + formulaResult);
                }

            } catch (Exception e) {
                isAlive = false;
//                log.error("Consumer exception", e);
            }
        }
    }

}