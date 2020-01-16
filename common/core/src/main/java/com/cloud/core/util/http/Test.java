package com.cloud.core.util.http;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: 黄伟勋
 * @Date: 2020/1/3
 */
public class Test extends HttpClientUtil {
    public static void main(String[] args) {
        new Test().getResult();
    }

    public void getResult() {

        String url = "http://47.100.178.1:9577/wechat-public-account/statistics/codeScan";
        JSONObject json = new JSONObject();
        json.put("page", "1");
        json.put("limit", 10);
        HashMap<String,String> map = new HashMap<>();
        map.put("page", "1");
        map.put("limit", "10");

        try {
//            httpSyncPost(url, map);
//            httpSyncGet(url, list);
//            httpSyncGet(url, urlParams);

//            httpAsyncPost(url, json.toString(), urlParams, new MyAsyncHttpClientCallback());
//            httpAsyncPost(url, list, list, new MyAsyncHttpClientCallback());
            httpAsyncGet(url, map, new MyAsyncHttpClientCallback());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
