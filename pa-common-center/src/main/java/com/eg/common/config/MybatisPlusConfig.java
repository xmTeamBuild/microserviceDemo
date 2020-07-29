package com.eg.common.config;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
@AutoConfigureAfter(SqlSessionFactory.class)
public class MybatisPlusConfig {

    @Value("${mybatis-plus.mapper-locations}")
    private String mapperLocations;

    @Value("${mybatis-plus.refresh-mapper}")
    private Boolean refreshMapper;

//    private static final ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();

    /*
     * 分页插件，自动识别数据库类型
     * 多租户，请参考官网【插件扩展】
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        // paginationInterceptor.setOverflow(false);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        // paginationInterceptor.setLimit(500);
        // 开启 count 的 join 优化,只针对部分 left join
        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        return paginationInterceptor;
    }

    /* * oracle数据库配置JdbcTypeForNull
     * 参考：https://gitee.com/baomidou/mybatisplus-boot-starter/issues/IHS8X
     不需要这样配置了，参考 yml:
     mybatis-plus:
       confuguration
         dbc-type-for-null: 'null' */
    public ConfigurationCustomizer configurationCustomizer(){
        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);
                configuration.setJdbcTypeForNull(JdbcType.NULL);
            }
        };
    }


//    /**
//     * mapper.xml 热加载
//     * @return
//     */
//    @Bean
//    public MybatisMapperRefresh mybatisMapperRefresh(){
//        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) SpringContextHolder.getBean("sqlSessionFactory");
//        Resource[] resources = new Resource[0];
//        try {
//            resources = resourceResolver.getResources(mapperLocations);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        MybatisMapperRefresh mybatisMapperRefresh = new MybatisMapperRefresh(resources,sqlSessionFactory,10,5,refreshMapper);
//        return mybatisMapperRefresh;
//
//    }
//
//    /**
//     * 逻辑删除
//     * @return
//     */
//    @Bean
//    public ISqlInjector sqlInjector() {
//        return new LogicSqlInjector();
//    }


}
