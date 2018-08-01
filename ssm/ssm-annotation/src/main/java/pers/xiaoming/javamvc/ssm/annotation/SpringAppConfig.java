package pers.xiaoming.javamvc.ssm.annotation;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;

// this is equivalent to a myspring*.xml doc
@Configuration

@EnableWebMvc

@ComponentScan("pers.xiaoming.javamvc.ssm.annotation")

// this is equivalent to "<context:property-placeholder location="classpath:jdbc.properties"/>" in myspring-db.xml
@PropertySource(value="classpath:jdbc.properties", ignoreResourceNotFound = true)

// this is equivalent to "<tx:annotation-driven/>" in myspring-tx.xml
@EnableTransactionManagement

public class SpringAppConfig {

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
    public SqlSessionFactoryBean setupSqlSessionFactoryBean(
            @Qualifier("myDataSource") DataSource myDataSource
    ) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(myDataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath:mybatis.xml");
        sqlSessionFactoryBean.setMapperLocations(resources);
        return sqlSessionFactoryBean;
    }

    @Bean
    @Qualifier("sqlSessionFactoryBeanName")
    public MapperScannerConfigurer setupMapperScannerConfigurer() {
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setSqlSessionFactoryBeanName("sqlSessionFactory");
        msc.setBasePackage("pers.xiaoming.javamvc.ssm.annotation.dao");
        return msc;
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
