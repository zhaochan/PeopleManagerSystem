package web.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.levilee.store.entity.Account;
import com.levilee.store.entity.Products;
import com.levilee.store.entity.Userinfo;
import com.levilee.store.util.Des5Util;
import com.levilee.stroe.service.AccountService;
import com.levilee.stroe.service.ProductsService;
import com.levilee.stroe.service.UserinfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserinfoAction extends ActionSupport implements ModelDriven<Userinfo> {
	private AccountService service = new AccountService();
	private UserinfoService infoservice = new UserinfoService();
	private Userinfo model = new Userinfo();
	 private String vcode;
		public String getVcode() {
			return vcode;
		}
		public void setVcode(String vcode) {
			this.vcode = vcode;
		}



	@Override
	public Userinfo getModel() {
		return model;
	}
	
	
	
	public String Register() throws Exception{//注册账号信息
		HttpSession session = ServletActionContext.getRequest().getSession();
		String text = (String) session.getAttribute("code");
		if(text.equalsIgnoreCase(getVcode())){		
		service.register(model.getUsername(), Des5Util.encrypt(model.getPassword(), "A1B2C3D4E5F6G7H8I9K0"));
		infoservice.add(model.getUsername(), model.getSex(),model.getEmail(), model.getPhonenumber() ,model.getAddress());
		return "register";
		}
		this.addActionError("验证码错误！");
		return "fail";
	}

	
	public String Find() throws Exception{
		HttpSession session = ServletActionContext.getRequest().getSession();
		String username = (String) session.getAttribute("username");
		Userinfo userinfo = infoservice.getByUsername(username);//得到用户信息
		AccountService accountService = new AccountService();
		Account account = accountService.getAccount(username);//得到密码
		String password = Des5Util.decrypt(account.getPassword(), "A1B2C3D4E5F6G7H8I9K0");
		ProductsService productservice = new ProductsService();
		List<Products> productList = productservice.getByUsername(username);//得到用户发布的商品
		session.setAttribute("password", password);
		session.setAttribute("userinfo", userinfo);
		ActionContext.getContext().getValueStack().push(productList);
		return "find";
	}

 public String Revamp() throws Exception{
	 Account account = new Account();
	 account.setPassword(Des5Util.encrypt(model.getPassword(), "A1B2C3D4E5F6G7H8I9K0"));
	 account.setUsername(model.getUsername());
	 service.update(account);
	 model.setRegdate(new Date());
	 infoservice.update(model);
	 return "revamp";
 }
 
 public String FindAllM(){//查询所有的用户
	 Account account = new Account();
	 List<Account> list = service.getAccounts();
	 List<Userinfo> listinfo = new ArrayList<>();
	 
	 for(Account acc:list){
		Userinfo user = infoservice.getByUsername(acc.getUsername());
		user.setPassword(acc.getPassword());
		listinfo.add(user);
	 }
	 
	 ActionContext.getContext().getValueStack().push(listinfo);
	 return "findallm";
 }
 
 public String FindByNameM() throws IOException, Exception{
	 String username = model.getUsername();
	 Account account = service.getAccount(username);
	 Userinfo userinfo = infoservice.getByUsername(username);
	 userinfo.setPassword(Des5Util.decrypt(account.getPassword(),"A1B2C3D4E5F6G7H8I9K0"));
	 ActionContext.getContext().getValueStack().push(userinfo); 
	 return "findbynamam";
 }
 
 public String FindByNameM1() throws Exception{
	 String username = model.getUsername();
	 Account account = service.getAccount(username);
	 Userinfo userinfo = infoservice.getByUsername(username);
	 userinfo.setPassword(Des5Util.decrypt(account.getPassword(),"A1B2C3D4E5F6G7H8I9K0"));
	 ActionContext.getContext().getValueStack().push(userinfo); 
	 return "findbyname1";
 }
 
 public String EditUserM() throws Exception{//编辑用户
	 String username = model.getUsername();
	 String password = model.getPassword();
	 Account account = new Account();
	 account.setUsername(username);
	 account.setPassword((Des5Util.encrypt(password,"A1B2C3D4E5F6G7H8I9K0")));
	 service.update(account);
	 
	 infoservice.update(model);
	 return "edituserm";
 }
 
 public String AddUserM() throws Exception{//添加用户
	 String username = model.getUsername();
	 String password = model.getPassword();
	 service.register(username, Des5Util.encrypt(password,"A1B2C3D4E5F6G7H8I9K0"));
	 infoservice.add(model.getUsername(), model.getSex(),model.getEmail(), model.getPhonenumber() ,model.getAddress());
	 return "adduserm";
 }
}
