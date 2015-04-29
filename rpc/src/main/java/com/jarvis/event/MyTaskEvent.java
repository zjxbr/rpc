package com.jarvis.event;

import org.apache.hadoop.yarn.event.AbstractEvent;

import com.jarvis.event.MyTaskEvent.MyTaskEventType;

public class MyTaskEvent extends AbstractEvent<MyTaskEventType> {

	public static enum MyTaskEventType {
		T_KILL, T_SCHEDULE
	}

	private final String taskID;

	public MyTaskEvent(MyTaskEventType type, long timestamp, String taskID) {
		super(type, timestamp);
		this.taskID = taskID;
	}

	public String getTaskID() {
		return taskID;
	}

}
