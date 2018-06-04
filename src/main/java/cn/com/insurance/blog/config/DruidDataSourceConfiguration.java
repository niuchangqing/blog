package cn.com.insurance.blog.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration // 该注解类似于spring配置文件
@MapperScan(basePackages = "cn.com.insurance.blog.main.mapper")
public class DruidDataSourceConfiguration implements EnvironmentAware {

	private Logger logger = LoggerFactory.getLogger(DruidDataSourceConfiguration.class);

	private Environment env;

	@Override
	public void setEnvironment(Environment environment) {
		this.env = environment;
	}

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception {
		SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
		fb.setDataSource(ds);// 指定数据源(这个必须有，否则报错)
		return fb.getObject();
	}

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));

		dataSource.setInitialSize(Integer.valueOf(env.getProperty("initialSize")));
		dataSource.setMinIdle(Integer.valueOf(env.getProperty("minIdle")));
		dataSource.setMaxActive(Integer.valueOf(env.getProperty("maxActive")));
		dataSource.setMaxWait(Integer.valueOf(env.getProperty("maxWait")));
		dataSource.setTimeBetweenEvictionRunsMillis(Integer.valueOf(env.getProperty("timeBetweenEvictionRunsMillis")));
		dataSource.setMinEvictableIdleTimeMillis(Integer.valueOf(env.getProperty("minEvictableIdleTimeMillis")));
		dataSource.setValidationQuery(env.getProperty("validationQuery"));
		dataSource.setTestWhileIdle(Boolean.valueOf(env.getProperty("testWhileIdle")));
		dataSource.setTestOnBorrow(Boolean.valueOf(env.getProperty("testOnBorrow")));
		dataSource.setTestOnReturn(Boolean.valueOf(env.getProperty("testOnReturn")));
		dataSource.setPoolPreparedStatements(Boolean.valueOf(env.getProperty("poolPreparedStatements")));
		dataSource.setMaxPoolPreparedStatementPerConnectionSize(
				Integer.valueOf(env.getProperty("maxPoolPreparedStatementPerConnectionSize")));
		try {
			dataSource.setFilters(String.valueOf(env.getProperty("filters")));
		} catch (SQLException e) {
			logger.error("druid configuration initialization filter", e);
		}
		dataSource.setConnectionProperties(String.valueOf(env.getProperty("connectionProperties")));
		return dataSource;
	}

}