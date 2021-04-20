package com.webbdong.springboot.aop.config;

import org.springframework.context.annotation.EnableLoadTimeWeaving;

/**
 * @EnableLoadTimeWeaving
 *      AspectJWeaving.ENABLED：开启LTW
 *      AspectJWeaving.DISABLED：不开启LTW
 *      AspectJWeaving.AUTODETECT：如果类路径下能读取到META-INF/aop.xml文件,则开启LTW,否则关闭，默认
 */
//@Configuration
//@EnableAspectJAutoProxy
@EnableLoadTimeWeaving
public class AOPConfig {

/*    @Bean
    public InstrumentationLoadTimeWeaver loadTimeWeaver() {
        InstrumentationLoadTimeWeaver loadTimeWeaver = new InstrumentationLoadTimeWeaver();
        return loadTimeWeaver;
    }*/

}
