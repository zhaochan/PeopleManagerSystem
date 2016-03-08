package web.action;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.levilee.store.entity.Cart;
import com.levilee.store.entity.Collection;
import com.levilee.store.entity.Orders;
import com.levilee.store.entity.Products;
import com.levilee.stroe.service.CartService;
import com.levilee.stroe.service.CollectionService;
import com.levilee.stroe.service.OrdersService;
import com.levilee.stroe.service.ProductsService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * @author ZhaoChangKui
 *
 */
public class CartAction extends ActionSupport implements ModelDriven<Cart> {
	private Cart model = new Cart();
	CartService  cartService = new CartService();
	@Override
	public Cart getModel() {
		return model;
	}
	
	public String AddCart(){
		double total = 0;
		HttpSession session = ServletActionContext.getRequest().getSession();
		String username = (String) session.getAttribute("username");
		model.setAmount(1);
		model.setUsername(username);
		cartService.add(model);
		List<Cart> list = cartService.get(username);
		ProductsService productservice = new ProductsService(); 
		List<Products> products = new ArrayList<Products>();

		for(Cart li:list){
			List<Products> product = productservice.getByProductid(li.getProductid());
			product.get(0).setCartid((li.getCartid()));
			products.add(product.get(0));
			
			total += product.get(0).getPrice();
		}
		ActionContext.getContext().getValueStack().push(products);
	
		session.setAttribute("totalmoney", total);
		session.setAttribute("cart", products);
		session.setAttribute("size", products.size());
		
		return "addcart";
	}
	
	public String MyCart(){
		double total = 0;
		HttpSession session = ServletActionContext.getRequest().getSession();
		String username = (String) session.getAttribute("username");
		List<Cart> list = cartService.get(username);
		ProductsService productservice = new ProductsService(); 
		List<Products> products = new ArrayList<Products>();
		for(Cart li:list){
			
			List<Products> product = productservice.getByProductid(li.getProductid());
			product.get(0).setCartid((li.getCartid()));
			products.add(product.get(0));
			total += product.get(0).getPrice();
		}
		ActionContext.getContext().getValueStack().push(products);		
		session.setAttribute("totalmoney", total);
		session.setAttribute("cart", products);
		session.setAttribute("size", products.size());
		
		return "mycart";
	}
	
	public String DeleteAllCart(){//清除购物车所有
		HttpSession session = ServletActionContext.getRequest().getSession();
		String username = (String) session.getAttribute("username");
		cartService.delete(username);
		
		session.setAttribute("totalmoney", 0);
		session.setAttribute("cart", null);
		session.setAttribute("size", 0);
		return "deleteallcart";
	}

	public String DeleteCart(){//清除购物车 一条
		int cartid = model.getCartid();
		cartService.delete(cartid);//删除
		
		double total = 0; 
		HttpSession session = ServletActionContext.getRequest().getSession();
		String username = (String) session.getAttribute("username");
		List<Cart> list = cartService.get(username);
		ProductsService productservice = new ProductsService(); 
		List<Products> products = new ArrayList<Products>();
		
		for(Cart li:list){
			List<Products> product = productservice.getByProductid(li.getProductid());
			product.get(0).setCartid((li.getCartid()));
			products.add(product.get(0));
			
			total += product.get(0).getPrice();
		}
		ActionContext.getContext().getValueStack().push(products);
		
		session.setAttribute("totalmoney", total);
		session.setAttribute("cart", products);
		session.setAttribute("size", products.size());
		return "deletecart";
	}
	
	
	public String Buy(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		List<Products> product = (List<Products>) session.getAttribute("cart");
		String username = (String) session.getAttribute("username");
		OrdersService orderservice = new OrdersService();
		for(Products p:product){
			Orders orders = new Orders();
			Date date = new Date();
			orders.setOrderdate(date);
			orders.setUsername(username);
			orders.setProductid(p.getProductid());
			orders.setStatus(1);
			orderservice.add(orders);
		}
		
		cartService.delete(username);//清除购物车
		double totalmoney = 0;
		List<Orders> orderlist = orderservice.getByUsername(username);
		ProductsService productservice = new ProductsService();
		List<Products> listorder = new ArrayList<>();
		for(Orders order:orderlist){
			List<Products> productlist = productservice.getByProductid(order.getProductid());
			listorder.add(productlist.get(0));
			totalmoney += productlist.get(0).getPrice();
		}
		
		ActionContext.getContext().getValueStack().push(listorder);
		session.setAttribute("cost", totalmoney);
		session.setAttribute("size", listorder.size());
		return "buy";
	}
	
	
	public String DeleteOrder(){//删除点单
		HttpSession session = ServletActionContext.getRequest().getSession();
		String username = (String) session.getAttribute("username");
		int productid = model.getProductid();
		OrdersService orderservice = new OrdersService();
		orderservice.deleteByUsernameAddProductid(username, productid);
		
		
		double totalmoney = 0;
		List<Orders> orderlist = orderservice.getByUsername(username);
		ProductsService productservice = new ProductsService();
		List<Products> listorder = new ArrayList<>();
		for(Orders order:orderlist){
			List<Products> productlist = productservice.getByProductid(order.getProductid());
			listorder.add(productlist.get(0));
			totalmoney += productlist.get(0).getPrice();
		}
		ActionContext.getContext().getValueStack().push(listorder);
		session.setAttribute("cost", totalmoney);
		session.setAttribute("size", listorder.size());
		return "deleteorder";				
	}
	
