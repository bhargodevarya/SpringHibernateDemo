package com.example;

import com.example.dao.*;
import com.example.model.*;
import com.example.service.*;
import com.google.common.collect.Lists;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
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
@EnableTransactionManagement(proxyTargetClass = true)
public class SpringHibernateDemoApplication implements CommandLineRunner {

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private SupplierLocationService supplierLocationService;

    @Autowired
    private ProductService productService;

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
        properties.put("hibernate.dialect"
                ,"org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl.auto","update");
        properties.put("hibernate.current_session_context_class"
                ,"org.springframework.orm.hibernate5.SpringSessionContext");

        StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
        standardServiceRegistryBuilder.applySettings(properties);
        standardServiceRegistryBuilder.applySetting(Environment.DATASOURCE,dataSource());

        MetadataSources metadataSources = new MetadataSources(standardServiceRegistryBuilder.build());
        metadataSources.addAnnotatedClass(Customer.class);
        metadataSources.addAnnotatedClass(Address.class);
        metadataSources.addAnnotatedClass(Order.class);
        metadataSources.addAnnotatedClass(OrderDetail.class);
        metadataSources.addAnnotatedClass(OrderProduct.class);
        metadataSources.addAnnotatedClass(Student.class);
        metadataSources.addAnnotatedClass(School.class);
        metadataSources.addAnnotatedClass(Product.class);
        metadataSources.addAnnotatedClass(Supplier.class);
        metadataSources.addAnnotatedClass(SupplierLocation.class);



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

        //showStudentsForSchoolId(1);

        //refactorLater();

        //List<Product> productList = productService.getProductsForBrand("xiomi");

        //createAcademicData();

        System.out.println(studentService.getStudentByName("Om"));
        System.out.println(studentService.getStudentById(1));
    }

    private void refactorLater() {
        Customer customer = new Customer();
        customer.setFistName("Amar");
        customer.setLastName("Arya");
        customer.setEmail("amar@gmail.com");
        customer.setCustomerStatus(CustomerStatus.ACTIVE);

        Address address1 = new Address("8th Main","New Thippasandra",
                "bangalore","Karnataka","India",560075);

        Address address2 = new Address("7th Main","New Thippasandra",
                "bangalore","Karnataka","India",560075);

       // Product product = new Product("Xiomi latest phone", 11999,"redmi note3","xiomi");
        Order order = new Order();

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setCost(11999);
        orderDetail.setOrderDate(new Date());

        OrderProduct orderProduct =new OrderProduct();

        address1.setCustomer(customer);
        address2.setCustomer(customer);

        order.setCustomer(customer);
        order.setOrderDetail(orderDetail);

        /*List<OrderProduct> orderProductList = new ArrayList<>();
        orderProductList.add(orderProduct);
        order.setOrderProduct(orderProductList);*/
        orderProduct.setOrder(order);

        order.setCustomer(customer);

        //orderDetail.setOrder(order);
        orderDetail.setAddress(address1);

        Set<Supplier> supplierSet = createSupplierData();
        List<Product> productList = createProducts();

        productList.stream().forEach(n -> {
            n.setSuppliers(supplierSet);
            productService.saveProduct(n);
        });

        orderProduct.setProduct(productList.get(1));
        orderProduct.setOrder(order);

        customerDao().saveCustomer(customer);
        addressDao().save(address1);
        addressDao().save(address2);

        //createSupplierData(product);

        //productDao().save(product);

        orderDetail().save(orderDetail);
        orderDao().save(order);
        orderProduct().saveOrderProduct(orderProduct);
    }

    private List<Product> createProducts(){
        return Lists.newArrayList(new Product("Leeco latest phone", 11999,"le 1s", "Letv")
                ,new Product("Xiomi latest phone", 11999,"redmi note3","xiomi")
                ,new Product("Samsung latest phone",35000,"J5","Samsung" )
                ,new Product("Apple latest phone", 85000,"iphone7","Apple")
                ,new Product("Oneplus latest phone", 30000,"One plus","Oneplus" ));
    }

    private Set<Supplier> createSupplierData() {
        Supplier supplier = new Supplier();
        supplier.setEmail("sup1@gmail.com");
        supplier.setName("supplier1");

        SupplierLocation supplierLocation = new SupplierLocation();
        supplierLocation.setSupplier(supplier);

        SupplierAddress supplierAddress = new SupplierAddress();
        supplierAddress.setAddrLine1("addr1");
        supplierAddress.setAddrLine2("addr2");
        supplierAddress.setCity("Bengaluru");
        supplierAddress.setState("Karnatka");
        supplierAddress.setZipCode(560075);

        supplierLocation.setSupplierAddress(supplierAddress);

        //supplierService.create(supplier);
        supplierLocationService.create(supplierLocation);

        //Product product = new Product("Xiomi latest phone", 11999,"redmi note3","xiomi");
        Set<Supplier> suppliers = new HashSet<>();
        suppliers.add(supplier);
        //product.setSuppliers(suppliers);

        //productService.saveProduct(product);

        return suppliers;
    }


    private void createAcademicData() {
        School school =schoolService.createSchool("gbps");
        Student student1 =studentService.createStudent("amar",school);
        Student student2 = studentService.createStudent("om",school);
    }

    /*private void showStudentsForSchoolId(int id) {
        schoolService.getStudentsForSchoolId(id).forEach(System.out::println);
    }*/
}
