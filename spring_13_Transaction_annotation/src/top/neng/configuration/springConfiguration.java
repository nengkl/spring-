package top.neng.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("top.neng")
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement
public class springConfiguration {
	
	@Value("${jdbc.Driver}")
	private String driverClassName;
	
	@Value("${jdbc.jdbcUrl}")
	private String url;
	
	@Value("${jdbc.userName}")
	private String username;
	
	@Value("${jdbc.password}")
	private String password;
	
	@Bean
	public JdbcTemplate getJdbcTemplate(@Qualifier("DataSource") DataSource ds){
		return new JdbcTemplate(ds);
	}
	
	@Bean("DataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		try {
			 ds.setDriverClassName(driverClassName);
			 ds.setUrl(url);
			 ds.setUsername(username);
			 ds.setPassword(password);
		}catch(Exception e){
			throw new RuntimeException("“Ï≥£",e);
		}
		return ds;
	}
	
	@Bean
	public PlatformTransactionManager TransactionManager(@Qualifier("DataSource") DataSource ds){
		return new DataSourceTransactionManager(ds);
	}
}
