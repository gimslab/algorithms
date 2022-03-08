package com.gimslab.tmp;

import org.junit.Test;

public class MainTest {
	private static int POOL_SIZE = 1;
	private static int QUEUE_SIZE = 10;

	@Test
	public void whenMultiplePriorityJobsQueued_thenHighestPriorityJobIsPicked() throws InterruptedException {
		Job job1 = new Job("Job1", JobPriority.LOW);
		Job job2 = new Job("Job2", JobPriority.MEDIUM);
		Job job3 = new Job("Job3", JobPriority.HIGH);
		Job job4 = new Job("Job4", JobPriority.MEDIUM);
		Job job5 = new Job("Job5", JobPriority.LOW);
		Job job6 = new Job("Job6", JobPriority.HIGH);

		PriorityJobScheduler pjs = new PriorityJobScheduler(
				POOL_SIZE, QUEUE_SIZE);

		pjs.scheduleJob(job1);
		pjs.scheduleJob(job2);
		pjs.scheduleJob(job3);
		pjs.scheduleJob(job4);
		pjs.scheduleJob(job5);
		pjs.scheduleJob(job6);

		// clean up
		Thread.sleep(10000);
	}
}
