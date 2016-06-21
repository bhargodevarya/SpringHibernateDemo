package com.example;

import com.example.dao.AddressDao;
import com.example.dao.CustomerDao;
import com.example.model.Address;
import com.example.model.Customer;
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
import java.util.Properties;

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
        properties.put("hibernate.hbm2ddl.auto","update");
        properties.put("hibernate.current_session_context_class","org.springframework.orm.hibernate5.SpringSessionContext");

        StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
        standardServiceRegistryBuilder.applySettings(properties);
        standardServiceRegistryBuilder.applySetting(Environment.DATASOURCE,dataSource());

        MetadataSources metadataSources = new MetadataSources(standardServiceRegistryBuilder.build());
        metadataSources.addAnnotatedClass(Customer.class);
        metadataSources.addAnnotatedClass(Address.class);

        //metadataSources.addPackage("com.example.model");

        //metadataSources.addPackage("");
        return metadataSources.getMetadataBuilder().build().buildSessionFactory();

        //return metadataSources.getMetadataBuilder().build().getSessionFactoryBuilder().build();
    }

	/*@Bean
	public LocalSessionFactoryBean  sessionFactory() throws ClassNotFoundException {
        Properties properties = new Properties();
        properties.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl.auto","update");
       // properties.put("hibernate.connection.provider_class","org.hibernate.connection.DatasourceConnectionProvider");
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource());
        localSessionFactoryBean.setPackagesToScan("com.example.model");
        localSessionFactoryBean.setHibernateProperties(properties);
		*//*SessionFactory sessionFactory = new LocalSessionFactoryBuilder(dataSource()).
				addAnnotatedClass(Customer.class).setProperties(properties).buildSessionFactory();*//*
		return localSessionFactoryBean;
	}*/

	/*@Bean(name = "hibernateTemplate")
	public HibernateTemplate hibernateTemplate() throws ClassNotFoundException {

		return new HibernateTemplate(sessionFactory().getObject());
	}*/

    @Bean
    public CustomerDao customerDao() {
        return  new CustomerDao();
    }

    @Bean
    public AddressDao addressDao() {
        return new AddressDao();
    }

    @Bean
    public HibernateTransactionManager hibernateTransactionManager() throws ClassNotFoundException {
        return new HibernateTransactionManager(createSessionFactory());
    }

    @Override
    public void run(String... args) throws Exception {
        Customer customer = new Customer();
        customer.setFistName("Amar");
        customer.setLastName("Arya");
        customer.setEmail("amar@gmail.com");
        //customer.setId(1);
        Address address1 = new Address("8th Main","New Thippasandra",
                "bangalore","Karnataka","India",560075);

        Address address2 = new Address("7th Main","New Thippasandra",
                "bangalore","Karnataka","India",560075);

        //customer.setAddress(address1);
        address1.setCustomer(customer);
        address2.setCustomer(customer);

        customerDao().saveCustomer(customer);
        addressDao().save(address1);
        addressDao().save(address2);
    }

    public void hibernate5way() {
        StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
        standardServiceRegistryBuilder.build();
        MetadataSources metadataSources = new MetadataSources(standardServiceRegistryBuilder.build());
        metadataSources.addPackage("");
        SessionFactory sessionFactory = metadataSources.getMetadataBuilder().
                build().getSessionFactoryBuilder().build();
        sessionFactory.openSession().beginTransaction().begin();
    }
}
