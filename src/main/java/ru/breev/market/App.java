package ru.breev.market;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.breev.market.config.AppConfig;

public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        TestBean tb = context.getBean("testBean", TestBean.class);
        tb.doSomething();

        context.close();
    }
}
