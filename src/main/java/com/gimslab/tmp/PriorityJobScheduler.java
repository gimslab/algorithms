package com.gimslab.tmp;

import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityJobScheduler {

	private ExecutorService priorityJobPoolExecutor;
	private ExecutorService priorityJobScheduler
			= Executors.newSingleThreadExecutor();
	private PriorityBlockingQueue<Job> priorityQueue;

	public PriorityJobScheduler(Integer poolSize, Integer queueSize) {
		priorityJobPoolExecutor = Executors.newFixedThreadPool(poolSize);
		priorityQueue = new PriorityBlockingQueue<Job>(
				queueSize,
				Comparator.comparing(Job::getJobPriority));
		priorityJobScheduler.execute(() -> {
			while (true) {
				try {
					priorityJobPoolExecutor.execute(priorityQueue.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
					break;
				}
			}
		});
	}

	public void scheduleJob(Job job) {
		priorityQueue.add(job);
	}
}