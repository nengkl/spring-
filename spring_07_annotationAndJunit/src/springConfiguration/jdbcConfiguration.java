package springConfiguration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
public class jdbcConfiguration {
	
	@Value("${jdbc.Driver}")
	private String Driver;
	
	@Value("${jdbc.jdbcUrl}")
	private String jdbcUrl;
	
	@Value("${jdbc.userName}")
	private String userName;
	
	@Value("${jdbc.password}")
	private String password;

	@Bean("dataSource")
	public DataSource CreateDataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass(Driver);
			dataSource.setJdbcUrl(jdbcUrl);
			dataSource.setUser(userName);
			dataSource.setPassword(password);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return dataSource;
	}
}
