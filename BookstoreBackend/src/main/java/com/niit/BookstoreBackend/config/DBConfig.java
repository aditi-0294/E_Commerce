package com.niit.BookstoreBackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//import com.niit.BookstoreBackend.dao.CartDAO;
import com.niit.BookstoreBackend.dao.CartItemDAO;
import com.niit.BookstoreBackend.dao.CategoryDAO;
import com.niit.BookstoreBackend.dao.ProductDAO;
import com.niit.BookstoreBackend.dao.SupplierDAO;
import com.niit.BookstoreBackend.dao.UserDetailDAO;
import com.niit.BookstoreBackend.dao.UserOrderDAO;
import com.niit.BookstoreBackend.model.Cart;
import com.niit.BookstoreBackend.model.CartItem;
import com.niit.BookstoreBackend.model.Category;
import com.niit.BookstoreBackend.model.Product;
import com.niit.BookstoreBackend.model.Supplier;
import com.niit.BookstoreBackend.model.UserDetail;
import com.niit.BookstoreBackend.model.UserOrder;

@Configuration // deals with bean creation that are managed by spring framework
@ComponentScan(basePackages = {"com.niit.BookstoreBackend"}) // tells where the entity classes reside that hibernate requires
@EnableTransactionManagement // inbuilt coding of management part by hibernate

public class DBConfig {

	@Bean(name = "dataSource") // provides connection information for the database
	
	public DataSource getH2DataSource() { //Inbuilt method - A factory for connections to the physical data source that this datasource object represents .

		System.out.println(" ****** Starting H2DataSource method ... ****** ");
		System.out.println();
		
		System.out.println(" ****** Connecting to H2 Database ... ****** ");
		DriverManagerDataSource dataSource = new DriverManagerDataSource() ;
		
		dataSource.setDriverClassName("org.h2.Driver");
	//	dataSource.setDialect("org.hibernate.dialect.H2Dialect") ;
	//	dataSource.setUrl("jdbc:h2:tcp://localhost/~/booksArchive"); // original url
	//	dataSource.setUrl("jdbc:h2:tcp://localhost/~/bookStore"); // new url
	//	dataSource.setUrl("jdbc:h2:tcp://localhost/~/ECommerce"); // final url
		
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/project_1"); // final url
		
		dataSource.setUsername("aditi");
		dataSource.setPassword("sanaditi");
		
		System.out.println();
		
		System.out.println(" ****** Connected to H2 Database ....  ****** ");
		System.out.println();
		
		System.out.println(" ****** DataSource created .. Method completed ... ****** ");
		System.out.println();
		
		return dataSource;
	
	}
	
	@Autowired
	@Bean(name="sessionFactory") // configures application to use hibernate
	public SessionFactory getSessionFactory(DataSource dataSource)	{  // Inbuilt Method - creates session (CRUD operations) instances : threads servicing client requests obtain session instances from this factory . 
		
		System.out.println(" ****** Creating Hibernate Properties ****** ");
		Properties prop=new Properties();
		//prop.setProperty("hibernate.hbm2ddl.auto", "validate || create || update"); // Drop and re-create the database schema on startup
		prop.setProperty("hibernate.hbm2ddl.auto", "update"); // Drop and re-create the database schema on startup
		//prop.setProperty("hibernate.hbm2ddl.auto", "create-drop"); // Drop and re-create the database schema on startup
		//<property name="hbm2ddl.auto" value="create"/>
		prop.put("hibernate.show_sql", "true"); //optional - prints all executed SQL to output console
		prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");//  SQL dialect
		System.out.println(" ****** Hibernate Properties Created ****** ");
		
		System.out.println();
		
		System.out.println(" ****** Creating Local SessionFactory Builder Object Creation ****** ");  // extension of standard hibernate configuration class that provides ways to specify a datasource and an application classloader .
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(getH2DataSource());
		sessionBuilder.addProperties(prop);
		System.out.println(" ****** Local SessionFactory Builder Object Creation completed ****** ");  // extension of standard hibernate configuration class that provides ways to specify a datasource and an application classloader .
		
		System.out.println();
		
		//System.out.println("---Factory Builder Object Created---");
	
		sessionBuilder.addAnnotatedClass(Category.class);
		
		sessionBuilder.addAnnotatedClass(Supplier.class);
		
		sessionBuilder.addAnnotatedClass(Product.class);
		
		sessionBuilder.addAnnotatedClass(UserDetail.class);
		
		sessionBuilder.addAnnotatedClass(Cart.class);
		
		sessionBuilder.addAnnotatedClass(CartItem.class);
		
		sessionBuilder.addAnnotatedClass(UserOrder.class) ;
		
		System.out.println(" ****** Creating Session Factory Object ****** ");
		SessionFactory sessionFactory=sessionBuilder.buildSessionFactory();
		System.out.println(" ****** Session Factory Object Creation completed ****** ");
		return sessionFactory;
	
	}
	
	@Autowired
	@Bean(name="transactionManager") // manages hibernate transactions .
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{ // binds hibernate session from the specified factory to the thread , potentially allowing for one thread-bound session per factory . 
		System.out.println(" ****** Creating Transaction manager Object ****** ");
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		System.out.println(" ****** Transaction manager Object Creation completed ****** ");
		return transactionManager;
	}
	
		
	/*  for CategoryDAO object creation */
	@Autowired
	@Bean(name="categoryDAO")
	public CategoryDAO getCategoryDAO(SessionFactory sessionFactory)
	{
		System.out.println(" ****** CategoryDAO Object Creation ****** ");
		return new CategoryDAO(sessionFactory);
	}
	

	/*  for SupplierDAO object creation */
	@Autowired
	@Bean(name="supplierDAO")
	public SupplierDAO getSupplierDAO(SessionFactory sessionFactory)
	{
		System.out.println(" ****** SupplierDAO Object Creation ****** ");
		return new SupplierDAO(sessionFactory);
	}

	
	/*  for ProductDAO object creation */
	@Autowired
	@Bean(name="productDAO")
	public ProductDAO getProductDAO(SessionFactory sessionFactory)
	{
		System.out.println(" ****** ProductDAO Object Creation ****** ");
		return new ProductDAO(sessionFactory);
	}

	
	/*  for UserDetailDAO object creation */
	@Autowired
	@Bean(name="userDetailDAO")
	public UserDetailDAO getUserDetailDAO(SessionFactory sessionFactory)
	{
		System.out.println(" ****** UserDetailDAO Object Creation ****** ");
		return new UserDetailDAO(sessionFactory);
	}

	
	/* for CartDAO object creation */
	/*
	@Autowired
	@Bean(name="cartDAO")
	public CartDAO getCartDAO(SessionFactory sessionFactory)
	{
		System.out.println(" ****** cartDAO Object Creation ****** ");
		return new CartDAO(sessionFactory);
	}
	*/
	
	
	/* for CartItemDAO object creation */
	@Autowired
	@Bean(name="cartItemDAO")
	public CartItemDAO getCartItemDAO(SessionFactory sessionFactory)
	{
		System.out.println(" ****** CartItemDAO Object Creation ****** ");
		return new CartItemDAO(sessionFactory);
	}
	
	
	/* for UserOrderDAO object Creation */
	@Autowired
	@Bean(name="userOrderDAO")
	public UserOrderDAO getUserOrderDAO(SessionFactory sessionFactory)
	{
		System.out.println("****** UserOrderDAO Object Creation ******");
		return new UserOrderDAO(sessionFactory);
	}

}