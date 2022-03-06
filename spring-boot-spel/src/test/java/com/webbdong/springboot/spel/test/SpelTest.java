package com.webbdong.springboot.spel.test;

import com.webbdong.springboot.spel.Person;
import com.webbdong.springboot.spel.SpringBootSpelApplication;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.expression.BeanFactoryAccessor;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Webb Dong
 * @date 2022-03-06 11:56 AM
 */
@SpringBootTest(classes = SpringBootSpelApplication.class)
public class SpelTest implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Test
    public void test() {
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext standardEvaluationContext = new StandardEvaluationContext(applicationContext);
        standardEvaluationContext.addPropertyAccessor(new BeanFactoryAccessor());
        Map<String, Object> params = new HashMap<>();
        params.put("name", "张三");
        params.put("age", 18);
        params.put("person", Person.builder()
                .name("Kobe")
                .age(40)
                .build());
        // 将自定义参数添加到上下文
        standardEvaluationContext.setVariables(params);
//        String expressionString = "#name + '的年龄是:' + #age";
        String expressionString = "#person.name + '的年龄是:' + #person.age";
        Expression expression = parser.parseExpression("#{" + expressionString + "}", new TemplateParserContext());
        String expressionValue = expression.getValue(standardEvaluationContext, String.class);
        System.out.println(expressionValue);
    }

    @SneakyThrows
    @Test
    public void test2() {
        String expressionString = "#person.name + '的年龄是:' + #person.age + '*'";
//        String expressionString = "'skc:productName:' + #skcCode";
        SpelExpressionParser parser = new SpelExpressionParser();
        DefaultParameterNameDiscoverer nameDiscoverer = new DefaultParameterNameDiscoverer();
        Method method = this.getClass().getDeclaredMethod("testMethod", Person.class);
        method.setAccessible(true);
        String[] paramNames = nameDiscoverer.getParameterNames(method);
        Expression expression = parser.parseExpression(expressionString);
        EvaluationContext context = new StandardEvaluationContext();
        Object[] args = new Object[] {
                Person.builder()
                        .name("Kobe")
                        .age(40)
                        .build()
        };
/*        Object[] args = new Object[] {
                "skcCode123456"
        };*/
        for (int i = 0; i < args.length; i++) {
            context.setVariable(paramNames[i], args[i]);
        }
        System.out.println(expression.getValue(context).toString());
    }

    private void testMethod(Person person /*String skcCode*/) {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}
