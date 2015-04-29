package com.jarvis.event;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.service.CompositeService;
import org.apache.hadoop.service.Service;
import org.apache.hadoop.yarn.event.AsyncDispatcher;
import org.apache.hadoop.yarn.event.Dispatcher;

import com.jarvis.event.MyJobEvent.MyJobEventType;
import com.jarvis.event.MyTaskEvent.MyTaskEventType;

public class MyDispatchService extends CompositeService {
	private Dispatcher dispatcher;

	public MyDispatchService(String name) {
		super(name);

	}

	@Override
	public void serviceInit(Configuration conf) throws Exception {
		dispatcher = new AsyncDispatcher();

		dispatcher.register(MyJobEventType.class, new MyJobEventHandler());
		dispatcher.register(MyTaskEventType.class, new MyTaskEventHandler());
		addService((Service) dispatcher);
		super.serviceInit(conf);
	}

	public Dispatcher getDispatcher() {
		return dispatcher;
	}
}
