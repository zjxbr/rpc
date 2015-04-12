package com.jarvis.rpc;

import org.apache.hadoop.ipc.VersionedProtocol;

public interface MyClientProtocol extends VersionedProtocol{
	
	public static final long versionID = 137L;
	
	public String echo(String str);
}
