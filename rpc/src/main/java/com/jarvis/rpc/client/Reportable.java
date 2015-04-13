package com.jarvis.rpc.client;

import com.jarvis.rpc.protobuf.ReportPB.ReportBean;

public interface Reportable {
	public boolean report(ReportBean msg);
}
