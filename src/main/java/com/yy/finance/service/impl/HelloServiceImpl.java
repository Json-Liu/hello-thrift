package com.yy.finance.service.impl;
import org.apache.thrift.TException;

import com.yy.finance.thrift.*;
public class HelloServiceImpl implements Hello.Iface{

	@Override
	public String helloString(String param) throws TException {
		return param;
	}

	@Override
	public int helloInt(int param) throws TException {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return param;
	}

	@Override
	public boolean helloBoolean(boolean param) throws TException {
		return param;
	}

	@Override
	public void helloVoid() throws TException {
		System.out.println("Hello , My name is josonLiu");
	}

	@Override
	public String helloNull() throws TException {
		return null;
	}

}
