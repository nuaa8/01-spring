package com.itheima;

import com.itheima.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * 第三方bean依赖注入
 *      1，简单类型依赖注入
 *      //1.  简单类型注入
        *     @Value("com.mysql.jdbc.Driver")
        *     private String driver;
        *     @Value("jdbc:mysql://localhost:3306/spring_db")
        *     private String url;
        *     @Value("root")
        *     private String userName;
        *     @Value("root")
        *     private String password;
 *      2.引用类型依赖注入
 *              //2.   引用类型依赖注入 （引用类型依赖注入只需要为bean定义方法设置形参  即可，容器会根据类型自动装配对象）
         *     @Bean
         *     public DataSource dataSource(BookDao bookDao){
         *         System.out.println(bookDao);
         *         DruidDataSource ds = new DruidDataSource();
         *         ds.setDriverClassName(driver);
         *         ds.setUrl(url);
         *         ds.setUsername(userName);
         *         ds.setPassword(password);
         *         return ds;
         *     }
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource);
    }
}
