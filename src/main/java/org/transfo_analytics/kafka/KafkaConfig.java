package org.transfo_analytics.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

//TODO Is it needed?

@Configuration
public class KafkaConfig {

    @Bean
    public RecordMessageConverter converter() {
        return new StringJsonMessageConverter();
    } //Needed so the listeners can produce Objects rather than strings
}
