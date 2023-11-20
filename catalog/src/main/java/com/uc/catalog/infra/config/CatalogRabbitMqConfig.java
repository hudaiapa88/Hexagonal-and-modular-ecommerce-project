package com.uc.catalog.infra.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.core.Queue;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "catalog.rabbitmq")
@Getter
@Setter
public class CatalogRabbitMqConfig {
    
    private String host;
    private int port;
    private String username;
    private String password;

   private String exchange;
   private String queueName;
   private  String routingKey;
    @Bean("catalogRabbitMqConnectionFactory")
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory= new CachingConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        return connectionFactory;
    }

    @Bean
    public RabbitAdmin productRabbitMqAdmin(@Qualifier("catalogRabbitMqConnectionFactory") ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory());
    }
    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
    @Bean("saveProductExchange")
    DirectExchange saveProductExchange() {
        return new DirectExchange(exchange);
    }
    @Bean("saveProductQueue")
    public Queue saveProductQueue() {
        return new Queue(queueName);
    }

    @Bean
    Binding binding(@Qualifier("saveProductQueue") Queue saveProductQueue,@Qualifier("saveProductExchange") DirectExchange exchange){
        return BindingBuilder.bind(saveProductQueue).to(exchange).with(routingKey);
    }
    @Bean
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }


}
