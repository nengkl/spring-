package springConfiguration;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan("top.nengkl")
@Import(jdbcConfiguration.class)
@PropertySource("classpath:jdbc.properties")
public class springConfiguration {
	@Bean("runner")
	public QueryRunner CreateQueryRunner(@Qualifier("dataSource") DataSource ds) {
		return new QueryRunner(ds);
	}
	
}
