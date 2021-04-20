package com.webbdong.springboot.aop.ltw.config;

import com.webbdong.springboot.aop.ltw.aspect.AspectDemo;
import org.aspectj.lang.Aspects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.LoadTimeWeavingConfigurer;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.instrument.classloading.LoadTimeWeaver;

/**
 * EnableLoadTimeWeaving.AspectJWeaving.ENABLED : 开启 LTW
 * EnableLoadTimeWeaving.AspectJWeaving.DISABLED : 关闭 LTW
 * EnableLoadTimeWeaving.AspectJWeaving.AUTODETECT : 如果类路径下能读取到 META-INF/aop.xml文件,则开启 LTW,否则关闭
 */
@Configuration
@EnableLoadTimeWeaving(aspectjWeaving = EnableLoadTimeWeaving.AspectJWeaving.ENABLED)
public class AopConfig implements LoadTimeWeavingConfigurer {

    @Override
    public LoadTimeWeaver getLoadTimeWeaver() {
        return new InstrumentationLoadTimeWeaver();
    }

    @Bean
    public AspectDemo aspectDemo() {
        return Aspects.aspectOf(AspectDemo.class);
    }

}
