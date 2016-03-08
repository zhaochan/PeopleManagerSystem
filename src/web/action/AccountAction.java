package web.action;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.levilee.store.entity.Account;
import com.levilee.store.util.DESUtil;
import com.levilee.store.util.Des5Util;
import com.levilee.stroe.service.AccountService;
import com.levilee.stroe.service.UserinfoService;
import com.levilee.stroe.service.VerifyCode;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * @author ZhaoChangKui
 *
 */

public class AccountAction extends ActionSupport implements ModelDriven<Account> {
	private AccountService service = new AccountService();
	private UserinfoService infoservice = new UserinfoService();
	private Account model = new Account(); 
	 private ByteArrayInputStream inputStream;//��֤��ͨ����
	 private String vcode;
	public String getVcode() {
		return vcode;
	}
	public void setVcode(String vcode) {
		this.vcode = vcode;
	}
	@Override
	public Account getModel() {
		return model;
	}	
	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String Vcode() throws IOException{//��֤�빦��
		VerifyCode vc = new VerifyCode();//�õ���֤�����
		BufferedImage image = vc.getImage();//�õ���֤��ͼƬ��
		String text = vc.getText();//�õ���֤���ϵ��ַ�
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("code", text);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpeg", outputStream);
        ByteArrayInputStream input = new ByteArrayInputStream(outputStream
                .toByteArray());
        this.setInputStream(input);
	//	ByteArrayInputStream inputStream = image.get;
		//VerifyCode.output(image, ServletActionContext.getResponse().getOutputStream());
		return "vcode";
		
	}

	public String Login() throws Exception{
		HttpSession session = ServletActionContext.getRequest().getSession();
		String text = (String) session.getAttribute("code");
		String code = getVcode();
		if(!text.equalsIgnoreCase(code)){
			this.addActionError("��֤�벻��ȷ�����������룡");
			return "fail";
		}else if(service.login(model.getUsername(),
				Des5Util.encrypt(model.getPassword(), "A1B2C3D4E5F6G7H8I9K0"))){//��½
			
		session.setAttribute("username", model.getUsername());
		return "login";
		}
		this.addActionError("�û���������������������룡");
		return "fail";
	}
	
	public String Quit(){//�˳���¼
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.invalidate();
		return "quit";
	}

	public String LoginM() throws Exception{
		if(service.login(model.getUsername(),
				Des5Util.encrypt(model.getPassword(), "A1B2C3D4E5F6G7H8I9K0"))){
			ServletActionContext.getRequest().getSession()
			.setAttribute("session_user", model.getUsername());
			return "loginm";
		}
		this.addActionError("�û�����������������µ�¼");
		return "loginmfail";
	}
}
