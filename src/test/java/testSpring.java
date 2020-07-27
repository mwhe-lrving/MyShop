import com.myshop.pojo.Category;
import com.myshop.pojo.GoodsComplex;
import com.myshop.service.UserinfoService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testSpring {
    @Test
    public void testIOC() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring.xml");
        Category category = (Category) context.getBean("category");
        GoodsComplex goods = (GoodsComplex) context.getBean("goodsComplex");
        System.out.println(category);
        System.out.println(goods);
        UserinfoService service = context.getBean(UserinfoService.class);
        System.out.println(service);
    }
}
