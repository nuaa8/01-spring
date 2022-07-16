package com.itheima.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/*
 * Spring整合MyBatis
*       1、SqlSessionFactoryBean
 *         @Bean
 *         public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){
 *         SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
 *         ssfb.setTypeAliasesPackage("com.itheima.domain");   //1.一个扫描类型别名的包
 *         ssfb.setDataSource(dataSource);  //dataSource通过注入的方式加进来
           return ssfb;
 *      2、MapperScannerConfigure
            @Bean
            public MapperScannerConfigurer mapperScannerConfigurer(){   //映射扫描配置类
            MapperScannerConfigurer msc = new MapperScannerConfigurer();
            msc.setBasePackage("com.itheima.dao");  //2.一个扫描映射的包
            return msc;
                }
 *
 *         以后如果要改，只改1和2两处即可，其他都是固定格式
 */
public class MybatisConfig {
    //定义bean， SqlSessionFactoryBean，用于产生SqlSessionFactory对象
    @Bean    //@bean 要想注入引用类型，在其形参上加上对应的参数就行了， 下面即是  （DataSource dataSource）
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        ssfb.setTypeAliasesPackage("com.itheima.domain");   //一个扫描类型别名的包
        /*
            整合 :
            <typeAliases>
                <package name="com.itheima.domain"/>
            </typeAliases>
         */
        ssfb.setDataSource(dataSource);  //dataSource通过注入的方式加进来
        /*
            整合
                 <environment id="mysql">
            <transactionManager type="JDBC"></transactionManager>
            <dataSource type="POOLED">
                <property name="driver" value="${jdbc.driver}"></property>
                <property name="url" value="${jdbc.url}"></property>
                <property name="username" value="${jdbc.username}"></property>
                <property name="password" value="${jdbc.password}"></property>
            </dataSource>
        </environment>
         */
        return ssfb;
    }
    //定义bean，返回MapperScannerConfigurer对象
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){   //映射扫描配置类
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("com.itheima.dao");  //一个扫描映射的包
        /*
        整合
         <mappers>
             <package name="com.itheima.dao"></package>
         </mappers>
         */
        return msc;
    }
}



