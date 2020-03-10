package com.example.demo.HttpApiService;


import com.alibaba.fastjson.JSON;
import com.example.demo.util.HttpResult;
import org.apache.commons.codec.Charsets;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class HttpAPIService {

    @Autowired
    private CloseableHttpClient httpClient;

    @Autowired
    private RequestConfig config;

    /**
     * get 请求
     * @param url
     * @return
     * @throws Exception
     */
    public String doGet(String url, String Authorization) throws Exception{
        HttpGet httpGet = new HttpGet(url);

        httpGet.setConfig(config);

        if(!StringUtils.isEmpty(Authorization)){
            httpGet.addHeader("Authorization", Authorization);
        }

        CloseableHttpResponse response = httpClient.execute(httpGet);

        if(response.getStatusLine().getStatusCode() == 200){
            return EntityUtils.toString(response.getEntity(), "UTF-8");
        }

        return null;
    }


    public String doGet(String url, Map<String, Object> map, String Authorization) throws Exception{
        URIBuilder uriBuilder = new URIBuilder(url);

        if(map != null){
            for(Map.Entry<String, Object> entry: map.entrySet()){
                uriBuilder.setParameter(entry.getKey(), entry.getValue().toString());
            }
        }

        return this.doGet(uriBuilder.build().toString(), Authorization);
    }

    public HttpResult doPostJson(String url, String JsonParams,String Authorization) throws Exception{
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");

        httpPost.setConfig(config);

        if(!StringUtils.isEmpty(Authorization)){
            httpPost.addHeader("Authorization", Authorization);
        }

        httpPost.setEntity(new StringEntity(JsonParams, Charsets.UTF_8));

        CloseableHttpResponse response = httpClient.execute(httpPost);

        return new HttpResult(response.getStatusLine().getStatusCode(), EntityUtils.toString(response.getEntity(), "UTF-8"));
    }

    public HttpResult doPost(String url, Map<String, Object> map) throws Exception{
        HttpPost httpPost = new HttpPost(url);

        httpPost.setConfig(config);

        if(map != null){
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            for(Map.Entry<String, Object> entry: map.entrySet()){
                list.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
            }

            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list, "UTF-8");

            httpPost.setEntity(urlEncodedFormEntity);
        }

        CloseableHttpResponse response = httpClient.execute(httpPost);

        return new HttpResult(response.getStatusLine().getStatusCode(), EntityUtils.toString(response.getEntity(), "UTF-8"));
    }

    public HttpResult doPostApplicationJSON(String url, Map<String, Object> map) throws Exception{
        HttpPost httpPost = new HttpPost(url);

        httpPost.setConfig(config);

        if(map != null){
            StringEntity entity = new StringEntity(JSON.toJSONString(map),"utf-8");
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
        }

        CloseableHttpResponse response = httpClient.execute(httpPost);

        return new HttpResult(response.getStatusLine().getStatusCode(), EntityUtils.toString(response.getEntity(), "UTF-8"));
    }

    public HttpResult doPost(String url) throws Exception {
        return this.doPost(url, null);
    }


}
