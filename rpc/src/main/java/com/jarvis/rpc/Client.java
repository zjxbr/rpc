package com.jarvis.rpc;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.mapreduce.protocol.ClientProtocol;

public class Client {
	public static void main(String[] args) throws IOException {
		MyClientProtocol clientProtocolImpl = RPC.getProxy(MyClientProtocol.class,
				ClientProtocol.versionID, new InetSocketAddress(RPCServer.host,
						RPCServer.port), new Configuration());
//		clientProtocol
		String getVal = clientProtocolImpl.echo("123");
		System.out.println(getVal);
	}
}
