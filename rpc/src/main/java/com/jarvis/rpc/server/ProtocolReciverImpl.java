package com.jarvis.rpc.server;

import java.io.IOException;

import org.apache.hadoop.ipc.ProtocolSignature;

import com.jarvis.rpc.protobuf.ReportPB.ReportBean;

public class ProtocolReciverImpl implements ProtocolReciver {

	@Override
	public long getProtocolVersion(String protocol, long clientVersion)
			throws IOException {
		return ProtocolReciver.versionID;

	}

	@Override
	public ProtocolSignature getProtocolSignature(String protocol,
			long clientVersion, int clientMethodsHash) throws IOException {
		return new ProtocolSignature(ProtocolReciver.versionID,
				new int[] { clientMethodsHash });
	}

	@Override
	public boolean report(ReportBean msg) {
		System.err.println(msg);
		return true;
	}
}
