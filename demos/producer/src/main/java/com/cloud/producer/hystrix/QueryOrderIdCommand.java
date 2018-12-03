package com.cloud.producer.hystrix;

import com.cloud.producer.service.ProducerService;
import com.netflix.hystrix.*;

/**
 * @author hwx
 * @date 2018/11/13
 */
public class QueryOrderIdCommand extends HystrixCommand<String> {
    private ProducerService producerService;


    public QueryOrderIdCommand(ProducerService producerService) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("QueryOrderIdCommand"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("queryByOrderId"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withCircuitBreakerRequestVolumeThreshold(10)//至少有10个请求，熔断器才进行错误率的计算
                        .withCircuitBreakerSleepWindowInMilliseconds(5000)//熔断器中断请求5秒后会进入半打开状态,放部分流量过去重试
                        .withCircuitBreakerErrorThresholdPercentage(50)//错误率达到50开启熔断保护
                        .withExecutionTimeoutEnabled(true))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties
                        .Setter().withCoreSize(10)));
        this.producerService = producerService;
    }

    /**
     * 开启请求缓存，只需重载getCacheKey方法
     * 这里的返回值需要返回一个可以代表同一个请求的String类型值
     * 不同的请求会有不同cacheKey.所以，同一请求第一次访问会调用，之后都会走缓存
     * 好处：    1.减少请求数、降低并发
     * 2.同一用户上下文数据一致
     * 3.这个方法会在run()和contruct()方法之前执行，减少线程开支
     */
    @Override
    protected String getCacheKey() {
        return super.getCacheKey();
    }

    @Override
    protected String run() {
        return producerService.test();
    }

    @Override
    protected String getFallback() {
        return "getFallback";
    }

}