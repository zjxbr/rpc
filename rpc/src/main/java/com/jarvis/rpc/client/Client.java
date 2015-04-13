package com.jarvis.rpc.client;

import java.io.IOException;

public class Client {
	public static void main(String[] args) throws IOException {
		// ProtocolReport clientProtocolImpl = RPC.getProxy(
		// ProtocolReport.class, ClientProtocol.versionID,
		// new InetSocketAddress(RPCServer.host, RPCServer.port),
		// new Configuration());
		// // clientProtocol
		// String getVal = clientProtocolImpl.echo("123");
		// System.out.println(getVal);

		Reportable reportable = new ReportableRPC();

		System.err.println("report success : " + reportable.report("hello"));
	}
}
