package com.iidooo.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.log4j.Logger;

import com.iidooo.core.constant.CoreConstants;

public class HttpUtil {

    private static final Logger logger = Logger.getLogger(HttpUtil.class);

    public static String sendPostRequest() {
        return "test";
    }
    
    public static String doGet(String url, String method){
        JSONObject result = new JSONObject();

        CloseableHttpClient httpclient = HttpClients.createDefault();

        url = url + "/" + method ;
        HttpGet httpGet = new HttpGet(url);

        httpGet.addHeader(HTTP.CONTENT_TYPE, CoreConstants.APPLICATION_JSON);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpGet);

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                InputStreamReader inputStreamReader = new InputStreamReader(entity.getContent(), CoreConstants.ENCODING_UTF8);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = null;
                StringBuilder httpContent = new StringBuilder();
                while ((line = bufferedReader.readLine()) != null) {
                    httpContent.append(line + "\n");
                }

                result = JSONObject.fromObject(httpContent.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.fatal(e);
                }
            }
            if (httpclient != null) {
                try {
                    httpclient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.fatal(e);
                }
            }
        }

        return result.toString();
    }

    public static String doGet(String url, String method, String data) {
        JSONObject result = new JSONObject();

        CloseableHttpClient httpclient = HttpClients.createDefault();
        
        // Set the get request params
        JSONObject jsonObject = JSONObject.fromObject(data);
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        Iterator<?> it = jsonObject.keys();
        while (it.hasNext()) {
            String key = (String) it.next();
            String value = jsonObject.getString(key);
            params.add(new BasicNameValuePair(key, value));
        }

        url = url + "/" + method + "?" + URLEncodedUtils.format(params, CoreConstants.ENCODING_UTF8);
        HttpGet httpGet = new HttpGet(url);

        httpGet.addHeader(HTTP.CONTENT_TYPE, CoreConstants.APPLICATION_JSON);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpGet);

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                InputStreamReader inputStreamReader = new InputStreamReader(entity.getContent(), CoreConstants.ENCODING_UTF8);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = null;
                StringBuilder httpContent = new StringBuilder();
                while ((line = bufferedReader.readLine()) != null) {
                    httpContent.append(line + "\n");
                }

                result = JSONObject.fromObject(httpContent.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.fatal(e);
                }
            }
            if (httpclient != null) {
                try {
                    httpclient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.fatal(e);
                }
            }
        }

        return result.toString();
    }

    public static String doPost(String url, String method, String data) {

        JSONObject result = new JSONObject();

        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(url + "/" + method);

        httpPost.addHeader(HTTP.CONTENT_TYPE, CoreConstants.APPLICATION_JSON);
        CloseableHttpResponse response = null;
        try {
            StringEntity stringEntity = new StringEntity(data);
            stringEntity.setContentEncoding(CoreConstants.ENCODING_UTF8);
            stringEntity.setContentType(CoreConstants.APPLICATION_JSON);
            httpPost.setEntity(stringEntity);
            response = httpclient.execute(httpPost);

            System.out.println(response.getStatusLine());

            HttpEntity entity = response.getEntity();
            InputStreamReader inputStreamReader = new InputStreamReader(entity.getContent(), CoreConstants.ENCODING_UTF8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            StringBuilder httpContent = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                httpContent.append(line + "\n");
            }

            result = JSONObject.fromObject(httpContent.toString());

        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal(e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.fatal(e);
                }
            }
            if (httpclient != null) {
                try {
                    httpclient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.fatal(e);
                }
            }
        }

        return result.toString();
    }
}
