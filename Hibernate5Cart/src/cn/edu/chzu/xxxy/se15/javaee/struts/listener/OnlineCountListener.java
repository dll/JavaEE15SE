package cn.edu.chzu.xxxy.se15.javaee.struts.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import cn.edu.chzu.xxxy.se15.javaee.struts.service.OnlineCounter;


/**
 * Application Lifecycle Listener implementation class OnlineCountListener
 *
 */
@WebListener
public class OnlineCountListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public OnlineCountListener() {
        // TODO Auto-generated constructor stub
    }

    /**
     * ʵ��sessionCreated()������������1
     */
    public void sessionCreated(HttpSessionEvent e) {
       OnlineCounter.addCounter();
    }
    /**
     * ʵ��sessionDestroyed()������������1
     */
    public void sessionDestroyed(HttpSessionEvent e) {
       OnlineCounter.reduceCounter();
    }		
}
