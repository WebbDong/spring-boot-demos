package com.webbdong.springboot.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Cache相关注解：
 *      1、@EnableCaching 开启缓存
 *          proxyTargetClass:设置是否强制使用CGLIB代理模式
 *          mode:设置通知模式，代理模式或AOP模式（AdviceMode.PROXY或AdviceMode.ASPECTJ）
 *
 *      2、@CacheConfig 缓存配置，定义类级别缓存操作的公共参数与配置
 *          cacheNames:公共缓存配置名称
 *          keyGenerator:公共key生成器
 *          cacheManager:
 *          cacheResolver:
 *
 *      3、@Cacheable 当缓存里没有对应key的缓存数据时，就将数据存入缓存中，如果缓存里有对应key的数据，则直接返回该数据
 *          value或cacheNames:缓存配置名，每个缓存组件有一个唯一的名字。缓存组件由CacheManager进行管理
 *          key:缓存的 key，可以为空，如果指定要按照 SpEL 表达式编写，如果不指定，则缺省按照方法的所有参数进行组合。例如：@Cacheable(value = "testcache", key = "#userName")
 *          condition:缓存的条件，可以为空，使用 SpEL 编写，返回 true 或者 false，只有为 true 才进行缓存。例如：@Cacheable(value = "testcache", condition = "#userName.length() > 2")
 *          unless:当unless指定的条件为true，方法的返回值就不会被缓存，使用SpEL
 *          sync:是否使用异步模式
 *
 *      4、@CachePut 不会检测之前有没有缓存数据，每次调用都会缓存数据
 *
 *      5、@CacheEvict 清空缓存
 *          condition:缓存的条件，可以为空，使用 SpEL 编写，返回 true 或者 false，只有为 true 才清空缓存
 *          allEntries:是否清空所有缓存内容，缺省为 false，如果指定为 true，则方法调用后将立即清空所有缓存
 *          beforeInvocation:是否在方法执行前就清空，缺省为 false，如果指定为 true，则在方法还没有执行的时候就清空缓存，缺省情况下，如果方法执行抛出异常，则不会清空缓存
 *
 *      6、Caching 设置复杂缓存规则，可以同时设置@Cacheable、@CachePut、@CacheEvict
 */
@SpringBootApplication
@ServletComponentScan
public class SpringBootCacheDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCacheDemoApplication.class, args);
    }

}
