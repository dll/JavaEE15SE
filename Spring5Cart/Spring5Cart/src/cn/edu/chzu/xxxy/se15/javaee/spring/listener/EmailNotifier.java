package cn.edu.chzu.xxxy.se15.javaee.spring.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import cn.edu.chzu.xxxy.se15.javaee.spring.event.EmailEvent;

public class EmailNotifier implements ApplicationListener{
	public void onApplicationEvent(ApplicationEvent evt){
		if(evt instanceof EmailEvent){
			EmailEvent emailEvent = (EmailEvent)evt;
			System.out.println("��Ҫ�����ʼ��Ľ��յ�ַ " + emailEvent.getAddress());
			System.out.println("��Ҫ�����ʼ����ʼ����� " + emailEvent.getText());
		}
		else{
			System.out.println("����������¼� " + evt);
		}
	}

}
