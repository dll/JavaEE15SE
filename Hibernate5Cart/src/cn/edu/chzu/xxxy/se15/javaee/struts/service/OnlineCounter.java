package cn.edu.chzu.xxxy.se15.javaee.struts.service;

public class OnlineCounter {
	
		private static long onlineCounter = 0;
		//������1
		public static void addCounter()
		{
			onlineCounter++;
		}
		//������1
		public static void reduceCounter()
		{
			 onlineCounter--;
		}
		//��������
		public static long getCounter()
		{
			return onlineCounter;
		}

}
