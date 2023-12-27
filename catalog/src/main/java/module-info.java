open module com.uc.catalog {
    requires lombok;
    requires spring.boot;
    requires spring.core;
    requires spring.boot.autoconfigure;
    requires spring.data.commons;
    requires spring.jdbc;
    requires spring.orm;
    requires spring.boot.starter.data.jpa;
    requires spring.beans;
    requires spring.context;
    requires spring.web;
    requires spring.data.jpa;
    requires spring.tx;
    requires com.fasterxml.jackson.databind;
    requires java.sql;
    requires com.zaxxer.hikari;
    requires org.slf4j;
    requires org.mapstruct;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires jakarta.annotation;
    requires jakarta.transaction;
    requires jakarta.cdi;
    requires spring.data.redis;
    requires redis.clients.jedis;
    requires spring.data.elasticsearch;
    requires spring.rabbit;
    requires spring.amqp;
    requires elasticsearch.java;
    requires io.swagger.v3.oas.annotations;
    requires org.springdoc.openapi.webmvc.core;
    requires org.springdoc.openapi.common;
    requires io.swagger.v3.oas.models;
    exports com.uc.catalog.api.category;
    exports com.uc.catalog.api.product;


}