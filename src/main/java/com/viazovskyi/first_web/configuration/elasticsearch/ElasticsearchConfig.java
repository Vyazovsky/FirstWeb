package com.viazovskyi.first_web.configuration.elasticsearch;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

@Configuration
public class ElasticsearchConfig  extends AbstractElasticsearchConfiguration {

    @Value("${elasticsearch.address:'localhost:9200'}")
    private String elasticSearchAddress;

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {
        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(elasticSearchAddress)
                .withSocketTimeout(100000)
                .withConnectTimeout(100000)
                .build();
        return RestClients.create(clientConfiguration).rest();
    }

}
