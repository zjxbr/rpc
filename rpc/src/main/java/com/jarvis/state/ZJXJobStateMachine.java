package com.jarvis.state;

import org.apache.hadoop.mapreduce.v2.app.job.JobStateInternal;
import org.apache.hadoop.mapreduce.v2.app.job.event.JobEvent;
import org.apache.hadoop.mapreduce.v2.app.job.event.JobEventType;
import org.apache.hadoop.yarn.event.EventHandler;
import org.apache.hadoop.yarn.state.SingleArcTransition;
import org.apache.hadoop.yarn.state.StateMachineFactory;

public class ZJXJobStateMachine implements EventHandler<ZJXJobEvent> {

//	protected static final StateMachineFactory<ZJXJobStateMachine, JobStateInternal, JobEventType, JobEvent> stateMachineFactory = new StateMachineFactory<ZJXJobStateMachine, JobStateInternal, JobEventType, JobEvent>(
//			JobStateInternal.NEW).add;
//
//	public static class InitTransition implements
//			SingleArcTransition<ZJXJobStateMachine, ZJXJobEvent> {
//
//		@Override
//		public void transition(ZJXJobStateMachine operand, ZJXJobEvent event) {
//			// TODO Auto-generated method stub
//
//		}
//
//	}

	@Override
	public void handle(ZJXJobEvent event) {
		System.err.println("hahaha event");
	}

}
