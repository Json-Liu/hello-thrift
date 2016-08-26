package com.yy.finance.service;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

import com.yy.finance.service.impl.HelloServiceImpl;
import com.yy.finance.thrift.Hello;

/**
 *  Thrift server
 * @author liuzhian
 *
 */
public class HelloServiceServe {
	private static final int SERVER_PORT = 7911;
	public static void main(String[] args) {
		try {
			// set the server port
			TServerSocket serverTransPort = new TServerSocket(SERVER_PORT);
			//set server protocol
			Factory proFactory = new TBinaryProtocol.Factory();
			//relate controller to server
			TProcessor processor = new Hello.Processor(new HelloServiceImpl());
			TServer.Args tArgs = new TServer.Args(serverTransPort);
			tArgs.processor(processor);
			tArgs.protocolFactory(proFactory);
			TServer server = new TSimpleServer(tArgs);
			System.out.println("Start server on port 7911...");
			server.serve();
		} catch (TTransportException e) {
			e.printStackTrace();
		}
	}
}
