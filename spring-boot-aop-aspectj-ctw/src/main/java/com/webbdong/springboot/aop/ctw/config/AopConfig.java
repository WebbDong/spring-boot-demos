package com.webbdong.springboot.aop.ctw.config;

import com.webbdong.springboot.aop.ctw.aspect.AspectDemo;
import org.aspectj.lang.Aspects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * EnableLoadTimeWeaving.AspectJWeaving.ENABLED : 开启 LTW
 * EnableLoadTimeWeaving.AspectJWeaving.DISABLED : 关闭 LTW
 * EnableLoadTimeWeaving.AspectJWeaving.AUTODETECT : 如果类路径下能读取到 META-INF/aop.xml文件,则开启 LTW,否则关闭
 */
@Configuration
public class AopConfig {

    @Bean
    public AspectDemo aspectDemo() {
        return Aspects.aspectOf(AspectDemo.class);
    }

}
