package com.niit.backend;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages ="com.niit.backend")
public class Config {
	
	@Bean(name="dataSorce")
	public DataSource dataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/data");
		dataSource.setUsername("azmu");
		dataSource.setPassword("azmu");
		
		return dataSource;
	}
	
	public Properties getHibernateProperties()
	{
		Properties hproperties = new Properties();
		hproperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		hproperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hproperties.setProperty("hibernate.show_sql","true");
		hproperties.setProperty("hconnection.pool_size","1");
		hproperties.setProperty("cache.provider_class","org.hibernate.cache.NoCacheProvider");
		hproperties.setProperty("hibernate.id.new_generator_mappings", "true");
		
		
		return hproperties;

	}
	
	@Bean(name="sessionFactory")
	@Autowired
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setHibernateProperties(getHibernateProperties());
		sessionFactory.setPackagesToScan("com.niit.backend");
		
		return sessionFactory;

	}
	
	@Bean(name="transactionManager")
	@Autowired
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;

	}

}