package com.itheima;

import com.itheima.dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 创建容器的方式：
 *  1.加载类路径下的配置文件
 *  2.从文件系统下加载配置文件
 *
 *  获取bean的方式：
 *  1.使用bean名称获取
 *      BookDao bookDao = (BookDao) ctx.getBean("bookDao1");
 *  2.使用bean名称获取并指定类型
 *      BookDao bookDao = ctx.getBean("bookDao",BookDao.class);
 *  3.使用bean类型获取
 *      BookDao bookDao = ctx.getBean(BookDao.class);使用bean类型获取，但容器中这个类型的bean只能有一种，多个会报错
 *
 */
public class App {
    public static void main(String[] args) {
        //1.加载类路径下的配置文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.从文件系统下加载配置文件
//        ApplicationContext ctx = new FileSystemXmlApplicationContext("D:\\myCode\\ideaWorkSpace\\heima2\\01-spring\\spring_10_container\\src\\main\\resources\\applicationContext.xml");
        BookDao bookDao = (BookDao) ctx.getBean("bookDao1");
//        BookDao bookDao = ctx.getBean("bookDao",BookDao.class);
//        BookDao bookDao = ctx.getBean(BookDao.class); //使用bean类型获取，但容器中这个类型的bean只能有一种，多个会报错
        bookDao.save();
    }
}
