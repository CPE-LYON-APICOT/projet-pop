package tp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("tp")
public class Main {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws InterruptedException {
        // System.out.println("Hello world!");

        var annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Main.class);
        Game bean = annotationConfigApplicationContext.getBean(Game.class);
        bean.launch();
    }
}