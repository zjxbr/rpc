package com.jarvis.yarnapp;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.yarn.api.ApplicationClientProtocol;
import org.apache.hadoop.yarn.api.protocolrecords.GetNewApplicationRequest;
import org.apache.hadoop.yarn.api.protocolrecords.GetNewApplicationResponse;
import org.apache.hadoop.yarn.api.records.ApplicationSubmissionContext;
import org.apache.hadoop.yarn.api.records.ContainerLaunchContext;
import org.apache.hadoop.yarn.conf.YarnConfiguration;
import org.apache.hadoop.yarn.exceptions.YarnException;
import org.apache.hadoop.yarn.ipc.YarnRPC;
import org.apache.hadoop.yarn.util.Records;

public class ZJXClient {

	private final Configuration conf;
	private final InetSocketAddress rmAddress;
	private final YarnRPC rpc;

	public ZJXClient() {
		conf = new Configuration();
		// get resouce manager address
		rmAddress = conf.getSocketAddr(YarnConfiguration.RM_ADDRESS,
				YarnConfiguration.DEFAULT_RM_ADDRESS,
				YarnConfiguration.DEFAULT_RM_PORT);
		// get Yarn RPC
		rpc = YarnRPC.create(conf);
	}

	/**
	 * get a new app response from YARN
	 * 
	 * @return
	 * @throws YarnException
	 * @throws IOException
	 */
	public GetNewApplicationResponse getNewApp() throws YarnException,
			IOException {

		// get a request for communicate with yarn
		GetNewApplicationRequest request = Records
				.newRecord(GetNewApplicationRequest.class);

		// get a proxy from yarn rpc, yarn rpc is a factory, can produce some
		// protocol
		ApplicationClientProtocol rmClientProtocol = (ApplicationClientProtocol) (rpc
				.getProxy(ApplicationClientProtocol.class, rmAddress, conf));
		// get response from yarn rpc proxy with sending the
		// GetNewApplicationRequest
		// which contains a protobuf object.
		GetNewApplicationResponse newApp = rmClientProtocol
				.getNewApplication(request);

		System.err.println("get a new application id:"
				+ newApp.getApplicationId());
		return newApp;
	}

	public void submitApp(GetNewApplicationResponse newApp)
			throws YarnException, IOException {
		ApplicationSubmissionContext context = Records
				.newRecord(ApplicationSubmissionContext.class);
		context.setApplicationName("zjx test application");
		
		ContainerLaunchContext amContainer = Records.newRecord(ContainerLaunchContext.class);
		
//		amContainer.setLocalResources(localResources);
		
		context.setApplicationId(newApp.getApplicationId());
	}

	public static void main(String[] args) throws YarnException, IOException {
		ZJXClient zjxClient = new ZJXClient();
		GetNewApplicationResponse newApp = zjxClient.getNewApp();
	}
}
