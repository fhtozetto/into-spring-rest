package br.com.lph.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class SpringJpaConfig {
	 @Bean //bean gerenciado pelo Spring
	    public DataSource dataSource() {
	        DriverManagerDataSource ds = new DriverManagerDataSource();
	        ds.setDriverClassName("com.mysql.jdbc.Driver");
	        ds.setUrl("jdbc:mysql://localhost:3306/test?createDatabaseIfNotExist=true");
	        ds.setUsername("root");
	        ds.setPassword("M3jkpn7b");
	        return ds;
	    }

	    @Bean //bean gerenciado pelo Spring
	    public EntityManagerFactory entityManagerFactory() { //Cria o objeto EntityManager para a conexão com o banco
	        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	        factory.setDataSource(dataSource());
	        factory.setPackagesToScan("br.com.lph.domain");
	        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
	        factory.setJpaProperties(jpaProperties());
	        factory.afterPropertiesSet();
	        return factory.getObject();
	    }

	    @Bean //bean gerenciado pelo Spring
	    public JpaTransactionManager transactionManager() { // Gerência as transações com o Banco
	        JpaTransactionManager tx = new JpaTransactionManager();
	        tx.setEntityManagerFactory(entityManagerFactory());
	        tx.setJpaDialect(new HibernateJpaDialect());
	        return tx;
	    }

	    private Properties jpaProperties() { // Propriedades do Hibernate para conexão com o Banco
	        Properties props = new Properties();
	        props.setProperty("hibernate.show_sql", "true");
	        props.setProperty("hibernate.format_sql", "true");
	        props.setProperty("hibernate.hbm2ddl.auto", "update");
	        return props;
	    }
}
