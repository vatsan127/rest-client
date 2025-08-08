package dev.srivatsan.rest_client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfiguration {

    @Bean
    @Primary
    public RestClient getRestClientBean() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(5000);
        requestFactory.setReadTimeout(5000);
        return RestClient.create();
    }

    @Bean("deploymentRestClient")
    public RestClient getRestClientBeanWithoutTimeout() {
        return RestClient.create();
    }

}