	public String MyOrder(){//我的订单
		HttpSession session = ServletActionContext.getRequest().getSession();
		String username = (String) session.getAttribute("username");
		OrdersService orderservice = new OrdersService();
		
		double totalmoney = 0;
		List<Orders> orderlist = orderservice.getByUsername(username);
		ProductsService productservice = new ProductsService();
		List<Products> listorder = new ArrayList<>();
		for(Orders order:orderlist){
			List<Products> productlist = productservice.getByProductid(order.getProductid());
			listorder.add(productlist.get(0));
			totalmoney += productlist.get(0).getPrice();
		}
		ActionContext.getContext().getValueStack().push(listorder);
		session.setAttribute("cost", totalmoney);
	
		return "myorder";
		
	}
	
	public String Collection(){//收藏商品
		int productid= model.getProductid();
System.out.println(productid+"15141651");		
		HttpSession session = ServletActionContext.getRequest().getSession();
		String username = (String) session.getAttribute("username");
		Collection collection = new Collection();
		collection.setUsername(username);
		collection.setProductid(productid);
		Date date = new Date();
		collection.setDate(date);
		CollectionService collectionservice = new CollectionService();
		collectionservice.add(collection);
		
		List<Collection> collectionlist = collectionservice.getByUsername(username);
		ProductsService productservice = new ProductsService();
		List<Products> listcollection = new ArrayList<>();
		for(Collection con:collectionlist){
			List<Products> product = productservice.getByProductid(con.getProductid());
			product.get(0).setReleasedate(con.getDate());
			listcollection.add(product.get(0));
		}
		ActionContext.getContext().getValueStack().push(listcollection);
		return "collection";
	}
	
	
	public String MyCollection(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		String username = (String) session.getAttribute("username");
		CollectionService collectionservice = new CollectionService();
		List<Collection> collectionlist = collectionservice.getByUsername(username);
		ProductsService productservice = new ProductsService();
		List<Products> listcollection = new ArrayList<>();
		for(Collection con:collectionlist){
			List<Products> product = productservice.getByProductid(con.getProductid());
			product.get(0).setReleasedate(con.getDate());
			listcollection.add(product.get(0));
		}
		ActionContext.getContext().getValueStack().push(listcollection);
		return "mycollection";
	}
	
	public String DeleteColletion(){//删除收藏
		int productid=model.getProductid();
		HttpSession session = ServletActionContext.getRequest().getSession();
		String username = (String) session.getAttribute("username");
		CollectionService collectionservice = new CollectionService();
		collectionservice.deleteByUsernameAddProductid(username, productid);
		
		
		List<Collection> collectionlist = collectionservice.getByUsername(username);
		ProductsService productservice = new ProductsService();
		List<Products> listcollection = new ArrayList<>();
		for(Collection con:collectionlist){
			List<Products> product = productservice.getByProductid(con.getProductid());
			product.get(0).setReleasedate(con.getDate());
			listcollection.add(product.get(0));
		}
		ActionContext.getContext().getValueStack().push(listcollection);
		return "deletecollection";
	}
}
