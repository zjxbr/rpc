package com.jarvis.state;

import org.apache.hadoop.yarn.event.AbstractEvent;

import com.jarvis.event.MyJobEvent.MyJobEventType;

public class ZJXJobEvent extends AbstractEvent<MyJobEventType> {

	private final String jobID;

	public ZJXJobEvent(MyJobEventType type, long timestamp, String jobID) {
		super(type, timestamp);
		this.jobID = jobID;
	}

	public String getJobID() {
		return jobID;
	}

}
