import com.News.Entity.Topic;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class getBeanTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(context.toString());
        Topic topic = (Topic) context.getBean("topic");
        topic.setTopicName("cuong");
        topic.setTopicBody("aaaaaaacs");
        System.out.println(topic.toString());
        ((ClassPathXmlApplicationContext)context).close();
        try {
            System.out.println("find driver");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("get driver");
            //on classpath
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            //not on classpath
        }
    }
}
