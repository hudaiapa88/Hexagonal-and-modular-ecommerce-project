open module com.uc.application {
    requires spring.core;
    requires spring.context;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.boot.starter.jdbc;
    requires spring.boot.starter.data.jpa;
    requires org.hibernate.orm.core;
    requires spring.data.commons;
    requires spring.beans;
    requires spring.web;
    requires org.slf4j;
    requires org.mapstruct;
    requires spring.data.jpa;
    requires jakarta.persistence;
    requires lombok;
    requires spring.boot.docker.compose;
    requires io.swagger.v3.oas.annotations;
    requires org.springdoc.openapi.webmvc.core;
    requires org.springdoc.openapi.common;
    requires io.swagger.v3.oas.models;
}