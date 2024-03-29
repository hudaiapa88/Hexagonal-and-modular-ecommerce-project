open module com.uc.inventory {
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
/*    requires jakarta.persistence;
    requires jakarta.transaction;
    requires jakarta.annotation;*/
    requires com.fasterxml.jackson.databind;
    requires java.sql;
    requires com.zaxxer.hikari;
    requires org.slf4j;
    requires org.mapstruct;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires jakarta.annotation;
    requires jakarta.transaction ;
    requires jakarta.cdi;
    requires com.uc.catalog;
    requires jakarta.validation;
    requires spring.kafka;
    requires spring.messaging;
    requires kafka.clients;
    requires io.swagger.v3.oas.annotations;
    requires org.springdoc.openapi.webmvc.core;
    requires org.springdoc.openapi.common;
    requires io.swagger.v3.oas.models;
}