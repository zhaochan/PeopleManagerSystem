package web.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.junit.Test;

import com.levilee.store.entity.Products;
import com.levilee.store.entity.Userinfo;
import com.levilee.stroe.service.ProductsService;
import com.levilee.stroe.service.UserinfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * @author ZhaoChangKui
 *
 */
public class ProductAction extends ActionSupport implements ModelDriven<Products> {
	private Products model = new Products();
	private ProductsService productserver = new ProductsService();
	private List<String> resumeContentType;// 上传文件的类型
	private List<String> resumeFileName;// 上传文件的名称
	private List<File> resume;// 上传文件的内容，调用set方法赋值！

	public void setResumeContentType(List<String> resumeContentType) {
		this.resumeContentType = resumeContentType;
	}

	public void setResumeFileName(List<String> resumeFileName) {
		this.resumeFileName = resumeFileName;
	}

	public void setResume(List<File> resume) {
		this.resume = resume;
	}
	@Override
	public Products getModel() {
		return model;
	}
		/**
		 * 返回一个不重复的字符串
		 * @return
		 */
		public static String uuid() {
			return UUID.randomUUID().toString().replace("-", "").toUpperCase();
		}

	public String Upload() throws IOException{//发布商品。上传商品内容
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(resume!=null){
		for(int i = 0; i < resume.size(); i++) {
			File srcFile = resume.get(i);//获取一个文件	
			String saveDir = ServletActionContext.getServletContext().getRealPath("/photos");
			String savename = uuid() + "_" + resumeFileName.get(i);
			File destFile = new File(saveDir, savename);
			// 保存之
			FileUtils.copyFile(srcFile, destFile);
			if(i==0)
			model.setPhoto1("photos/"+savename);
			if(i==1)
				model.setPhoto2("photos/"+savename);
			
		}
		}
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		model.setReleasedate(date);
		model.setUsername((String)session.getAttribute("username"));
		productserver.add(model);
		
		return "upload";
	}
	
	public String FindByType(){
		String category = model.getCategory();		
		List<Products> list = productserver.getByCategory(category);
		ActionContext.getContext().getValueStack().push(list);
		List<Products> productlist = productserver.getAll();
		ServletActionContext.getRequest().getSession().setAttribute("productlist", productlist);
		return "find";
	}
	
	
	public String FindByProductid(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		int productid = model.getProductid();
		List<Products>  product = productserver.getByProductid(productid);
		ActionContext.getContext().getValueStack().push(product.get(0));
		UserinfoService userinfoservice = new UserinfoService();
		Userinfo userinfo = userinfoservice.getByUsername(product.get(0).getUsername());
		session.setAttribute("userinfomation", userinfo);
		session.setAttribute("reusername", userinfo.getUsername());
		return "findbyproductid";
	}
	
public String FindGoodsM(){//查找商品
	List<Products> list = new ArrayList();
	list=productserver.getAll();
	ActionContext.getContext().getValueStack().push(list);
	return "findgoodsm";
}
	
	
	
	@Test
	public void test(){
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(uuid()); 
		Date date = new Date();
		System.out.println(simple.format(date));
	}
}
