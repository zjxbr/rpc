package com.jarvis.event;

import org.apache.hadoop.yarn.event.EventHandler;

public class MyJobEventHandler implements EventHandler<MyJobEvent> {

	@Override
	public void handle(MyJobEvent event) {
		System.err.println("handling job event : " + event.getJobID());
	}

}
