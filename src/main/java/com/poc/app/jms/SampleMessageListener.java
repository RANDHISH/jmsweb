package com.poc.app.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class SampleMessageListener implements MessageListener {

	public void onMessage(Message message) {

		try {
			System.out.println(((TextMessage) message).getText());
			System.out.println("Hello");
		} catch (JMSException ex) {
			throw new RuntimeException(ex);
		}
	}

}
