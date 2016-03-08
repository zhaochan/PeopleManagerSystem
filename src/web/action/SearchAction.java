package web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.levilee.store.entity.Products;
import com.levilee.stroe.service.ProductsService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author ZhaoChangKui
 *
 */

public class SearchAction extends ActionSupport {
	ProductsService productservice = new ProductsService();
	private String keyword;
	private String type;
	private String min;
	private String max;
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		this.min = min;
	}
	public String getMax() {
		return max;
	}
	public void setMax(String max) {
		this.max = max;
	}

	public String Find(){//≤È’“
		String key = getKeyword();
		String catagory = getType();
System.out.println(key);
  		List<Products> productlist = productservice.getAll();
  		ActionContext.getContext().getValueStack().push(productlist);
  		ServletActionContext.getRequest().getSession().setAttribute("productlist", productlist);
    
		return "find";
	}
}
