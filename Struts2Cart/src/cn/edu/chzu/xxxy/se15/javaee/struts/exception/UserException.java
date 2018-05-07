package cn.edu.chzu.xxxy.se15.javaee.struts.exception;
/**
 * 自定义异常处理机制，值得深入研究：控制所有...
 * */
@SuppressWarnings("serial")
public class UserException extends Exception {
	public UserException() {
		super();
	}

	public UserException(String msg) {
		super(msg);
	}

	public UserException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public UserException(Throwable cause) {
		super(cause);
	}
}
