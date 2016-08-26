package com.yy.finance.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import com.yy.finance.thrift.Hello;

public class HelloServiceClient {
	public static void main(String[] args) {
		TTransport transport = new TSocket("127.0.0.1",7911);
		try {
			transport.open();//connect to server
			TProtocol protocol = new TBinaryProtocol(transport);// select a transport protocal
			Hello.Client client = new Hello.Client(protocol);// create a client
			client.helloVoid();//invoke a method
			transport.close();//close the connection
		} catch (TTransportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
