package com.jarvis.rpc.client;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.mapreduce.protocol.ClientProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jarvis.rpc.ProtocolReciver;
import com.jarvis.rpc.RPCServer;
import com.jarvis.rpc.protobuf.ReportPB.ReportBean;

public class ReportableRPC implements Reportable {

	private static final Logger LOG = LoggerFactory
			.getLogger(ReportableRPC.class);
	private ProtocolReciver protocolReport;

	public ReportableRPC() {
		try {
			protocolReport = RPC.getProxy(ProtocolReciver.class,
					ClientProtocol.versionID, new InetSocketAddress(
							RPCServer.host, RPCServer.port),
					new Configuration());
		} catch (IOException e) {
			LOG.error(ExceptionUtils.getFullStackTrace(e));
		}
	}

	@Override
	public synchronized boolean report(ReportBean msg) {
		return protocolReport.report(msg);
	}

}
