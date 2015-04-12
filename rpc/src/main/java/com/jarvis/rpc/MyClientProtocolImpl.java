package com.jarvis.rpc;

import java.io.IOException;

import org.apache.hadoop.ipc.ProtocolSignature;

public class MyClientProtocolImpl implements MyClientProtocol {

	@Override
	public long getProtocolVersion(String protocol, long clientVersion)
			throws IOException {
		return MyClientProtocol.versionID;
	}

	@Override
	public ProtocolSignature getProtocolSignature(String protocol,
			long clientVersion, int clientMethodsHash) throws IOException {
		return new ProtocolSignature(MyClientProtocol.versionID, null);
	}

	public String echo(String str) {
		return str;
	}
}
