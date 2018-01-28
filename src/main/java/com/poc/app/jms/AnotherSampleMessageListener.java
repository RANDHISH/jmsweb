package com.poc.app.jms;

import javax.jms.Message;
import javax.jms.MessageListener;

public class AnotherSampleMessageListener implements MessageListener {


	public void onMessage(Message arg0) {

		System.out.println("In the other message listener");

	}

}
