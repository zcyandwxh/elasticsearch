import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 *   
 * <p>描述</p>
 *
 * @author: 彗星（huixing@maihaoche.com）
 * @date: 2018/3/6 
 * @since V1.0
 *  
 */
@SpringBootApplication
@ComponentScan("com")
public class ElasticsearchBoot {
    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchBoot.class, args);
    }
}
