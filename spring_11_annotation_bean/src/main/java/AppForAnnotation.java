import com.itheima.config.SpringConfig;
import com.itheima.dao.BookDao;
import com.itheima.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 纯注解开发：
 * Spring3.0开启了纯注解开发模式，使用Java类 替代配置文件，开启了Spring快速开发赛道
 * 1、@Configuration注解用于设定当前类为配置类
 * 2、@ComponentScan注解用于设定扫描路径，此注解只能添加一次，多个数据请用数组格式
 * 3、读取Spring核心配置文件初始化容器对象切换为读取Java配置类初始化容器对象
 *           //加载  配置文件  初始化容器
             * ApplicationContext ctx = new
             * ClassPathXmlApplicationContext("applicationContext.xml");
             * //加载  配置类  初始化容器
             * ApplicationContext ctx = new
             * AnnotationConfigApplicationContext(SpringConfig.class);
 */
public class AppForAnnotation {
    public static void main(String[] args) {
        //加载  配置类  初始化容器，   AnnotationConfigApplicationContext加载Spring配置类初始化Spring容器
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        System.out.println(bookDao);
        //按类型获取bean
        BookService bookService = ctx.getBean(BookService.class);
        System.out.println(bookService);
    }
}
