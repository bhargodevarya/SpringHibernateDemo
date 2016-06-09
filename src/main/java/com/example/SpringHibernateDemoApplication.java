package com.example;

import com.example.dao.CustomerDao;
import com.example.model.Customer;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
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
		dataSource.setPassword("welcome");
		return  dataSource;
	}

	@Bean
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
		/*SessionFactory sessionFactory = new LocalSessionFactoryBuilder(dataSource()).
				addAnnotatedClass(Customer.class).setProperties(properties).buildSessionFactory();*/
		return localSessionFactoryBean;
	}

	@Bean(name = "hibernateTemplate")
	public HibernateTemplate hibernateTemplate() throws ClassNotFoundException {

		return new HibernateTemplate(sessionFactory().getObject());
	}

    @Bean
    public CustomerDao customerDao() {
        return  new CustomerDao();
    }

    @Bean
    public HibernateTransactionManager hibernateTransactionManager() throws ClassNotFoundException {
        return new HibernateTransactionManager(sessionFactory().getObject());
    }

    @Override
    public void run(String... args) throws Exception {
        Customer customer = new Customer();
        customer.setFistName("Amar");
        customer.setLastName("Arya");
        customer.setEmail("amar@gmail.com");
        customerDao().saveCustomer(customer);
    }
}
