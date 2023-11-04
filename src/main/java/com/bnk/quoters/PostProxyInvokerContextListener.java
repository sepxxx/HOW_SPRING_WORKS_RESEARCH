package com.bnk.quoters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.lang.reflect.Method;

public class PostProxyInvokerContextListener implements ApplicationListener<ContextRefreshedEvent> {
//    @Autowired
    private ConfigurableListableBeanFactory beanFactory;

//    @Autowired
//    private ConfigurableBeanFactory beanFactory;

    public PostProxyInvokerContextListener() {
    }

    @Autowired
    public PostProxyInvokerContextListener(ConfigurableListableBeanFactory beanFactory) {
        this.beanFactory=beanFactory;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            BeanDefinition beanDefinition = beanFactory.
                    getBeanDefinition(beanName);
            //можем вытащить оригинальное название класса
            //которое еще прописали в xml
            String originalClassName = beanDefinition.getBeanClassName();
            try {
                Class<?> originalClass = Class.forName(originalClassName);
                Method[] methods = originalClass.getMethods();
                for (Method method : methods) {
                    if(method.isAnnotationPresent(PostProxy.class)) {
                        System.out.println("НАШ МЕТОД ПОПАЛ ПОД POSTPROXY");
                        //мы не можем просто сделать
                        //method.invoke()
                        //тк мы ищем его в оригинальном классе
                        //а мы можем работать с прокси
                        Object bean = context.getBean(beanName);
                        Method curentMethod = bean.getClass().getMethod(method.getName(),
                                method.getParameterTypes());
                        curentMethod.invoke(bean);
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
