package com.jarvis.event;

import org.apache.hadoop.yarn.event.AbstractEvent;

import com.jarvis.event.MyJobEvent.MyJobEventType;

public class MyJobEvent extends AbstractEvent<MyJobEventType> {

	public static enum MyJobEventType {
		JOB_KILL, JOB_INIT, JOB_START
	}

	private final String jobID;

	public MyJobEvent(MyJobEventType type, long timestamp, String jobID) {
		super(type, timestamp);
		this.jobID = jobID;
	}

	public String getJobID() {
		return jobID;
	}

}
