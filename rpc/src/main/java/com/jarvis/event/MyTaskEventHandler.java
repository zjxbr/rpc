package com.jarvis.event;

import org.apache.hadoop.yarn.event.EventHandler;

public class MyTaskEventHandler implements EventHandler<MyTaskEvent> {

	@Override
	public void handle(MyTaskEvent event) {
		System.err.println("handling task : " + event.getTaskID());
	}

}
