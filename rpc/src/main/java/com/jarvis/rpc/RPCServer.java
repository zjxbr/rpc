package com.jarvis.rpc;

import java.io.IOException;

import org.apache.hadoop.HadoopIllegalArgumentException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.Server;

public class RPCServer {
	public static final String host = "localhost";
	public static final int port = 10388;

	public static void main(String[] args)
			throws HadoopIllegalArgumentException, IOException {
		Server server = new RPC.Builder(new Configuration())
				.setProtocol(ProtocolReciver.class)
				.setInstance(new ProtocolReciverImpl()).setBindAddress(host)
				.setPort(port).setNumHandlers(5).build();
		server.start();
	}
}
