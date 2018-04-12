/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mapr.log;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.mahout.math.random.Sampler;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 *
 * @author andrewserff
 */
public class ConsoleLogger implements EventLogger {

    private static final Logger log = LogManager.getLogger(ConsoleLogger.class);
    public static final String URL_PROP_NAME = "url";

    private String url;
    private CloseableHttpClient httpClient;

    public ConsoleLogger(Map<String, Object> props) throws NoSuchAlgorithmException {
        this.url = (String) props.get(URL_PROP_NAME);
        SSLConnectionSocketFactory sf = new SSLConnectionSocketFactory(SSLContext.getDefault(), new NoopHostnameVerifier());
        this.httpClient = HttpClientBuilder.create().setSSLSocketFactory(sf).build();
    }

    @Override
    public void logEvent(Sampler event, Map<String, Object> producerConfig) {
        logEvent(event);
    }
    
    private void logEvent(Sampler event) {
        try {
            System.out.println(event.sample().toString());
        } catch (Exception e) {
        }
    }

    @Override
    public void shutdown() {
        try {
            httpClient.close();
        } catch (IOException ex) {
            //oh well
        }
    }
}
