package com.jarvis.event;

import java.io.IOException;

import org.apache.hadoop.yarn.conf.YarnConfiguration;

import com.jarvis.event.MyJobEvent.MyJobEventType;
import com.jarvis.event.MyTaskEvent.MyTaskEventType;

public class Main {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		MyDispatchService server = new MyDispatchService("zjx test server");
		YarnConfiguration yarnConf = new YarnConfiguration();

		server.init(yarnConf);
		server.start();
		server.getDispatcher()
				.getEventHandler()
				.handle(new MyJobEvent(MyJobEventType.JOB_START, System
						.currentTimeMillis(), "zjx job"));

		server.getDispatcher()
				.getEventHandler()
				.handle(new MyTaskEvent(MyTaskEventType.T_KILL, System
						.currentTimeMillis(), "zjx task"));
		server.close();
	}
}
