package org.springframework.management.config;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.MybatisSqlSessionTemplate;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.io.VFS;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"org.springframework.management.dao*"}, sqlSessionFactoryRef = "sqlSessionFactory")
public class SqlSessionFactoryConfig {
    @Autowired
    @Qualifier("managementDS")
    DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
        MybatisConfiguration configuration = new MybatisConfiguration();
        //设置数据库的下划线模式到model的驼峰模式的数据映射
        configuration.setMapUnderscoreToCamelCase(true);
        //禁用二级缓存，二级缓存默认用的内存实现，考虑分布式部署，实现时用redis替代
        configuration.setCacheEnabled(false);
        factoryBean.setConfiguration(configuration);

        factoryBean.setDataSource(dataSource);
        VFS.addImplClass(SpringBootVFS.class);
        factoryBean.setTypeAliasesPackage("org.springframework.management.entity");
        return factoryBean.getObject();
    }

    @Bean
    public MybatisSqlSessionTemplate sqlSessionTemplate() throws Exception {
        MybatisSqlSessionTemplate template = new MybatisSqlSessionTemplate(sqlSessionFactory());
        return template;
    }
}
