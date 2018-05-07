package cn.edu.chzu.xxxy.se15.javaee.struts.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import cn.edu.chzu.xxxy.se15.javaee.struts.action.ItemAction;

public class InitDatasListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		new ItemAction().getAllItems();
	}

}
