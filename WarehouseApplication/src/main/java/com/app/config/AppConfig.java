package com.app.config;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;



@Configuration
@EnableWebMvc
@ComponentScan("com.app")
@PropertySource("classpath:app.properties")
@EnableTransactionManagement
@Import(SecurityConfig.class)
public class AppConfig implements WebMvcConfigurer {
	
	@Autowired
	private Environment env;

	//1. DataSource
	@Bean
	public BasicDataSource ds() {
		BasicDataSource d=new BasicDataSource();
		d.setDriverClassName(env.getProperty("spring.jdbc.dc"));
		d.setUrl(env.getProperty("spring.jdbc.url"));
		d.setUsername(env.getProperty("spring.jdbc.un"));
		d.setPassword(env.getProperty("spring.jdbc.pwd"));
		return d;
	}
	//2. SessionFactory
	@Bean
	public LocalSessionFactoryBean sf() {
		LocalSessionFactoryBean s=new LocalSessionFactoryBean();
		s.setDataSource(ds());
		s.setHibernateProperties(props());
		//s.setAnnotatedClasses(null);
		//s.setAnnotatedClasses(ShipmentType.class);
		s.setPackagesToScan("com.app.model");
		return s;
	}
	@Bean
	public Properties props() {
		Properties p=new Properties();
		p.put("hibernate.dialect",env.getProperty("spring.orm.dialect"));
		p.put("hibernate.show_sql",env.getProperty("spring.orm.showsql"));
		p.put("hibernate.format_sql",env.getProperty("spring.orm.fmtsql"));
		p.put("hibernate.hbm2ddl.auto",env.getProperty("spring.orm.ddlauto"));
		return p;
	}
	
	//3. HibernateTemplate
	@Bean
	public HibernateTemplate ht() {
		HibernateTemplate h=new HibernateTemplate();
		h.setSessionFactory(sf().getObject());
		return h;
	}
	
	//4. HibernateTxManager
	@Bean
	public HibernateTransactionManager htm() {
		HibernateTransactionManager htm=new HibernateTransactionManager();
		htm.setSessionFactory(sf().getObject());
		return htm;
	} 

	//5. ViewResolver
	@Bean
	public InternalResourceViewResolver ivr() {
		InternalResourceViewResolver v=new InternalResourceViewResolver();
		v.setPrefix(env.getProperty("spring.mvc.prefix"));
		v.setSuffix(env.getProperty("spring.mvc.suffix"));
		return v;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	} 
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		return new CommonsMultipartResolver();
	}
	//8. Password Encoder
		@Bean
		public BCryptPasswordEncoder pwdEncoder() {
			return new BCryptPasswordEncoder();
		}
	//email
		@Bean
		public JavaMailSenderImpl jms() {
			JavaMailSenderImpl m = new JavaMailSenderImpl();
			m.setHost(env.getProperty("email.host"));
			m.setPort(env.getProperty("email.port",Integer.class));
			m.setUsername(env.getProperty("email.usr"));
			m.setPassword(env.getProperty("email.pwd"));
			m.setJavaMailProperties(eprops());
			return m;
		}
		private Properties eprops() {
			Properties p=new Properties();
		    p.put("mail.smtp.auth",env.getProperty("email.auth"));
		    p.put("mail.smtp.starttls.enable",env.getProperty("email.ssl.enbl"));
			return p;
		}
}

	
