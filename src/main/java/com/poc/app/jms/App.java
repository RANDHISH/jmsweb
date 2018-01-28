package com.poc.app.jms;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 * Hello world!
 * 
 */
public class App {

	private JmsTemplate jmsTemplate;
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void sendMessage() {
		MessageCreator messageCreator=new MessageCreator() {
		public Message createMessage(Session session) throws
		JMSException {
		return session.createTextMessage("I am sending Invoice message");}
		};

		jmsTemplate.send("testqueue1", messageCreator);
	}
	
	public void sendAnotherMessage() {
		MessageCreator messageCreator=new MessageCreator() {
		public Message createMessage(Session session) throws
		JMSException {
		return session.createTextMessage("I am sending Invoice message");}
		};

		jmsTemplate.send("testqueue2", messageCreator);
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		App app = (App)context.getBean("jmsInvoiceSender");
		app.sendMessage();
		app.sendAnotherMessage();
		while(true){
		}
	}
}
