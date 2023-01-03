package crud_DAO;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;


import crudModel.Product;

@Component
public class ProductDao { //obj relational mapping

	@Autowired            //here, we are automatically generate the object of HibernateTemplate class...why we generate the object of HibernateTemplate class...bcz we want to use its readymade method like(save(insert),delete(delete),saveOrUpdate(update)
	private HibernateTemplate hibernateTemplate;
	
	//create/insert
	@Transactional       //@Transactional annotation is used only in case of create,insert ,update,delete opeartion..not for select/get operation
	public void createProduct(Product product)
	{
		this.hibernateTemplate.saveOrUpdate(product);
		//insert
	}
	
	//get all products/select
	public List<Product> getProducts()
	{
		List<Product> products = this.hibernateTemplate.loadAll(Product.class);
		//select
		return products;
	}
	
	//delete the single product
	@Transactional       //@Transactional annotation is used only in case of create,insert ,update,delete opeartion..not for select/get operation
	public void deleteProduct(int pid)
	{
		Product p = this.hibernateTemplate.load(Product.class,pid);
		this.hibernateTemplate.delete(p);
		
	}
	
	//get the single product //select
	public Product getProduct(int pid)
	{
		return this.hibernateTemplate.get(Product.class,pid);
	}
	
}
