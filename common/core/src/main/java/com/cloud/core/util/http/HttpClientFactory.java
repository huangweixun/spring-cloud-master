package com.cloud.core.util.http;


/**
 * httpclient 工厂类
 * @Author: 黄伟勋
 * @Date: 2020/1/3
 */
public class HttpClientFactory {
    private static HttpAsyncClient httpAsyncClient = new HttpAsyncClient();

    private static HttpSyncClient httpSyncClient = new HttpSyncClient();


    private HttpClientFactory() {
    }

    private static HttpClientFactory httpClientFactory = new HttpClientFactory();

    public static HttpClientFactory getInstance() {

        return httpClientFactory;

    }

    protected HttpAsyncClient getHttpAsyncClientPool() {
        return httpAsyncClient;
    }

    protected HttpSyncClient getHttpSyncClientPool() {
        return httpSyncClient;
    }


}
