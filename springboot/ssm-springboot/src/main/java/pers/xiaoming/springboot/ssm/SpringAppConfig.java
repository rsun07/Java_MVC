package pers.xiaoming.springboot.ssm;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@ComponentScan("pers.xiaoming.springboot.ssm")
@PropertySource(value="classpath:jdbc.properties", ignoreResourceNotFound = true)
@SpringBootApplication
public class SpringAppConfig extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringAppConfig.class);
    }

    // datasource config
    @Value("${jdbc.driver}")
    private String driverClass;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.user}")
    private String mysqlUser;

    @Value("${jdbc.password}")
    private String mysqlPassword;

    @Bean
    @Qualifier("myDataSource")
    public DataSource getDataSource() throws PropertyVetoException {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass(this.driverClass);
        cpds.setJdbcUrl(this.jdbcUrl);
        cpds.setUser(this.mysqlUser);
        cpds.setPassword(this.mysqlPassword);
        return cpds;
    }

    // following two are spring-mybatis configs
    @Bean
    @Qualifier("sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory(
            @Qualifier("myDataSource") DataSource myDataSource
    ) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(myDataSource);

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource mybatisConfigXml = resolver.getResource("classpath:mybatis.xml");
        sqlSessionFactoryBean.setConfigLocation(mybatisConfigXml);
        return sqlSessionFactoryBean;
    }

    @Bean
    @Qualifier("mapperScannerConfigurer")
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("pers.xiaoming.springboot.ssm.dao");
        return mapperScannerConfigurer;
    }

    // Mybatis transaction manager
    @Bean
    @Qualifier("transactionManager")
    public PlatformTransactionManager setuptxManager(
            @Qualifier("myDataSource") DataSource myDataSource
    ) {
        return new DataSourceTransactionManager(myDataSource);
    }
}
