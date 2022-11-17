package com.example.demo;

import com.example.demo.aspect.DynamicPointcutAdvisor;
import com.example.demo.aspect.ExceptionAspect;
import com.example.demo.stream.TaskMessageProcessor;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableBinding(TaskMessageProcessor.class)
public class CloudStreamOpentelemetryDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudStreamOpentelemetryDemoApplication.class, args);
    }

    @Bean
    public ExceptionAspect originExceptionAspect() {
        return new ExceptionAspect();
    }

    @Bean
    public PointcutAdvisor exceptionAspect(ExceptionAspect originExceptionAspect) {
        String pointcut = "execution(* com.example.demo.controller.CommonController.*(..))";
        DynamicPointcutAdvisor pointcutAdvisor = new DynamicPointcutAdvisor(pointcut);
        pointcutAdvisor.setAdviceBeanName("exceptionAspect");
        pointcutAdvisor.setAdvice(originExceptionAspect);
        pointcutAdvisor.setOrder(20);
        return pointcutAdvisor;
    }
}
