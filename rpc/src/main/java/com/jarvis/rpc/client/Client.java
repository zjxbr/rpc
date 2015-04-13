package com.jarvis.rpc.client;

import java.io.IOException;

import com.jarvis.rpc.protobuf.ReportPB.ReportBean;

public class Client {
	public static void main(String[] args) throws IOException {
		Reportable reportable = new ReportableRPC();
		ReportBean reportBean = ReportBean.newBuilder().setTaskId("taskId")
				.setMessage("msg").setReportTime(System.currentTimeMillis())
				.setStatus(1).build();
		System.err.println("report success : " + reportable.report(reportBean));
	}
}
