package com.example;

import com.example.dao.*;
import com.example.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.Driver;
import java.util.*;

@SpringBootApplication
@EnableTransactionManagement
public class SpringHibernateDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(SpringHibernateDemoApplication.class, args);
	}

	@Bean
	public DataSource dataSource() throws ClassNotFoundException {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
         dataSource.setDriverClass((Class<? extends Driver>)Class.forName("com.mysql.jdbc.Driver"));
        //BasicDataSource dataSource = new BasicDataSource();
		//dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/customerDB");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return  dataSource;
	}

    @Bean
    public SessionFactory createSessionFactory() throws ClassNotFoundException {

        Properties properties = new Properties();
        properties.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl.auto","create");
        properties.put("hibernate.current_session_context_class","org.springframework.orm.hibernate5.SpringSessionContext");

        StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
        standardServiceRegistryBuilder.applySettings(properties);
        standardServiceRegistryBuilder.applySetting(Environment.DATASOURCE,dataSource());

        MetadataSources metadataSources = new MetadataSources(standardServiceRegistryBuilder.build());
        metadataSources.addAnnotatedClass(Customer.class);
        metadataSources.addAnnotatedClass(Address.class);
        metadataSources.addAnnotatedClass(Order.class);
        metadataSources.addAnnotatedClass(Product.class);
        metadataSources.addAnnotatedClass(OrderDetail.class);
        metadataSources.addAnnotatedClass(OrderProduct.class);

        return metadataSources.getMetadataBuilder().build().buildSessionFactory();
    }

    @Bean
    public CustomerDao customerDao() {
        return  new CustomerDao();
    }

    @Bean
    public AddressDao addressDao() {
        return new AddressDao();
    }

    @Bean
    public OrderDao orderDao() {
        return new OrderDao();
    }

    @Bean
    public OrderProductDao orderProduct() {
        return new OrderProductDao();
    }

    @Bean
    public OrderDetailDao orderDetail() {
        return new OrderDetailDao();
    }

    @Bean
    public ProductDao productDao() {
        return new ProductDao();
    }

    @Bean
    public HibernateTransactionManager hibernateTransactionManager() throws ClassNotFoundException{
        return new HibernateTransactionManager(createSessionFactory());
    }

    @Override
    public void run(String... args) throws Exception {
        Customer customer = new Customer();
        customer.setFistName("Amar");
        customer.setLastName("Arya");
        customer.setEmail("amar@gmail.com");
        customer.setCustomerStatus(CustomerStatus.ACTIVE);

        Address address1 = new Address("8th Main","New Thippasandra",
                "bangalore","Karnataka","India",560075);

        Address address2 = new Address("7th Main","New Thippasandra",
                "bangalore","Karnataka","India",560075);

        address1.setCustomer(customer);
        address2.setCustomer(customer);

        Product product = new Product("Xiomi latest phone", 11999,"redmi note3","xiomi");

        Order order = new Order();
        order.setCustomer(customer);


        OrderDetail orderDetail = new OrderDetail(new Date(),11999,address1,order);
        orderDetail.setOrder(order);

        List<Product> productList = new ArrayList<>();
        productList.add(product);
        OrderProduct orderProduct =new OrderProduct(productList);
        orderProduct.setOrder(order);

        Set<OrderProduct> orderProductSet = new HashSet<>();
        orderProductSet.add(orderProduct);

        order.setOrderProduct(orderProductSet);
        order.setOrderDetail(orderDetail);

        customerDao().saveCustomer(customer);
        addressDao().save(address1);
        addressDao().save(address2);

        productDao().save(product);
        orderDao().save(order);
        //orderDetail().save(orderDetail);
        //orderProduct().save(orderProduct);


    }
}
