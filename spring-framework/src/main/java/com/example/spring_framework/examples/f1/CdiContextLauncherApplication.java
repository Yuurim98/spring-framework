package com.example.spring_framework.examples.f1;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.Arrays;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Component
@Named // Component를 대체
class BusinessService {

    private DataService dataService;

    public DataService getDataService() {
        return dataService;
    }

    //@Autowired
    @Inject // Autowired를 대체
    public void setDataService(DataService dataService) {
        System.out.println("setter 주입");
        this.dataService = dataService;
    }
}

//@Component
@Named
class DataService {

}

@Configuration
@ComponentScan
public class CdiContextLauncherApplication {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(
            CdiContextLauncherApplication.class);

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        System.out.println(context.getBean(BusinessService.class).getDataService());
    }

}
