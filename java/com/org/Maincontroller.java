package com.org;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import crudModel.Product;
import crud_DAO.ProductDao;

@Controller
public class Maincontroller {
	
	@Autowired
  private ProductDao productDao;
	
	@RequestMapping("/hm")
	public String home(Model m)
	{
		List<Product> products = productDao.getProducts();
		m.addAttribute("product",products);
		return "index1";
	}
	
	//show add product form
	@RequestMapping("/add_p")
  public  String addProduct(Model m)
  {
	  m.addAttribute("title","Add Product");
	  return "add_product_form";
  }
	
	//handle add product form
	
	@RequestMapping(value="/handle_product")
	public RedirectView handleProduct (@ModelAttribute Product prod,HttpServletRequest req)
	{
		System.out.println(prod);
		
		productDao.createProduct(prod);     //insert //name,desc,price
		RedirectView rv=new RedirectView();                           //ctrl space for typing redirectview,etc...
		rv.setUrl(req.getContextPath()+"/");
		
		return rv;
	}
	
	//delete handler
		@RequestMapping("/delete/{productId}")  //10
		public RedirectView deleteProduct(@PathVariable("productId") int productId,   HttpServletRequest req)
		{
			productDao.deleteProduct(productId); //41
			RedirectView rv=new RedirectView();
			rv.setUrl(req.getContextPath()+"/");
			
			return rv;
			}
		
	//update handler
		@RequestMapping("/update/{productId}")
		public String updateProduct(@PathVariable("productId") int productId, Model m)
		{
			
			Product product=productDao.getProduct(productId);
			
			m.addAttribute("product",product);
			return "update_form";
			
			
		}
}
