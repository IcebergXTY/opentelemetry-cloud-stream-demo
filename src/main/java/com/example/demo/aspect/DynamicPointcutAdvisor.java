package com.example.demo.aspect;

import org.springframework.aop.Pointcut;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.AbstractBeanFactoryPointcutAdvisor;

/**
 * 动态切点
 */
public class DynamicPointcutAdvisor extends AbstractBeanFactoryPointcutAdvisor {

    private static final long serialVersionUID = -1148427126976660753L;

    /**
     * 表达式
     */
    private final String expression;

    public DynamicPointcutAdvisor(String expression) {
        this.expression = expression;
    }

    public Pointcut aspectJExpressionPointcut() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(this.expression);
        return pointcut;
    }

    @Override
    public Pointcut getPointcut() {
        return aspectJExpressionPointcut();
    }
}
