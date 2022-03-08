package com.gimslab.tmp;

public class Job implements Runnable {
	private String jobName;
	private JobPriority jobPriority;

	public Job(String jobName, JobPriority jobPriority) {
		this.jobName = jobName;
		this.jobPriority = jobPriority;
	}

	@Override
	public void run() {
		System.out.println("Job:" + jobName +
				" Priority:" + jobPriority);
		try {
			Thread.sleep(1000); // to simulate actual execution time
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public JobPriority getJobPriority() {
		return jobPriority;
	}

	public void setJobPriority(JobPriority jobPriority) {
		this.jobPriority = jobPriority;
	}
}