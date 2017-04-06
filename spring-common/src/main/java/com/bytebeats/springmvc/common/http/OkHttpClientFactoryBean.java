package com.bytebeats.springmvc.common.http;

import com.bytebeats.springmvc.common.util.StringUtils;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

/**
 * OkHttpClient FactoryBean
 *
 * @author Ricky Fung
 * @date 2017-01-05 11:23
 */
public class OkHttpClientFactoryBean implements FactoryBean<OkHttpClient>, DisposableBean {

    private Logger logger = LoggerFactory.getLogger(OkHttpClientFactoryBean.class);

    private int readTimeout;
    private int connectTimeout;
    private boolean requestRetryEnabled;
    private String proxyHost;
    private int proxyPort;

    private OkHttpClient httpclient;

    @Override
    public OkHttpClient getObject() throws Exception {

        logger.info("HttpClientFactoryBean getObject invoke");

        Proxy proxy = null;
        if(StringUtils.isNotEmpty(proxyHost) && proxyPort>0){
            proxy = new Proxy(Proxy.Type.HTTP,
                    new InetSocketAddress(proxyHost, proxyPort));
        }
        ConnectionPool connectionPool = new ConnectionPool(5, 5, TimeUnit.MINUTES);
        httpclient = new OkHttpClient.Builder()
                .readTimeout(readTimeout, TimeUnit.MILLISECONDS)
                .connectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
                .connectionPool(connectionPool)
                .retryOnConnectionFailure(requestRetryEnabled)
                .proxy(proxy)
                .build();

        logger.info("HttpClient init: readTimeout->{}, connectTimeout->{}, " +
                        "requestRetryEnabled->{}, proxyHost->{}, proxyPort->{}",
                readTimeout, connectTimeout,  requestRetryEnabled, proxyHost, proxyPort);

        logger.info("HttpClient using->:{}", httpclient.getClass().getName());
        return httpclient;
    }
 
    @Override
    public Class<?> getObjectType() {
        return OkHttpClient.class;
    }
 
    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public void setRequestRetryEnabled(boolean requestRetryEnabled) {
        this.requestRetryEnabled = requestRetryEnabled;
    }

    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

    public void setProxyPort(int proxyPort) {
        this.proxyPort = proxyPort;
    }

    @Override
    public void destroy() throws Exception {
        logger.info("HttpClientFactoryBean destroy...");
        if(httpclient!=null){
            httpclient.dispatcher().executorService().shutdown();
            httpclient.connectionPool().evictAll();
        }
        httpclient = null;
    }
}