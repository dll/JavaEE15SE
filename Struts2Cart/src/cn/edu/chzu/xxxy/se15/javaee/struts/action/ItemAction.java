package cn.edu.chzu.xxxy.se15.javaee.struts.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.edu.chzu.xxxy.se15.javaee.struts.bean.ItemBean;
import cn.edu.chzu.xxxy.se15.javaee.struts.bean.ShoppingCartBean;
import cn.edu.chzu.xxxy.se15.javaee.struts.bean.UserBean;
import cn.edu.chzu.xxxy.se15.javaee.struts.service.ItemService;
import cn.edu.chzu.xxxy.se15.javaee.struts.service.UserService;
/**
 * 获取商品信息调用逻辑
 * 
 * */
public class ItemAction extends ActionSupport implements ModelDriven<ItemBean> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ItemBean> items;
	private Map<String, Object> request,session,application;
	public List<ItemBean> getItems() {
		return items;
	}

	public void setItems(List<ItemBean> items) {
		this.items = items;
	}
	
	public String getAllItems() {
		ItemService itemServ = new ItemService();
		items=itemServ.getAllItems();
		return "success";
	}
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		//获取ActionContext对象
		ActionContext ctx= ActionContext.getContext();
		//通过ActionContext对象获取请求、会话和上下文对象相关联的Map对象
		request=(Map<String, Object>) ctx.get("request");
		session=(Map<String, Object>) ctx.getSession();
		application=(Map<String, Object>) ctx.getApplication();
		//访问application范围的属性值:计数
		Integer counter = (Integer)application.get("counter");
		if(counter==null) counter=1;
		else counter=counter+1;
		//设置application范围的属性
		application.put("counter", counter);

		this.addActionMessage(this.getText("visitor.success"));

		session.put("items", new ItemBean());
		request.put("tip", "欢迎您访问本站！");
		
		return "none";
	}
	
	/**
	 * 新增商品，图片上传和下载
	 * */
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String newItem() throws Exception
	{
		//获取ActionContext对象
		ActionContext ctx = ActionContext.getContext();
		//通过ActionContext对象获取请求相关联的Map对象
		request=(Map<String, Object>) ctx.get("request");
		
		//将上传的文件保存至项目WebContent目录下的images文件夹下。
		String realpath = ServletActionContext.getServletContext().getRealPath("/images");

		if(upload!=null)
		{
			File saveDir = new File(realpath);
			if(!saveDir.exists())
				saveDir.mkdirs();
			//创建保存的文件
			File saveFile = new File(saveDir,uploadFileName);
			//使用commons-io组件的FileUtils上传文件
			try {
				FileUtils.copyFile(upload,saveFile);
				
				item.setImage("images/"+uploadFileName);//保存到Image字段中,表单没有值
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		ctx.put("message", "上传成功！");
		///////////////////////////////////////////
		ItemService itemServ=new ItemService();
		if(itemServ.register(item)){
			this.addActionMessage(this.getText("newItem.success"));
			request.put("tip", "新增商品成功！");
			return "success";
		}
		else{
			this.addActionMessage(this.getText("newItem.fail"));
			request.put("tip", "新增商品失败！");
			return "fail";
		}
	}
	
	public ItemBean getItem() {
		return item;
	}

	public void setItem(ItemBean item) {
		this.item = item;
	}

	private ItemBean item=new ItemBean();

	@Override
	public ItemBean getModel() {
		return this.item;
	}
}
