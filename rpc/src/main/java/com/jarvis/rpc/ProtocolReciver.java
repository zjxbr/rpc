package com.jarvis.rpc;

import org.apache.hadoop.ipc.VersionedProtocol;

import com.jarvis.rpc.protobuf.ReportPB.ReportBean;

public interface ProtocolReciver extends VersionedProtocol {
	public static final long versionID = 137L;

	public boolean report(ReportBean msg);

}
